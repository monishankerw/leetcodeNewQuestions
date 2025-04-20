
# 🗺️ Java Map Interface - Complete Guide

The `Map` interface in Java provides a way to store key-value pairs. It is part of the `java.util` package and does **not allow duplicate keys**, but values can be duplicated.

---

## 🔗 Core Implementations of Map

| Implementation       | Ordering                       | Thread-Safe       | Null Keys | Null Values | Use Case                                  |
|----------------------|--------------------------------|--------------------|------------|--------------|--------------------------------------------|
| `HashMap`            | No ordering                    | ❌ No              | ✅ Yes     | ✅ Yes       | General-purpose, fast access               |
| `LinkedHashMap`      | Maintains insertion order      | ❌ No              | ✅ Yes     | ✅ Yes       | Ordered iteration (e.g., LRU cache)        |
| `TreeMap`            | Sorted by natural/custom order | ❌ No              | ❌ No      | ✅ Yes       | Sorted map                                 |
| `Hashtable`          | No ordering                    | ✅ Yes             | ❌ No      | ❌ No        | Legacy thread-safe                         |
| `ConcurrentHashMap`  | No ordering                    | ✅ Yes (efficient) | ❌ No      | ❌ No        | High concurrency, modern multithreading    |
| `WeakHashMap`        | No ordering                    | ❌ No              | ✅ Yes     | ✅ Yes       | Auto cleanup with GC (memory-sensitive)    |
| `IdentityHashMap`    | No ordering                    | ❌ No              | ✅ Yes     | ✅ Yes       | Compares keys by reference (`==`)          |
| `EnumMap`            | Order of enum constants        | ❌ No              | ❌ No      | ✅ Yes       | Maps enum constants                        |

---

## 🧱 HashMap
- Stores entries in a **hash table**.
- Allows `null` key and multiple `null` values.
- Not synchronized.

```java
Map<String, String> map = new HashMap<>();
map.put("Name", "Moni");
map.put(null, "NullKey");
```

---

## 🔗 LinkedHashMap
- Maintains **insertion order**.
- Good for ordered iteration.
- Used in **LRU cache** implementations.

```java
Map<String, String> map = new LinkedHashMap<>();
map.put("ID", "123");
map.put("Name", "Moni");
```

---

## 🌳 TreeMap
- Keys are **sorted** based on natural or custom comparator.
- No `null` key allowed.

```java
Map<String, String> map = new TreeMap<>();
map.put("b", "Banana");
map.put("a", "Apple");
```

---

## 🗃️ Hashtable
- Legacy class.
- Thread-safe but slower.
- No `null` key or value.

```java
Map<String, String> table = new Hashtable<>();
table.put("Name", "Moni");
```

---

## ⚙️ ConcurrentHashMap
- Thread-safe, supports concurrent read/write.
- No `null` keys or values.
- **Modern replacement for Hashtable**.

```java
ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
map.put("User", "Moni");
```

---

## 💨 WeakHashMap
- Keys are stored with **weak references**.
- Auto cleanup when keys are no longer referenced.

```java
Map<Object, String> map = new WeakHashMap<>();
Object key = new String("tempKey");
map.put(key, "tempValue");
key = null;
System.gc();
```

---

## 🆔 IdentityHashMap
- Uses `==` instead of `.equals()` for key comparison.
- Allows `null` keys/values.

```java
IdentityHashMap<String, String> map = new IdentityHashMap<>();
map.put(new String("key"), "value1");
map.put(new String("key"), "value2"); // Both keys are different
```

---

## 🧩 EnumMap
- Special map for `enum` keys.
- All keys must be from a single enum type.

```java
enum Status { NEW, PROCESSING, COMPLETE }

EnumMap<Status, String> map = new EnumMap<>(Status.class);
map.put(Status.NEW, "Created");
```

---

## 🧠 Choosing the Right Map

| Need                          | Use                             |
|-------------------------------|----------------------------------|
| Fast access (non-threaded)    | `HashMap`                       |
| Ordered iteration             | `LinkedHashMap`                 |
| Sorted map                    | `TreeMap`                       |
| Thread-safe access            | `ConcurrentHashMap`             |
| Legacy system compatibility   | `Hashtable`                     |
| Automatic cleanup             | `WeakHashMap`                   |
| Reference-based comparison    | `IdentityHashMap`               |
| Enum-specific key mapping     | `EnumMap`                       |

---

## 📌 Summary Diagram (Textual)

```
Map
├── HashMap
│   └── LinkedHashMap
│   └── WeakHashMap
│   └── IdentityHashMap
├── TreeMap
├── Hashtable
│   └── Properties
├── EnumMap
├── ConcurrentHashMap
```

---

Let me know if you want PDF, visual diagrams, or quiz-based flashcards!

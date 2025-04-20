
# ✅ HashMap vs Hashtable

| Feature            | HashMap                           | Hashtable                                |
|--------------------|------------------------------------|-------------------------------------------|
| **Thread Safety**   | ❌ Not synchronized               | ✅ Synchronized (thread-safe)            |
| **Performance**     | 🔥 Faster                         | 🐢 Slower due to locking                 |
| **Null Keys/Values**| ✅ Allowed                        | ❌ Not allowed                           |
| **Introduced In**   | Java 1.2                          | Java 1.0                                 |
| **Legacy**          | Modern usage                      | Legacy (avoid in new code)              |
| **Iterator**        | Fail-fast                         | Fail-safe (Enumeration)                 |
| **Package**         | java.util                         | java.util                               |

---

## 🔍 Code Examples

### ✅ HashMap
```java
Map<String, String> map = new HashMap<>();
map.put("Name", "Moni");
map.put(null, "NullKeyAllowed");
map.put("City", null);  // Null values allowed
System.out.println(map);
```

### 🚫 Hashtable
```java
Map<String, String> table = new Hashtable<>();
table.put("Name", "Moni");
// table.put(null, "NullKey");     // ❌ Throws NullPointerException
// table.put("City", null);        // ❌ Throws NullPointerException
System.out.println(table);
```

---

## ⚠️ When to Use What?

| Use Case                      | Recommendation        |
|-------------------------------|------------------------|
| Multithreading required?      | Use ConcurrentHashMap |
| Single-threaded speed needed  | Use HashMap           |
| Null keys/values needed?      | Use HashMap           |
| Legacy system in use?         | You might see Hashtable |

---

# ✅ ConcurrentHashMap vs Hashtable

| Feature            | ConcurrentHashMap                     | Hashtable                               |
|--------------------|----------------------------------------|------------------------------------------|
| **Thread Safety**   | ✅ Efficient (segment locking)         | ✅ Safe (locks entire map)              |
| **Performance**     | 🚀 High performance                    | 🐢 Slower                               |
| **Null Keys/Values**| ❌ Not allowed                         | ❌ Not allowed                          |
| **Iteration**       | Fail-safe                              | Fail-fast                              |
| **Modern Preferred**| ✅ Yes                                 | 🚫 Legacy                               |
| **Introduced In**   | Java 1.5 (java.util.concurrent)        | Java 1.0                                |

---

## 🔍 Code Example

### ✅ ConcurrentHashMap
```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Name", "Moni");
        map.put("Tech", "Java");
        System.out.println("ConcurrentHashMap: " + map);
    }
}
```

### 🚫 Hashtable
```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>();
        table.put("Name", "Moni");
        table.put("Tech", "Java");
        System.out.println("Hashtable: " + table);
    }
}
```

---

# ✅ WeakHashMap - Auto-Cleanup with Garbage Collection

### What is WeakHashMap?
- Stores keys using weak references.
- Entries are removed when a key is no longer referenced elsewhere.

---

## 🎯 Use Cases

| Use Case             | Why?                                 |
|----------------------|---------------------------------------|
| Caching              | Auto-removal of unused data           |
| Listeners/Metadata   | Clean up when object is no longer used|
| Memory Leak Prevention| Prevents memory leaks from unused keys|

---

## Key Characteristics

| Feature           | Description                             |
|-------------------|------------------------------------------|
| **Implements**     | Map                                     |
| **Auto Cleanup**   | ✅ Yes (keys GC eligible)              |
| **Thread-safe?**   | ❌ No (wrap with Collections.synchronizedMap) |
| **Null Support**   | ✅ Allows null keys and values         |

---

## 🔍 Code Example

```java
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        Map<Object, String> map = new WeakHashMap<>();
        Object key = new String("moni_key");

        map.put(key, "Some value");

        System.out.println("Before GC: " + map);

        key = null; // Remove strong reference to the key
        System.gc(); // Suggest JVM to run GC
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("After GC: " + map);
    }
}
```

---

## 🔄 Comparison Table: HashMap vs WeakHashMap

| Feature             | HashMap         | WeakHashMap                   |
|---------------------|------------------|--------------------------------|
| **Key Reference**    | Strong           | Weak (GC eligible)             |
| **Auto Cleanup**     | ❌ No            | ✅ Yes                         |
| **Thread-safe**      | ❌ No            | ❌ No                          |
| **Null keys allowed**| ✅ Yes          | ✅ Yes                         |
| **Use Case**         | General use      | Caching, memory-sensitive maps|

---

✅ Use `WeakHashMap` when you want temporary data storage that automatically gets cleaned up as memory allows.

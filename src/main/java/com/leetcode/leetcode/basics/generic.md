Here is a .md version of the explanation:

# Generics in Java

Generics in Java were introduced with **Java 5** to
provide type safety and avoid runtime errors. 
They enable developers to define classes, interfaces, and methods with placeholders for types,
which can be specified when used.

---

## Key Advantages
1. **Type Safety**: Ensures that the compiler checks type compatibility at compile time, reducing runtime errors.
2. **Code Reusability**: Allows writing a single method or class that works with different data types.
3. **Elimination of Type Casting**: Avoids explicit casting by enforcing the type at compile time.

---

## Generic Syntax

### 1. Generic Class

```java
class GenericClass<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

Using a Generic Class

GenericClass<String> obj = new GenericClass<>();
obj.setData("Hello");
String value = obj.getData(); // No casting required

Common Generic Components

1. Generic Classes

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

2. Generic Methods

public static <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.print(element + " ");
    }
}

// Usage
String[] names = {"Alice", "Bob"};
printArray(names);

3. Bounded Type Parameters

public static <T extends Number> double sum(T num1, T num2) {
    return num1.doubleValue() + num2.doubleValue();
}

4. Generic Interfaces

interface Container<T> {
    void add(T item);
    T get();
}

Wildcards in Generics

1. Unbounded Wildcard (?)

public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}

2. Upper Bounded Wildcard (? extends Type)

public double sum(List<? extends Number> list) {
    double sum = 0;
    for (Number num : list) {
        sum += num.doubleValue();
    }
    return sum;
}

3. Lower Bounded Wildcard (? super Type)

public void addNumbers(List<? super Integer> list) {
    list.add(10);
}

Example: Generic Stack Implementation

class GenericStack<T> {
    private List<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("Generics");
        System.out.println(stack.pop()); // Output: Generics
    }
}


```

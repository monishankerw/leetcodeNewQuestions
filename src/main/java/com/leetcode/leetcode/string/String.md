
```markdown
# Java Strings

## String Creation

In Java, strings can be created in two primary ways:
1. **Using String Literal**: 
   - String literals are stored in a special memory area known as the **String Constant Pool (SCP)**.
   - Example: `String str = "xyz";`
   - **Memory Allocation**: String literals are stored in the SCP to optimize memory usage. If the string already exists in the pool, no new object is created.

2. **Using `new` Keyword**:
   - Example: `String s = new String("welcome");`
   - **Memory Allocation**: A new string object is created in the heap memory, and the literal "welcome" is placed in the SCP. To store this string in the SCP, you need to use the `intern()` method.
   - Example: `String x = s.intern();`

### Examples

**Example 1:**
```java
class A {
    public static void main(String[] args) {
        String s = "xyz";
        System.out.println("String s = " + s);
        String s1 = new String("xyz");
        System.out.println("String s1 = " + s1);
    }
}
```
*Output*:
```
String s = xyz
String s1 = xyz
```

**Example 2:**
```java
class A {
    public static void main(String[] args) {
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        String s3 = "xyz";
        String s4 = "xyz";
        // Heap: s1->xyz, s2->xyz(2)
        // SCP: xyz (no duplicate allowed)
    }
}
```

## Mutable vs. Immutable Classes

### Mutable Class
- **Definition**: An object whose values can be changed.
- **Example**:
```java
class A {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        A a = new A();
        a.setI(1);
        System.out.println(a.getI());
    }
}
```

### Immutable Class
- **Definition**: An object whose state cannot be modified after creation.
- **Example**:
```java
public final class A {
    private final int i;

    public int getI() {
        return i;
    }

    public A(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        A a = new A(12);
        System.out.println(a.getI());
    }
}
```
*Rules for Immutability*:
1. Make the class `final`.
2. Make fields `final` and `private`.
3. Initialize fields via the constructor.
4. Provide only getter methods, no setters.

## Why Java Strings Are Immutable
- **Immutability**: Once a `String` object is created, its state cannot be changed. Any modification creates a new `String` object.
- **Thread Safety**: Immutable objects are inherently thread-safe.

## String vs. StringBuilder vs. StringBuffer

| **String**               | **StringBuilder**        | **StringBuffer**           |
|--------------------------|--------------------------|----------------------------|
| Immutable                | Mutable                  | Mutable                    |
| Storage: SCP and Heap    | Heap                     | Heap                       |
| Memory: More Required    | Less Memory Required     | Less Memory Required       |
| Slow                     | Faster than `String`     | Faster than `String`       |
| Thread Safe and Synchronized | Not Thread Safe       | Thread Safe and Synchronized |

**Examples:**

**StringBuilder:**
```java
class A {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Hello");
        System.out.println(s1);
        s1.append(" world");
        System.out.println(s1);
    }
}
```

**StringBuffer:**
```java
class A {
    public static void main(String[] args) {
        StringBuffer s2 = new StringBuffer("Hello");
        System.out.println(s2);
        s2.append(" world");
        System.out.println(s2);
    }
}
```

## Common String Methods

1. **`toLowerCase()`**: Converts all characters in the string to lowercase.
   ```java
   class A {
       public static void main(String[] args) {
           String s = "moni";
           System.out.println(s.toLowerCase()); // moni
           System.out.println(s.toUpperCase()); // MONI
       }
   }
   ```

2. **`trim()`**: Removes leading and trailing whitespace.
   ```java
   class A {
       public static void main(String[] args) {
           String s1 = " MoniShanker ";
           System.out.println(s1);
           System.out.println(s1.trim()); // MoniShanker
       }
   }
   ```

3. **`split()`**: Splits the string into tokens.
   ```java
   class A {
       public static void main(String[] args) {
           String s1 = "Moni Shanker";
           String[] s2 = s1.split(" ");
           System.out.println(s2[0]); // Moni
           System.out.println(s2[1]); // Shanker
       }
   }
   ```

4. **`length()`**: Returns the length of the string.
   ```java
   class A {
       public static void main(String[] args) {
           String s1 = "I am Java Developer";
           System.out.println(s1.length()); // 20
           String[] s2 = s1.split(" ");
           System.out.println(s2[0].length()); // 1
           System.out.println(s2[1].length()); // 2
           System.out.println(s2[2].length()); // 4
           System.out.println(s2[3].length()); // 8
       }
   }
   ```

5. **`charAt()`**: Returns the character at a specified index.
   ```java
   class A {
       public static void main(String[] args) {
           String s1 = "ManiShanker";
           for (int i = 0; i < s1.length(); i++) {
               System.out.println(s1.charAt(i)); // prints each character
           }
       }
   }
   ```

## `String` vs. `StringBuffer` vs. `StringBuilder`

### `==` vs `.equals()`

- **`==`**: Compares memory addresses (reference comparison).
- **`.equals()`**: Compares string values (content comparison).

**Examples:**

**String Comparison:**
```java
class A {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
    }
}
```

**String Comparison with Different Cases:**
```java
class A {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // false
    }
}
```

**Thread Comparison:**
```java
class A {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = t1;
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(t1 == t3); // true
        System.out.println(t1 == t2); // false
        System.out.println(s1 == s2); // false
        System.out.println(t1.equals(t2)); // false
        System.out.println(s1.equals(s2)); // true
    }
}
```

**String Immutability:**
```java
class A {
    public static void main(String[] args) {
        String s1 = new String("Schin");
        s1.concat("Tendulkar");
        s1 = s1.concat("abc");
        System.out.println(s1); // SchinTendulkarabc
    }
}
```

**String Tokenizer Example:**
```java
class A {
    public static void main(String[] args) {
        String s = "Schin";
        s.concat("Tendulkar");
        System.out.println(s); // Schin
    }
}
```
```

```





## Additional Methods

### `indexOf()`
The `indexOf()` method returns the position of the first occurrence of the specified character or string in a specified string.

### `toString()`
The `toString()` method returns a string representation of an object. It's overridden by subclasses to provide meaningful string representation.

Example:
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Person person = new Person("John", 30);
        System.out.println(person); // Implicitly calls person.toString()
    }
}
```

### `toCharArray()`
The `toCharArray()` method converts a string into a character array. Useful for iterating over or manipulating individual characters.

Example:
```java
String str = "Hello";
char[] charArray = str.toCharArray(); // Contains characters 'H', 'e', 'l', 'l', 'o'
```

### `isEmpty()`
The `isEmpty()` method checks if a string contains any characters. It returns `true` if the string is empty, otherwise `false`.

Example:
```java
String str1 = ""; // Empty string
String str2 = "Hello";
boolean isEmpty1 = str1.isEmpty(); // true
boolean isEmpty2 = str2.isEmpty(); // false
```

The statement `map.put(value, map.getOrDefault(value, 0) + 1);` is commonly used in Java to update the count or frequency of occurrences of a particular value in a `Map`. Here's how it works step by step:

### Explanation:
1. **`map.getOrDefault(value, 0)`**:
   - The `getOrDefault(key, defaultValue)` method checks if the `map` contains the key (`value` in this case).
   - If the `value` is already present in the map, it retrieves the associated value (which could be the count of occurrences).
   - If the `value` is **not present**, it returns the default value, which is `0` in this case. This ensures that if the `value` is being added for the first time, its count starts from `0`.

2. **`+ 1`**:
   - After retrieving the current count (or `0` if the key doesn’t exist), the expression increments the count by `1`. This effectively adds 1 to the frequency count of the `value`.

3. **`map.put(value, ...)`**:
   - The `put(key, value)` method then updates the map, setting the `value` as the key and the new incremented count as the associated value. If the `value` was not already present in the map, it gets added with an initial count of `1`.

### In Summary:
- **Purpose**: This line of code counts how many times a `value` occurs and stores that count in the `map`.
- **Behavior**:
   - If the `value` is already in the `map`, its count is incremented by `1`.
   - If the `value` is not in the `map`, it is added with a count of `1`.

### Example:

```java
Map<String, Integer> map = new HashMap<>();
String value = "apple";

map.put(value, map.getOrDefault(value, 0) + 1);  // Adds "apple" with count 1
map.put(value, map.getOrDefault(value, 0) + 1);  // Increments the count of "apple" to 2

System.out.println(map);  // Output: {apple=2}
```

In this example:
- The first `put` adds "apple" with a count of `1`.
- The second `put` increments the count of "apple" to `2`.













```


```









```


```
                       ""
                    /  |  \
                  a    b    c
                / \   / \   / \
              ab  ac ba  bc ca  cb
             /     \  |    \ |   \
           abc    acb bac  bca cab  cba
```

- Each path in this tree represents a different permutation being constructed.
- Once a full permutation is built (when no more characters are left in `s`), it gets added to the result list.
- Backtracking allows the algorithm to explore all possible orders by removing one character at a time and trying others.


```

```

```
Here is a comprehensive list of string methods for both basic and advanced levels, useful in Data Structures and Algorithms (DSA) and development:

### **Basic String Methods**
These are essential for beginner-level programming and basic string manipulation.

1. **`charAt(int index)`**
   - Returns the character at the specified index.
   ```java
   String str = "hello";
   char ch = str.charAt(1);  // 'e'
   ```

2. **`length()`**
   - Returns the length of the string.
   ```java
   String str = "hello";
   int len = str.length();  // 5
   ```

3. **`toLowerCase()`**
   - Converts all characters to lowercase.
   ```java
   String str = "HELLO";
   String lower = str.toLowerCase();  // "hello"
   ```

4. **`toUpperCase()`**
   - Converts all characters to uppercase.
   ```java
   String str = "hello";
   String upper = str.toUpperCase();  // "HELLO"
   ```

5. **`substring(int beginIndex)`**
   - Returns the substring starting from the specified index.
   ```java
   String str = "hello";
   String sub = str.substring(2);  // "llo"
   ```

6. **`substring(int beginIndex, int endIndex)`**
   - Returns the substring from `beginIndex` to `endIndex - 1`.
   ```java
   String str = "hello";
   String sub = str.substring(1, 4);  // "ell"
   ```

7. **`equals(Object anotherString)`**
   - Compares two strings for equality.
   ```java
   String str1 = "hello";
   String str2 = "hello";
   boolean isEqual = str1.equals(str2);  // true
   ```

8. **`equalsIgnoreCase(String anotherString)`**
   - Compares two strings, ignoring case considerations.
   ```java
   String str1 = "Hello";
   String str2 = "hello";
   boolean isEqual = str1.equalsIgnoreCase(str2);  // true
   ```

9. **`startsWith(String prefix)`**
   - Checks if the string starts with the given prefix.
   ```java
   String str = "hello";
   boolean starts = str.startsWith("he");  // true
   ```

10. **`endsWith(String suffix)`**
   - Checks if the string ends with the given suffix.
    ```java
    String str = "hello";
    boolean ends = str.endsWith("lo");  // true
    ```

11. **`indexOf(char ch)`**
   - Returns the index of the first occurrence of the specified character.
    ```java
    String str = "hello";
    int index = str.indexOf('e');  // 1
    ```

12. **`lastIndexOf(char ch)`**
   - Returns the index of the last occurrence of the specified character.
    ```java
    String str = "hello";
    int index = str.lastIndexOf('l');  // 3
    ```

13. **`replace(char oldChar, char newChar)`**
   - Replaces all occurrences of the old character with the new character.
    ```java
    String str = "hello";
    String newStr = str.replace('l', 'p');  // "heppo"
    ```

14. **`trim()`**
   - Removes leading and trailing spaces.
    ```java
    String str = "  hello  ";
    String trimmed = str.trim();  // "hello"
    ```

### **Intermediate String Methods**
These methods are often used in DSA and development.

15. **`split(String regex)`**
   - Splits the string into an array using a regular expression.
    ```java
    String str = "apple,orange,banana";
    String[] fruits = str.split(",");  // ["apple", "orange", "banana"]
    ```

16. **`matches(String regex)`**
   - Checks if the string matches the given regular expression.
    ```java
    String str = "hello123";
    boolean matches = str.matches("[a-z]+[0-9]+");  // true
    ```

17. **`compareTo(String anotherString)`**
   - Compares two strings lexicographically.
    ```java
    String str1 = "apple";
    String str2 = "banana";
    int result = str1.compareTo(str2);  // negative value (-1)
    ```

18. **`compareToIgnoreCase(String str)`**
   - Compares two strings lexicographically, ignoring case differences.
    ```java
    String str1 = "Apple";
    String str2 = "apple";
    int result = str1.compareToIgnoreCase(str2);  // 0 (equal)
    ```

19. **`contains(CharSequence seq)`**
   - Returns `true` if the string contains the specified sequence of characters.
    ```java
    String str = "hello world";
    boolean contains = str.contains("world");  // true
    ```

20. **`join(CharSequence delimiter, CharSequence... elements)`**
   - Joins strings with a specified delimiter.
    ```java
    String result = String.join("-", "2024", "09", "23");  // "2024-09-23"
    ```

21. **`toCharArray()`**
   - Converts the string into a char array.
    ```java
    String str = "hello";
    char[] chars = str.toCharArray();  // ['h', 'e', 'l', 'l', 'o']
    ```

22. **`isEmpty()`**
   - Checks if the string is empty.
    ```java
    String str = "";
    boolean empty = str.isEmpty();  // true
    ```

23. **`intern()`**
   - Returns a canonical representation for the string object.
    ```java
    String str1 = new String("hello").intern();
    ```

### **Advanced String Methods**
Useful in advanced scenarios like optimization, DSA algorithms, or memory management.

24. **`regionMatches(int toffset, String other, int ooffset, int len)`**
   - Tests if two string regions are equal.
    ```java
    String str1 = "HelloWorld";
    String str2 = "World";
    boolean result = str1.regionMatches(5, str2, 0, 5);  // true
    ```

25. **`codePointAt(int index)`**
   - Returns the Unicode code point at the specified index.
    ```java
    String str = "hello";
    int codePoint = str.codePointAt(0);  // 104 (Unicode for 'h')
    ```

26. **`format(String format, Object... args)`**
   - Formats the string using a format string and arguments (similar to `printf`).
    ```java
    String formatted = String.format("Name: %s, Age: %d", "John", 25);
    ```

27. **`repeat(int count)`**
   - Repeats the string `count` times.
    ```java
    String str = "abc";
    String repeated = str.repeat(3);  // "abcabcabc"
    ```

28. **`strip()`**
   - Removes leading and trailing spaces (introduced in Java 11).
    ```java
    String str = "  hello  ";
    String stripped = str.strip();  // "hello"
    ```

29. **`stripLeading()`**
   - Removes only the leading spaces (introduced in Java 11).
    ```java
    String str = "  hello";
    String leadingStripped = str.stripLeading();  // "hello"
    ```

30. **`stripTrailing()`**
   - Removes only the trailing spaces (introduced in Java 11).
    ```java
    String str = "hello  ";
    String trailingStripped = str.stripTrailing();  // "hello"
    ```

31. **`transform(Function<String, String> f)`**
   - Applies a transformation to the string (introduced in Java 12).
    ```java
    String transformed = "hello".transform(s -> s.toUpperCase());  // "HELLO"
    ```

32. **`chars()`**
   - Returns an `IntStream` of character codes.
    ```java
    String str = "hello";
    str.chars().forEach(System.out::println);  // prints ASCII values of characters
    ```

### **Use Cases in DSA**
- **Pattern Matching**: Use `indexOf()`, `matches()`, and `split()` for pattern matching in string-based problems.
- **Palindromes**: Use `charAt()`, `toCharArray()`, or reverse strings for checking palindromes.
- **Substring Problems**: Use `substring()`, `compareTo()` in algorithms related to substrings.
- **Trie Implementation**: Use `charAt()`, `toCharArray()` to implement Trie data structure.

These methods cover a wide range of operations required in both string manipulation for development and competitive programming.


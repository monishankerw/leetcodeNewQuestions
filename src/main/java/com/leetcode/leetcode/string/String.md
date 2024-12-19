
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

```markdown
# Important Java String Questions for Interview

## 1. Reverse a String
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "MoniShanker";
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }
}
```

## 2. Check for Palindrome String
```java
public class PalindromeString {
    public static void main(String[] args) {
        String str = "madam";
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        if (str.equals(rev)) {
            System.out.println("Palindrome String");
        } else {
            System.out.println("Not Palindrome String");
        }
    }
}
```

## 3. Find FrequenyOccElements Characters
```java
import java.util.HashMap;
import java.util.Map;

public class FrequenyOccElements {
    public static void main(String[] args) {
        String str = "javadeveloper";
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char value : arr) {
            if (Character.isAlphabetic(value)) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
        System.out.println(map);
    }
}
```

## 4. Find Duplicate Elements
```java
public class DuplicateElement {
    public static void main(String[] args) {
        String str = "JavaDeveloper";
        int r = 0;
        char[] x = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (x[i] == x[j]) {
                    System.out.print(x[j]);
                    r++;
                    break;
                }
            }
        }
    }
}
```

## 5. Frequency of Characters
```java
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        String s = "aabcddeff";
        Map<Character, Integer> x = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            x.put(ch, x.getOrDefault(ch, 0) + 1);
        }
        System.out.println(x);
    }
}
```

## 6. Occurrence of a Character
```java
public class OccuranceOfCharacter {
    public static void main(String[] args) {
        String str = "aaabaccddee";
        char ch = 'a';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

## 7. Validate Brackets
```java
import java.util.Stack;

public class ValidateBracket {
    public static void main(String[] args) {
        String s = "{([])}";
        boolean status = validateStringBracket(s);
        System.out.println(s);
        System.out.println(status);
    }

    private static boolean validateStringBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                default:
                    stack.push(ch);
                    break;
            }
        }
        return stack.isEmpty();
    }
}
```

## 8. Sort Characters of a String
```java
import java.util.Arrays;

public class SortString {
    public static void main(String[] args) {
        String s = "edcab";
        System.out.println(sortingString(s));
    }

    private static String sortingString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
```

## 9. Reverse Words in a String
```java
public class ReverseWord {
    public static void main(String[] args) {
        String[] str = "my name is abc".split(" ");
        reverse(str);
    }

    private static void reverse(String[] str) {
        String rev = "";
        for (int i = str.length - 1; i >= 0; i--) {
            rev = rev + str[i] + " ";
        }
        System.out.println("Reverse String::");
        System.out.println(rev.trim());
    }
}
```

## 10. Count Number of Words
```java
public class CountNumberOfWords {
    public static void main(String[] args) {
        String str = "Welcome to java";
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == ' ') && (str.charAt(i + 1) != ' ')) {
                count++;
            }
        }
        System.out.println("Number of words: " + count);
    }
}
```

## 11. Count Characters in a String
```java
public class CountWord {
    public static void main(String[] args) {
        String str = "Java Developer";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                count++;
        }
        System.out.println(count);
    }
}
```

## 12. Check String Rotation
```java
public class StringRotation {
    public static void main(String[] args) {
        String a = "HELLO";
        String b = "LOHEL";
        if (checkRotation(a, b)) {
            System.out.println("Given Strings are rotations of each other");
        } else {
            System.out.println("Given Strings are not rotations of each other");
        }
    }

    private static boolean checkRotation(String a, String b) {
        if (a.length() != b.length()) return false;
        String temp = a + b;
        return temp.indexOf(b) != -1;
    }
}
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


## 13. Swap Adjacent Characters
```java
public class SwapString {
    public static void main(String[] args) {
        String str = "manishankar";
        System.out.println(swapping(str));
    }

    private static String swapping(String str) {
        if (str == null || str.isEmpty()) return str;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length - 1; i += 2) {
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;
        }
        return new String(ch);
    }
}
```
```
```
### 1. **Find the First Non-Repeating Character**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        System.out.println(findFirstNonRepeatingCharacter(str));
    }

    private static char findFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No non-repeating character found");
    }
}
```

### 2. **Count Vowels and Consonants**
```java
public class CountVowelsConsonants {
    public static void main(String[] args) {
        String str = "java programming";
        int vowels = 0, consonants = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

### 3. **Remove All Duplicate Characters**
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "aabccde";
        System.out.println(removeDuplicates(str));
    }

    private static String removeDuplicates(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : set) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
```

### 4. **Find the Longest Substring Without Repeating Characters**
```java
import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(findLongestUniqueSubstring(str));
    }

    private static int findLongestUniqueSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left++));
            }
            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

### 5. **Check if Two Strings are Anagrams**
```java
import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(areAnagrams(str1, str2));
    }

    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
```

### 6. **Reverse Words in a Sentence**
```java
public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Java is awesome";
        System.out.println(reverseWords(sentence));
    }

    private static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }
}
```

### 7. **Find the Longest Palindromic Substring**
```java
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindromicSubstring(str));
    }

    private static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

### 8. **Find All Permutations of a String**
```java
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = new ArrayList<>();
        generatePermutations(str, "", permutations);
        System.out.println(permutations);
    }

    private static void generatePermutations(String str, String prefix, List<String> permutations) {
        if (str.isEmpty()) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String newPrefix = prefix + str.charAt(i);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                generatePermutations(remaining, newPrefix, permutations);
            }
        }
    }
}
```

### 9. **Check if a String is a Rotation of Another String**
```java
public class StringRotation {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        System.out.println(isRotation(str1, str2));
    }

    private static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;
        return concatenated.contains(str2);
    }
}
```

### 10. **Find the Longest Common Prefix**
```java
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
```


### 1. **Check if Two Strings are Anagrams**
```java
public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are anagrams: " + areAnagrams(str1, str2));
    }

    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        java.util.Arrays.sort(s1);
        java.util.Arrays.sort(s2);
        return java.util.Arrays.equals(s1, s2);
    }
}
```

### 2. **Check if a String is a Rotated String**
```java
public class RotatedString {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        System.out.println("Is rotated: " + isRotated(str1, str2));
    }

    private static boolean isRotated(String str1, String str2) {
        return str1.length() == str2.length() && (str1 + str1).contains(str2);
    }
}
```

### 3. **Find All Unique Characters in a String**
```java
public class UniqueChars {
    public static void main(String[] args) {
        String str = "unique";
        System.out.println("Unique characters: " + findUniqueCharacters(str));
    }

    private static String findUniqueCharacters(String str) {
        StringBuilder unique = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (unique.indexOf(String.valueOf(ch)) == -1) {
                unique.append(ch);
            }
        }
        return unique.toString();
    }
}
```

### 4. **Reverse Words in a String**
```java
public class ReverseWords {
    public static void main(String[] args) {
        String str = "Java is awesome";
        System.out.println("Reversed words: " + reverseWords(str));
    }

    private static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }
}
```

### 5. **Check if a String Contains Only Digits**
```java
public class IsDigitsOnly {
    public static void main(String[] args) {
        String str = "123456";
        System.out.println("Contains only digits: " + isDigitsOnly(str));
    }

    private static boolean isDigitsOnly(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
```

### 6. **Convert a String to a Character Array and Sort It**
```java
public class SortCharacters {
    public static void main(String[] args) {
        String str = "java";
        System.out.println("Sorted characters: " + sortCharacters(str));
    }

    private static String sortCharacters(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }
}
```

### 7. **Count Occurrences of Each Character**
```java
import java.util.HashMap;
import java.util.Map;

public class CharCount {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Character count: " + countCharacters(str));
    }

    private static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }
}
```

### 8. **Check if a String is a Palindrome Ignoring Non-Alphanumeric Characters**
```java
public class PalindromeIgnoreNonAlphanumeric {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
```

### 9. **Find the Longest Substring Without Repeating Characters**
```java
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("Longest substring length: " + longestSubstringWithoutRepeating(str));
    }

    private static int longestSubstringWithoutRepeating(String s) {
        Set<Character> chars = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (chars.contains(s.charAt(right))) {
                chars.remove(s.charAt(left++));
            }
            chars.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

### 10. **Find the First Non-Repeating Character**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "swiss";
        System.out.println("First non-repeating character: " + findFirstNonRepeatingChar(str));
    }

    private static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No non-repeating character found");
    }
}
```

### 11. **Remove Duplicates from a String**
```java
public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "aabbcc";
        System.out.println("String without duplicates: " + removeDuplicates(str));
    }

    private static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
```

### 12. **Find the Longest Palindromic Substring**
```java
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println("Longest palindromic substring: " + longestPalindromicSubstring(str));
    }

    private static String longestPalindromicSubstring(String s) {
        if (s.isEmpty()) return "";
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1);
            String max = odd.length() > even.length() ? odd : even;
            if (max.length() > longest.length()) {
                longest = max;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
```

### 13. **Find the Index of the First Non-Repeating Character**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class IndexOfFirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println("Index of first non-repeating character: " + indexOfFirstNonRepeatingChar(str));
    }

    private static int indexOfFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return str.indexOf(entry.getKey());
            }
        }
        return -1; // No unique character found
    }
}
```

### 14. **Check if a String is a Substring of Another String**
```java
public class IsSubstring {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "ell";
        System

.out.println("Is substring: " + isSubstring(str1, str2));
    }

    private static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}
```

### 15. **Count the Number of Words in a String**
```java
public class CountWords {
    public static void main(String[] args) {
        String str = "This is a sample string";
        System.out.println("Word count: " + countWords(str));
    }

    private static int countWords(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }
}
```

### 16. **Reverse Each Word in a String**
```java
public class ReverseEachWord {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("Reversed words: " + reverseEachWord(str));
    }

    private static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            StringBuilder wordBuilder = new StringBuilder(word);
            reversed.append(wordBuilder.reverse().toString()).append(" ");
        }
        return reversed.toString().trim();
    }
}
```

### 17. **Replace All Occurrences of a Substring**
```java
public class ReplaceSubstring {
    public static void main(String[] args) {
        String str = "Hello World, Hello Java";
        String target = "Hello";
        String replacement = "Hi";
        System.out.println("Replaced string: " + replaceSubstring(str, target, replacement));
    }

    private static String replaceSubstring(String str, String target, String replacement) {
        return str.replace(target, replacement);
    }
}
```

### 18. **Find the Common Prefix String Array**
```java
public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Common prefix: " + commonPrefix(strs));
    }

    private static String commonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
```

### 19. **Count Palindromic Substrings**
```java
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Count of palindromic substrings: " + countPalindromicSubstrings(str));
    }

    private static int countPalindromicSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
```

### 20. **Find the Shortest Palindrome String by Adding Characters**
```java
public class ShortestPalindrome {
    public static void main(String[] args) {
        String str = "aacecaaa";
        System.out.println("Shortest palindrome: " + shortestPalindrome(str));
    }

    private static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] kmp = buildKMP(l);
        return rev.substring(0, s.length() - kmp[kmp.length - 1]) + s;
    }

    private static int[] buildKMP(String s) {
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
```

### 21. **Check if a String is a Valid Palindrome (ignoring cases and non-alphanumeric characters)**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Is valid palindrome: " + isValidPalindrome(str));
    }

    private static boolean isValidPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
```

### 22. **Generate All Substrings of a String**
```java
import java.util.HashSet;
import java.util.Set;

public class AllSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("All substrings: " + generateSubstrings(str));
    }

    private static Set<String> generateSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings;
    }
}
```

### 23. **Convert a String to Lowercase Without Using Built-in Methods**
```java
public class ToLowerCase {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Lowercase string: " + toLowerCase(str));
    }

    private static String toLowerCase(String str) {
        StringBuilder lower = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                lower.append((char) (ch + 32));
            } else {
                lower.append(ch);
            }
        }
        return lower.toString();
    }
}
```

### 24. **Convert a String to Uppercase Without Using Built-in Methods**
```java
public class ToUpperCase {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Uppercase string: " + toUpperCase(str));
    }

    private static String toUpperCase(String str) {
        StringBuilder upper = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                upper.append((char) (ch - 32));
            } else {
                upper.append(ch);
            }
        }
        return upper.toString();
    }
}
```

### 25. **Find the Length of the Longest Common Prefix in Two Strings**
```java
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String str1 = "flower";
        String str2 = "flow";
        System.out.println("Length of longest common prefix: " + lengthOfLongestCommonPrefix(str1, str2));
    }

    private static int lengthOfLongestCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < minLength && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }
}
```

### 26. **Replace All Occurrences of a Character with Another Character**
```java
public class ReplaceChar {
    public static void main(String[] args) {
        String str = "hello world";
        char oldChar = 'o';
        char newChar = 'a';
        System.out.println("Replaced string: " + replaceChar(str, oldChar, newChar));
    }

    private static String replaceChar(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }
}
```

### 27. **Find the Longest Prefix Suffix**
```java
public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String str = "ababcababc";
        System.out.println("Longest prefix suffix: " + longestPrefixSuffix(str));
    }

    private static String longestPrefixSuffix(String str) {
        int n = str.length();
        String prefixSuffix = "";
        for (int i = 0; i < n / 2; i++) {
            if (str.substring(0, i + 1).equals(str.substring(n - i - 1))) {
                prefixSuffix = str.substring(0, i + 1);
            }
        }
        return prefixSuffix;
    }
}
```

### 28. **Determine if a String Can Be Rearranged to Form a Palindrome**
```java
import java.util.HashMap;
import java.util.Map;

public

 class CanFormPalindrome {
    public static void main(String[] args) {
        String str = "carerac";
        System.out.println("Can form palindrome: " + canFormPalindrome(str));
    }

    private static boolean canFormPalindrome(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
```

### 29. **Count the Number of Vowels in a String**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("Number of vowels: " + countVowels(str));
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
```

### 30. **Find the Minimum Window Substring Containing All Characters of Another String**
```java
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> charCountT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCountT.put(ch, charCountT.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> charCountS = new HashMap<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
        int required = charCountT.size();
        int formed = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            charCountS.put(ch, charCountS.getOrDefault(ch, 0) + 1);
            if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() == charCountT.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                ch = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                charCountS.put(ch, charCountS.get(ch) - 1);
                if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() < charCountT.get(ch).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
```

### 31. **Check if a String is a Rotation of Another String Using Substring Check**
```java
public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println("Is rotation: " + isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
```

### 32. **Find the Longest Substring with At Most K Distinct Characters**
```java
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {
    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;
        System.out.println("Longest substring length: " + longestSubstringWithKDistinct(str, k));
    }

    private static int longestSubstringWithKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);
            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) {
                    charCount.remove(s.charAt(left));
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
```

### 33. **Find All Permutations of a String**
```java
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutations: " + generatePermutations(str));
    }

    private static List<String> generatePermutations(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s);
        return result;
    }

    private static void backtrack(List<String> result, String path, String s) {
        if (s.length() == 0) {
            result.add(path);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            backtrack(result, path + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
        }
    }
}
Here is a step-by-step explanation of how the `permute` method works, using recursion and backtracking:

### Step-by-Step Breakdown:

1. **Initial Call:**
   - The initial method call is `permute("", "abc", result)`, where:
     - `prefix = ""` (empty string, no characters chosen yet)
     - `s = "abc"` (all characters are still available to use)
     - `result = []` (empty list to store the permutations)
   
2. **First Level Recursion (Processing "abc"):**
   - The method checks if `s.length()` is 0 (it is not).
   - It enters a loop to iterate over each character in `"abc"`:
     - First, it picks `'a'` and calls `permute("a", "bc", result)`:
       - `prefix = "a"`
       - `s = "bc"` (character `'a'` is removed from `s`).
     - The method will recursively go deeper with this choice.

3. **Second Level Recursion (Processing "bc"):**
   - Now, the method is working with `"bc"`:
     - Again, it checks if `s.length()` is 0 (it is not).
     - It enters another loop to iterate over `"bc"`:
       - First, it picks `'b'` and calls `permute("ab", "c", result)`:
         - `prefix = "ab"`
         - `s = "c"` (character `'b'` is removed from `s`).
       - The method continues with this choice.

4. **Third Level Recursion (Processing "c"):**
   - The method is now working with `"c"`:
     - It checks if `s.length()` is 0 (it is not).
     - It loops over the single character `'c'` and calls `permute("abc", "", result)`:
       - `prefix = "abc"`
       - `s = ""` (character `'c'` is removed, leaving an empty string).
     - This is the deepest point of the recursion for this path.

5. **Base Case Reached:**
   - At this point, the method checks `s.length()` and finds that it is 0.
   - This means a complete permutation has been formed: `"abc"`.
   - The method adds `"abc"` to the `result` list: `result = ["abc"]`.
   - Now the method backtracks to explore other possibilities.

6. **Backtracking to Explore Other Permutations:**
   - After the permutation `"abc"` is added, the method backtracks to the second level where it had chosen `'b'`.
   - It now picks the second character `'c'` from `"bc"` and calls `permute("ac", "b", result)`:
     - `prefix = "ac"`
     - `s = "b"`
   - The recursion continues with this new choice.

7. **Completing More Permutations:**
   - The same process continues:
     - From `"ac"`, it picks `'b'` and calls `permute("acb", "", result)`.
     - Since `s` is empty, `"acb"` is added to the result list: `result = ["abc", "acb"]`.
   - The method backtracks again and keeps trying other combinations like `bac`, `bca`, `cab`, `cba`, etc.

8. **Recursion Ends:**
   - After all characters have been explored and all possible permutations have been added to `result`, the recursion ends.
   - The final list of permutations is: `["abc", "acb", "bac", "bca", "cab", "cba"]`.

### Visual Representation:

The flow of recursive calls can be visualized as a decision tree:

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

### 34. **Find the Number of Words in a String Using Regular Expressions**
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWordsRegex {
    public static void main(String[] args) {
        String str = "This is a sample string.";
        System.out.println("Word count: " + countWords(str));
    }

    private static int countWords(String str) {
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
```

### 35. **Check if a String Contains All Unique Characters Using Bitwise Operators**
```java
public class UniqueCharsBitwise {
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println("Contains unique characters: " + hasUniqueChars(str));
    }

    private static boolean hasUniqueChars(String str) {
        int checker = 0;
        for (char ch : str.toCharArray()) {
            int bitIndex = ch - 'a';
            if ((checker & (1 << bitIndex)) > 0) {
                return false;
            }
            checker |= (1 << bitIndex);
        }
        return true;
    }
}
```

### 36. **Find the Smallest Substring Containing All Characters of Another String**
```java
import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContainingAllChars {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Smallest substring: " + smallestSubstring(s, t));
    }

    private static String smallestSubstring(String s, String t) {
        Map<Character, Integer> charCountT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCountT.put(ch, charCountT.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> charCountS = new HashMap<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
        int required = charCountT.size();
        int formed = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            charCountS.put(ch, charCountS.getOrDefault(ch, 0) + 1);
            if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() == charCountT.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                ch = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                charCountS.put(ch, charCountS.get(ch) - 1);
                if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() < charCountT.get(ch).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
```

### 37. **Count the Number of Distinct Substrings**
```java
import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstrings {
    public static void main(String[] args) {
        String str = "banana";
        System.out

.println("Distinct substrings count: " + countDistinctSubstrings(str));
    }

    private static int countDistinctSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings.size();
    }
}
```

### 38. **Check if a String is a Subsequence of Another String**
```java
public class SubsequenceCheck {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        System.out.println("Is subsequence: " + isSubsequence(s1, s2));
    }

    private static boolean isSubsequence(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index1++;
            }
            index2++;
        }
        return index1 == s1.length();
    }
}
```

### 39. **Find the Most Frequent Character in a String**
```java
import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Most frequent character: " + mostFrequentCharacter(str));
    }

    private static char mostFrequentCharacter(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        char maxChar = s.charAt(0);
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }
}
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


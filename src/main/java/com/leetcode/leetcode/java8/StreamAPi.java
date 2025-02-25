package com.leetcode.leetcode.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

---

### **1. What is a Stream?**
- A **sequence of elements** supporting sequential/parallel operations.
- **Not a data structure**; it takes input from sources (collections, arrays, I/O).
- **Does not modify the source data** (non-invasive).
- Supports **lazy evaluation** and **pipelined operations**.

---

### **2. Key Concepts**
- **Intermediate Operations**: Return a new stream (e.g., `filter`, `map`, `sorted`). Lazy—executed only when a terminal operation is invoked.
- **Terminal Operations**: Produce a result or side-effect (e.g., `collect`, `forEach`, `reduce`). Consumes the stream.
- **Stream Pipeline**: Combines a source, intermediate operations, and a terminal operation.

---

### **3. Creating Streams**
```java
// From a collection
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();

// From an array
String[] array = {"a", "b", "c"};
Stream<String> arrayStream = Arrays.stream(array);

// Static factory methods
Stream<String> staticStream = Stream.of("a", "b", "c");

// Infinite streams
Stream<Integer> infinite = Stream.iterate(0, n -> n + 1); // 0,1,2,...
Stream<Double> randoms = Stream.generate(Math::random); // random numbers
```

---

### **4. Common Operations**
#### **Intermediate Operations**
- **`filter(Predicate<T>)`**: Select elements matching a condition.
  ```java
  stream.filter(s -> s.startsWith("A"));
  ```
- **`map(Function<T, R>)`**: Transform elements.
  ```java
  stream.map(String::toUpperCase);
  ```
- **`flatMap(Function<T, Stream<R>>)`**: Flatten nested streams.
  ```java
  List<List<String>> nested = ...;
  nested.stream().flatMap(List::stream); // Stream<String>
  ```
- **`sorted()` / `sorted(Comparator<T>)`**: Order elements.
- **`distinct()`**: Remove duplicates.
- **`limit(n)` / `skip(n)`**: Truncate or skip elements.

#### **Terminal Operations**
- **`collect(Collector)`**: Aggregate results (e.g., into a list).
  ```java
  List<String> result = stream.collect(Collectors.toList());
  ```
- **`forEach(Consumer<T>)`**: Apply an action to each element.
- **`reduce()`**: Combine elements (e.g., sum, min).
  ```java
  int sum = numbers.stream().reduce(0, Integer::sum);
  ```
- **`count()`**: Count elements.
- **`anyMatch()` / `allMatch()` / `noneMatch()`**: Check predicates.
- **`findFirst()` / `findAny()`**: Retrieve elements (returns `Optional<T>`).

---

### **5. Collectors Utility Class**
Predefined collectors for common operations:
```java
// Collect to a list/set
Collectors.toList();
Collectors.toSet();

// Join strings
String joined = stream.collect(Collectors.joining(", "));

// Group by a property
Map<String, List<Employee>> byDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));

// Partition by a condition
Map<Boolean, List<String>> partitioned = stream
    .collect(Collectors.partitioningBy(s -> s.length() > 5));
```

---

### **6. Parallel Streams**
- Enable parallel processing via `parallelStream()` or `parallel()`.
- **Caution**: Ensure thread safety and avoid shared mutable state.
```java
list.parallelStream().filter(...).collect(...);
```

---

### **7. Examples**
#### **Filter, Map, Collect**
```java
List<String> filtered = names.stream()
    .filter(s -> s.startsWith("A"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

#### **Summing Squares of Even Numbers**
```java
int sum = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .reduce(0, Integer::sum);
```

---

### **8. Best Practices & Pitfalls**
- **Avoid side-effects** in stream operations (use pure functions).
- **Order matters**: Stateful ops (e.g., `sorted`, `distinct`) can impact performance.
- **Reuse streams**: Once consumed, streams cannot be reused.
- **Prefer method references** for readability (e.g., `String::length`).

---

### **9. Key Advantages**
- **Readability**: Declarative code expresses intent clearly.
- **Conciseness**: Reduce boilerplate code (e.g., loops).
- **Parallelism**: Easy parallelization with minimal code changes.

---

The Stream API is a powerful tool for writing clean, efficient data processing pipelines in Java. By combining operations like `filter`, `map`, and `collect`, you can express complex logic succinctly while leveraging multicore processors with parallel streams.
 */
public class StreamAPi {

    public static void main(String[] args) {
        List<Integer>num =Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer>num1 =Arrays.asList(3,5,7,8,4,6,4,1);
        List<String> startWith = Arrays.asList("1122", "2222", "11112", "444444");
        List<Integer> remDuplicate = Arrays.asList(1, 2, 1, 3, 1, 4, 2, 4);
        // even number 2,4,6,8
        //num%2==0
        //stream(): convert collection into stream

//        Stream<Integer> stream = num.stream();
//        System.out.println(stream);
        // // collect(): Collects the elements into a another data structure.
        //        // 1. filter():filter the elements based on a predicate.
        List<Integer>evenNumber=num.stream().filter(nums->nums%2==0).collect(Collectors.toList());
        System.out.println("Even Number:"+evenNumber);

        //2.odd number
        List<Integer>oddNumber=num.stream().filter(nums->nums%2!=0).collect(Collectors.toList());
        System.out.println("Odd Number:"+oddNumber);

        //3.sum of even number
        // reduce():Terminal Operation
        // 3.REDUCE()->THE REDUCE METHOD IS USED TO REDUCE THE ELEMENTS OF A STREAM TO A SINGLE VALUE.
        //Used to perform a reduction on the elements of a stream using an associative accumulation function and returning an optional with the reduced value.

        Integer sum = num.stream().filter(nums -> nums % 2 == 0).reduce(0, (a, b) -> a + b);
       /*
       Method	Explanation
list.stream()	Creates a stream from the list.
.filter(x -> x % 2 == 0)	Filters even numbers (x % 2 == 0).
.reduce(0, (a, b) -> a + b)	Reduces the stream to a single value (sum of elements).
        */
        System.out.println(sum);

        //4.

        Map<Boolean, List<Integer>> map = num.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
       /*
       Operation	Explanation
list.stream()	Creates a stream from the list.
s -> s % 2 == 0	Predicate to check if a number is even.
Collectors.partitioningBy	Partitions the stream elements into two groups.
        */
        System.out.println("EVEN NUMBER:"+map.get(true));
        System.out.println("ODD NUMBER:"+map.get(false));

        // 5. map : Transforms each elements into another form
        List<Integer> list = num.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
        System.out.println("Square even Number::"+list);

        // 6. startWith
        List<String> list1 = startWith.stream().filter(x -> x.startsWith("1")).collect(Collectors.toList());
        System.out.println("StartWith:"+list1);

        // 7. Remove Duplicate
        List<Integer> removeDuplicate = remDuplicate.stream().distinct().collect(Collectors.toList());
        System.out.println("Remove Duplicate::"+removeDuplicate);

        //  8. mapToInt
        // sum all number in list
        System.out.println("Sum All Numbers::" + num.stream().mapToInt(Integer::intValue).sum());

        //  9. sort the number acending or descending
        List<Integer> sortAccending = num1.stream().sorted().collect(Collectors.toList());
        System.out.println("SORT ELEMENTS ACCENDING ORDER"+sortAccending);

        // 10. sort number descending order
        List<Integer> descendingOrder = num1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("DescendingOrder:"+descendingOrder);



        // 11. greater than 4 and then find their average
        OptionalDouble average = num1.stream().filter(x -> x > 4).mapToInt(x -> x).average();
        System.out.println("AVERAGE:"+average);

        //  12. flatMap(): flatten the lists into a single list
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 1),Arrays.asList(5, 7, 6));

        //13.
        List<Integer> singleList = lists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Single List::"+singleList);

        //14.  merge and remove duplicate
        List<Integer> merge = lists.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
        System.out.println("Merge List::"+merge);

        // 15.Find the second-highest number
        Optional<Integer> secondHighestNumber = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second Highest Number::"+secondHighestNumber);

        //16. Maximum Value in a List
        OptionalInt maxNumber = num.stream().mapToInt(x -> x).max();
        System.out.println("Max Number:"+maxNumber);
        OptionalInt minNumber = num.stream().mapToInt(x -> x).min();

        //17. Average of Even Numbers
        OptionalDouble avgOfEvenNumber = num.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average();
        System.out.println("Avg Of even number"+avgOfEvenNumber);

        //18. Count Numbers Divisible by 3
        long count = num.stream().mapToInt(x -> x).filter(x -> x % 3 == 0).count();
        System.out.println("Count Numbers Divisible by 3:"+count);

        //19. Convert a List of Numbers to Their ASCII Characters

        List<Integer> assValue = Arrays.asList(67, 67, 68, 98, 97);
        assValue.stream().mapToInt(x->x).mapToObj(c->(char)c).forEach(c->System.out.println("Characters::"+c));

        //20.Convert String Lengths to an IntStream
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
        words.stream().mapToInt(String::length).forEach(length->System.out.println("Length:"+length));

        //21.Find the longest string using reduce
        Optional<String> longestString = words.stream().reduce((x, y) -> x.length() > y.length() ? x : y);
        System.out.println("Longest String ::"+longestString);
        //22. uppercase
        List<String> upperCase = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("UpperCase::"+upperCase);

        //23. Convert a stream of strings to a list of integers representing their lengths
        List<Integer> x2 = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(x2);

        //24. Split the string into individual characters
        String input="aavdaaavdsswfsasa";
        String[] output = input.split("");
        System.out.println("OUTPUT::"+Arrays.toString(output));

        //25. Count occurrences of each character
        Map<String, Long> countOccurence = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Count occurrences of each character:::"+countOccurence);

        //26.Find duplicate characters with occurrences > 1
        List<String> duplicateChar = Arrays.stream(input.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Find duplicate characters with occurrences"+duplicateChar);

        //27.  Find unique elements

        List<String> unique = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Find unique elements"+unique);

        //28.  Find the first non-repeating element

        // Step 1: Convert input string into a stream of characters
        Optional<String> firstNonRepeating = Arrays.stream(input.split("")) // Split string into individual characters
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences of each character
                .entrySet().stream() // Convert map to a stream of entries
                .filter(entry -> entry.getValue() == 1) // Filter entries where the count is 1 (non-repeating)
                .map(Map.Entry::getKey) // Extract the character (key)
                .findFirst(); // Find the first non-repeating character

        System.out.println("Find the first non-repeating element::"+firstNonRepeating);
    
// Intersection
int[] arr1 = {1, 2, 3,2, 4};
int[] arr2 = {1, 2};

// Convert arr1 to a Set for efficient lookup
Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        System.out.println("SET:"+set);
// Filter arr2 to find elements present in set and print them
System.out.print("Intersection: ");
Arrays.stream(arr2)
      .filter(set::contains)
      .distinct() // To ensure unique elements
      .forEach(System.out::println); // Correct usage of forEach

/*
Step	            Function	                   Result
Arrays.stream(arr1)	Convert int[] to IntStream	    [1, 2, 3, 2, 1]
.boxed()	Convert IntStream to Stream<Integer>	[Integer(1), Integer(2), Integer(3), Integer(2), Integer(1)]
.collect(Collectors.toSet())	Collect elements into a Set<Integer>	[1, 2, 3]


Step	Function	Result
Arrays.stream(arr2)	Converts arr2 to a stream	[3, 4, 5, 6]
.filter(set::contains)	Filters elements present in set	[3, 4] (if set = {3, 4})
.distinct()	Ensures no duplicates	[3, 4]
.forEach(System.out::println)	Prints each element in the stream	Prints 3 on one line and 4 on the next
 */
    }  
}
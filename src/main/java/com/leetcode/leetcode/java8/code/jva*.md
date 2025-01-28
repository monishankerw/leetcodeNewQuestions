
1. Stream Creation

stream() and parallelStream()
•	Purpose: Convert a collection or array into a stream for processing.
•	Usage:

List<Integer> list = Arrays.asList(1, 2, 3);
Stream<Integer> stream = list.stream();          // Sequential stream
Stream<Integer> parallelStream = list.parallelStream(); // Parallel stream


	•	Parallel vs Sequential:
	•	stream(): Processes elements sequentially.
	•	parallelStream(): Splits data and processes in parallel for potential performance gains.

2. Intermediate Operations

Intermediate operations transform or filter the stream. They return a stream and are lazy, meaning they don’t execute until a terminal operation is called.

filter(Predicate<T>)
•	Purpose: Filters elements based on a condition.
•	Usage:

Stream<Integer> evenNumbers = list.stream().filter(x -> x % 2 == 0);


	•	Example: Retain even numbers.

map(Function<T, R>)
•	Purpose: Transforms elements in a stream.
•	Usage:

Stream<String> stringLengths = list.stream().map(String::length);


	•	Example: Convert strings to their lengths.

flatMap(Function<T, Stream<R>>)
•	Purpose: Flattens nested streams into a single stream.
•	Usage:

List<List<Integer>> nestedList = List.of(List.of(1, 2), List.of(3, 4));
Stream<Integer> flatStream = nestedList.stream().flatMap(List::stream);


	•	Example: Flatten nested lists into a single list.

sorted(Comparator<T>)
•	Purpose: Sorts elements in natural or custom order.
•	Usage:

list.stream().sorted().forEach(System.out::println);
list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


	•	Example: Sort in ascending or descending order.

distinct()
•	Purpose: Removes duplicate elements.
•	Usage:

list.stream().distinct().forEach(System.out::println);


	•	Example: Remove duplicates from a list.

limit(long n)
•	Purpose: Truncates the stream to the first n elements.
•	Usage:

list.stream().limit(3).forEach(System.out::println);


	•	Example: Keep only the first 3 elements.

skip(long n)
•	Purpose: Skips the first n elements of the stream.
•	Usage:

list.stream().skip(3).forEach(System.out::println);


	•	Example: Ignore the first 3 elements.

peek(Consumer<T>)
•	Purpose: Allows debugging by performing an action on each element.
•	Usage:

list.stream().peek(System.out::println).collect(Collectors.toList());


	•	Example: Log intermediate elements during processing.

3. Terminal Operations

Terminal operations trigger the execution of intermediate operations.

forEach(Consumer<T>)
•	Purpose: Performs an action for each element.
•	Usage:

list.stream().forEach(System.out::println);


	•	Example: Print all elements.

collect(Collector<T, A, R>)
•	Purpose: Gathers stream elements into a collection or other structure.
•	Usage:

List<Integer> collected = list.stream().collect(Collectors.toList());


	•	Example: Convert a stream into a list.

reduce(BinaryOperator<T>)
•	Purpose: Combines elements to produce a single result.
•	Usage:

int sum = list.stream().reduce(0, Integer::sum);


	•	Example: Compute the sum of elements.

toArray()
•	Purpose: Converts the stream into an array.
•	Usage:

Integer[] array = list.stream().toArray(Integer[]::new);


	•	Example: Create an array from a stream.

count()
•	Purpose: Counts the number of elements in a stream.
•	Usage:

long count = list.stream().count();


	•	Example: Get the size of the stream.

findFirst() and findAny()
•	Purpose: Retrieve an element from the stream.
•	Usage:

Optional<Integer> first = list.stream().findFirst();
Optional<Integer> any = list.stream().findAny();


	•	Example: Fetch the first or any element.

allMatch(Predicate<T>), anyMatch(Predicate<T>), noneMatch(Predicate<T>)
•	Purpose: Test if elements match a condition.
•	Usage:

boolean allEven = list.stream().allMatch(x -> x % 2 == 0);
boolean anyEven = list.stream().anyMatch(x -> x % 2 == 0);
boolean noneEven = list.stream().noneMatch(x -> x % 2 == 0);


	•	Example:
	•	allMatch: True if all elements satisfy the predicate.
	•	anyMatch: True if any element satisfies the predicate.
	•	noneMatch: True if no element satisfies the predicate.

max(Comparator<T>) and min(Comparator<T>)
•	Purpose: Find the maximum or minimum element based on a comparator.
•	Usage:

Optional<Integer> max = list.stream().max(Integer::compare);
Optional<Integer> min = list.stream().min(Integer::compare);


	•	Example: Find the largest or smallest number.

4. Collectors

Used with the collect() terminal operation.

toList()
•	Purpose: Collects elements into a list.
•	Usage:

List<Integer> list = stream.collect(Collectors.toList());



toSet()
•	Purpose: Collects elements into a set.
•	Usage:

Set<Integer> set = stream.collect(Collectors.toSet());



joining()
•	Purpose: Concatenates strings with optional delimiter.
•	Usage:

String result = list.stream().map(String::valueOf).collect(Collectors.joining(", "));


	•	Example: Create a comma-separated string.

groupingBy(Function<T, K>)
•	Purpose: Groups elements by a key.
•	Usage:

Map<Integer, List<Integer>> grouped = list.stream().collect(Collectors.groupingBy(x -> x % 2));



partitioningBy(Predicate<T>)
•	Purpose: Partitions elements into two groups based on a predicate.
•	Usage:

Map<Boolean, List<Integer>> partitioned = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));

Would you like examples for specific methods or further explanations?

Suggested Questions:
1.	How do you use reduce() to calculate averages?
2.	What’s the difference between map() and flatMap()?
3.	How does groupingBy() differ from partitioningBy()?
4.	Can you demonstrate advanced collectors like toMap()?
5.	What are best practices for using parallelStream()?
6.	How to debug streams using peek()?
7.	Can you explain when to use findFirst() vs findAny()?

````
````
# Stream API Frequently Asked Questions

### 1. **How does `collect(Collectors.toList())` work?**
The `collect(Collectors.toList())` method is a terminal operation in the Stream API that collects elements from a stream into a `List`. It works by internally creating a `Collector` that accumulates the stream's elements into a `List`.

**Key Points**:
- Iterates through the stream and adds each element to a `List`.
- The resulting `List` is mutable and preserves the order of elements in the stream.

**Example**:
```java
List<String> names = List.of("Alice", "Bob", "Charlie");
List<String> collectedNames = names.stream()
                                   .filter(name -> name.startsWith("A"))
                                   .collect(Collectors.toList());
System.out.println(collectedNames); // Output: [Alice]
```

---

### 2. **Compare `Stream` and `parallelStream()`**

| Feature                | `Stream`                              | `parallelStream()`                      |
|------------------------|----------------------------------------|-----------------------------------------|
| Execution              | Sequential execution (single-threaded). | Parallel execution (multi-threaded).   |
| Performance            | Suitable for small or simple datasets. | Better for large datasets with CPU-intensive tasks. |
| Thread Utilization     | Uses a single core.                   | Utilizes multiple CPU cores.           |
| Order Preservation     | Preserves order unless explicitly modified. | Order may not always be preserved.    |
| Use Case               | When order is critical or data is small. | When performance gains are required on large datasets. |

**Example**:
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

// Stream
numbers.stream()
       .forEach(System.out::println);

// Parallel Stream
numbers.parallelStream()
       .forEach(System.out::println);
```

---

### 3. **Difference between `limit()` and `skip()`**

| Feature           | `limit(long n)`                        | `skip(long n)`                           |
|-------------------|----------------------------------------|------------------------------------------|
| Purpose           | Extracts the first `n` elements.       | Skips the first `n` elements and processes the rest. |
| Use Case          | Restrict the size of the stream.       | Ignore a specific number of elements.    |
| Example           | `stream.limit(3)` produces `[1, 2, 3]` | `stream.skip(2)` produces `[3, 4, 5]`    |

**Example**:
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

// limit()
List<Integer> limited = numbers.stream()
                               .limit(3)
                               .collect(Collectors.toList());
System.out.println(limited); // Output: [1, 2, 3]

// skip()
List<Integer> skipped = numbers.stream()
                               .skip(2)
                               .collect(Collectors.toList());
System.out.println(skipped); // Output: [3, 4, 5]
```

---

### 4. **How `reduce()` works with examples**

The `reduce()` method is used to perform a reduction on the elements of the stream using an accumulator. It combines elements into a single result.

**Key Variants**:
1. **Without an Identity**:
   - Returns an `Optional`.
   - Example:
     ```java
     List<Integer> numbers = List.of(1, 2, 3, 4);
     Optional<Integer> sum = numbers.stream()
                                    .reduce((a, b) -> a + b);
     System.out.println(sum.orElse(0)); // Output: 10
     ```

2. **With an Identity**:
   - Provides an initial value for the accumulator.
   - Example:
     ```java
     List<Integer> numbers = List.of(1, 2, 3, 4);
     int sum = numbers.stream()
                      .reduce(0, (a, b) -> a + b);
     System.out.println(sum); // Output: 10
     ```

3. **With an Identity and a Combiner** (for parallel streams):
   - Combines results from multiple threads.
   - Example:
     ```java
     List<Integer> numbers = List.of(1, 2, 3, 4);
     int product = numbers.stream()
                          .reduce(1, (a, b) -> a * b, (a, b) -> a * b);
     System.out.println(product); // Output: 24
     ```

---

### 5. **How to handle exceptions in the Stream API**

Exceptions can be tricky in streams due to the lambda-based functional approach. Common strategies include:

1. **Using a Wrapper Method**:
   - Example:
     ```java
     List<String> data = List.of("10", "20", "invalid", "30");
     List<Integer> numbers = data.stream()
                                 .map(StreamAPIExamples::safeParseInt)
                                 .collect(Collectors.toList());

     static Integer safeParseInt(String s) {
         try {
             return Integer.parseInt(s);
         } catch (NumberFormatException e) {
             return 0; // Default value
         }
     }
     ```

2. **Using `Try-Catch` Inside Lambdas**:
   - Example:
     ```java
     List<String> data = List.of("10", "20", "invalid", "30");
     List<Integer> numbers = data.stream()
                                 .map(s -> {
                                     try {
                                         return Integer.parseInt(s);
                                     } catch (NumberFormatException e) {
                                         return 0;
                                     }
                                 })
                                 .collect(Collectors.toList());
     ```

3. **Using a Custom Functional Interface**:
   Create a functional interface to handle exceptions cleanly.

---

### 6. **Limitations of Streams**

1. **One-Time Use**:
   A stream cannot be reused once its terminal operation is called.

2. **Debugging Challenges**:
   Debugging streams can be complex due to lambda expressions and lazy evaluation.

3. **Performance Overhead**:
   - Streams introduce overhead for small datasets compared to traditional loops.
   - Parallel streams may not always be efficient due to thread-management costs.

4. **Order Sensitivity**:
   Parallel streams might not maintain the order of elements unless explicitly specified.

5. **Not Suitable for Stateful Operations**:
   Operations like incrementing a counter or maintaining external state are discouraged.

---

### 7. **Stream Performance in Large Datasets**

1. **Sequential Streams**:
   - Work well for smaller datasets or when order matters.
   - Single-threaded execution might become a bottleneck for large datasets.

2. **Parallel Streams**:
   - Utilize multiple cores, reducing execution time for large datasets.
   - Performance improvement depends on the size of the data, the complexity of operations, and the number of available CPU cores.

3. **Key Considerations**:
   - Ensure the data source supports parallel processing (e.g., `ArrayList`, not `LinkedList`).
   - Avoid using parallel streams if thread safety is a concern.
   - Test performance before switching to parallel streams as it may degrade performance for simple tasks or small data.

**Example**:
```java
List<Integer> largeDataset = IntStream.range(1, 1_000_000)
                                      .boxed()
                                      .collect(Collectors.toList());

// Sequential Stream
long start = System.currentTimeMillis();
long sum1 = largeDataset.stream()
                        .reduce(0L, Long::sum);
long end = System.currentTimeMillis();
System.out.println("Sequential Time: " + (end - start) + "ms");

// Parallel Stream
start = System.currentTimeMillis();
long sum2 = largeDataset.parallelStream()
                        .reduce(0L, Long::sum);
end = System.currentTimeMillis();
System.out.println("Parallel Time: " + (end - start) + "ms");


```
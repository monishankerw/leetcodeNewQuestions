
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


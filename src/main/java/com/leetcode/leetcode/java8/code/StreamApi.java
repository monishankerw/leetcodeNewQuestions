package com.leetcode.leetcode.java8.code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
     STREAMAPI JAVA8FEATURES
->WHICH HELPS US TO MANIPULATE COLLECTION
->A STREAM IS A SEQUENCE OF OBJECTS THAT SUPPORTS VARIOUS METHODS.
->PRESENT IN java.util.package
-> A STREAM IS NOT PRESENT IN JAVA.UTIL PACKAGE

....INTERMEDIATE OPERATION
                            THREE METHODS:
                            1.FILTER():->FILTER IS USED FOR FILTERING THE DATA. IT ALWAYS RETURNS THE BOOLEAN VALUE.
                            2.MAP():->TRANSFER THE OBJECT VALUE.
                            Here are additional examples of intermediate operations in Java 8 Stream API:

Intermediate Operations Examples
	1.	filter(Predicate)
Filters elements based on a condition.
Example:

List<String> names = List.of("Alice", "Bob", "Charlie", "David");
List<String> filteredNames = names.stream()
                                  .filter(name -> name.length() > 3)
                                  .collect(Collectors.toList());
System.out.println(filteredNames); // Output: [Alice, Charlie, David]

	2.	map(Function)
Transforms each element into another form.
Example:

List<Integer> numbers = List.of(1, 2, 3, 4);
List<Integer> squaredNumbers = numbers.stream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());
System.out.println(squaredNumbers); // Output: [1, 4, 9, 16]

	3.	flatMap(Function)
Flattens nested structures (e.g., a list of lists).
Example:

List<List<Integer>> numberLists = List.of(
    List.of(1, 2, 3),
    List.of(4, 5),
    List.of(6, 7, 8)
);
List<Integer> flatList = numberLists.stream()
                                    .flatMap(List::stream)
                                    .collect(Collectors.toList());
System.out.println(flatList); // Output: [1, 2, 3, 4, 5, 6, 7, 8]

	4.	sorted()
Sorts the elements in natural order or based on a comparator.
Example 1 (Natural Order):

List<Integer> numbers = List.of(4, 2, 3, 1);
List<Integer> sortedNumbers = numbers.stream()
                                     .sorted()
                                     .collect(Collectors.toList());
System.out.println(sortedNumbers); // Output: [1, 2, 3, 4]

Example 2 (Custom Comparator):

List<String> names = List.of("Charlie", "Bob", "Alice");
List<String> sortedNames = names.stream()
                                .sorted((a, b) -> b.compareTo(a)) // Reverse order
                                .collect(Collectors.toList());
System.out.println(sortedNames); // Output: [Charlie, Bob, Alice]

	5.	distinct()
Removes duplicate elements.
Example:

List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
List<Integer> distinctNumbers = numbers.stream()
                                       .distinct()
                                       .collect(Collectors.toList());
System.out.println(distinctNumbers); // Output: [1, 2, 3, 4, 5]

	6.	limit(long n)
Limits the stream to the first n elements.
Example:

List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> limitedNumbers = numbers.stream()
                                      .limit(3)
                                      .collect(Collectors.toList());
System.out.println(limitedNumbers); // Output: [1, 2, 3]

	7.	skip(long n)
Skips the first n elements.
Example:

List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> skippedNumbers = numbers.stream()
                                      .skip(2)
                                      .collect(Collectors.toList());
System.out.println(skippedNumbers); // Output: [3, 4, 5]

	8.	peek(Consumer)
Performs an action on each element as it is processed (used for debugging).
Example:

List<Integer> numbers = List.of(1, 2, 3, 4);
List<Integer> doubledNumbers = numbers.stream()
                                      .peek(n -> System.out.println("Processing: " + n))
                                      .map(n -> n * 2)
                                      .collect(Collectors.toList());
System.out.println(doubledNumbers);
// Output:
// Processing: 1
// Processing: 2
// Processing: 3
// Processing: 4
// [2, 4, 6, 8]

	9.	takeWhile(Predicate) (Java 9 and later)
Takes elements while the condition is true.
Example:

List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> result = numbers.stream()
                              .takeWhile(n -> n < 4)
                              .collect(Collectors.toList());
System.out.println(result); // Output: [1, 2, 3]

	10.	dropWhile(Predicate) (Java 9 and later)
Drops elements while the condition is true, and processes the remaining.
Example:

List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> result = numbers.stream()
                              .dropWhile(n -> n < 4)
                              .collect(Collectors.toList());
System.out.println(result); // Output: [4, 5]

.....TERMINAL OPERATIONS
                            1.COLLECT()->THE COLLECT METHOD IS USED TO RETURN THE RESULT OF THE INTERMEDIATE OPERATIONS PERFORMED ON THE STREAM.
                            2.FOREACH()->THE FOREACH METHOD IS USED TO ITERATE THROUGH EVERY ELEMENTS OF THE STREAM.
                            3.REDUCE()->THE REDUCE METHOD IS USED TO REDUCE THE ELEMENTS OF A STREAM TO A SINGLE VALUE.
                            STREAM(): STREAM IS A SEQUENCE OF OBJECT WE CAN TRAVELS THROUGH SEQUENCE OF OBJECT THROUGH JAVA8.
                            1.SEQUENTIAL STREAM: sequential stream is where you current stream execute in one core in one thread.
                            2.PARALLEL STREAM:Parallel stream is applicable for multiple core sequential stream execute single core.


Common Interview Questions
	1.	How is a Stream different from a Collection?
	•	Stream processes elements on demand and does not store them.
	•	Collection stores data in memory.
	2.	What is lazy evaluation in Streams?
	•	Intermediate operations are not executed until a terminal operation is called, improving performance.
	3.	What are some pitfalls of using the Stream API?
	•	Overusing parallelStream() can degrade performance in tasks with high interdependencies.
	•	Streams cannot be reused once closed.
	4.	How does map() differ from flatMap()?
	•	map(): Transforms elements individually.
	•	flatMap(): Flattens nested structures into a single stream.
	5.	Can you modify data using Streams?
	•	Streams are typically used for transformations and not modifications. If you need to modify, consider using external structures.

Advantages
	•	Simplifies complex data processing.
	•	Built-in parallelism with parallelStream().
	•	Integrates seamlessly with Java Collections.


Potential Questions You Could Ask:
	1.	How does collect(Collectors.toList()) work?
	2.	Can you compare Stream and parallelStream()?
	3.	What is the difference between limit() and skip()?
	4.	Can you explain how reduce() works with examples?
	5.	How do you handle exceptions in the Stream API?
	6.	What are the limitations of Streams?
	7.	Can you explain stream performance in large datasets?

 */
public class StreamApi {

    public static class EvenNumberFilter {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
            List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).toList();
            System.out.println("Even Numbers: " + evenNumbers);

        }
    }
    public static class SumOfEvenNumbers {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            int sum = numbers.stream()
                    .filter(x -> x % 2 == 0)
                    .reduce(0, Integer::sum);
            System.out.println("Sum of Even Numbers: " + sum);
        }
    }

    public static class LongestStringFinder {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
            Optional<String> longestString = words.stream().reduce((x, y) -> x.length() > y.length() ? x : y);
            System.out.println("Longest String: " + longestString.orElse("No strings found"));
        }
    }

    public static class EvenOddPartition {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 7);
            Map<Boolean, List<Integer>> partitioned = numbers.stream()
                    .collect(Collectors.partitioningBy(x -> x % 2 == 0));
            System.out.println("Even Numbers: " + partitioned.get(true));
            System.out.println("Odd Numbers: " + partitioned.get(false));
        }
    }

    public static class SquareOfEvenNumbers {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> squares = numbers.stream()
                    .filter(x -> x % 2 == 0)
                    .map(x -> x * x)
                    .collect(Collectors.toList());
            System.out.println("Squares of Even Numbers: " + squares);
        }
    }

    public static class UpperCaseWords {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
            List<String> upperCaseWords = words.stream().map(String::toUpperCase).toList();
            System.out.println("Uppercase Words: " + upperCaseWords);
            List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
            System.out.println("Word Lengths: " + wordLengths);
        }
    }

    public static class AscendingOrder {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(2, 4, 1, 6, 75, 41);
            List<Integer> sortedNumbers = numbers.stream().sorted().toList();
            System.out.println("Ascending Order: " + sortedNumbers);
        }
    }

    public static class DescendingOrder {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(2, 4, 1, 6, 75, 41);
            List<Integer> sortedNumbers = numbers.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();
            System.out.println("Descending Order: " + sortedNumbers);
        }
    }

    public static class FilterByStartingDigit {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1233, 344, 111, 445, 5, 66, 3331, 111);
            List<Integer> filteredNumbers = numbers.stream()
                    .filter(x -> String.valueOf(x).startsWith("1"))
                    .collect(Collectors.toList());
            System.out.println("Numbers Starting with '1': " + filteredNumbers);
        }
    }

    public static class RemoveDuplicates {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 5, 6, 4, 1);
            List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
            System.out.println("Unique Numbers: " + uniqueNumbers);
        }
    }

    public static class SecondHighestNumber {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 5, 6, 4, 1);
            Optional<Integer> secondHighest = numbers.stream()
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .skip(1)
                    .findFirst();
            System.out.println("Second Highest Number: " + secondHighest.orElse(null));
        }
    }

    public static class MergeLists {
        public static void main(String[] args) {
            List<List<Integer>> nestedLists = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(3, 4, 2),
                    Arrays.asList(4, 3, 5)
            );
            List<Integer> mergedList = nestedLists.stream().flatMap(List::stream).toList();
            System.out.println("Merged List: " + mergedList);

            List<Integer> uniqueMergedList = nestedLists.stream()
                    .flatMap(List::stream)
                    .distinct()
                    .toList();
            System.out.println("Unique Merged List: " + uniqueMergedList);
        }
    }

    public static class IntersectionFinder {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 2};
            int[] arr2 = {1, 5, 3, 2};
            Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
            Arrays.stream(arr2).filter(set1::contains).distinct().forEach(System.out::println);
        }
    }

    public static class SumOfElements {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 4, 3, 2, 7, 9);
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Sum of Elements: " + sum);

            OptionalDouble average = numbers.stream().filter(x -> x > 4).mapToInt(x -> x).average();
            System.out.println("Average of Elements > 4: " + average.orElse(0.0));

            OptionalInt max = numbers.stream().mapToInt(x -> x).max();
            System.out.println("Max Element: " + max.orElse(Integer.MIN_VALUE));

            OptionalInt min = numbers.stream().mapToInt(x -> x).min();
            System.out.println("Min Element: " + min.orElse(Integer.MAX_VALUE));

            long divisibleBy3Count = numbers.stream().filter(x -> x % 3 == 0).count();
            System.out.println("Count of Numbers Divisible by 3: " + divisibleBy3Count);
        }
    }


 

        // Convert ASCII values to Characters
        public static class ConvertAsciiToChar {
            public static void main(String[] args) {
                List<Integer> asciiValues = Arrays.asList(67, 67, 68, 98, 97);
                asciiValues.stream()
                        .mapToInt(x -> x)
                        .mapToObj(c -> (char) c)
                        .forEach(c -> System.out.println("Character: " + c));
            }
        }

        // Convert String Lengths to IntStream
        public static class StringLengths {
            public static void main(String[] args) {
                List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
                words.stream()
                        .mapToInt(String::length)
                        .forEach(length -> System.out.println("Length: " + length));
            }
        }

        // Split String into Individual Characters
        public static class SplitString {
            public static void main(String[] args) {
                String input = "aavdaaavdsswfsasa";
                String[] output = input.split("");
                System.out.println("Split Output: " + Arrays.toString(output));
            }
        }

        // Count Occurrences of Each Character
        public static class CountCharacterOccurrences {
            public static void main(String[] args) {
                String input = "aavdaaavdsswfsasa";
                Map<String, Long> countOccurrences = Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                System.out.println("Character Occurrences: " + countOccurrences);
            }
        }

        // Find Duplicate Characters with Occurrences > 1
        public static class FindDuplicateCharacters {
            public static void main(String[] args) {
                String input = "aavdaaavdsswfsasa";
                List<String> duplicateChars = Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                System.out.println("Duplicate Characters: " + duplicateChars);
            }
        }

        // Find Unique Characters
        public static class FindUniqueCharacters {
            public static void main(String[] args) {
                String input = "aavdaaavdsswfsasa";
                List<String> uniqueChars = Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                System.out.println("Unique Characters: " + uniqueChars);
            }
        }

        // Find the First Non-Repeating Character
        public static class FirstNonRepeatingCharacter {
            public static void main(String[] args) {
                String input = "aavdaaavdsswfsasa";
                Optional<String> firstNonRepeating = Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst();
                System.out.println("First Non-Repeating Character: " + firstNonRepeating.orElse("None"));
            }
        }
    }



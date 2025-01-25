package com.leetcode.leetcode.java8.code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


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



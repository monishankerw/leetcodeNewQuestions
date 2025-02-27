package com.leetcode.leetcode.java8;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayQuestionsJava8 {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {
        // 1. Sum of Array Elements
        int[] arr1 = {1, 2, 3, 4};
        int sum = Arrays.stream(arr1).sum();
        System.out.println("1. Sum: " + sum);

        // 2. Find Maximum Element
        int max = Arrays.stream(arr1).max().orElse(0);
        System.out.println("2. Max: " + max);

        // 3. Find Minimum Element
        int min = Arrays.stream(arr1).min().orElse(0);
        System.out.println("3. Min: " + min);

        // 4. Filter Even Numbers
        int sumEven = Arrays.stream(arr1).filter(n -> n % 2 == 0).sum();
        System.out.println("4. Sum of evens: " + sumEven);

        // 5. Reverse an Array
        int[] reversed = IntStream.range(0, arr1.length)
                .map(i -> arr1[arr1.length - 1 - i])
                .toArray();
        System.out.println("5. Reversed array: " + Arrays.toString(reversed));

        // 6. Check for Duplicates
        int[] arr2 = {1, 2, 3, 2};
        boolean hasDuplicates = Arrays.stream(arr2).distinct().count() != arr2.length;
        System.out.println("6. Has duplicates: " + hasDuplicates);

        // 7. Remove Duplicates
        int[] unique = Arrays.stream(arr2).distinct().toArray();
        System.out.println("7. Unique array: " + Arrays.toString(unique));

        // 8. Rotate Array by K Positions
        int k = 2;
        int[] rotated = IntStream.range(0, arr1.length)
                .map(i -> arr1[(i + arr1.length - k) % arr1.length])
                .toArray();
        System.out.println("8. Rotated array: " + Arrays.toString(rotated));

        // 9. Sort Custom Objects
        Person[] people = {new Person("Alice", 30), new Person("Bob", 25)};
        Arrays.sort(people, (a, b) -> a.getAge() - b.getAge());
        System.out.println("9. Sorted people: " + Arrays.toString(people));

        // 10. Find Second Largest Element
        int[] arr3 = {5, 2, 8, 3};
        int secondLargest = Arrays.stream(arr3)
                .sorted()
                .skip(arr3.length - 2)
                .findFirst()
                .orElse(-1);
        System.out.println("10. Second largest: " + secondLargest);

        // 11. Merge Two Sorted Arrays
        int[] arr4 = {1, 3, 5};
        int[] arr5 = {2, 4, 6};
        int[] merged = IntStream.concat(Arrays.stream(arr4), Arrays.stream(arr5))
                .sorted()
                .toArray();
        System.out.println("11. Merged array: " + Arrays.toString(merged));

        // 12. Find Common Elements
        int[] arr6 = {1, 2, 3};
        int[] arr7 = {2, 3, 4};
        List<Integer> common = Arrays.stream(arr6)
                .filter(x -> Arrays.stream(arr7).anyMatch(y -> y == x))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("12. Common elements: " + common);

        // 13. Calculate Average
        double avg = Arrays.stream(arr1).average().orElse(0);
        System.out.println("13. Average: " + avg);

        // 14. Check Palindrome Array
        int[] palindrome = {1, 2, 3, 2, 1};
        boolean isPalindrome = IntStream.range(0, palindrome.length / 2)
                .allMatch(i -> palindrome[i] == palindrome[palindrome.length - 1 - i]);
        System.out.println("14. Is palindrome: " + isPalindrome);

        // 15. Frequency of Elements
        int[] freqArr = {1, 2, 2, 3, 3, 3};
        Map<Integer, Long> frequency = Arrays.stream(freqArr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("15. Frequency map: " + frequency);

        // 16. Find Intersection
        Set<Integer> set = Arrays.stream(arr7).boxed().collect(Collectors.toSet());
        int[] intersection = Arrays.stream(arr6)
                .filter(set::contains)
                .distinct()
                .toArray();
        System.out.println("16. Intersection: " + Arrays.toString(intersection));

        // 17. Multiply Corresponding Elements
        int[] arr8 = {1, 2, 3};
        int[] arr9 = {4, 5, 6};
        int[] product = IntStream.range(0, Math.min(arr8.length, arr9.length))
                .map(i -> arr8[i] * arr9[i])
                .toArray();
        System.out.println("17. Element-wise product: " + Arrays.toString(product));

        // 18. Longest Consecutive Sequence
        int[] seqArr = {100, 4, 200, 1, 3, 2};
        Set<Integer> numSet = Arrays.stream(seqArr).boxed().collect(Collectors.toSet());
        int longest = Arrays.stream(seqArr)
                .filter(num -> !numSet.contains(num - 1))
                .map(num -> {
                    int current = num;
                    int count = 0;
                    while (numSet.contains(current)) {
                        count++;
                        current++;
                    }
                    return count;
                })
                .max()
                .orElse(0);
        System.out.println("18. Longest sequence: " + longest);

        // 19. Find Missing Number
        int[] missingArr = {1, 2, 4, 5};
        int n = missingArr.length + 1;
        int missing = n * (n + 1) / 2 - Arrays.stream(missingArr).sum();
        System.out.println("19. Missing number: " + missing);

        // 20. Check Anagram Arrays
        int[] anagram1 = {1, 2, 3};
        int[] anagram2 = {3, 2, 1};
        boolean isAnagram = Arrays.equals(
                Arrays.stream(anagram1).sorted().toArray(),
                Arrays.stream(anagram2).sorted().toArray()
        );
        System.out.println("20. Are anagrams: " + isAnagram);

        //21. Flatten a 2D Array
        //Convert a 2D array into a 1D array using streams.
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        int[] flattened = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println("21. Flattened 2D array: " + Arrays.toString(flattened));
        //22. First Non-Repeated Element
        //Find the first non-repeated element in an array using streams.
        int[] repeatArr = {1, 2, 3, 2, 1, 4};
        Map<Integer, Long> frequencyMap = Arrays.stream(repeatArr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));

        int firstUnique = frequencyMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
        System.out.println("22. First non-repeated: " + firstUnique);

        //23. Partition Even and Odd Numbers
        //Split an array into even and odd numbers using partitioning.
        Map<Boolean, List<Integer>> partitioned = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.partitioningBy(n1 -> n1 % 2 == 0));
        System.out.println("23. Partitioned (even, odd): " + partitioned);

        //24. Validate All Positive Numbers
        //Check if all elements in the array are positive.
        boolean allPositive = Arrays.stream(arr1).allMatch(n2 -> n2 > 0);
        System.out.println("24. All elements positive: " + allPositive);

        //25. Convert String Array to Uppercase
        //Convert a string array to uppercase using streams.
        String[] words = {"java", "streams", "interview"};
        String[] upperWords = Arrays.stream(words)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println("25. Uppercase strings: " + Arrays.toString(upperWords));

        //26. Find Kth Smallest Element
        //Find the kth smallest element in an unsorted array using streams.
        int k1 = 3;
        int[] unsorted = {9, 3, 5, 1, 7};
        int kthSmallest = Arrays.stream(unsorted)
                .sorted()
                .skip(k1 - 1)
                .findFirst()
                .orElse(-1);
        System.out.println("26. 3rd smallest element: " + kthSmallest);

        //27. Sum of Squares of Even Numbers
        //Calculate the sum of squares of all even numbers in an array.

        int sumOfSquares = Arrays.stream(arr1)
                .filter(n3 -> n3 % 2 == 0)
                .map(n3 -> n3 * n3)
                .sum();
        System.out.println("27. Sum of squares of evens: " + sumOfSquares);

        //28. Count Occurrences of a Specific Element
        //Count how many times a specific element appears in an array.

        int target = 2;
        long count = Arrays.stream(arr1)
                .filter(n4 -> n4 == target)
                .count();
        System.out.println("28. Count of " + target + ": " + count);

        //29. Longest String in an Array
        //Find the longest string in a string array using streams.
        String[] strings = {"apple", "banana", "kiwi"};
        String longest1 = Arrays.stream(strings)
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .orElse("");
        System.out.println("29. Longest string: " + longest1);

        //30. Merge and Deduplicate Two Arrays
        //Merge two arrays and remove duplicates using streams.

        int[] mergeArr1 = {1, 2, 3};
        int[] mergeArr2 = {3, 4, 5};
        int[] mergedUnique = IntStream.concat(Arrays.stream(mergeArr1), Arrays.stream(mergeArr2))
                .distinct()
                .toArray();
        System.out.println("30. Merged unique: " + Arrays.toString(mergedUnique));

        //31. Check if Array is Sorted
        //Verify if an array is sorted in ascending order using streams.
        boolean isSorted = IntStream.range(0, arr1.length - 1)
                .allMatch(i -> arr1[i] <= arr1[i + 1]);
        System.out.println("31. Is sorted: " + isSorted);

        //32. Convert Primitive Array to List
        //Convert an int array to a List<Integer> using streams.

        List<Integer> list = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("32. Array as list: " + list);

        //33. Most Frequent Element
        //Find the element that appears most frequently in an array.
        Map<Integer, Long> freqMap = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        int mostFrequent = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
        System.out.println("33. Most frequent element: " + mostFrequent);

        //34. Square Every Element
        //Replace every element in an array with its square.
        int[] squared = Arrays.stream(arr1)
                .map(n5 -> n5 * n5)
                .toArray();
        System.out.println("34. Squared array: " + Arrays.toString(squared));

   //35. Find All Pairs with Given Sum
        //Find all pairs in an array that sum to a target value.
        int targetSum = 5;
        Set<Integer> seen = new HashSet<>();
        List<String> pairs = Arrays.stream(arr1)
                .boxed()
                .flatMap(x -> {
                    if (seen.contains(targetSum - x)) {
                        return Stream.of("(" + x + ", " + (targetSum - x) + ")");
                    } else {
                        seen.add(x);
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toList());
        System.out.println("35. Pairs summing to " + targetSum + ": " + pairs);


        //
      //   36. Convert List to Primitive Array
     //   Convert a List<Integer> to an int[] using streams.

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        int[] primitiveArray = integerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("36. List to array: " + Arrays.toString(primitiveArray));

        //37. Check If Any Element Satisfies Condition
        //Check if any element in the array is greater than 10.

        boolean anyGreaterThan10 = Arrays.stream(arr1).anyMatch(n6 -> n6 > 10);
        System.out.println("37. Any element > 10: " + anyGreaterThan10);

        //38. Sum of Elements Greater Than Threshold
        //Calculate the sum of elements greater than a given threshold.
        int threshold = 2;
        int sumAboveThreshold = Arrays.stream(arr1)
                .filter(n7 -> n7 > threshold)
                .sum();
        System.out.println("38. Sum above " + threshold + ": " + sumAboveThreshold);

        //39. Find Index of an Element
        //Find the index of a specific element in an array using streams.
        int searchElement = 3;
        int index = IntStream.range(0, arr1.length)
                .filter(i -> arr1[i] == searchElement)
                .findFirst()
                .orElse(-1);
        System.out.println("39. Index of " + searchElement + ": " + index);

        //40. Split Array into Two Based on Condition
        //Split an array into two lists: elements ≤ 5 and >5.
        Map<Boolean, List<Integer>> split = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.partitioningBy(n8 -> n8 <= 5));
        System.out.println("40. Split (≤5, >5): " + split);


    }
}
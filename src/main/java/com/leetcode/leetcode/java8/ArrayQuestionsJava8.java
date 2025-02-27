package com.leetcode.leetcode.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;

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
    }
}
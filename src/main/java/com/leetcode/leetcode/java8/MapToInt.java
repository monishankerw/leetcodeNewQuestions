package com.leetcode.leetcode.java8;

import java.util.*;

public class MapToInt {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 4);
        List<String> word = Arrays.asList("aaas", "dwwq", "fwewr", "fds");

        // Map words to their lengths
        word.stream().mapToInt(String::length)
                .forEach(length -> System.out.println("Length: " + length));

        // Sum of elements
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // Min and max values
        list.stream().mapToInt(x -> x).min()
                .ifPresent(min -> System.out.println("Min: " + min));

        list.stream().mapToInt(x -> x).max()
                .ifPresent(max -> System.out.println("Max: " + max));

        // Average of even numbers
        list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average()
                .ifPresent(avg -> System.out.println("Average: " + avg));

        // Count of numbers divisible by 3
        long count = list.stream().mapToInt(x -> x).filter(x -> x % 3 == 0).count();
        System.out.println("Count: " + count);

        // Remove duplicates from an array
        int[] arr = {1, 2, 3, 4, 5, 5, 3, 2, 6, 7};
        int[] uniqueArray = Arrays.stream(arr).distinct().toArray();
        System.out.println("Unique Elements: " + Arrays.toString(uniqueArray));

        // Remove duplicates using LinkedHashSet (preserving order)
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] uniqueArrayFromSet = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Unique Elements (LinkedHashSet): " + Arrays.toString(uniqueArrayFromSet));

        // Find intersection of two arrays
        int[] arr1 = {1, 2, 3, 5, 6};
        int[] arr2 = {2, 3, 4};
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for (int num : arr1)
            set1.add(num);
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        int[] intersectionArray = intersection.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Intersection: " + Arrays.toString(intersectionArray));

        // Convert a list of numbers to ASCII characters
        List<Integer> list1 = Arrays.asList(54, 65, 34, 75, 87);
        list1.stream().mapToInt(x -> x).mapToObj(c -> (char) c)
                .forEach(c -> System.out.println("Char: " + c));
    }
}
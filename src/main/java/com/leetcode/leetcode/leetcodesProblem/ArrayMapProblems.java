package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayMapProblems {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3};
        int[] arr2 = {3, 2, 1, 4, 2, 2, 3, 1};

        System.out.println("1. Frequency Count (Traditional): " + frequencyCount(arr));
        System.out.println("1. Frequency Count (Java 8): " + frequencyCountJava8(arr));

        System.out.println("2. First Non-Repeating (Traditional): " + firstNonRepeating(arr));
        System.out.println("2. First Non-Repeating (Java 8): " + firstNonRepeatingJava8(arr));

        System.out.println("3. Max Frequency Element (Traditional): " + maxFrequencyElement(arr));
        System.out.println("3. Max Frequency Element (Java 8): " + maxFrequencyElementJava8(arr));

        System.out.println("4. Are Anagrams (Traditional): " + areAnagrams(arr, arr2));
        System.out.println("4. Are Anagrams (Java 8): " + areAnagramsJava8(arr, arr2));

        System.out.println("5. Element Indices Map: " + elementIndices(arr));

        System.out.println("6. Count Pairs With Sum = 5: " + countPairsWithSum(arr, 5));

        System.out.println("7. Elements Appearing Exactly 2 Times: " + elementsKTimes(arr, 2));

        System.out.println("8. Has Zero Sum Subarray: " + hasZeroSumSubarray(new int[]{1, 2, -3, 4, 5}));

        System.out.println("9. Group By Remainder mod 3: " + groupByRemainder(arr, 3));

        System.out.println("10. Count Distinct Elements: " + countDistinctElements(arr));
    }

    // 1. Count frequency
    private static Map<Integer, Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);
        return map;
    }

    private static Map<Integer, Long> frequencyCountJava8(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 2. First non-repeating
    private static String firstNonRepeating(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                return String.valueOf(entry.getKey());

        return "None";
    }

    private static String firstNonRepeatingJava8(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .findFirst().orElse("None");
    }

    // 3. Max frequency
    private static String maxFrequencyElement(int[] arr) {
        Map<Integer, Integer> map = frequencyCount(arr);
        int max = 0, maxKey = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                maxKey = e.getKey();
            }
        }
        return maxKey + " => " + max;
    }

    private static String maxFrequencyElementJava8(int[] arr) {
        return frequencyCountJava8(arr).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> e.getKey() + " => " + e.getValue())
                .orElse("Empty");
    }

    // 4. Anagram check
    private static boolean areAnagrams(int[] a, int[] b) {
        return frequencyCount(a).equals(frequencyCount(b));
    }

    private static boolean areAnagramsJava8(int[] a, int[] b) {
        return frequencyCountJava8(a).equals(frequencyCountJava8(b));
    }

    // 5. Indices of each element
    private static Map<Integer, List<Integer>> elementIndices(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        return map;
    }

    // 6. Count pairs with a given sum
    private static int countPairsWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            count += map.getOrDefault(target - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    // 7. Elements appearing exactly k times
    private static List<Integer> elementsKTimes(int[] arr, int k) {
        Map<Integer, Integer> map = frequencyCount(arr);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == k)
                result.add(entry.getKey());
        }
        return result;
    }

    // 8. Subarray with zero sum
    private static boolean hasZeroSumSubarray(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == 0 || seen.contains(sum))
                return true;
            seen.add(sum);
        }
        return false;
    }

    // 9. Group by remainder
    private static Map<Integer, List<Integer>> groupByRemainder(int[] arr, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n : arr) {
            int rem = n % k;
            map.computeIfAbsent(rem, x -> new ArrayList<>()).add(n);
        }
        return map;
    }

    // 10. Count distinct elements
    private static int countDistinctElements(int[] arr) {
        return new HashSet<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new))).size();
    }
}
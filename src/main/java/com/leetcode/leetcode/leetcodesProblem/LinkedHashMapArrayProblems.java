package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;

public class LinkedHashMapArrayProblems {

    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 6, 7, 5, 8, 6, 9};

        System.out.println("11. Frequency with Insertion Order: " + frequencyWithOrder(arr));
        System.out.println("12. First Unique in Insertion Order: " + firstUniqueInOrder(arr));
        System.out.println("13. Remove Duplicates Keeping Order: " + removeDuplicatesKeepOrder(arr));
        System.out.println("14. Frequency Map Preserving Order: " + frequencyMapPreserveOrder(arr));
        System.out.println("15. First and Last Positions (Insertion Order): " + firstAndLastPositions(arr));
    }

    // 11. Track the insertion order of array elements with their frequency
    private static Map<Integer, Integer> frequencyWithOrder(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // 12. Find the first element that appears only once (in insertion order)
    private static String firstUniqueInOrder(int[] arr) {
        Map<Integer, Integer> map = frequencyWithOrder(arr);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return String.valueOf(entry.getKey());
            }
        }
        return "None";
    }

    // 13. Remove duplicates while maintaining the order of array elements
    private static List<Integer> removeDuplicatesKeepOrder(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return new ArrayList<>(set);
    }

    // 14. Create a frequency map while preserving the order of input
    private static Map<Integer, Integer> frequencyMapPreserveOrder(int[] arr) {
        return frequencyWithOrder(arr); // same as 11
    }

    // 15. Map array elements to their first and last positions in insertion order
    private static Map<Integer, int[]> firstAndLastPositions(int[] arr) {
        Map<Integer, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[]{i, i});
            } else {
                map.get(arr[i])[1] = i;
            }
        }
        return map;
    }
}
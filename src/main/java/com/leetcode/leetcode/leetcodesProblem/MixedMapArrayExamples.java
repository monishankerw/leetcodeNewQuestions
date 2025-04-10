package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;

public class MixedMapArrayExamples {

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 3, 5, 6, 2};

        System.out.println("21. Squares in LinkedHashMap: " + squaresLinkedHashMap(arr));
        System.out.println("22. Map element to indices: " + mapToIndices(arr));
        System.out.println("23. Map<index,value>: " + indexValueMap(arr));
        System.out.println("24. Map to binary strings: " + binaryMap(arr));
        System.out.println("25. Duplicate in sliding window (k=3): " + hasDuplicateInWindow(arr, 3));
    }

    // 21. Map each number to its square using LinkedHashMap
    private static Map<Integer, Integer> squaresLinkedHashMap(int[] arr) {
        Map<Integer, Integer> squareMap = new LinkedHashMap<>();
        for (int num : arr) {
            squareMap.put(num, num * num);
        }
        return squareMap;
    }

    // 22. Map each element to list of indices where it appears
    private static Map<Integer, List<Integer>> mapToIndices(int[] arr) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        return indexMap;
    }

    // 23. Create a Map<index, value> from an array
    private static Map<Integer, Integer> indexValueMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        return map;
    }

    // 24. Map elements to their binary representation
    private static Map<Integer, String> binaryMap(int[] arr) {
        Map<Integer, String> binaryMap = new HashMap<>();
        for (int num : arr) {
            binaryMap.put(num, Integer.toBinaryString(num));
        }
        return binaryMap;
    }

    // 25. Detect duplicate in sliding window of size k
    private static boolean hasDuplicateInWindow(int[] arr, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (window.contains(arr[i])) return true;
            window.add(arr[i]);
            if (window.size() > k) {
                window.remove(arr[i - k]);
            }
        }
        return false;
    }
}
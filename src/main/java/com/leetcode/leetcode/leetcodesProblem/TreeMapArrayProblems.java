package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;

public class TreeMapArrayProblems {

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 30, 40, 50, 30, 60};

        System.out.println("16. Frequency in Sorted Order: " + frequencySorted(arr));
        System.out.println("17. Min/Max Frequency Elements: " + minMaxFrequencyElements(arr));
        System.out.println("18. Closest Greater/Smaller Element:");
        closestGreaterOrSmaller(arr);
        System.out.println("19. Group Elements into Bins: " + groupIntoBins(arr, 10));
        
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 3, 3, 4, 5};
        System.out.println("20. Merged Sorted Frequency Map: " + mergeAndCount(arr1, arr2));
    }

    // 16. Count frequency of array elements in sorted (ascending) order
    private static Map<Integer, Integer> frequencySorted(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // 17. Find the smallest and largest frequency elements
    private static String minMaxFrequencyElements(int[] arr) {
        Map<Integer, Integer> map = frequencySorted(arr);
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        int minElem = -1, maxElem = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < minFreq) {
                minFreq = entry.getValue();
                minElem = entry.getKey();
            }
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxElem = entry.getKey();
            }
        }
        return "MinFreq: " + minElem + "(" + minFreq + "), MaxFreq: " + maxElem + "(" + maxFreq + ")";
    }

    // 18. Find closest greater or smaller element for each array element
    private static void closestGreaterOrSmaller(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) set.add(num);

        for (int num : arr) {
            Integer lower = set.lower(num);
            Integer higher = set.higher(num);
            System.out.println("Element: " + num + ", Lower: " + lower + ", Higher: " + higher);
        }
    }

    // 19. Group elements into sorted bins (e.g., group 0-10, 11-20, ...)
    private static Map<String, List<Integer>> groupIntoBins(int[] arr, int binSize) {
        Map<String, List<Integer>> binMap = new TreeMap<>();
        for (int num : arr) {
            int start = (num / binSize) * binSize;
            int end = start + binSize - 1;
            String key = start + "-" + end;
            binMap.computeIfAbsent(key, k -> new ArrayList<>()).add(num);
        }
        return binMap;
    }

    // 20. Merge two sorted arrays into a TreeMap and count frequencies
    private static Map<Integer, Integer> mergeAndCount(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : arr2) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }
}
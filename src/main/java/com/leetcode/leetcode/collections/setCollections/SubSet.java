package com.leetcode.leetcode.collections.setCollections;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4};

        // Find matching subset values
        List<Integer> subsetValues = new ArrayList<>();
        boolean isSubset = isSubset(arr1, arr2, subsetValues);

        if (isSubset) {
            System.out.println("arr2[] is a subset of arr1[]");
        } else {
            System.out.println("arr2[] is not a subset of arr1[]");
        }
        System.out.println("Matching subset values: " + subsetValues);
    }

    private static boolean isSubset(int[] arr1, int[] arr2, List<Integer> subsetValues) {
        // Add all elements of arr1 to a Set for fast lookup
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Check elements of arr2 in the Set
        for (int num : arr2) {
            if (set1.contains(num)) {
                subsetValues.add(num);
            } else {
                return false; // If any element is missing, arr2 is not a subset
            }
        }
        return true;
    }
    /*
     Set<Integer> set1 = Arrays.stream(x).boxed().collect(Collectors.toSet());
     List<Integer> subset = Arrays.stream(y)
     .boxed().filter(set1::contains).collect(Collectors.toList());
     boolean isSubset=subset.size()==y.length;
     System.out.println(subset);
     */
}
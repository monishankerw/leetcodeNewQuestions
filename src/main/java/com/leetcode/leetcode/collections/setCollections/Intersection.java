package com.leetcode.leetcode.collections.setCollections;

import java.util.*;
import java.util.stream.Collectors;
//Intersection 1
public class Intersection {
    public static void main(String[] args) {
        int [] arr1={1,2,3,4};
        int [] arr2={1,2};

        /*
        usind java 8 stream api
         */
        System.out.println("Intersection with java 8 stream api::");
        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Arrays.stream(arr2).filter(set::contains).distinct().forEach(System.out::println);
        intersections(arr1,arr2);
    }

    private static void intersections(int[] arr1, int[] arr2) {
        Set<Integer>set=new HashSet<>();
        for (int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                System.out.println(arr2[i]);
            }
        }
    }

    //Intesection 2
//    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a map to store the frequency of elements in nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // List to store the intersection elements
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1); // Decrease the frequency
            }
        }

        // Convert the result list to an array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
}

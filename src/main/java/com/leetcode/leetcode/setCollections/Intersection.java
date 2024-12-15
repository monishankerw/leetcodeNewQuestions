package com.leetcode.leetcode.setCollections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
}

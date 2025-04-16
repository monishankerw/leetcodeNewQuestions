package com.leetcode.leetcode.arrays;

import java.util.Arrays;

public class ArraysCoding{
    public static class ArraysPartition{
        public static void main(String[] args) {
            int arr[]={1,4,2,3};
            System.out.println("Arrays Partition::"+arraysPartition(arr));
        }

        private static int arraysPartition(int[] arr) {
           Arrays.sort(arr);
            int sum=0;
            for (int i=0;i<arr.length;i+=2){
                sum+=arr[i];
            }
           return sum;
        }
    }
}

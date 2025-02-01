package com.leetcode.leetcode.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Leets150QuestionSolveds {
    public static class MergeSortedArray {
        public static void main(String[] args) {
            int nums1[] = {1, 2, 3, 0, 0, 0}, m = 3, nums2[] = {2, 5, 6}, n = 3;
            merges(nums1, m, nums2, n);
            int[] merged = mergeSortedArrayss(nums1, m, nums2, n);
            System.out.println("Output: " + Arrays.toString(nums1));
        }


        private static void merges(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;

            // Merge in reverse order to utilize the extra space in nums1
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }

            // If there are remaining elements in nums2
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }

        }

        private static int[] mergeSortedArrayss(int[] nums1, int m, int[] nums2, int n) {
            return IntStream.concat(
                            Arrays.stream(nums1, 0, m), // Stream from the first m elements of nums1
                            Arrays.stream(nums2, 0, n) // Stream from all n elements of nums2
                    )
                    .sorted() // Sort the combined stream
                    .toArray(); // Convert back to an array
        }


    }

    public static class SortedSquares {
        public static void main(String[] args) {
            // Test case 1
            int[] nums1 = {-4, -1, 0, 3, 10};
            System.out.println("Output: " + Arrays.toString(sortedSquares(nums1))); // Output: [0, 1, 9, 16, 100]
            System.out.println("Output: " + Arrays.toString(sortedSquaress(nums1))); // Output: [0, 1, 9, 16, 100]

            // Test case 2
            int[] nums2 = {-7, -3, 2, 3, 11};
            System.out.println("Output: " + Arrays.toString(sortedSquares(nums2))); // Output: [4, 9, 9, 49, 121]
        }

        public static int[] sortedSquaress(int[] nums) {
            return Arrays.stream(nums)  // Create a stream from the array
                    .map(x -> x * x)    // Square each element
                    .sorted()            // Sort the squared elements
                    .toArray();         // Collect the result into an array
        }

        public static int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int left = 0, right = n - 1;

            // Fill the result array from the end to the start
            for (int i = n - 1; i >= 0; i--) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    result[i] = nums[left] * nums[left];
                    left++;
                } else {
                    result[i] = nums[right] * nums[right];
                    right--;
                }
            }

            return result;
        }
    }

    public static class IntervalIntersection {
        public static void main(String[] args) {
            // Creating an instance of the Solution class
            IntervalIntersection sol = new IntervalIntersection();

            // Test Case 1
            int[][] firstList1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
            int[][] secondList1 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
            int[][] result1 = sol.intervalIntersection(firstList1, secondList1);

            System.out.println("Intersection of firstList1 and secondList1:");
            for (int[] interval : result1) {
                System.out.println("[" + interval[0] + "," + interval[1] + "]");
            }

            // Test Case 2
            int[][] firstList2 = {{1, 3}, {5, 9}};
            int[][] secondList2 = {};
            int[][] result2 = sol.intervalIntersection(firstList2, secondList2);

            System.out.println("Intersection of firstList2 and secondList2:");
            if (result2.length == 0) {
                System.out.println("No intersection.");
            } else {
                for (int[] interval : result2) {
                    System.out.println("[" + interval[0] + "," + interval[1] + "]");
                }
            }

            // Test Case 3
            int[][] firstList3 = {{1, 5}};
            int[][] secondList3 = {{2, 3}};
            int[][] result3 = sol.intervalIntersection(firstList3, secondList3);

            System.out.println("Intersection of firstList3 and secondList3:");
            for (int[] interval : result3) {
                System.out.println("[" + interval[0] + "," + interval[1] + "]");
            }
        }

        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            // List to store the result
            List<int[]> result = new ArrayList<>();

            // Pointers for both lists
            int i = 0, j = 0;

            // Traverse both lists
            while (i < firstList.length && j < secondList.length) {
                // Get the intervals from firstList and secondList
                int[] first = firstList[i];
                int[] second = secondList[j];

                // Check if the intervals intersect
                if (first[1] >= second[0] && second[1] >= first[0]) {
                    // Calculate the intersection
                    int start = Math.max(first[0], second[0]);
                    int end = Math.min(first[1], second[1]);
                    result.add(new int[]{start, end});
                }

                // Move the pointer for the interval that ends first
                if (first[1] < second[1]) {
                    i++;
                } else {
                    j++;
                }
            }

            // Convert the result List to an array
            return result.toArray(new int[result.size()][]);
        }


    }

   public static class MajorityElement {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;

            // Step 1: Find the candidate for majority element
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            // Step 2: Return the candidate
            return candidate;
        }

        public static void main(String[] args) {
            MajorityElement solution = new MajorityElement();

            // Test Case 1
            int[] nums1 = {3, 2, 3};
            System.out.println("Majority Element: " + solution.majorityElement(nums1)); // Output: 3

            // Test Case 2
            int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
            System.out.println("Majority Element: " + solution.majorityElement(nums2)); // Output: 2

            // Test Case 3
            int[] nums3 = {1, 1, 1, 2, 3, 1, 1};
            System.out.println("Majority Element: " + solution.majorityElement(nums3)); // Output: 1
        }
    }
}



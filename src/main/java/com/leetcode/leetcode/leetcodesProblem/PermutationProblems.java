package com.leetcode.leetcode.leetcodesProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationProblems {
    public static class PermutationString {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s1="ABC";
            String s2=" ";
            permun(s1,s2);
        }

        private static void permun(String s1, String s2) {
            if(s1.length()==0) {//The length() method returns the length of a specified string
                System.out.print(s2+" ");
                return;
            }
            for(int i=0;i<s1.length();i++) {
                char ch=s1.charAt(i);//it return the charvalue of the particular index as mentained
                String left_substr=s1.substring(0,i);//SUBSTRING is a string manipulation function that manipulates all string data types (BIT, BLOB, and CHARACTER), and extracts characters from a string to create another string
                String rigtht_substr=s1.substring(i+1);
                String rest=left_substr+rigtht_substr;
                permun(rest,s2+ch);
            }
        }

    }

    public static class PermunationsI {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // Sort the array to handle duplicates
            boolean[] used = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), result, used);
            return result;
        }

        private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
            if (path.size() == nums.length) { // Base case: if path contains all numbers
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // Skip duplicates at the same level
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                if (!used[i]) {
                    path.add(nums[i]);   // Choose the number
                    used[i] = true;      // Mark it as used

                    backtrack(nums, path, result, used); // Recur

                    // Backtrack: undo the choice
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }

        public static void main(String[] args) {
            PermunationsI solution = new PermunationsI();

            // Test case 1
            int[] nums1 = {1, 2, 3};
            System.out.println("Unique permutations for [1,2,3]:");
            System.out.println(solution.permuteUnique(nums1));

            // Test case 2
            int[] nums2 = {0, 1};
            System.out.println("\nUnique permutations for [0,1]:");
            System.out.println(solution.permuteUnique(nums2));

            // Test case 3
            int[] nums3 = {1};
            System.out.println("\nUnique permutations for [1]:");
            System.out.println(solution.permuteUnique(nums3));
        }
    }

   public static class PermunationsII {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // Sort to handle duplicates
            boolean[] used = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), result, used);
            return result;
        }

        private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
            if (path.size() == nums.length) { // Base case
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // Skip duplicate elements in the same recursion level
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true; // Mark as used

                    backtrack(nums, path, result, used);

                    // Backtrack
                    path.remove(path.size() - 1);
                    used[i] = false; // Unmark
                }
            }
        }

        // Main method for testing
        public static void main(String[] args) {
            PermunationsII sol = new PermunationsII();
            int[] nums1 = {1, 1, 2};
            System.out.println("Unique Permutations for [1,1,2]:");
            System.out.println(sol.permuteUnique(nums1));

            int[] nums2 = {1, 2, 3};
            System.out.println("Unique Permutations for [1,2,3]:");
            System.out.println(sol.permuteUnique(nums2));
        }
    }
    public static class NextPermutation {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;

            // Step 1: Find the first decreasing element from the right
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i >= 0) {
                // Step 2: Find the smallest number greater than nums[i] to the right
                int j = n - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j); // Swap nums[i] and nums[j]
            }

            // Step 3: Reverse the subarray to the right of index i
            reverse(nums, i + 1, n - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            NextPermutation np = new NextPermutation();

            // Test case 1
            int[] nums1 = {1, 2, 3};
            np.nextPermutation(nums1);
            System.out.println("Next permutation of [1,2,3]: " + Arrays.toString(nums1));

            // Test case 2
            int[] nums2 = {3, 2, 1};
            np.nextPermutation(nums2);
            System.out.println("Next permutation of [3,2,1]: " + Arrays.toString(nums2));

            // Test case 3
            int[] nums3 = {1, 1, 5};
            np.nextPermutation(nums3);
            System.out.println("Next permutation of [1,1,5]: " + Arrays.toString(nums3));
        }
    }

    public static class MinimumAdjacentSwaps {
        public int getMinSwaps(String num, int k) {
            char[] original = num.toCharArray();
            char[] target = num.toCharArray();

            // Step 1: Find the k-th smallest wonderful number
            for (int i = 0; i < k; i++) {
                nextPermutation(target);
            }

            // Step 2: Calculate the minimum swaps to transform original into target
            return countSwaps(original, target);
        }

        private void nextPermutation(char[] nums) {
            int n = nums.length;
            int i = n - 2;

            // Find the first decreasing element from the right
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i >= 0) {
                // Find the smallest number greater than nums[i] to the right
                int j = n - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j); // Swap nums[i] and nums[j]
            }

            // Reverse the subarray to the right of index i
            reverse(nums, i + 1, n - 1);
        }

        private void swap(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(char[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        private int countSwaps(char[] original, char[] target) {
            int swaps = 0;

            for (int i = 0; i < original.length; i++) {
                if (original[i] != target[i]) {
                    int j = i + 1;

                    // Find the position of the target[i] in original array
                    while (original[j] != target[i]) {
                        j++;
                    }

                    // Bring original[j] to position i by swapping
                    while (j > i) {
                        swap(original, j, j - 1);
                        swaps++;
                        j--;
                    }
                }
            }

            return swaps;
        }

        public static void main(String[] args) {
            MinimumAdjacentSwaps solution = new MinimumAdjacentSwaps();

            // Example 1
            String num1 = "5489355142";
            int k1 = 4;
            System.out.println("Minimum swaps for Example 1: " + solution.getMinSwaps(num1, k1)); // Output: 2

            // Example 2
            String num2 = "11112";
            int k2 = 4;
            System.out.println("Minimum swaps for Example 2: " + solution.getMinSwaps(num2, k2)); // Output: 4

            // Example 3
            String num3 = "00123";
            int k3 = 1;
            System.out.println("Minimum swaps for Example 3: " + solution.getMinSwaps(num3, k3)); // Output: 1
        }
    }

}

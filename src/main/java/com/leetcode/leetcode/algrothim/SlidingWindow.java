package com.leetcode.leetcode.algrothim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindow {
    // 1. To find the maximum sum of all subarrays of size K
    public static class MaxSubArray {
        public static void main(String[] args) {
            int arr[] = {1, 2, 6, 2, 4, 1};
            int k = 3, n = arr.length;
            System.out.println("MaxSubArray: " + maxSubArray(arr, k, n));
        }

        private static int maxSubArray(int[] arr, int k, int n) {
            if (n < k) {
                System.out.println("Invalid: Array size is smaller than window size");
                return -1;
            }

            int max_Sum = 0;

            // Compute sum of first window of size k
            for (int i = 0; i < k; i++)
                max_Sum += arr[i];

            int window_Sum = max_Sum;

            // Slide the window over the array
            for (int i = k; i < n; i++) {
                window_Sum += arr[i] - arr[i - k];  // Add new element, remove old element
                max_Sum = Math.max(max_Sum, window_Sum);
            }

            return max_Sum;
        }
    }


    public static class Anagrams {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) return result; // Edge case: If s is smaller than p, return empty list.

            // Frequency arrays for characters in p and current window in s
            int[] countP = new int[26]; // Store frequency of chars in p
            int[] countS = new int[26]; // Store frequency of chars in current window of s

            // Build frequency array for p
            for (char c : p.toCharArray()) {
                countP[c - 'a']++;
            }

            // First window of size p.length()
            for (int i = 0; i < pLen; i++) {
                countS[s.charAt(i) - 'a']++;
            }

            // Compare the first window
            if (Arrays.equals(countP, countS)) {
                result.add(0);
            }

            // Slide the window through s
            for (int i = pLen; i < sLen; i++) {
                countS[s.charAt(i) - 'a']++;         // Add new character to window
                countS[s.charAt(i - pLen) - 'a']--;  // Remove the leftmost character

                // Compare frequency arrays
                if (Arrays.equals(countP, countS)) {
                    result.add(i - pLen + 1);
                }
            }

            return result;
        }

        // Main method to test the function
        public static void main(String[] args) {
            Anagrams solution = new Anagrams();

            // Test case 1
            String s1 = "cbaebabacd";
            String p1 = "abc";
            System.out.println("Anagram indices in '" + s1 + "' for '" + p1 + "': " + solution.findAnagrams(s1, p1));

            // Test case 2
            String s2 = "abab";
            String p2 = "ab";
            System.out.println("Anagram indices in '" + s2 + "' for '" + p2 + "': " + solution.findAnagrams(s2, p2));

            // Test case 3 (Edge case: no anagrams)
            String s3 = "af";
            String p3 = "be";
            System.out.println("Anagram indices in '" + s3 + "' for '" + p3 + "': " + solution.findAnagrams(s3, p3));

            // Test case 4 (Edge case: identical strings)
            String s4 = "aa";
            String p4 = "aa";
            System.out.println("Anagram indices in '" + s4 + "' for '" + p4 + "': " + solution.findAnagrams(s4, p4));

            // Test case 5 (Edge case: single character strings)
            String s5 = "a";
            String p5 = "a";
            System.out.println("Anagram indices in '" + s5 + "' for '" + p5 + "': " + solution.findAnagrams(s5, p5));
        }
    }



    public static class Permutation {
        public boolean checkInclusion(String s1, String s2) {
            int n = s2.length(), m = s1.length();
            if (m > n) return false;

            int[] s1Freq = new int[26];
            int[] windowFreq = new int[26];

            // Fill frequency array for s1
            for (char c : s1.toCharArray()) {
                s1Freq[c - 'a']++;
            }

            // Process the first window of size m in s2
            for (int i = 0; i < m; i++) {
                windowFreq[s2.charAt(i) - 'a']++;
            }

            // Check if first window is a permutation
            if (Arrays.equals(s1Freq, windowFreq)) return true;

            // Slide the window across s2
            for (int i = m; i < n; i++) {
                // Add new character to window
                windowFreq[s2.charAt(i) - 'a']++;

                // Remove old character from window
                windowFreq[s2.charAt(i - m) - 'a']--;

                // Compare updated window with s1's frequency
                if (Arrays.equals(s1Freq, windowFreq)) return true;
            }

            return false;
        }

        public static void main(String[] args) {
            /*
            	1.	Use a frequency array to track character counts for s1.
	2.	Create a sliding window of size s1.length() over s2 and compare its frequency with s1.
	3.	Slide the window across s2, updating character counts dynamically.
	4.	If at any point the window’s frequency matches s1, return true.
	5.	Return false if no match is found.
             */
            Permutation solution = new Permutation();
            System.out.println(solution.checkInclusion("ab", "eidbaooo")); // Output: true
            System.out.println(solution.checkInclusion("ab", "eidboaoo")); // Output: false
        }
    }
}

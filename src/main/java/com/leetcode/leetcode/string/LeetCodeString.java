package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeString {

    public static class LongestSubstringWithoutRepeating {
        public static void main(String[] args) {
            String s1 = "abcabcbb";
            String s2 = "bbbbb";
            String s3 = "pwwkew";

            System.out.println("Length of longest substring in \"" + s1 + "\": " + lengthOfLongestSubstring(s1));
            System.out.println("Length of longest substring in \"" + s2 + "\": " + lengthOfLongestSubstring(s2));
            System.out.println("Length of longest substring in \"" + s3 + "\": " + lengthOfLongestSubstring(s3));
        }

        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>(); // Stores last index of characters
            int maxLength = 0;
            int left = 0; // Left boundary of the sliding window

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // If character exists in the map, move left to avoid duplicates
                if (map.containsKey(currentChar)) {
                    left = Math.max(left, map.get(currentChar) + 1);
                }

                // Store the latest index of current character
                map.put(currentChar, right);

                // Update the maximum length found so far
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
}

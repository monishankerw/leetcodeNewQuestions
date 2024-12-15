package com.leetcode.leetcode.collections.setCollections;

import java.util.HashSet;

public class LongestSubstring {
    public static void main(String[] args) {
        String str="abcabcaa";
        /*
        	1.	Sliding Window Technique:
	•	Maintain a sliding window (left and right pointers) to keep track of the current substring.
	•	Use a HashSet to ensure no duplicate characters exist in the current window.
	2.	Steps:
	•	As you iterate over the string using the right pointer:
	•	If the current character already exists in the HashSet, move the left pointer forward and remove characters until the duplicate is eliminated.
	•	Add the current character to the HashSet.
	•	Update maxLength as the difference between the right and left pointers plus one.
	3.	Complexity:
	•	Time Complexity: O(n) because each character is processed at most twice (once added and once removed).
	•	Space Complexity: O(k) where k is the size of the HashSet, bounded by the number of unique characters.

         */
        Integer result=longestSubstring(str);
        System.out.println("Output:"+result);
    }

    private static int longestSubstring(String str) {
        //sliding window technique
        HashSet<Object> set = new HashSet<>();
        int maxLength=0;
        int left=0;
        for (int right=0;right<str.length();right++){
            while (set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
return maxLength;

    }
}

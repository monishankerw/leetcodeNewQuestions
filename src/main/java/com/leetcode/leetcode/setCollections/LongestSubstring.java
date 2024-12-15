package com.leetcode.leetcode.setCollections;

import java.util.HashSet;

public class LongestSubstring {
    public static void main(String[] args) {
        String str="abcabcaa";
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

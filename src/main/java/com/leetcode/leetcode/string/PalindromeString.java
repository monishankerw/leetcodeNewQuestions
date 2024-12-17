package com.leetcode.leetcode.string;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "madam"; // Input string
        String rev = "";

        // Reverse the string
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        // Check if original and reversed strings are equal
        if (str.equals(rev)) {
            System.out.println("Output: Palindrome String");
        } else {
            System.out.println("Output: Not a Palindrome String");
        }
    }
}
package com.leetcode.leetcode.string;

import java.util.stream.IntStream;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "madam"; // Input string

        // Using Traditional Approach
        System.out.println("Using Traditional Approach:");
        System.out.println("Output: " + (isPalindromeTraditional(str) ? "Palindrome String" : "Not a Palindrome String"));

        // Using Java 8 Streams
        System.out.println("\nUsing Java 8 Stream:");
        System.out.println("Output: " + (isPalindromeStreams(str) ? "Palindrome String" : "Not a Palindrome String"));
    }

    // Traditional Approach (Reversing String)
    private static boolean isPalindromeTraditional(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return str.equals(rev);
    }

    // Java 8 Stream Approach
    private static boolean isPalindromeStreams(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }
}
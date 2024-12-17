package com.leetcode.leetcode.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "testing";
        String rev = "";

        String result = reverses(str, rev);
        System.out.println("Reversed String: " + result);
    }

    private static String reverses(String str, String rev) {
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }
    /*
     // Reverse the string using Java 8
        String reversed = new StringBuilder(str)
                .reverse()
                .toString();

     */
}
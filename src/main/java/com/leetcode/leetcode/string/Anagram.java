package com.leetcode.leetcode.string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean result = anagram(str1, str2);

        if (result) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

    private static boolean anagram(String str1, String str2) {
        // If lengths are not the same, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort the character arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare the sorted arrays
        return Arrays.equals(arr1, arr2);
    }
}
/*
  private static boolean anagram(String str1, String str2) {
        // If lengths are not the same, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to sorted character sequences and compare
        String sortedStr1 = str1.chars()
                               .sorted()
                               .mapToObj(c -> String.valueOf((char) c))
                               .collect(Collectors.joining());

        String sortedStr2 = str2.chars()
                               .sorted()
                               .mapToObj(c -> String.valueOf((char) c))
                               .collect(Collectors.joining());

        // Compare sorted strings
        return sortedStr1.equals(sortedStr2);
    }
 */
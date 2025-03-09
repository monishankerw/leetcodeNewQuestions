package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        // Without Java 8
        boolean resultWithoutJava8 = isAnagramWithoutJava8(str1, str2);
        System.out.println("Without Java 8: " + (resultWithoutJava8 ? "Anagrams" : "Not Anagrams"));

        // With Java 8 Streams
        boolean resultWithJava8 = isAnagramWithJava8(str1, str2);
        System.out.println("With Java 8: " + (resultWithJava8 ? "Anagrams" : "Not Anagrams"));
    }

    // ✅ Without Java 8 (Using Sorting)
    private static boolean isAnagramWithoutJava8(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // ✅ With Java 8 Streams (Using Sorted Character Sequences)
    private static boolean isAnagramWithJava8(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        String sortedStr1 = str1.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        String sortedStr2 = str2.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        return sortedStr1.equals(sortedStr2);
    }
}
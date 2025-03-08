package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringOperations {
    public static void main(String[] args) {
        String str = "Java Developer";
        String sentence = "My name is ABC";
        String sentence2 = "Java is a powerful programming language";


        // 1️⃣ Reverse String
        System.out.println("Reversed String (Without Java 8): " + reverseWithoutJava8(str));
        System.out.println("Reversed String (With Java 8): " + reverseWithJava8(str));

        // 2️⃣ Reverse Words in Sentence
        System.out.println("Reversed Words (Without Java 8): " + reverseWordsWithoutJava8(sentence));
        System.out.println("Reversed Words (With Java 8): " + reverseWordsWithJava8(sentence));

        // 3️⃣ Count Words in a Sentence
        System.out.println("Word Count (Without Java 8): " + countWordsWithoutJava8(sentence));
        System.out.println("Word Count (With Java 8): " + countWordsWithJava8(sentence));

        // 4️⃣ Count Non-Space Characters
        System.out.println("Non-Space Character Count (Without Java 8): " + countNonSpaceCharacters(str));
        System.out.println("Non-Space Character Count (With Java 8): " + countNonSpaceCharactersJava8(str));

        // Counting words without Java 8
        int countWithoutJava8 = countWordsWithoutsJava8(sentence2);
        System.out.println("Word Count (Without Java 8): " + countWithoutJava8);

        // Counting words using Java 8 Streams
        long countWithJava8 = countWordsWithsJava8(sentence2);
        System.out.println("Word Count (With Java 8): " + countWithJava8);

    }

    // 1️⃣ Reverse String
    private static String reverseWithoutJava8(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    private static String reverseWithJava8(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 2️⃣ Reverse Words in a Sentence
    private static String reverseWordsWithoutJava8(String str) {
        String[] words = str.split(" ");
        String rev = "";
        for (int i = words.length - 1; i >= 0; i--) {
            rev += words[i] + " ";
        }
        return rev.trim();
    }

    private static String reverseWordsWithJava8(String str) {
        List<String> words = Arrays.asList(str.split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    // 3️⃣ Count Words in a Sentence
    private static int countWordsWithoutJava8(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                count++;
            }
        }
        return count;
    }

    private static long countWordsWithJava8(String str) {
        return Arrays.stream(str.trim().split("\\s+")).count();
    }

    // 4️⃣ Count Non-Space Characters
    private static int countNonSpaceCharacters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c != ' ') count++;
        }
        return count;
    }

    private static long countNonSpaceCharactersJava8(String str) {
        return str.chars().filter(c -> c != ' ').count();
    }
    // ✅ Without Java 8 - Using a loop
    private static int countWordsWithoutsJava8(String str) {
        str = str.trim(); // Remove leading/trailing spaces
        if (str.isEmpty()) return 0; // Edge case: empty string

        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                count++;
            }
        }
        return count;
    }

    // ✅ With Java 8 - Using Streams
    private static long countWordsWithsJava8(String str) {
        return Arrays.stream(str.trim().split("\\s+")) // Split by multiple spaces
                .count();
    }
}
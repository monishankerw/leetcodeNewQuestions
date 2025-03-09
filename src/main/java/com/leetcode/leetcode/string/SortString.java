package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortString {
    public static void main(String[] args) {
        String str = "manishankar";

        // Using Traditional Bubble Sort
        System.out.println("Using Traditional Bubble Sort:");
        System.out.println("Sorted String: " + sortUsingBubbleSort(str));

        // Using Java 8 Streams
        System.out.println("\nUsing Java 8 Stream:");
        System.out.println("Sorted String: " + sortUsingStreams(str));
    }

    // Traditional Bubble Sort Approach
    private static String sortUsingBubbleSort(String str) {
        char[] ch = str.toCharArray();

        // Bubble sort algorithm
        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = 0; j < ch.length - i - 1; j++) {
                if (ch[j] > ch[j + 1]) {
                    // Swap characters
                    char temp = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = temp;
                }
            }
        }
        return new String(ch);
    }

    // Java 8 Stream Approach
    private static String sortUsingStreams(String str) {
        return str.chars() // Convert string to IntStream
                .sorted() // Sort characters in ascending order
                .mapToObj(c -> String.valueOf((char) c)) // Convert back to characters
                .collect(Collectors.joining()); // Join characters into a string
    }
}
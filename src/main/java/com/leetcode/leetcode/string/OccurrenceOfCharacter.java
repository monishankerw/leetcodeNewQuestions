package com.leetcode.leetcode.string;

import java.util.stream.Collectors;

public  class OccurrenceOfCharacter {
    public static void main(String[] args) {
        // Declare and Initialize the String and Character
        String str = "aaabaccddee";
        char ch = 'a';

        System.out.println("Using Traditional Approach:");
        System.out.println("Occurrences of '" + ch + "': " + countOccurrences(str, ch));

        System.out.println("\nUsing Java 8 Streams:");
        System.out.println("Occurrences of '" + ch + "': " + countOccurrencesUsingStreams(str, ch));
    }

    // Traditional Approach (Without Java 8)
    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    // Java 8 Stream-Based Approach
    private static long countOccurrencesUsingStreams(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
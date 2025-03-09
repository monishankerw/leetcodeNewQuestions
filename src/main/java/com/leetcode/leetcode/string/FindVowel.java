package com.leetcode.leetcode.string;

import java.util.stream.Collectors;

public class FindVowel {
    public static void main(String[] args) {
        String str = "Test Engin";

        System.out.println("Using Traditional Approach:");
        countVowelsAndConsonants(str);

        System.out.println("\nUsing Java 8 Streams:");
        countVowelsAndConsonantsUsingStreams(str);
    }

    // Traditional Approach (Without Java 8)
    private static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        String small = str.toLowerCase();

        for (char ch : small.toCharArray()) {
            if (Character.isLetter(ch)) {  // Check if it's a letter
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Java 8 Stream-Based Approach
    private static void countVowelsAndConsonantsUsingStreams(String str) {
        long vowels = str.toLowerCase()
                .chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();

        long consonants = str.toLowerCase()
                .chars()
                .filter(c -> Character.isLetter(c) && "aeiou".indexOf(c) == -1)
                .count();

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
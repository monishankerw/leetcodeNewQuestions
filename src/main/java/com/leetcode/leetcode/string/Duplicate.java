package com.leetcode.leetcode.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicate {

    // ✅ 1. Duplicate Characters in a String (Without Java 8)
    public static class DuplicateCharacters {
        public static void main(String[] args) {
            String str = "javadeveloper";

            System.out.println("Duplicate characters in the string:");
            printDuplicateCharacters(str);

            System.out.println("\nDuplicate characters using Java 8:");
            findDuplicateCharactersUsingStreams(str);
        }

        private static void printDuplicateCharacters(String str) {
            HashSet<Character> set = new HashSet<>();
            HashSet<Character> duplicates = new HashSet<>();

            for (char ch : str.toCharArray()) {
                if (!set.add(ch)) { // If adding fails, it's a duplicate
                    duplicates.add(ch);
                }
            }
            // Print duplicate characters
            duplicates.forEach(ch -> System.out.print(ch + " "));
        }

        // ✅ 1.1 Duplicate Characters in a String (Using Java 8 Streams)
        private static void findDuplicateCharactersUsingStreams(String str) {
            str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> System.out.print(entry.getKey() + " "));
        }
    }

    // ✅ 2. Duplicate Elements in an Array (Without Java 8)
    public static class DuplicateElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 2, 7, 8, 8, 3};

            System.out.println("\n\nDuplicate elements in the array:");
            printDuplicateNumbers(arr);
        }

        private static void printDuplicateNumbers(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> duplicates = new HashSet<>();

            for (int num : arr) {
                if (!set.add(num)) { // If add fails, it's a duplicate
                    duplicates.add(num);
                }
            }
            duplicates.forEach(num -> System.out.print(num + " "));
        }
    }

    // ✅ 3. Duplicate Words in a String (With Java 8)
    public static class DuplicateWords {
        public static void main(String[] args) {
            String str = "This is new word is This new word";
            System.out.println("\n\nDuplicate words in the string:");
            findDuplicateWords(str);
        }

        private static void findDuplicateWords(String str) {
            // Convert to lowercase and split words
            String[] words = str.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

            // Count occurrences of each word
            Map<String, Long> wordCount = Arrays.stream(words)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // Print duplicate words
            wordCount.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
}
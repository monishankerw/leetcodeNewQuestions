package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Duplicate {
    public static class DuplicateElements {
        public static void main(String[] args) {
            String str = "javadeveloper";

            System.out.println("Duplicate elements in the string:");

            printDuplicateCharacters(str);
        }

        private static void printDuplicateCharacters(String str) {
            HashSet<Character> set = new HashSet<>();
            HashSet<Character> duplicates = new HashSet<>();

            for (char ch : str.toCharArray()) {
                if (!set.add(ch)) { // If adding fails, it's a duplicate
                    duplicates.add(ch);
                }
            }

            // Print all unique duplicate characters
            duplicates.forEach(System.out::print);
        }
    /*
    java8
    private static void findDuplicateCharactersUsingStreams(String str) {
        str.chars()  // Convert string to IntStream
            .mapToObj(c -> (char) c)  // Convert int to Character
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))  // Group and count
            .entrySet().stream()  // Stream the map entries
            .filter(entry -> entry.getValue() > 1)  // Filter only duplicates
            .forEach(entry -> System.out.print(entry.getKey() + " "));  // Print the duplicates
    }
     */
    }
    public static class DuplicatesElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 2, 7, 8, 8, 3};

            System.out.println("Duplicate elements in the array:");
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.print(arr[j] + " ");
                        break;
                    }
                }
            }
        }
    }


public static class DuplicateWord {
    public static void main(String[] args) {
        String str = "This is new word is This new word";

        // Remove punctuation (except spaces) and convert to lower case
        String input = str.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split the string into words
        String[] words = input.split("\\s+");

        // Use a HashMap to count the occurrences of each word
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Print the duplicate words
        System.out.println("Duplicate Words::::");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

}
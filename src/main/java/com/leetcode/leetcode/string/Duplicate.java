package com.leetcode.leetcode.string;

import java.util.HashSet;
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
}
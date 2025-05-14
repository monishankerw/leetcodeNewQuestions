package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class String30Question {
    //1. Remove Special Characters
    public static class RemoveSpacialCarct{
        public static void main(String[] args) {
            String input = "Di@!$^$pawa%&*li =.";
            String output = input.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }
    //2.Email Matching
    public static class EmailMatching{
        public static void main(String[] args) {
            String input = "monishanker@gmail.com";
            String output = input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ? "Valid" : "Invalid";
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }
    //3.Convert CamelCase to snake_case
    public static class CamelCaseToSnakeCase{
        public static void main(String[] args) {
            String input = "camelCaseString";
            String output = input.replaceAll("(?<!^)(?=[A-Z])", "_").toLowerCase();
            System.out.println("Input: " + input);
            System.out.println("Output: " + output);
        }
    }
    public static class WordOccurrence {
        public static void main(String[] args) {
            String str = "This is new word is this new word mkh";
            String[] words = str.toLowerCase().replaceAll("[^a-zA-Z]", " ").split(" ");

            Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(),
                    Collectors.counting()));
            map.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entey -> System.out.println(entey.getKey() + ":" + entey.getValue()));

        }
    }
    public static class  RemoveDuplicateWords {
        public static void main(String[] args) {
            String str = "This is new word is this new word";

            // Normalize: lowercase, remove non-letters, split
            String[] words = str.toLowerCase()
                    .replaceAll("[^a-zA-Z ]", "")
                    .split("\\s+");

            // Remove duplicates while preserving order
            String result = Arrays.stream(words)
                    .distinct()
                    .collect(Collectors.joining(" "));

            System.out.println("Original: " + str);
            System.out.println("Without duplicates: " + result);
        }
    }
}

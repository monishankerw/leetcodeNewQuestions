package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        String str = "hello";

        // Without Java 8
        System.out.println("Character count (Without Java 8): " + countCharactersWithoutJava8(str));

        // With Java 8 Streams
        System.out.println("Character count (With Java 8): " + countCharactersWithJava8(str));
    }

    // ✅ Without Java 8 (Using HashMap)
    private static Map<Character, Integer> countCharactersWithoutJava8(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }

    // ✅ With Java 8 Streams
    private static Map<Character, Long> countCharactersWithJava8(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)  // Convert int to Character
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
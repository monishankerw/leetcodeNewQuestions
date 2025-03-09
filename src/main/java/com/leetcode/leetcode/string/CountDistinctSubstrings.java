package com.leetcode.leetcode.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountDistinctSubstrings {
    public static void main(String[] args) {
        String str = "banana";

        // Without Java 8
        System.out.println("Distinct substrings count (Without Java 8): " + countDistinctSubstringsWithoutJava8(str));

        // With Java 8 Streams
        System.out.println("Distinct substrings count (With Java 8): " + countDistinctSubstringsWithJava8(str));
    }

    // ✅ Without Java 8 (Using Nested Loops)
    private static int countDistinctSubstringsWithoutJava8(String s) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings.size();
    }

    // ✅ With Java 8 Streams
    private static int countDistinctSubstringsWithJava8(String s) {
        return (int) IntStream.range(0, s.length())  // Start indexes
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, s.length() + 1)  // End indexes
                        .mapToObj(j -> s.substring(i, j)))  // Generate substrings
                .collect(Collectors.toSet())  // Collect unique substrings
                .size();
    }
}
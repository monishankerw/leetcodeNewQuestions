package com.leetcode.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstrings {
    public static void main(String[] args) {
        String str = "banana";
        System.out

.println("Distinct substrings count: " + countDistinctSubstrings(str));
    }

    private static int countDistinctSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings.size();
    }
}
/*
  private static int countDistinctSubstrings(String s) {
        Set<String> substrings = IntStream.range(0, s.length())  // Stream of start indexes
            .boxed()
            .flatMap(i -> IntStream.range(i + 1, s.length() + 1)  // Stream of end indexes for each start index
                .mapToObj(j -> s.substring(i, j)))  // Generate substring for each pair of indexes
            .collect(HashSet::new, HashSet::add, HashSet::addAll);  // Collect unique substrings into a HashSet

        return substrings.size();  // Return the count of distinct substrings
    }
 */
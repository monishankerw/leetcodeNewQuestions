package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class CharCount {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Character count: " + countCharacters(str));
    }

    private static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }
}
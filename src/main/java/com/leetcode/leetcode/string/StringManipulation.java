package com.leetcode.leetcode.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StringManipulation {

    // 1. Reverse a String
    public static String reverseTraditional(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    public static String reverseJava8(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 2. Check Palindrome
    public static boolean isPalindromeTraditional(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeJava8(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }

    // 3. Check Anagrams
    public static boolean areAnagramsTraditional(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static boolean areAnagramsJava8(String s1, String s2) {
        return Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
    }

    // 4. Character Frequency Count
    public static Map<Character, Integer> charFrequencyTraditional(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    public static Map<Character, Long> charFrequencyJava8(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 5. Most Common Word
    public static String mostCommonWordTraditional(String para, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();
        String[] words = para.toLowerCase().split("[\\W]+");

        for (String word : words) {
            if (!bannedSet.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static String mostCommonWordJava8(String para, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        return Arrays.stream(para.toLowerCase().split("[\\W]+"))
                .filter(word -> !bannedSet.contains(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    // 6. Remove Duplicates
    public static String removeDuplicatesTraditional(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (seen.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesJava8(String str) {
        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    // 7. Longest Common Prefix
    public static String longestCommonPrefixTraditional(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixJava8(String[] strs) {
        return Arrays.stream(strs)
                .reduce((s1, s2) -> {
                    int i = 0;
                    while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) i++;
                    return s1.substring(0, i);
                }).orElse("");
    }

    // Main method to test all implementations
    public static void main(String[] args) {
        // Test reverse
        System.out.println("Reverse (Traditional): " + reverseTraditional("hello"));
        System.out.println("Reverse (Java 8): " + reverseJava8("hello"));

        // Test palindrome
        System.out.println("\nPalindrome (Traditional): " + isPalindromeTraditional("madam"));
        System.out.println("Palindrome (Java 8): " + isPalindromeJava8("madam"));

        // Test anagrams
        System.out.println("\nAnagrams (Traditional): " + areAnagramsTraditional("listen", "silent"));
        System.out.println("Anagrams (Java 8): " + areAnagramsJava8("listen", "silent"));

        // Test character frequency
        System.out.println("\nChar Frequency (Traditional): " + charFrequencyTraditional("aabbbc"));
        System.out.println("Char Frequency (Java 8): " + charFrequencyJava8("aabbbc"));

        // Test most common word
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println("\nMost Common Word (Traditional): " +
                mostCommonWordTraditional(para, banned));
        System.out.println("Most Common Word (Java 8): " +
                mostCommonWordJava8(para, banned));

        // Test remove duplicates
        System.out.println("\nRemove Duplicates (Traditional): " + removeDuplicatesTraditional("aabbbc"));
        System.out.println("Remove Duplicates (Java 8): " + removeDuplicatesJava8("aabbbc"));

        // Test longest common prefix
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("\nLCP (Traditional): " + longestCommonPrefixTraditional(strs));
        System.out.println("LCP (Java 8): " + longestCommonPrefixJava8(strs));
    }
}
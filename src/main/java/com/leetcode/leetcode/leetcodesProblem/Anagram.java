package com.leetcode.leetcode.leetcodesProblem; // Defines the package structure

import java.util.*; // Imports all utility classes like Map, List, Arrays, etc.
import java.util.stream.Collectors; // Imports Collectors for Java 8 grouping

public class Anagram {
    public static void main(String[] args) {
        anagrams(); // Traditional integer array anagram check
        anagramsJava8(); // Java 8 version of integer array anagram check
        groupAnagrams(); // Traditional grouping of integer anagrams
        groupAnagramsJava8(); // Java 8 style grouping of integer anagrams

        String s1 = "anagram";
        String s2 = "naagram";

        boolean anagramsString = isAnagramsString(s1, s2); // Traditional string anagram check
        System.out.println("String Anagrams (traditional): " + anagramsString);

        boolean anagramsStringJava8 = isAnagramsStringJava8(s1, s2); // Java 8 string anagram check
        System.out.println("String Anagrams (Java 8): " + anagramsStringJava8);
    }

    // Traditional way to check if two int arrays are anagrams (same digits, any order)
    private static void anagrams() {
        int[] ang1 = {1, 2, 3};
        int[] ang2 = {3, 2, 1};

        Arrays.sort(ang1); // Sort array 1 → [1,2,3]
        Arrays.sort(ang2); // Sort array 2 → [1,2,3]

        boolean isAnag = Arrays.equals(ang1, ang2); // Compare if sorted arrays are equal
        System.out.println("Anagrams (traditional): " + isAnag); // Output: true
    }

    // Java 8 version using streams to check anagram of int arrays
    private static void anagramsJava8() {
        int[] ang1 = {1, 2, 3};
        int[] ang2 = {3, 2, 1};

        // Stream the array, sort, and collect back to array → then compare
        boolean isAng = Arrays.equals(
                Arrays.stream(ang1).sorted().toArray(),
                Arrays.stream(ang2).sorted().toArray()
        );
        System.out.println("Anagrams (Java 8): " + isAng); // Output: true
    }

    // Group numbers with the same digits using traditional approach
    private static void groupAnagrams() {
        int[] nums = {112, 121, 211, 123, 321, 132, 456, 346};

        // Create a map to store sorted-digit string as key, and list of numbers as value
        Map<String, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            char[] chars = String.valueOf(num).toCharArray(); // Convert number to char array
            Arrays.sort(chars); // Sort digits
            String key = new String(chars); // Create a string key from sorted digits

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(num); // Grouping
        }

        System.out.println("Grouped Number Anagrams (traditional):");
        for (List<Integer> group : map.values()) {
            System.out.println(group); // Print each group of anagram numbers
        }
    }

    // Java 8 version of grouping integer anagrams using Streams
    private static void groupAnagramsJava8() {
        int[] nums = {112, 121, 211, 123, 321, 132, 456, 346};

        // Stream the array, box it (convert int to Integer), group using sorted digits as key
        Map<String, List<Integer>> grouped = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> {
                    char[] chars = String.valueOf(num).toCharArray();
                    Arrays.sort(chars); // Sort digits of number
                    return new String(chars); // Use sorted digits string as key
                }));

        System.out.println("Grouped Number Anagrams (Java 8):");
        grouped.values().forEach(System.out::println); // Print grouped numbers
    }

    // Traditional method to check if two strings are anagrams
    private static boolean isAnagramsString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false; // Different lengths can't be anagrams

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1); // Count each char in s1
        }

        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1); // Count each char in s2
        }

        return map1.equals(map2); // Compare character counts
    }

    // Java 8 version to check if two strings are anagrams
    private static boolean isAnagramsStringJava8(String s1, String s2) {
        // Convert each string to char stream, sort, convert to array, and compare
        return Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
    }
    public static class GroupAnagramsExample {

        public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

            // Traditional method
            List<List<String>> resultTraditional = groupAnagramsTraditional(strs);
            System.out.println("Traditional Grouping:");
            System.out.println(resultTraditional);

            // Java 8 Stream method
            List<List<String>> resultStream = groupAnagramsJava8(strs);
            System.out.println("Java 8 Stream Grouping:");
            System.out.println(resultStream);
        }

        // ✅ Traditional Way
        public static List<List<String>> groupAnagramsTraditional(String[] strs) {
            Map<String, List<String>> anagramMap = new HashMap<>();

            for (String str : strs) {
                char[] charArray = str.toCharArray();        // Convert to char array
                Arrays.sort(charArray);                      // Sort characters
                String sortedStr = new String(charArray);    // Use sorted string as key

                if (!anagramMap.containsKey(sortedStr)) {
                    anagramMap.put(sortedStr, new ArrayList<>());
                }

                anagramMap.get(sortedStr).add(str);          // Group word
            }

            return new ArrayList<>(anagramMap.values());     // Return result
        }

        // ✅ Java 8 Stream Way
        public static List<List<String>> groupAnagramsJava8(String[] strs) {
            return Arrays.stream(strs)
                    .collect(Collectors.groupingBy(
                            str -> {
                                char[] chars = str.toCharArray();
                                Arrays.sort(chars);
                                return new String(chars); // key = sorted version
                            }
                    ))
                    .values()
                    .stream()
                    .collect(Collectors.toList()); // get only grouped values
        }
    }
}
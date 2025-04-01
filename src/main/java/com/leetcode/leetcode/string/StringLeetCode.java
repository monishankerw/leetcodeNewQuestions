package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLeetCode {
    public static class RearrangeCharctToMakeTargetString {
        public static void main(String[] args) {
            String str = "ilovecodingonleetcode";
            String target = "code";

            System.out.println("\nWithout Java 8:");
            System.out.println("Output:: " + rearrangeCharctToMakeTargetStringWithoutJava8(str, target));


        }

        // ✅ Without Java 8 (Traditional Approach)
        private static int rearrangeCharctToMakeTargetStringWithoutJava8(String str, String target) {
            System.out.println("Input String: " + str);
            System.out.println("Target String: " + target);

            // Step 1: Count frequency of characters in 'str'
            Map<Character, Integer> sCount = new HashMap<>();
            for (char c : str.toCharArray()) {
                sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            }
            System.out.println("Character Count in Input String: " + sCount);

            // Step 2: Count frequency of characters in 'target'
            Map<Character, Integer> targetCount = new HashMap<>();
            for (char c : target.toCharArray()) {
                targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
            }
            System.out.println("Character Count in Target String: " + targetCount);

            // Step 3: Calculate the maximum number of times 'target' can be formed
            int minCopies = Integer.MAX_VALUE;
            for (char c : targetCount.keySet()) {
                if (!sCount.containsKey(c)) {
                    System.out.println("Character '" + c + "' not found in input string. Cannot form target.");
                    return 0;
                }
                int possibleCopies = sCount.get(c) / targetCount.get(c);
                System.out.println("Character '" + c + "' can be used " + possibleCopies + " times.");
                minCopies = Math.min(minCopies, possibleCopies);
            }

            System.out.println("Minimum number of times target can be formed: " + minCopies);
            return minCopies;
        }

    }


    public static class VowelSubstringCounter {
        public static void main(String[] args) {
            String word1 = "aeiouu";
            String word2 = "unicornarihan";
            String word3 = "cuaieuouac";

            System.out.println("Output for 'aeiouu': " + countVowelSubstrings(word1)); // Expected: 2
            System.out.println("Output for 'unicornarihan': " + countVowelSubstrings(word2)); // Expected: 0
            System.out.println("Output for 'cuaieuouac': " + countVowelSubstrings(word3)); // Expected: 7
        }

        public static int countVowelSubstrings(String word) {
            int count = 0;
            int n = word.length();
            Set<Character> vowels = new HashSet<>();

            for (int i = 0; i < n; i++) {
                vowels.clear();
                for (int j = i; j < n; j++) {
                    char c = word.charAt(j);
                    if (isVowel(c)) {
                        vowels.add(c);
                        if (vowels.size() == 5) {
                            count++;
                        }
                    } else {
                        break; // Stop when encountering a consonant
                    }
                }
            }

            return count;
        }

        private static boolean isVowel(char c) {
            return "aeiou".indexOf(c) != -1;
        }
    }
}
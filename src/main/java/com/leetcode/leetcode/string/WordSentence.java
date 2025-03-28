package com.leetcode.leetcode.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordSentence {
    public static class WordCount {
        public static void main(String[] args) {

            String str = "This is my Name is This my tests";

            System.out.println("Longest Words without java8::" + findLongestWordWithoutJava8(str));
            System.out.println("Longest Words with java8:::" + findLongestWordJava8(str));

            System.out.println("Shortest Words without java8::" + findShortestWordWithoutJava8(str));
            System.out.println("Shortest Words with java8::" + findShortestWordWithava8(str));

            System.out.println("findEvenLengthWordsWithoutJava8::" + findEvenLengthWordsWithoutJava8(str));
            System.out.println("findEvenLengthWordsJava8::" + findEvenLengthWordsJava8(str));

            System.out.println("countVowelsAndConsonantsWithoutJava8::"+countVowelsAndConsonantsWithoutJava8(str));
            System.out.println("countVowelsAndConsonantsJava8::"+countVowelsAndConsonantsJava8(str));
            System.out.println("Reverse Word Order without java8::" + reverseWordsWithoutJava8(str));
            System.out.println("Reverse Word Order with java8::" + reverseWordsJava8(str));

            System.out.println("Reverse Word without java8::" + reverseWordWithoutJava8(str));
            System.out.println("Reverse Word with Java8::" + reverseWordJava8(str));

            System.out.println("Word Count without java 8::" + wordCountWithoutJaava8(str));
            System.out.println("Word Count with java 8::" + wordCountWithJaava8(str));

            System.out.println("Frequency Occurrence Words Without java 8::" + frequenyOccWordsWithoutJava8(str));
            System.out.println("Frequency Occurrence Words With java 8::" + frequenyOccWordsWithJava8(str));


            System.out.println("Non Repeated words without java 8::" + nonRepeatedWordsWithoutJava8(str));
            System.out.println("Non Repeated words with java 8::" + nonRepeatedWordsWithJava8(str));

            System.out.println("MostFrequentWordWithoutJava8::" + mostFrequentWordWithoutJava8(str));
            System.out.println("MostFrequentWordWithJava8::" + mostFrequentWordWithJava8(str));

            System.out.println("findWordWithMaxRepeatedCharsWithoutJava8::"+findWordWithMaxRepeatedCharsWithoutJava8(str));
        }



        private static String findLongestWordWithoutJava8(String str) {
            String[] words = str.split(" ");  // Step 1: Split the sentence into words
            String longestWord = "";          // Step 2: Initialize a variable to store the longest word

            for (String word : words) {       // Step 3: Loop through each word in the array
                if (word.length() > longestWord.length()) {  // Step 4: Compare lengths
                    longestWord = word;      // Step 5: Update longestWord if the current word is longer
                }
            }

            return longestWord;  // Step 6: Return the longest word found
        }



        private static String findLongestWordJava8(String str) {
            return Arrays.stream(str.split(" "))
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");
        }

        private static String findShortestWordWithoutJava8(String str) {
            String[] words = str.split(" ");
            String shortestWord = words[0]; // Assume the first word is the shortest

            for (String word : words) {
                if (word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }

            return shortestWord;
        }

        private static String findShortestWordWithava8(String str) {
            String[] words = str.split(" ");
            String shortestWord = words[0]; // Assume the first word is the shortest

            for (String word : words) {
                if (word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }

            return shortestWord;

        }

        private static String findEvenLengthWordsWithoutJava8(String str) {
            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                if (word.length() % 2 == 0) {
                    result.append(word).append(" ");
                }
            }

            return result.toString().trim();
        }

        private static String findEvenLengthWordsJava8(String str) {
            return Arrays.stream(str.split(" "))
                    .filter(word -> word.length() % 2 == 0)
                    .collect(Collectors.joining(" "));
        }

        private static String countVowelsAndConsonantsWithoutJava8(String str) {
            str = str.toLowerCase().replaceAll("\\s+", ""); // Convert to lowercase and remove spaces
            int vowelCount = 0, consonantCount = 0;

            for (char ch : str.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if ("aeiou".indexOf(ch) != -1) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            return "Vowels: " + vowelCount + ", Consonants: " + consonantCount;
        }
        private static String countVowelsAndConsonantsJava8(String str) {
            str = str.toLowerCase().replaceAll("\\s+", ""); // Convert to lowercase and remove spaces

            long vowels = str.chars()
                    .filter(ch -> "aeiou".indexOf(ch) != -1)
                    .count();

            long consonants = str.chars()
                    .filter(ch -> Character.isLetter(ch) && "aeiou".indexOf(ch) == -1)
                    .count();

            return "Vowels: " + vowels + ", Consonants: " + consonants;
        }
        private static String reverseWordsWithoutJava8(String str) {
            String[] words = str.split(" ");
            StringBuilder builder = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                builder.append(words[i]).append(" ");
            }

            return builder.toString().trim();
        }

        private static String reverseWordsJava8(String str) {
            List<String> words = Arrays.asList(str.split(" "));
            Collections.reverse(words);
            return String.join(" ", words);
        }

        private static String reverseWordWithoutJava8(String str) {
            String[] words = str.split(" ");
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                builder.append(new StringBuilder(word).reverse()).append(" ");
            }
            return builder.toString().trim();
        }

        private static String reverseWordJava8(String str) {
            return Arrays.stream(str.split(" "))
                    .map(word -> new StringBuilder(word).reverse().toString())
                    .collect(Collectors.joining(" "));
        }

        private static int wordCountWithoutJaava8(String str) {
            // trim() returns a new string with leading and trailing spaces removed,
            str = str.trim();
            if (str.isEmpty()) {
                return 0;
            }
            // Start with 1 assuming there's at least one word

            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                // If current character is space and next character is not space, count a new word
                if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                    count++;
                }
            }
            return count;
        }
    }

    /*
    	1.	trim() → Removes any leading or trailing spaces from the string.
	2.	split("\\s+") → Splits the string into words using one or more spaces (\\s+ regex).
	3.	Arrays.stream(...).count() → Converts the array into a stream and counts the number of words.

     */
    private static long wordCountWithJaava8(String str) {
        return Arrays.stream(str.trim().split("\\s+")).count();
    }

    private static String frequenyOccWordsWithoutJava8(String str) {

        String[] split = str.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : split) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map.toString();
    }

    private static String frequenyOccWordsWithJava8(String str) {
        Map<String, Long> map = Arrays.stream(str.trim().split("\\s+")).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        return map.toString();
    }

    private static String nonRepeatedWordsWithoutJava8(String str) {
        String[] word = str.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String w : word) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        for (String wors : word) {
            if (map.get(wors) == 1) {
                builder.append(wors).append("");
            }
        }
        return builder.toString().trim();
    }

    private static String nonRepeatedWordsWithJava8(String str) {
        List<String> nonRepeatedWords = Arrays.stream(str.split("\\s+")) // Split sentence into words
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Convert to stream
                .filter(entry -> entry.getValue() == 1) // Filter words that appear only once
                .map(Map.Entry::getKey) // Extract words
                .collect(Collectors.toList()); // Collect as a List
        return nonRepeatedWords.toString();

    }

    private static String mostFrequentWordWithoutJava8(String str) {
        String[] words = str.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String mostFreq = " ";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFreq = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostFreq;
    }

    private static String mostFrequentWordWithJava8(String str) {
        String mostFrequent = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Find the max value
                .get().getKey(); // Extract the word
        return mostFrequent;
    }
    private static String findWordWithMaxRepeatedCharsWithoutJava8(String str) {
        String[] words = str.split(" ");
        String maxRepeatedWord = "";
        int maxRepeatCount = 0;

        for (String word : words) {
            int maxCharCount = getMaxRepeatedCharCount(word);

            if (maxCharCount > maxRepeatCount) {
                maxRepeatCount = maxCharCount;
                maxRepeatedWord = word;
            }
        }

        return maxRepeatedWord;
    }

    private static int getMaxRepeatedCharCount(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int maxCount = 0;

        for (char ch : word.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, charCountMap.get(ch));
        }

        return maxCount;
    }
    
    public static class Anagram {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";

            // Check without Java 8
            boolean resultWithoutJava8 = isAnagramWithoutJava8(str1, str2);
            System.out.println("Without Java 8: " + (resultWithoutJava8 ? "Anagrams" : "Not Anagrams"));
            // With Java 8 Streams
            boolean resultWithJava8 = isAnagramWithJava8(str1, str2);
            System.out.println("With Java 8: " + (resultWithJava8 ? "Anagrams" : "Not Anagrams"));
        }

        // ✅ Without Java 8 (Using Sorting)
        private static boolean isAnagramWithoutJava8(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }

            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return Arrays.equals(arr1, arr2);
        }

        private static boolean isAnagramWithJava8(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }

            String sortedStr1 = str1.chars()
                    .sorted()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());

            String sortedStr2 = str2.chars()
                    .sorted()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());

            return sortedStr1.equals(sortedStr2);
        }
    }

}

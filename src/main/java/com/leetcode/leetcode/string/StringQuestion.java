package com.leetcode.leetcode.string;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StringQuestion{
    public static class RevString {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Reverse String::" + revString(str));
        }

        private static String revString(String str) {
            StringBuilder builder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                builder.append(str.charAt(i));
            }
            return builder.toString();
        }
    }
    //### 14. **Check if a String is a Substring of Another String**
//
    public static class IsSubstring {
        public static void main(String[] args) {
            String str1 = "hello";
            String str2 = "ell";
            System.out.println("Is substring: " + isSubstring(str1, str2));
        }

        private static boolean isSubstring(String str1, String str2) {
            return str1.contains(str2);
        }
    }

    public static class IndexOfFirstNonRepeatingChar {
        public static void main(String[] args) {
            String str = "loveleetcode";
            System.out.println("Index of first non-repeating character: " + indexOfFirstNonRepeatingChar(str));
        }

        private static int indexOfFirstNonRepeatingChar(String str) {
            Map<Character, Integer> charCount = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return str.indexOf(entry.getKey());
                }
            }
            return -1; // No unique character found
        }
    }
    public static class StringOperations {
        public static void main(String[] args) {
            String str = "Java Developer";
            String sentence = "My name is ABC";
            String sentence2 = "Java is a powerful programming language";


            // 1️⃣ Reverse String
            System.out.println("Reversed String (Without Java 8): " + reverseWithoutJava8(str));
            System.out.println("Reversed String (With Java 8): " + reverseWithJava8(str));

            // 2️⃣ Reverse Words in Sentence
            System.out.println("Reversed Words (Without Java 8): " + reverseWordsWithoutJava8(sentence));
            System.out.println("Reversed Words (With Java 8): " + reverseWordsWithJava8(sentence));

            // 3️⃣ Count Words in a Sentence
            System.out.println("Word Count (Without Java 8): " + countWordsWithoutJava8(sentence));
            System.out.println("Word Count (With Java 8): " + countWordsWithJava8(sentence));

            // 4️⃣ Count Non-Space Characters
            System.out.println("Non-Space Character Count (Without Java 8): " + countNonSpaceCharacters(str));
            System.out.println("Non-Space Character Count (With Java 8): " + countNonSpaceCharactersJava8(str));

            // Counting words without Java 8
            int countWithoutJava8 = countWordsWithoutsJava8(sentence2);
            System.out.println("Word Count (Without Java 8): " + countWithoutJava8);

            // Counting words using Java 8 Streams
            long countWithJava8 = countWordsWithsJava8(sentence2);
            System.out.println("Word Count (With Java 8): " + countWithJava8);

        }

        // 1️⃣ Reverse String
        private static String reverseWithoutJava8(String str) {
            String rev = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                rev += str.charAt(i);
            }
            return rev;
        }

        private static String reverseWithJava8(String str) {
            return new StringBuilder(str).reverse().toString();
        }

        // 2️⃣ Reverse Words in a Sentence
        private static String reverseWordsWithoutJava8(String str) {
            String[] words = str.split(" ");
            String rev = "";
            for (int i = words.length - 1; i >= 0; i--) {
                rev += words[i] + " ";
            }
            return rev.trim();
        }

        private static String reverseWordsWithJava8(String str) {
            List<String> words = Arrays.asList(str.split(" "));
            Collections.reverse(words);
            return String.join(" ", words);
        }

        // 3️⃣ Count Words in a Sentence
        private static int countWordsWithoutJava8(String str) {
            str = str.trim();
            if (str.isEmpty()) return 0;
            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                    count++;
                }
            }
            return count;
        }

        private static long countWordsWithJava8(String str) {
            return Arrays.stream(str.trim().split("\\s+")).count();
        }

        // 4️⃣ Count Non-Space Characters
        private static int countNonSpaceCharacters(String str) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c != ' ') count++;
            }
            return count;
        }

        private static long countNonSpaceCharactersJava8(String str) {
            return str.chars().filter(c -> c != ' ').count();
        }
        // ✅ Without Java 8 - Using a loop
        private static int countWordsWithoutsJava8(String str) {
            str = str.trim(); // Remove leading/trailing spaces
            if (str.isEmpty()) return 0; // Edge case: empty string

            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                    count++;
                }
            }
            return count;
        }

        // ✅ With Java 8 - Using Streams
        private static long countWordsWithsJava8(String str) {
            return Arrays.stream(str.trim().split("\\s+")) // Split by multiple spaces
                    .count();
        }
    }
    public static class PalindromeString {
        public static void main(String[] args) {
            String str = "madam";
            String rev = "";
            System.out.println("Output:" + (isPalindromeString(str, rev) ? "PalindromeString" : "NotPalindrome String"));
            // Using Java 8 Streams
            System.out.println("\nUsing Java 8 Stream:");
            System.out.println("Output: " + (isPalindromeStreams(str) ? "Palindrome String" : "Not a Palindrome String"));

        }

        private static boolean isPalindromeString(String str, String rev) {
            for (int i = str.length() - 1; i >= 0; i--) {
                rev += str.charAt(i);
            }
            return str.equals(rev);
        }
        // Java 8 Stream Approach
        private static boolean isPalindromeStreams(String str) {
            return IntStream.range(0, str.length() / 2)
                    .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
        }
    }

    public static class SwapString {
        public static void main(String[] args) {
            String str = "manishankar";

            System.out.println("Using Traditional Approach:");
            System.out.println(swappingTraditional(str));

            System.out.println("\nUsing Java 8 Streams:");
            System.out.println(swappingUsingStreams(str));
        }

        // Traditional Approach (Without Java 8)
        private static String swappingTraditional(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }

            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length - 1; i += 2) {
                char temp = ch[i];
                ch[i] = ch[i + 1];
                ch[i + 1] = temp;
            }
            return new String(ch);
        }

        // Java 8 Stream-Based Approach
        private static String swappingUsingStreams(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }

            char[] ch = str.toCharArray();

            IntStream.range(0, ch.length - 1)
                    .filter(i -> i % 2 == 0) // Process only even indices
                    .forEach(i -> {
                        char temp = ch[i];
                        ch[i] = ch[i + 1];
                        ch[i + 1] = temp;
                    });

            return new String(ch);
        }
    }

    public static class ValidateBracket {
        public static void main(String[] args) {
            String s = "{([])}";
            boolean status = validateStringBracket(s);
            System.out.println(s);
            System.out.println(status);
        }

        private static boolean validateStringBracket(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                switch (ch) {
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') return false;
                        stack.pop();
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') return false;
                        stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') return false;
                        stack.pop();
                        break;
                    default:
                        stack.push(ch);
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
    public static class SortString {
        public static void main(String[] args) {
            String str = "manishankar";

            // Using Traditional Bubble Sort
            System.out.println("Using Traditional Bubble Sort:");
            System.out.println("Sorted String: " + sortUsingBubbleSort(str));

            // Using Java 8 Streams
            System.out.println("\nUsing Java 8 Stream:");
            System.out.println("Sorted String: " + sortUsingStreams(str));
        }

        // Traditional Bubble Sort Approach
        private static String sortUsingBubbleSort(String str) {
            char[] ch = str.toCharArray();

            // Bubble sort algorithm
            for (int i = 0; i < ch.length - 1; i++) {
                for (int j = 0; j < ch.length - i - 1; j++) {
                    if (ch[j] > ch[j + 1]) {
                        // Swap characters
                        char temp = ch[j];
                        ch[j] = ch[j + 1];
                        ch[j + 1] = temp;
                    }
                }
            }
            return new String(ch);
        }

        // Java 8 Stream Approach
        private static String sortUsingStreams(String str) {
            return str.chars() // Convert string to IntStream
                    .sorted() // Sort characters in ascending order
                    .mapToObj(c -> String.valueOf((char) c)) // Convert back to characters
                    .collect(Collectors.joining()); // Join characters into a string
        }
    }

    public static class SortString2 {
        public static void main(String[] args) {
            String s = "edcab";
            System.out.println(sortingString(s));
        }

        private static String sortingString(String s) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
    // ✅ 1. Duplicate Characters in a String (Without Java 8)
    public static class DuplicateShows {
        public static void main(String[] args) {
            String str = "javadeveloper";

            System.out.println("Duplicate characters in the string:");
            printDuplicateCharacters(str);

            System.out.println("\nDuplicate characters using Java 8:");
            findDuplicateCharactersUsingStreams(str);
        }

        private static void printDuplicateCharacters(String str) {
            HashSet<Character> set = new HashSet<>();
            HashSet<Character> duplicates = new HashSet<>();

            for (char ch : str.toCharArray()) {
                if (!set.add(ch)) { // If adding fails, it's a duplicate
                    duplicates.add(ch);
                }
            }
            // Print duplicate characters
            duplicates.forEach(ch -> System.out.print(ch + " "));
        }

        // ✅ 1.1 Duplicate Characters in a String (Using Java 8 Streams)
        private static void findDuplicateCharactersUsingStreams(String str) {
            str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> System.out.print(entry.getKey() + " "));
        }
    }
    public static class RemoveDuplicate {
        public static void main(String[] args) {
            String str = "aadfgrr";
            System.out.println("Remove Duplicate:" + removeDup(str));
        }

        private static String removeDup(String str) {
            StringBuilder sb = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (char ch : str.toCharArray()) {
                if (set.add(ch)) {
                    sb.append(ch);
                }
            }
            return sb.toString();

        }
    }
    // ✅ 3. Duplicate Words in a String (With Java 8)
    public static class DuplicateWords {
        public static void main(String[] args) {
            String str = "This is new word is This new word";
            System.out.println("\n\nDuplicate words in the string:");
            findDuplicateWords(str);
        }

        private static void findDuplicateWords(String str) {
            // Convert to lowercase and split words
            String[] words = str.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

            // Count occurrences of each word
            Map<String, Long> wordCount = Arrays.stream(words)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // Print duplicate words
            wordCount.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
    public static class FreqOccurency {
        public static void main(String[] args) {
            String str = "aabfdferfde";
            System.out.println("Fre Occ:" + freqOcc(str));
            // With Java 8 Streams
            System.out.println("Character count (With Java 8): " + countCharactersWithJava8(str));
        }

        private static HashMap<Character, Integer> freqOcc(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            return map;
        }
        // ✅ With Java 8 Streams
        private static Map<Character, Long> countCharactersWithJava8(String str) {
            return str.chars()
                    .mapToObj(c -> (char) c)  // Convert int to Character
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }

    public static class OccurrenceOfCharacter {
        public static void main(String[] args) {
            // Declare and Initialize the String and Character
            String str = "aaabaccddee";
            char ch = 'a';

            System.out.println("Using Traditional Approach:");
            System.out.println("Occurrences of '" + ch + "': " + countOccurrences(str, ch));

            System.out.println("\nUsing Java 8 Streams:");
            System.out.println("Occurrences of '" + ch + "': " + countOccurrencesUsingStreams(str, ch));
        }

        // Traditional Approach (Without Java 8)
        private static int countOccurrences(String str, char ch) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == ch) {
                    count++;
                }
            }
            return count;
        }

        // Java 8 Stream-Based Approach
        private static long countOccurrencesUsingStreams(String str, char ch) {
            return str.chars()
                    .filter(c -> c == ch)
                    .count();
        }
    }

    public class FindVowel {
        public static void main(String[] args) {
            String str = "Test Engin";

            System.out.println("Using Traditional Approach:");
            countVowelsAndConsonants(str);

            System.out.println("\nUsing Java 8 Streams:");
            countVowelsAndConsonantsUsingStreams(str);
        }

        // Traditional Approach (Without Java 8)
        private static void countVowelsAndConsonants(String str) {
            int vowels = 0, consonants = 0;
            String small = str.toLowerCase();

            for (char ch : small.toCharArray()) {
                if (Character.isLetter(ch)) {  // Check if it's a letter
                    if ("aeiou".indexOf(ch) != -1) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }

        // Java 8 Stream-Based Approach
        private static void countVowelsAndConsonantsUsingStreams(String str) {
            long vowels = str.toLowerCase()
                    .chars()
                    .filter(c -> "aeiou".indexOf(c) != -1)
                    .count();

            long consonants = str.toLowerCase()
                    .chars()
                    .filter(c -> Character.isLetter(c) && "aeiou".indexOf(c) == -1)
                    .count();

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }
    }

    public static class FirstNonRepeatedCharacter {
        public static void main(String[] args) {
            String str = "swiss";

            Optional<Character> firstNonRepeated = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst();

            firstNonRepeated.ifPresent(character -> System.out.println("First non-repeated character: " + character));
        }
    }
    public static class FirstUniqueCharacter {
        public static void main(String[] args) {
            String str = "loveleetcode";
            char result = firstNonRepeatingCharacter(str);
            System.out.println("First Non-Repeating Character: " + (result == '\0' ? "None" : result));
        }

        private static char firstNonRepeatingCharacter(String str) {
            Map<Character, Integer> charCount = new LinkedHashMap<>();

            // Count occurrences of each character
            for (char ch : str.toCharArray()) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }

            // Find first character with frequency 1
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }

            return '\0'; // Return null character if no unique char found
        }
    }
    public static class NonRepeatedCharacters {
        public static void main(String[] args) {
            String str = "hello world java";

            System.out.println("Using Java 8 Streams: " + findNonRepeatedUsingStreams(str));
            System.out.println("Without Using Java 8 Streams: " + findNonRepeatedWithoutStreams(str));
        }

        // Method using Java 8 Streams
        private static List<Character> findNonRepeatedUsingStreams(String str) {
            return str.replaceAll("\\s+", "").chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        // Method without using Java 8 Streams
        private static List<Character> findNonRepeatedWithoutStreams(String str) {
            str = str.replaceAll("\\s+", ""); // Remove spaces
            Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
            List<Character> nonRepeatedChars = new ArrayList<>();

            // Count occurrences of each character
            for (char c : str.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

            // Find non-repeated characters
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() == 1) {
                    nonRepeatedChars.add(entry.getKey());
                }
            }

            return nonRepeatedChars;
        }
    }
    public static class FirstNonRepeatedWord {
        public static void main(String[] args) {
            String input = "Java is fun and Java is popular";

            System.out.println("Traditional Approach: " + firstNonRepeatedWordTraditional(input));
            System.out.println("Java 8 Streams Approach: " + firstNonRepeatedWordJava8(input));
        }

        // ✅ Traditional Approach (Using LinkedHashMap)
        public static String firstNonRepeatedWordTraditional(String input) {
            String[] words = input.split("\\s+");
            Map<String, Integer> wordCount = new LinkedHashMap<>();

            // Count occurrences of each word
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            // Find the first word with count == 1
            for (String word : words) {
                if (wordCount.get(word) == 1) {
                    return word;
                }
            }
            return ""; // No non-repeated word found
        }

        // ✅ Java 8 Streams Approach
        public static String firstNonRepeatedWordJava8(String input) {
            return Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("");
        }
    }
    public static class StringCompression {
        public static void main(String[] args) {
            String str = "aabcccccaaa";
            String compressed = compressString(str);
            System.out.println("Compressed String: " + compressed);
        }

        private static String compressString(String str) {
            if (str == null || str.isEmpty()) return str;

            StringBuilder compressed = new StringBuilder();
            int count = 1;

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    compressed.append(str.charAt(i)).append(count);
                    count = 1; // Reset count for the next character
                }
            }
            // Append last character and its count
            compressed.append(str.charAt(str.length() - 1)).append(count);

            // Return the original string if compression is not smaller
            return compressed.length() < str.length() ? compressed.toString() : str;
        }
    }


    public static class LongestSubstringWithKDistinct {
        public static void main(String[] args) {
            String str = "eceba";
            int k = 2;
            System.out.println("Longest substring length: " + longestSubstringWithKDistinct(str, k));
        }

        private static int longestSubstringWithKDistinct(String s, int k) {
            Map<Character, Integer> charCount = new HashMap<>();
            int left = 0, right = 0, maxLength = 0;
            while (right < s.length()) {
                charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);
                while (charCount.size() > k) {
                    charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                    if (charCount.get(s.charAt(left)) == 0) {
                        charCount.remove(s.charAt(left));
                    }
                    left++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            return maxLength;
        }
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

    public static class CountWordsRegex {
        public static void main(String[] args) {
            String str = "This is a sample string.";
            System.out.println("Word count: " + countWords(str));
        }

        private static int countWords(String str) {
            Pattern pattern = Pattern.compile("\\b\\w+\\b");
            Matcher matcher = pattern.matcher(str);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            return count;
        }
    }
    public static class UniqueCharsBitwise {
        public static void main(String[] args) {
            String str = "abcde";
            System.out.println("Contains unique characters: " + hasUniqueChars(str));
        }

        private static boolean hasUniqueChars(String str) {
            int checker = 0;
            for (char ch : str.toCharArray()) {
                int bitIndex = ch - 'a';
                if ((checker & (1 << bitIndex)) > 0) {
                    return false;
                }
                checker |= (1 << bitIndex);
            }
            return true;
        }
    }
    public static class SmallestSubstringContainingAllChars {
        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            System.out.println("Smallest substring: " + smallestSubstring(s, t));
        }

        private static String smallestSubstring(String s, String t) {
            Map<Character, Integer> charCountT = new HashMap<>();
            for (char ch : t.toCharArray()) {
                charCountT.put(ch, charCountT.getOrDefault(ch, 0) + 1);
            }
            Map<Character, Integer> charCountS = new HashMap<>();
            int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
            int required = charCountT.size();
            int formed = 0;

            while (right < s.length()) {
                char ch = s.charAt(right);
                charCountS.put(ch, charCountS.getOrDefault(ch, 0) + 1);
                if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() == charCountT.get(ch).intValue()) {
                    formed++;
                }

                while (left <= right && formed == required) {
                    ch = s.charAt(left);
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        start = left;
                    }
                    charCountS.put(ch, charCountS.get(ch) - 1);
                    if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() < charCountT.get(ch).intValue()) {
                        formed--;
                    }
                    left++;
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }
    }
    public static class MostFrequentCharacter {
        public static void main(String[] args) {
            String str = "hello";
            System.out.println("Most frequent character: " + mostFrequentCharacter(str));
        }

        private static char mostFrequentCharacter(String s) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char ch : s.toCharArray()) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
            char maxChar = s.charAt(0);
            int maxCount = 0;
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxChar = entry.getKey();
                }
            }
            return maxChar;
        }
    }
    public static class SubsequenceCheck {
        public static void main(String[] args) {
            String s1 = "abc";
            String s2 = "ahbgdc";
            System.out.println("Is subsequence: " + isSubsequence(s1, s2));
        }

        private static boolean isSubsequence(String s1, String s2) {
            int index1 = 0;
            int index2 = 0;
            while (index1 < s1.length() && index2 < s2.length()) {
                if (s1.charAt(index1) == s2.charAt(index2)) {
                    index1++;
                }
                index2++;
            }
            return index1 == s1.length();
        }
    }
    public static class LongestPalindromicSubstring {
        public static void main(String[] args) {
            String str = "babad";
            System.out.println("Longest palindromic substring: " + longestPalindromicSubstring(str));
        }

        private static String longestPalindromicSubstring(String s) {
            if (s.isEmpty()) return "";
            String longest = "";
            for (int i = 0; i < s.length(); i++) {
                String odd = expandAroundCenter(s, i, i);
                String even = expandAroundCenter(s, i, i + 1);
                String max = odd.length() > even.length() ? odd : even;
                if (max.length() > longest.length()) {
                    longest = max;
                }
            }
            return longest;
        }

        private static String expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }
    }
    public static class SubstringSearch {
        public static void main(String[] args) {
            String text = "hello world";
            String pattern = "world";
            int result = bruteForceSearch(text, pattern);
            System.out.println("Pattern found at index: " + result);
        }

        private static int bruteForceSearch(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();

            for (int i = 0; i <= n - m; i++) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) return i; // Found pattern
            }
            return -1; // Not found
        }
    }
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

    public static class LongestUniqueSubstring {
        public static void main(String[] args) {
            String s = "pwwkew";
            System.out.println("Longest Substring Length: " + longestSubstringWithoutRepeating(s));
        }
        /*
        ✅ Explanation of the Algorithm
            1.	Use a Set<Character> to track unique characters in the current window.
            2.	Expand the right pointer while adding new characters to the set.
            3.	If a duplicate character is found, move the left pointer until the substring is unique again.
            4.	Update maxLen to store the maximum length of a substring without repeating characters.

        ✅ Time Complexity: O(n) (Each character is processed at most twice).
        ✅ Space Complexity: O(k) (Where k is the number of unique characters in the string).
         */
        public static int longestSubstringWithoutRepeating(String s) {
            Map<Character, Integer> charIndex = new HashMap<>();
            int maxLen = 0, left = 0;

            for (int right = 0; right < s.length(); right++) {
                if (charIndex.containsKey(s.charAt(right))) {
                    left = Math.max(charIndex.get(s.charAt(right)) + 1, left); // Update left to skip repeating character
                }
                charIndex.put(s.charAt(right), right);
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }
    public static class Permutations {
        public static void main(String[] args) {
            String str = "abc";
            List<String> permutations = new ArrayList<>();
            generatePermutations(str, "", permutations);
            System.out.println(permutations);
        }

        private static void generatePermutations(String str, String prefix, List<String> permutations) {
            if (str.isEmpty()) {
                permutations.add(prefix);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    String newPrefix = prefix + str.charAt(i);
                    String remaining = str.substring(0, i) + str.substring(i + 1);
                    generatePermutations(remaining, newPrefix, permutations);
                }
            }
        }
    }

    public static class StringRotation {
        public static void main(String[] args) {
            String s1 = "waterbottle";
            String s2 = "erbottlewat";

            boolean result = isRotation(s1, s2);
            System.out.println("Is Rotation? " + (result ? "Yes" : "No"));
        }
        /*
        ✅ Time Complexity: O(n) (substring search).
        ✅ Space Complexity: O(n) (concatenated string).
         */
        private static boolean isRotation(String s1, String s2) {
            if (s1.length() != s2.length() || s1.isEmpty()) {
                return false;
            }
            return (s1 + s1).contains(s2);
        }
    }
    public static class UniqueChars {
        public static void main(String[] args) {
            String str = "unique";
            System.out.println("Unique characters: " + findUniqueCharacters(str));
        }

        private static String findUniqueCharacters(String str) {
            StringBuilder unique = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (unique.indexOf(String.valueOf(ch)) == -1) {
                    unique.append(ch);
                }
            }
            return unique.toString();
        }
    }
    //    ### 5. **Check if a String Contains Only Digits**
//            ```java
    public static class IsDigitsOnly {
        public static void main(String[] args) {
            String str = "123456";
            System.out.println("Contains only digits: " + isDigitsOnly(str));
        }

        private static boolean isDigitsOnly(String str) {
            return str.chars().allMatch(Character::isDigit);
        }
    }
    //    ### 6. **Convert a String to a Character Array and Sort It**
//            ```java
    public static class SortCharacters {
        public static void main(String[] args) {
            String str = "java";
            System.out.println("Sorted characters: " + sortCharacters(str));
        }

        private static String sortCharacters(String str) {
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            return new String(charArray);
        }
    }
    public static class PalindromeIgnoreNonAlphanumeric {
        public static void main(String[] args) {
            String str = "A man, a plan, a canal: Panama";
            System.out.println("Is palindrome: " + isPalindrome(str));
        }

        private static boolean isPalindrome(String str) {
            String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        }
    }
    public static class StringRotations {
        public static void main(String[] args) {
            String a = "HELLO";
            String b = "LOHEL";

            System.out.println("Using Traditional Approach:");
            if (checkRotationTraditional(a, b)) {
                System.out.println("Given Strings are rotations of each other");
            } else {
                System.out.println("Given Strings are not rotations of each other");
            }

            System.out.println("\nUsing Java 8 Approach:");
            String result = checkRotationJava8(a, b) ?
                    "Given Strings are rotations of each other" :
                    "Given Strings are not rotations of each other";
            System.out.println(result);
        }

        // Traditional Approach (Without Java 8)
        private static boolean checkRotationTraditional(String a, String b) {
            if (a.length() != b.length()) {
                return false;
            }
            String temp = a + a;
            return temp.contains(b);
        }

        // Java 8 Optimized Approach
        private static boolean checkRotationJava8(String a, String b) {
            return a.length() == b.length() && (a + a).contains(b);
        }
    }

    public static class  MostCommonWordFinder {
        public static void main(String[] args) {
            String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned = {"hit"};

            System.out.println("Most Common Word (Traditional): " + mostCommonWordTraditional(paragraph, banned));
            System.out.println("Most Common Word (Java 8): " + mostCommonWordJava8(paragraph, banned));
        }

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
    }
    //### 17. **Replace All Occurrences of a Substring**
//            ```java
    public static class ReplaceSubstring {
        public static void main(String[] args) {
            String str = "Hello World, Hello Java";
            String target = "Hello";
            String replacement = "Hi";
            System.out.println("Replaced string: " + replaceSubstring(str, target, replacement));
        }

        private static String replaceSubstring(String str, String target, String replacement) {
            return str.replace(target, replacement);
        }
    }
    //### 19. **Count Palindromic Substrings**
//            ```java
    public static class PalindromicSubstrings {
        public static void main(String[] args) {
            String str = "abc";
            System.out.println("Count of palindromic substrings: " + countPalindromicSubstrings(str));
        }

        private static int countPalindromicSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += expandAroundCenter(s, i, i);
                count += expandAroundCenter(s, i, i + 1);
            }
            return count;
        }

        private static int expandAroundCenter(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            return count;
        }
    }
    public static class LongestCommonPrefix {
        public static void main(String[] args) {
            String[] words = {"flower", "flow", "flight"};



            System.out.println("Traditional LCP: " + longestCommonPrefixTraditional(words));
            System.out.println("Java 8 LCP: " + longestCommonPrefixJava8(words));
        }

        // ✅ Traditional Approach (Using Iteration)
        public static String longestCommonPrefixTraditional(String[] strs) {
            if (strs == null || strs.length == 0) return "";

            String prefix = strs[0];
            for (String s : strs) {
                while (s.indexOf(prefix) != 0) { // Reduce prefix until it matches
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }

        // ✅ Java 8 Streams Approach
        public static String longestCommonPrefixJava8(String[] strs) {
            return Arrays.stream(strs)
                    .reduce((s1, s2) -> {
                        int i = 0;
                        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) i++;
                        return s1.substring(0, i);
                    }).orElse("");
        }
    }

    public static class MinWindowSubstring {
        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            System.out.println("Minimum window substring: " + minWindow(s, t));
        }

        private static String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";
            Map<Character, Integer> charCountT = new HashMap<>();
            for (char ch : t.toCharArray()) {
                charCountT.put(ch, charCountT.getOrDefault(ch, 0) + 1);
            }
            Map<Character, Integer> charCountS = new HashMap<>();
            int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
            int required = charCountT.size();
            int formed = 0;

            while (right < s.length()) {
                char ch = s.charAt(right);
                charCountS.put(ch, charCountS.getOrDefault(ch, 0) + 1);
                if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() == charCountT.get(ch).intValue()) {
                    formed++;
                }

                while (left <= right && formed == required) {
                    ch = s.charAt(left);
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        start = left;
                    }
                    charCountS.put(ch, charCountS.get(ch) - 1);
                    if (charCountT.containsKey(ch) && charCountS.get(ch).intValue() < charCountT.get(ch).intValue()) {
                        formed--;
                    }
                    left++;
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }
    }
    //    ### 24. **Convert a String to Uppercase Without Using Built-in Methods**
//            ```java
    public static class ToUpperCase {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Uppercase string: " + toUpperCase(str));
        }

        private static String toUpperCase(String str) {
            StringBuilder upper = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    upper.append((char) (ch - 32));
                } else {
                    upper.append(ch);
                }
            }
            return upper.toString();
        }
    }
    //    ### 23. **Convert a String to Lowercase Without Using Built-in Methods**
//            ```java
    public static class ToLowerCase {
        public static void main(String[] args) {
            String str = "Hello World";
            System.out.println("Lowercase string: " + toLowerCase(str));
        }

        private static String toLowerCase(String str) {
            StringBuilder lower = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    lower.append((char) (ch + 32));
                } else {
                    lower.append(ch);
                }
            }
            return lower.toString();
        }
    }
    //    ### 21. **Check if a String is a Valid Palindrome (ignoring cases and non-alphanumeric characters)**
//            ```java
    public static class ValidPalindrome {
        public static void main(String[] args) {
            String str = "A man, a plan, a canal: Panama";
            System.out.println("Is valid palindrome: " + isValidPalindrome(str));
        }

        private static boolean isValidPalindrome(String str) {
            String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        }
    }
    //    ### 20. **Find the Shortest Palindrome String by Adding Characters**
//            ```java
    public static class ShortestPalindrome {
        public static void main(String[] args) {
            String str = "aacecaaa";
            System.out.println("Shortest palindrome: " + shortestPalindrome(str));
        }

        private static String shortestPalindrome(String s) {
            String rev = new StringBuilder(s).reverse().toString();
            String l = s + "#" + rev;
            int[] kmp = buildKMP(l);
            return rev.substring(0, s.length() - kmp[kmp.length - 1]) + s;
        }

        private static int[] buildKMP(String s) {
            int[] lps = new int[s.length()];
            int len = 0;
            int i = 1;
            while (i < s.length()) {
                if (s.charAt(i) == s.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }
    }
    //    Generate All Substrings of a String
    public static class AllSubstrings {
        public static void main(String[] args) {
            String str = "abc";
            System.out.println("All substrings: " + generateSubstrings(str));
        }

        private static Set<String> generateSubstrings(String s) {
            Set<String> substrings = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    substrings.add(s.substring(i, j));
                }
            }
            return substrings;
        }
    }
    public static class ReplaceChar {
        public static void main(String[] args) {
            String str = "hello world";
            char oldChar = 'o';
            char newChar = 'a';
            System.out.println("Replaced string: " + replaceChar(str, oldChar, newChar));
        }

        private static String replaceChar(String str, char oldChar, char newChar) {
            return str.replace(oldChar, newChar);
        }
    }
    public static class LongestPrefixSuffix {
        public static void main(String[] args) {
            String str = "ababcababc";
            System.out.println("Longest prefix suffix: " + longestPrefixSuffix(str));
        }

        private static String longestPrefixSuffix(String str) {
            int n = str.length();
            String prefixSuffix = "";
            for (int i = 0; i < n / 2; i++) {
                if (str.substring(0, i + 1).equals(str.substring(n - i - 1))) {
                    prefixSuffix = str.substring(0, i + 1);
                }
            }
            return prefixSuffix;
        }
    }



    public static class PartitionString {
        public static void main(String[] args) {
            String s1 = "abacaba";
            String s2 = "ssssss";

            System.out.println("Greedy HashSet Approach: " + partitionStringGreedy(s1));
            System.out.println("Java 8 Streams Approach: " + partitionStringJava8(s1));
            System.out.println("Greedy HashSet Approach: " + partitionStringGreedy(s2));
            System.out.println("Java 8 Streams Approach: " + partitionStringJava8(s2));
        }

        // ✅ Greedy Approach (Using HashSet)
        public static int partitionStringGreedy(String s) {
            Set<Character> seen = new HashSet<>();
            int partitions = 1; // At least one partition is required

            for (char ch : s.toCharArray()) {
                if (seen.contains(ch)) {
                    partitions++; // Start a new substring
                    seen.clear(); // Reset for new substring
                }
                seen.add(ch);
            }
            return partitions;
        }

        // ✅ Java 8 Streams Approach
        public static int partitionStringJava8(String s) {
            Set<Character> seen = new HashSet<>();
            return (int) IntStream.range(0, s.length())
                    .map(i -> {
                        char ch = s.charAt(i);
                        if (seen.contains(ch)) {
                            seen.clear(); // Start new substring
                            seen.add(ch);
                            return 1; // New partition
                        }
                        seen.add(ch);
                        return 0; // Continue in the same partition
                    })
                    .sum() + 1; // Initial partition count
        }
    }
}

package com.leetcode.leetcode.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class StringQuestion {
    //reverse String
    public static class ReverseString {
        public static void main(String[] args) {
            String str = "testing";
            String rev = "";
            for (int i = str.length(); i >= 0; i--) {
                rev = rev + str.charAt(i);
            }
            System.out.println("ReverseString::" + rev);
        }
    }
    public static class ReverseString1 {
        public static void main(String[] args) {
            String str = "testing";
            String rev = new StringBuilder(str).reverse().toString();
            System.out.println("Reverse String: " + rev);
        }
    }
    public static class ReverseCharacter {
        public static void main(String[] args) {

            char[] chars = {'a', 'd', 'q', 'p', 'e'};
            reverseChars(chars);

            // Print the array in the desired format
            System.out.print("{");
            for (int i = 0; i < chars.length; i++) {
                System.out.print("'" + chars[i] + "'");
                if (i < chars.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }

        private static void reverseChars(char[] chars) {
            int left = 0, right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        public static class ReverseWord {
            public static void main(String[] args) {
                String[] str="Java developer".split(" ");
                String rev="";
                for(int i=str.length-1;i>=0;i--){
                    rev=rev+str[i]+" ";
                }
                System.out.println("Reverse String::");
                System.out.println(rev.trim());
            }
        }
        public static class ReverseEachWord {
            public static void main(String[] args) {
                String str = "hello world";
                System.out.println("Reversed words: " + reverseEachWord(str));
            }

            private static String reverseEachWord(String str) {
                String[] words = str.split(" ");
                StringBuilder reversed = new StringBuilder();
                for (String word : words) {
                    StringBuilder wordBuilder = new StringBuilder(word);
                    reversed.append(wordBuilder.reverse().toString()).append(" ");
                }
                return reversed.toString().trim();
            }
        }
        //Palindrome String
        public static class PaliString {
            public static void main(String[] args) {
                String str = "madam";
                String rev = "";
                String org_rev = str;
                for (int i = str.length() - 1; i >= 0; i--) {
                    rev = rev + str.charAt(i);
                }
                if (org_rev.equals(rev)) {
                    System.out.println("Palindrome String::");
                } else
                    System.out.println("Not Palindrome String");

            }
        }

        // Class for checking if two strings are anagrams
        public static class Anagram {
            public static void main(String[] args) {
                String str1 = "listen";
                String str2 = "silent";

                boolean anagrams = areAnagrams(str1, str2);
                System.out.println("Are they anagrams? " + anagrams);
            }

            private static boolean areAnagrams(String str1, String str2) {
                if (str1.length() != str2.length()) {
                    return false;
                }
                char[] chars1 = str1.toCharArray();
                char[] chars2 = str2.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                return Arrays.equals(chars1, chars2);
            }
        }
        public static class AnagramWords {
            public static void main(String[] args) {

                char str1[]= {'l','i','s','t','e','n'};

                char str2[]= {'s','i','l','e','n','t'};

                if(Anagram(str1,str2))
                    System.out.println("The two strings are anagram of each other");

                else
                    System.out.println("The two strings are not anagram of each other");
            }
            private static boolean Anagram(char[] str1, char[] str2) {

                int n1=str1.length;

                int n2=str2.length;

                if(n1!=n2)

                    return false;
                Arrays.sort(str1);
                Arrays.sort(str2);

                for(int i=0;i<n1;i++)

                    if(str1[i]!=str2[i])

                        return false;

                return true;
            }
        }

        // Class for finding frequency of characters in a string
        public static class FreqOcc {
            public static void main(String[] args) {
                String str = "aabcdedbvd";
                Map<Character, Integer> map = calculateFrequency(str);
                map.forEach((key, value) -> System.out.println(key + " : " + value));
            }

            private static Map<Character, Integer> calculateFrequency(String str) {
                Map<Character, Integer> mapCount = new HashMap<>();
                for (char c : str.toCharArray()) {
                    mapCount.put(c, mapCount.getOrDefault(c, 0) + 1);
                }
                return mapCount;
            }
        }

        // Class for finding frequency of characters using Java 8 Streams
        public static class OccJava8 {
            public static void main(String[] args) {
                String str = "anbasbdabn";
                Map<Character, Long> map = calculateFrequencyUsingStreams(str);
                System.out.println("Frequency using Streams: " + map);
            }

            private static Map<Character, Long> calculateFrequencyUsingStreams(String str) {
                return str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            }
        }

        // Class for counting distinct substrings
        public static class CountDistinctSubstrings {
            public static void main(String[] args) {
                String str = "banana";
                int result = countDistinctSubstrings(str);
                System.out.println("Distinct substrings count: " + result);
            }

            private static int countDistinctSubstrings(String str) {
                HashSet<String> set = new HashSet<>();
                for (int i = 0; i < str.length(); i++) {
                    for (int j = i + 1; j <= str.length(); j++) { // Fixed substring length
                        set.add(str.substring(i, j));
                    }
                }
                return set.size();
            }
        }
        public static class OccuranceOfCharacter {
            public static void main(String[] args) {
                //Declare and Initialize the String and Character:
                String str = "aaabaccddee";
                char ch = 'a';

                //Count the Occurrences of the Character:

                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
        // Class for sorting Employee objects

        public static class Employee implements Comparable<Employee> {
            private int id;
            private String name;
            private String salary;

            public Employee(int id, String name, String salary) {
                this.id = id;
                this.name = name;
                this.salary = salary;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getSalary() {
                return salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", salary='" + salary + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Employee o) {
                return this.id - o.id; // Sorting by id in ascending order
            }


            public static void main(String[] args) {
                ArrayList<Employee> list = new ArrayList<>();
                list.add(new Employee(101, "Moni", "12222"));
                list.add(new Employee(100, "Lani", "42222"));
                list.add(new Employee(103, "Srni", "123222"));
                list.add(new Employee(102, "Rsni", "123222"));

                // Sort the list based on Employee's compareTo method
                Collections.sort(list);

                // Print the sorted list
                System.out.println("Sorted Employees: " + list);

                // Sorting by Name using Comparator
                Collections.sort(list, Comparator.comparing(Employee::getName));
                System.out.println("\nSorted by Name:");
                list.forEach(System.out::println);

                // Sorting by Salary using Comparator
                Collections.sort(list, Comparator.comparing(Employee::getSalary));
                System.out.println("\nSorted by Salary:");
                list.forEach(System.out::println);
            }
        }

        // Class for checking if one string is a rotation of another
        public static class StringRotation {
            public static void main(String[] args) {
                String str1 = "Hello";
                String str2 = "LOHEL";

                if (checkRotation(str1, str2)) {
                    System.out.println("Rotation");
                } else {
                    System.out.println("Not Rotation");
                }
            }

            private static boolean checkRotation(String str1, String str2) {
                if (str1.length() != str2.length()) {
                    return false;
                }
                String temp = str1 + str1; // Concatenate str1 with itself
                return temp.contains(str2); // Check if str2 is a substring
            }

            public static class RotatedString {
                public static void main(String[] args) {
                    String str1 = "waterbottle";
                    String str2 = "erbottlewat";
                    System.out.println("Is rotated: " + isRotated(str1, str2));
                }

                private static boolean isRotated(String str1, String str2) {
                    return str1.length() == str2.length() && (str1 + str1).contains(str2);
                }
            }
            // Longest Common Prefix
            public static class LongestCommonPrefix {
                public static void main(String[] args) {
                    String[] str = {"flower", "flow", "flight"};
                    String longestCommonPrefix = longestCommonPrefix(str);
                    System.out.println("Longest Common Prefix:" + longestCommonPrefix);
                }
            }

            private static String longestCommonPrefix(String[] str) {
                if (str == null || str.length == 0)
                    return "";
                String prefix = str[0];
                for (int i = 0; i < str.length; i++) {
                    while (!str[i].startsWith(prefix)) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                        if (prefix.isEmpty()) {
                            return "";
                        }
                    }
                }
                return prefix;
            }
        }

        //Valid Parentheses
        public static class ValidParentheses {
            public static void main(String[] args) {
                String input = "()[]{}";
                boolean output = validParentheses(input);
                System.out.println("output:" + output);
            }

            private static boolean validParentheses(String input) {
                Stack<Character> stack = new Stack<>();
                for (int i = 0; i < input.length(); i++) {
                    System.out.println("Loop::" + i);
                    char ch = input.charAt(i);
                    System.out.println("Charcts:" + ch);
                    switch (ch) {
                        case '}':
                            if (stack.isEmpty() || stack.peek() != '{')
                                return false;
                            stack.pop();
                            break;

                        case ']':
                            if (stack.isEmpty() || stack.peek() != '[')
                                return false;
                            stack.pop();
                            break;
                        case ')':
                            if (stack.isEmpty() || stack.peek() != '(')
                                return false;
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

        public static class CountTotalWordOfSentence {
            public static void main(String[] args) {
                String str = "Java Developer";
                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != ' ')
                        count++;
                }
                System.out.println(count);
            }
        }
    }

    public static class CountNumberOfWords {
        public static void main(String[] args) {
            String str = "Welcome to java";
            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                if ((str.charAt(i) == ' ') && (str.charAt(i + 1) != ' ')) {
                    count++;
                }
            }
            System.out.println("Number of words: " + count);
        }
    }


    public static class SortString {
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

    @Override
    public String toString() {
        return super.toString();
    }

   public static class StartWith {
        public static void main(String[] args) {
            List<String> str= Arrays.asList("Reflection","Relex","testing","Rose","apple");
            List<String>x=   str.stream().filter(s->s.startsWith("R")).collect(Collectors.toList());
            System.out.println("Enter a string:"+x);
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
    public static class Swapping {
        public static void main(String[] args) {
            String str1="hello",str2="world";
            System.out.println("Before Swapping:");
            System.out.println("str1:"+str1);
            System.out.println("str2:"+str2);
            str1=str1+str2;
            str2=str1.substring(0,str1.length()-str2.length());
            str1=str1.substring(str2.length());
            System.out.println("After Swapping:::");
            System.out.println("str1::"+str1);
            System.out.println("str2::"+str2);


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



   public static class MostCommonWord {
        public String mostCommonWord(String paragraph, String[] banned) {
            // Normalize the paragraph to lowercase and replace punctuations with spaces
            String normalized = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");

            // Split the paragraph into words
            String[] words = normalized.split("\\s+");

            // Create a set of banned words for quick lookup
            Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

            // Map to store word frequencies
            Map<String, Integer> wordCount = new HashMap<>();

            // Count occurrences of non-banned words
            for (String word : words) {
                if (!bannedSet.contains(word)) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Find the most common word
            String mostCommon = "";
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostCommon = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            return mostCommon;
        }

        public static void main(String[] args) {
            MostCommonWord solution = new MostCommonWord();

            // Test case 1
            String paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned1 = {"hit"};
            System.out.println("Most common word: " + solution.mostCommonWord(paragraph1, banned1)); // Output: "ball"

            // Test case 2
            String paragraph2 = "a, a, a, a, b,b,b,c, c";
            String[] banned2 = {"a"};
            System.out.println("Most common word: " + solution.mostCommonWord(paragraph2, banned2)); // Output: "b"

            // Test case 3
            String paragraph3 = "This is a simple example, Example! Example!";
            String[] banned3 = {"example"};
            System.out.println("Most common word: " + solution.mostCommonWord(paragraph3, banned3)); // Output: "is"
        }
    }

    public static class RemoveDuplicateElements {
        public static void main(String[] args) {
            List<String>x=new ArrayList<>();
            x.add("a");
            x.add("b");
            x.add("c");
            x.add("a");
            x.add("b");
            x.add("a");
            System.out.println("All Elements:"+x);
            List<String> x1= x.stream().distinct().collect(Collectors.toList());
            System.out.println("Remove Duplicate:"+x1);
        }
    }
    public static class FindDuplicateElement {
        public static void main(String[] args) {
            String str = "JavaDeveloper";
            int r = 0;
            char[] x = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (x[i] == x[j]) {
                        System.out.print(x[j]);
                        r++;
                        break;
                    }
                }
            }
        }
    }
    public static class DuplicateWord {
        public static void main(String[] args) {
            String str = "This is new word is This new word";

            // Remove punctuation (except spaces) and convert to lower case
            String input = str.replaceAll("[^a-zA-Z ]", "").toLowerCase();

            // Split the string into words
            String[] words = input.split("\\s+");

            // Use a HashMap to count the occurrences of each word
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // Print the duplicate words
            System.out.println("Duplicate Words::::");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }
    public static class RemoveDuplicateCharacter {
        public static void main(String[] args) {
            String st="aabdsddee";
            String result=removeCharacter(st);
            System.out.println("Remove Duplicate Character:"+result);
        }

        private static String removeCharacter(String st) {
            Set<Character>set=new LinkedHashSet<>();
            for (char ch:st.toCharArray()){
                set.add(ch);
                System.out.println(set);

            }
            StringBuilder sb=new StringBuilder();
            for(char ch:set){
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    public static class RemoveDuplicateString {
        public static void main(String[] args) {
            String str = "programmming";
            String res = str.chars().mapToObj(c -> (char) c)
                    .distinct()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            System.out.println(res);
        }
    }

    public static class RemoveDuplicates {
        public static void main(String[] args) {
            String str = "aabbccdef";
            System.out.println("String without duplicates: " + removeDuplicates(str));
        }

        private static String removeDuplicates(String str) {
            StringBuilder result = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (result.indexOf(String.valueOf(ch)) == -1) {
                    result.append(ch);
                }
            }
            return result.toString();
        }
    }
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
    public static class LongestPalindromicSubstring {

        // Method to find the longest palindromic substring
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 0) {
                return "";
            }

            // dp[i][j] will be true if the substring s[i...j] is a palindrome
            boolean[][] dp = new boolean[n][n];

            int start = 0; // Start index of the longest palindrome
            int maxLength = 1; // Length of the longest palindrome

            // Single character substrings are palindromes
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            // Fill the dp table for substrings of length 2 or more
            for (int i = n - 1; i >= 0; i--) { // Start from the end
                for (int j = i + 1; j < n; j++) { // Expand to the right
                    if (s.charAt(i) == s.charAt(j)) { // Check for matching characters
                        // If the length is 2 or the inner substring is a palindrome
                        if (j - i == 1 || dp[i + 1][j - 1]) {
                            dp[i][j] = true;

                            // Update the longest palindrome details
                            if (j - i + 1 > maxLength) {
                                maxLength = j - i + 1;
                                start = i;
                            }
                        }
                    }
                }
            }

            // Return the longest palindromic substring
            return s.substring(start, start + maxLength);
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

            // Test cases
            String str1 = "babad";
            String str2 = "cbbd";
            String str3 = "a";
            String str4 = "ac";

            System.out.println("Longest Palindromic Substring of \"" + str1 + "\": " + lps.longestPalindrome(str1)); // Output: "bab" or "aba"
            System.out.println("Longest Palindromic Substring of \"" + str2 + "\": " + lps.longestPalindrome(str2)); // Output: "bb"
            System.out.println("Longest Palindromic Substring of \"" + str3 + "\": " + lps.longestPalindrome(str3)); // Output: "a"
            System.out.println("Longest Palindromic Substring of \"" + str4 + "\": " + lps.longestPalindrome(str4)); // Output: "a" or "c"
        }
    }
    public static class LongestCommonPrefix {

        // Method to find the longest common prefix
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // Start with the first string as the prefix
            StringBuilder prefix = new StringBuilder(strs[0]);

            for (int i = 1; i < strs.length; i++) {
                int j = 0;

                // Compare the current prefix with the next string
                while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                    j++;
                }

                // Trim the prefix to the matched length
                prefix.setLength(j);

                // If the prefix becomes empty, return early
                if (prefix.length() == 0) {
                    return "";
                }
            }

            return prefix.toString();
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            LongestCommonPrefix lcp = new LongestCommonPrefix();

            // Test cases
            String[] strs1 = {"flower", "flow", "flight"};
            String[] strs2 = {"dog", "racecar", "car"};
            String[] strs3 = {"interspecies", "interstellar", "interstate"};
            String[] strs4 = {"", "prefix", "pre"};
            String[] strs5 = {"single"};

            System.out.println("Longest Common Prefix of strs1: " + lcp.longestCommonPrefix(strs1)); // Output: "fl"
            System.out.println("Longest Common Prefix of strs2: " + lcp.longestCommonPrefix(strs2)); // Output: ""
            System.out.println("Longest Common Prefix of strs3: " + lcp.longestCommonPrefix(strs3)); // Output: "inters"
            System.out.println("Longest Common Prefix of strs4: " + lcp.longestCommonPrefix(strs4)); // Output: ""
            System.out.println("Longest Common Prefix of strs5: " + lcp.longestCommonPrefix(strs5)); // Output: "single"
        }
    }



    public static class FirstNonRepeatedCharacter {

        // Method to find the first non-repeated character in a string
        public char findFirstNonRepeatedCharacter(String s) {
            if (s == null || s.isEmpty()) {
                return '\0'; // Return null character if input is null or empty
            }

            // LinkedHashMap to maintain the order of characters and their counts
            Map<Character, Integer> charCount = new LinkedHashMap<>();

            // Populate the map with character counts
            for (char c : s.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            // Find the first character with a count of 1
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }

            return '\0'; // If no non-repeated character is found
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            FirstNonRepeatedCharacter fnrc = new FirstNonRepeatedCharacter();

            // Test cases
            String str1 = "swiss";
            String str2 = "success";
            String str3 = "aabbcc";
            String str4 = "abcd";
            String str5 = "";

            System.out.println("First non-repeated character in \"" + str1 + "\": " + fnrc.findFirstNonRepeatedCharacter(str1)); // Output: 'w'
            System.out.println("First non-repeated character in \"" + str2 + "\": " + fnrc.findFirstNonRepeatedCharacter(str2)); // Output: 'u'
            System.out.println("First non-repeated character in \"" + str3 + "\": " + fnrc.findFirstNonRepeatedCharacter(str3)); // Output: '\0'
            System.out.println("First non-repeated character in \"" + str4 + "\": " + fnrc.findFirstNonRepeatedCharacter(str4)); // Output: 'a'
            System.out.println("First non-repeated character in \"" + str5 + "\": " + fnrc.findFirstNonRepeatedCharacter(str5)); // Output: '\0'
        }
    }

    public static class LongestWordInDictionary {

        // Method to find the longest word in the dictionary
        public String longestWord(String[] words) {
            // Sort the words array lexicographically
            Arrays.sort(words);

            // Use a HashSet to keep track of valid prefixes
            Set<String> wordSet = new HashSet<>();
            String longestWord = "";

            for (String word : words) {
                // Check if the current word can be built one character at a time
                if (word.length() == 1 || wordSet.contains(word.substring(0, word.length() - 1))) {
                    wordSet.add(word); // Add the current word to the set

                    // Update the longest word if needed
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            return longestWord;
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            LongestWordInDictionary lwid = new LongestWordInDictionary();

            // Test cases
            String[] words1 = {"w", "wo", "wor", "worl", "world"};
            String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
            String[] words3 = {"cat", "bat", "rat"};
            String[] words4 = {"e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"};

            System.out.println("Longest word in words1: " + lwid.longestWord(words1)); // Output: "world"
            System.out.println("Longest word in words2: " + lwid.longestWord(words2)); // Output: "apple"
            System.out.println("Longest word in words3: " + lwid.longestWord(words3)); // Output: "cat" or "bat" or "rat"
            System.out.println("Longest word in words4: " + lwid.longestWord(words4)); // Output: "elephant"
        }
    }

    public static class LongestSubstringWithTwoDistinct {

        // Method to find the length of the longest substring with at most two distinct characters
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }

            int maxLength = 0;
            int left = 0;
            int right = 0;

            // HashMap to store the count of characters in the current window
            Map<Character, Integer> charCount = new HashMap<>();

            while (right < n) {
                // Add the current character to the map
                char c = s.charAt(right);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);

                // Shrink the window until there are at most 2 distinct characters
                while (charCount.size() > 2) {
                    char leftChar = s.charAt(left);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);

                    if (charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }

                    left++;
                }

                // Update the maximum length
                maxLength = Math.max(maxLength, right - left + 1);

                // Expand the window
                right++;
            }

            return maxLength;
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            LongestSubstringWithTwoDistinct lswtd = new LongestSubstringWithTwoDistinct();

            // Test cases
            String str1 = "eceba";
            String str2 = "ccaabbb";
            String str3 = "aaaa";
            String str4 = "abcabcabc";
            String str5 = "";

            System.out.println("Length of longest substring with two distinct characters in \"" + str1 + "\": " + lswtd.lengthOfLongestSubstringTwoDistinct(str1)); // Output: 3
            System.out.println("Length of longest substring with two distinct characters in \"" + str2 + "\": " + lswtd.lengthOfLongestSubstringTwoDistinct(str2)); // Output: 5
            System.out.println("Length of longest substring with two distinct characters in \"" + str3 + "\": " + lswtd.lengthOfLongestSubstringTwoDistinct(str3)); // Output: 4
            System.out.println("Length of longest substring with two distinct characters in \"" + str4 + "\": " + lswtd.lengthOfLongestSubstringTwoDistinct(str4)); // Output: 2
            System.out.println("Length of longest substring with two distinct characters in \"" + str5 + "\": " + lswtd.lengthOfLongestSubstringTwoDistinct(str5)); // Output: 0
        }
    }
    public static class LongestCommonSubsequence {

        // Method to find the longest common subsequence between two strings
        public String longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            // DP table to store lengths of LCS
            int[][] dp = new int[m + 1][n + 1];

            // Fill the DP table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Backtrack to construct the LCS string
            StringBuilder lcs = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs.insert(0, text1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            return lcs.toString();
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            LongestCommonSubsequence lcsFinder = new LongestCommonSubsequence();

            // Test cases
            String text1 = "abcde";
            String text2 = "ace";
            String text3 = "abc";
            String text4 = "def";
            String text5 = "abcdgh";
            String text6 = "aedfhr";

            System.out.println("LCS of \"" + text1 + "\" and \"" + text2 + "\": " + lcsFinder.longestCommonSubsequence(text1, text2)); // Output: "ace"
            System.out.println("LCS of \"" + text3 + "\" and \"" + text4 + "\": " + lcsFinder.longestCommonSubsequence(text3, text4)); // Output: ""
            System.out.println("LCS of \"" + text5 + "\" and \"" + text6 + "\": " + lcsFinder.longestCommonSubsequence(text5, text6)); // Output: "adh"
        }
    }


    public static class FirstNonRepeatedCharacters {

        // Method to find the first non-repeated character in a string
        public char findFirstNonRepeatedCharacter(String str) {
            // Map to store character frequencies
            Map<Character, Integer> charCountMap = new HashMap<>();

            // First pass: Count the occurrences of each character
            for (char c : str.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            // Second pass: Find the first character with a count of 1
            for (char c : str.toCharArray()) {
                if (charCountMap.get(c) == 1) {
                    return c;
                }
            }

            return '\0'; // Return null character if no non-repeated character found
        }

        // Main method to test the functionality
        public static void main(String[] args) {
            FirstNonRepeatedCharacter fnrc = new FirstNonRepeatedCharacter();

            // Test cases
            String str1 = "swiss";
            String str2 = "teeter";
            String str3 = "success";
            String str4 = "aabbcc";
            String str5 = "abcde";

            System.out.println("First non-repeated character in \"" + str1 + "\": " + fnrc.findFirstNonRepeatedCharacter(str1)); // Output: "w"
            System.out.println("First non-repeated character in \"" + str2 + "\": " + fnrc.findFirstNonRepeatedCharacter(str2)); // Output: "r"
            System.out.println("First non-repeated character in \"" + str3 + "\": " + fnrc.findFirstNonRepeatedCharacter(str3)); // Output: "u"
            System.out.println("First non-repeated character in \"" + str4 + "\": " + fnrc.findFirstNonRepeatedCharacter(str4)); // Output: '\0'
            System.out.println("First non-repeated character in \"" + str5 + "\": " + fnrc.findFirstNonRepeatedCharacter(str5)); // Output: "a"
        }
    }
    public static class PermutationString {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s1="ABC";
            String s2=" ";
            permun(s1,s2);
        }

        private static void permun(String s1, String s2) {
            if(s1.length()==0) {//The length() method returns the length of a specified string
                System.out.print(s2+" ");
                return;
            }
            for(int i=0;i<s1.length();i++) {
                char ch=s1.charAt(i);//it return the charvalue of the particular index as mentained
                String left_substr=s1.substring(0,i);//SUBSTRING is a string manipulation function that manipulates all string data types (BIT, BLOB, and CHARACTER), and extracts characters from a string to create another string
                String rigtht_substr=s1.substring(i+1);
                String rest=left_substr+rigtht_substr;
                permun(rest,s2+ch);
            }
        }

    }


    public static class PermutationArray {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3}; // Input array
            List<List<Integer>> result = new ArrayList<>();
            permute(nums, new ArrayList<>(), result);

            // Print the result
            System.out.println("Permutations of the array:");
            for (List<Integer> permutation : result) {
                System.out.println(permutation);
            }
        }

        // Recursive method to generate permutations
        private static void permute(int[] nums, List<Integer> current, List<List<Integer>> result) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current)); // Add current permutation to the result
                return;
            }
            for (int num : nums) {
                if (current.contains(num)) continue; // Skip numbers already in the current permutation
                current.add(num); // Choose
                permute(nums, current, result); // Explore
                current.remove(current.size() - 1); // Unchoose (backtrack)
            }
        }
    }
    public static class PreservingSpace {

        public static void main(String[] args) {
            String str = "Java Developer";
            preservingSpace(str);
        }

        private static void preservingSpace(String str) {
            // Initialize two pointers as two corners
            int n = str.length();
            int start = 0, end = n - 1;

            char[] ch = str.toCharArray();

            // Move both pointers toward each other
            while (start < end) {
                // If character at start is a space, skip it
                if (ch[start] == ' ') {
                    start++;
                    continue;
                }
                // If character at end is a space, skip it
                if (ch[end] == ' ') {
                    end--;
                    continue;
                }
                // If both are not spaces, swap
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }

            // Convert character array back to a string and print it
            System.out.println(new String(ch));
        }
    }
}
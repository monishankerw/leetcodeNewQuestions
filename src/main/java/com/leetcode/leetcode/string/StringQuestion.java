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
}
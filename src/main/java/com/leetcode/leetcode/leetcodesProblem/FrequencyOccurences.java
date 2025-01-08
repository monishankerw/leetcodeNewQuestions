package com.leetcode.leetcode.leetcodesProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOccurences {
    public static class FreOccurs {
        public static void main(String[] args) {
            int arr[] = {10, 21, 10, 20, 21, 32, 10};

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(0, 1) + 1);

            }
            System.out.println("Fre Occure::" + map);
        }
    }

    public static class FreOcurrs {
        public static void main(String[] args) {
            String str = "anbadbeaaa";

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(0, 1) + 1);
            }
            System.out.println("Freq::" + map);
        }
    }

    public static class FreOcurrsJava8 {
        public static void main(String[] args) {
            String str = "anbadbeaaa";

            // Count the frequency of each character
            Map<Character, Long> charFrequency = str.chars()
                    .mapToObj(c -> (char) c) // Convert each int (ASCII) to a Character
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Group and count

            // Print the frequency map
            System.out.println(charFrequency);
        }
    }
    public static class CountOccursChar{
        public static void main(String[] args) {
            String str="aanddvbb";
            char c='a';
            int count=0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)==c){
                    count++;
                }
            }
            System.out.println("Count Occress::"+count);
        }
    }
}

package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.Collections;

public class SortString {
    public static class accendingOrder {
        public static void main(String[] args) {
            String s = "edcab";
            System.out.println(sortingString(s));
        }

        private static String sortingString(String s) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            return sortedString;
        }
    }
       /*
       java 8
        private static String sortingString(String s) {
        return s.chars()  // Convert the string to an IntStream of character codes
                 .sorted()  // Sort the characters in ascending order
                 .mapToObj(c -> (char) c)  // Convert int to Character
                 .map(String::valueOf)  // Convert each character to String
                 .collect(Collectors.joining());  // Join them back into a single string
    }
        */

    public class DescendingOrder {
        public static void main(String[] args) {
            String s = "edcab";
            System.out.println(sortingString(s));
        }

        private static String sortingString(String s) {
            // Convert the string to a character array
            Character[] charArray = new Character[s.length()];
            for (int i = 0; i < s.length(); i++) {
                charArray[i] = s.charAt(i);
            }

            // Sort the array in descending order
            Arrays.sort(charArray, Collections.reverseOrder());

            // Convert the character array back to a string
            StringBuilder sortedString = new StringBuilder();
            for (char c : charArray) {
                sortedString.append(c);
            }

            return sortedString.toString();
        }
    }
    /*
      private static String sortingString(String s) {
        return s.chars()  // Convert the string to an IntStream of character codes
                 .boxed()  // Box each int value to Integer (necessary for sorting in reverse order)
                 .sorted(Collections.reverseOrder())  // Sort the stream in descending order
                 .map(i -> (char) i.intValue())  // Convert Integer back to Character
                 .map(String::valueOf)  // Convert each character to String
                 .collect(Collectors.joining());  // Join them back into a single string
    }
     */
}
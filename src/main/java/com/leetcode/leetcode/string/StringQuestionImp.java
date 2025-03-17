package com.leetcode.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringQuestionImp {
    public static class RevString{
        public static void main(String[] args) {
            String str="Hello World";
            System.out.println("Reverse String::"+revString(str));
        }

        private static String revString(String str) {
            StringBuilder builder = new StringBuilder();
            for (int i=str.length()-1;i>=0;i--){
                builder.append(str.charAt(i));
            }
            return builder.toString();
        }
    }

    public static class PalindromeString{
        public static void main(String[] args) {
            String str="madam";
            String rev="";
            System.out.println("Output:"+(isPalindromeString(str,rev)?"PalindromeString":"NotPalindrome String"));

        }

        private static boolean isPalindromeString(String str, String rev) {
            for (int i=str.length()-1;i>=0;i--){
                rev+=str.charAt(i);
            }
            return str.equals(rev);
        }
    }

    public static class RemoveDuplicate{
        public static void main(String[] args) {
            String str="aadfgrr";
            System.out.println("Remove Duplicate:"+removeDup(str));
        }

        private static String removeDup(String str) {
            StringBuilder sb=new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (char ch:str.toCharArray()){
                if (set.add(ch)){
                    sb.append(ch);
                }
            }
            return sb.toString();

        }
    }
    public static class FreqOccurency{
        public static void main(String[] args) {
            String str="aabfdferfde";
            System.out.println("Fre Occ:"+freqOcc(str));
        }

        private static HashMap<Character, Integer> freqOcc(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch:str.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            return map;
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

}

package com.leetcode.leetcode.leetcodesProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOccurences {
    /*
    1. Understanding map.getOrDefault(key, defaultValue):
	•	The method getOrDefault(key, defaultValue) is used to retrieve the value associated with the specified key (0 in this case).
	•	If the key does not exist in the map, it returns the provided defaultValue (1 in this case).

2. Breakdown of the Code:
	•	map.getOrDefault(0, 1):
	•	Looks for the key 0 in the map.
	•	If the key 0 exists, it retrieves its value.
	•	If the key 0 does not exist, it returns 1.
	•	+ 1:
	•	Adds 1 to the retrieved value (or the default value 1 if key 0 is not present).
	•	map.put(num, ...):
	•	Associates the computed value with the key num in the map.

3. What Does It Do?

This line of code updates the map as follows:
	•	If the key 0 exists in the map, retrieve its value, add 1 to it, and store this new value in the map with the key num.
	•	If the key 0 does not exist, use the default value 1, add 1 to it, and store 2 in the map with the key num.

     */
    public static class FreOccurs {
        public static void main(String[] args) {
            int arr[] = {10, 21, 10, 20, 21, 32, 10};

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);

            }
            System.out.println("Fre Occure::" + map);
        }
    }

    public static class FreOcurrs {
        public static void main(String[] args) {
            String str = "anbadbeaaa";

            Map<Character, Integer> map = new HashMap<>();
            //The toCharArray() method in Java is a built-in method of the String class.
            // It is used to convert a String into a character array (char[]),
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(0, 1) + 1);
            }
            System.out.println("Freq::" + map);
        }
    }

    public static class FreOcurrsJava8 {
        public static void main(String[] args) {
            String str = "anbadbeaaa";


            Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            // Print the frequency map
            System.out.println(map);
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

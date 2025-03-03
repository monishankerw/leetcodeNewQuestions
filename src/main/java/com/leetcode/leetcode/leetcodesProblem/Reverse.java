package com.leetcode.leetcode.leetcodesProblem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reverse {
    public static class A {
        public static void main(String[] args) {
            int rev = 0, num = 12345;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            System.out.println("Reverse Number=" + rev);

        }
    }
public static class B{
    public static void main(String[] args) {
        String str="testing";
        String rev="";
        for (int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
        }
        System.out.println("Reverse String="+rev);
    }
}
public static class C{
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Original Arrays: " + Arrays.toString(arr1));

        // Traditional Approach (Without Java 8)
        reverseArrays(arr1);
        System.out.println("Reverse Arrays (Without Java 8): " + Arrays.toString(arr1));

        Integer[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal Arrays (Java 8): " + Arrays.toString(arr2));

        // Java 8 Streams Approach
        arr2 = reverseUsingStreams(arr2);
        System.out.println("Reverse Arrays (Java 8): " + Arrays.toString(arr2));
    }

    // Traditional Approach (Without Java 8)
    private static void reverseArrays(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Java 8 Streams Approach
    private static Integer[] reverseUsingStreams(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray(new Integer[0]);
    }

}
public static class D {
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
}
public static class E{
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
}

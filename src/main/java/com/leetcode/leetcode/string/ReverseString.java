package com.leetcode.leetcode.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "testing";
        String rev = "";

        String result = reverses(str, rev);
        System.out.println("Reversed String: " + result);
    }

    private static String reverses(String str, String rev) {
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }
    /*
     // Reverse the string using Java 8
        String reversed = new StringBuilder(str)
                .reverse()
                .toString();

     */
    public static class ReverseWord {
        public static void main(String[] args) {
            String[] str="my name is abc".split(" ");
            reverse(str);
        }

        private static void reverse(String[] str) {
            String rev=" ";
            for (int i=str.length-1;i>=0;i--){
                rev=rev+str[i]+" ";
            }
            System.out.println("Reverse String::");
            System.out.println(rev.substring(0,rev.length()-1));
        }
    }
    /*
      // Split the string into words, reverse the stream, and join the words back into a single string
        String reversed = Arrays.stream(str.split(" "))  // Convert the string to a stream of words
                                 .sorted((a, b) -> -1)  // Reverse the order using a comparator
                                 .collect(Collectors.joining(" "));  // Join the reversed words back into a string

        System.out.println("Reversed String: ");
        System.out.println(reversed);
    }
     */
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
    /*
     // Split the string by spaces, filter out empty words, and count the number of elements
        long count = Arrays.stream(str.split(" "))  // Split the string into words
                           .filter(word -> !word.isEmpty())  // Filter out empty words (if any)
                           .count();  // Count the words

        System.out.println("Number of words: " + count);
    }
     */
    public static class CountWord {
        public static void main(String[] args) {
            String str="Java Developer";
            int count=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!=' ')
                    count++;
            }
            System.out.println(count);
        }
    }
    /*
       // Count non-space characters in the string
        long count = str.chars()  // Get the stream of characters
                       .filter(c -> c != ' ')  // Filter out spaces
                       .count();  // Count the remaining characters

        System.out.println(count);
    }
     */


    public static class CountOfEacWord {
        public static void main(String[] args) {
            String str="word is Self ghhj";
            int count=1;
            for(int i=0;i<str.length()-1;i++){
                if ((str.charAt(i) == ' ') && (str.charAt(i + 1) != ' ')) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    /*
      // Using Java 8 Stream to count words
        long count = Arrays.stream(str.split(" "))  // Split string by spaces
                           .filter(word -> !word.isEmpty())  // Filter out empty words (in case there are multiple spaces)
                           .count();  // Count the number of words

        System.out.println(count);
    }
     */
    public static class CountTotalWordOfSentence {
        public static void main(String[] args) {
            String str="Java Developer";
            int count=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!=' ')
                    count++;
            }
            System.out.println(count);
        }
    }
    /*
    long count = Arrays.stream(str.split("\\s+"))  // Split string by one or more spaces
            .filter(word -> !word.isEmpty())  // Filter out empty words
            .count();  // Count the number of words

        System.out.println("Word count: " + count);
}

     */
}
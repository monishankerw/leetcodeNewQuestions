package com.leetcode.leetcode.string;

public class OccuranceOfCharacter {
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

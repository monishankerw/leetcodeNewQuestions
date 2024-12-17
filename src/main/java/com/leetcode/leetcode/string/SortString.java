package com.leetcode.leetcode.string;

public class SortString {
           public static void main(String[] args) {
               String str = "manishankar";
               char[] ch = str.toCharArray();

               // Bubble sort algorithm to sort characters
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

               // Convert sorted character array back to string
               String sortedStr = new String(ch);
               System.out.println("Sorted string: " + sortedStr);
           }
       }
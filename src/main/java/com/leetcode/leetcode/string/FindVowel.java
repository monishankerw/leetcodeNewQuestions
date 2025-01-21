package com.leetcode.leetcode.string;

import java.util.Locale;

public class FindVowel {
    public static void main(String[] args) {
        String str="Test Engin";
        int v=0,c=0;
     String small  = str.toLowerCase();
     for (int i=0;i<str.length();i++){
         char ch=small.charAt(i);
         if(ch!=' '&& (ch>='a'&&ch<='z')){
             if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                 v++;
             }else{
                 c++;
             }
         }
     }
        System.out.println("Vowel::"+v);
        System.out.println("Con::"+c);


    }
}
package com.leetcode.leetcode.string;

public class StringRotation {
           public static void main(String[] args) {
               String a="HELLO";
               String b="LOHEL";
               if(checkRotation(a,b)){
                   System.out.println("Given Strings are rotations of each other");
               } else{
                   System.out.println("Given Strings are not rotations of each other");
               }
           }

           private static boolean checkRotation(String a, String b) {
               if(a.length()!=b.length())
                   return false;
               String temp=a+b;
               if(temp.indexOf(b)!=-1){
                   return true;
               } else {
                   return false;
               }
           }
       }
       /*
       public class StringRotation {
    public static void main(String[] args) {
        String a = "HELLO";
        String b = "LOHEL";
        String result = checkRotation(a, b) ? "Given Strings are rotations of each other"
                                           : "Given Strings are not rotations of each other";
        System.out.println(result);
    }

    private static boolean checkRotation(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }
}
        */
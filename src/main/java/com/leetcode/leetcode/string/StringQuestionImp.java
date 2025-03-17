package com.leetcode.leetcode.string;

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
}

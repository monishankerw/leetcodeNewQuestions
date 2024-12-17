package com.leetcode.leetcode.string;

public class SwapString {
           public static void main(String[] args) {
               String str="manishankar";
               System.out.println(swapping(str));
           }

           private static String swapping(String str) {
               if(str==null || str.isEmpty())
                   return str;
               char[] ch=str.toCharArray();
               for (int i=0;i<ch.length-1;i+=2){
                   char temp=ch[i];
                   ch[i]=ch[i+1];
                   ch[i+1]=temp;
               }
               return new String(ch);
           }
       }
       /*
       import java.util.stream.IntStream;

public class SwapString {
    public static void main(String[] args) {
        String str = "manishankar";
        System.out.println(swapping(str));
    }

    private static String swapping(String str) {
        if (str == null || str.isEmpty())
            return str;

        // Convert string to a character array using streams
        char[] ch = str.toCharArray();

        // Use IntStream to iterate and swap in pairs
        IntStream.range(0, ch.length - 1)
                .filter(i -> i % 2 == 0)  // Only process even indices (swap pairs)
                .forEach(i -> {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                });

        return new String(ch);
    }
}
        */
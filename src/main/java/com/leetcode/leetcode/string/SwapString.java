package com.leetcode.leetcode.string;

import java.util.stream.IntStream;

public class SwapString {
    public static void main(String[] args) {
        String str = "manishankar";

        System.out.println("Using Traditional Approach:");
        System.out.println(swappingTraditional(str));

        System.out.println("\nUsing Java 8 Streams:");
        System.out.println(swappingUsingStreams(str));
    }

    // Traditional Approach (Without Java 8)
    private static String swappingTraditional(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length - 1; i += 2) {
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;
        }
        return new String(ch);
    }

    // Java 8 Stream-Based Approach
    private static String swappingUsingStreams(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] ch = str.toCharArray();

        IntStream.range(0, ch.length - 1)
                .filter(i -> i % 2 == 0) // Process only even indices
                .forEach(i -> {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                });

        return new String(ch);
    }
}
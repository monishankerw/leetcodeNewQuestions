package com.leetcode.leetcode.string;

public class StringRotation {
    public static void main(String[] args) {
        String a = "HELLO";
        String b = "LOHEL";

        System.out.println("Using Traditional Approach:");
        if (checkRotationTraditional(a, b)) {
            System.out.println("Given Strings are rotations of each other");
        } else {
            System.out.println("Given Strings are not rotations of each other");
        }

        System.out.println("\nUsing Java 8 Approach:");
        String result = checkRotationJava8(a, b) ?
                "Given Strings are rotations of each other" :
                "Given Strings are not rotations of each other";
        System.out.println(result);
    }

    // Traditional Approach (Without Java 8)
    private static boolean checkRotationTraditional(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        String temp = a + a;
        return temp.contains(b);
    }

    // Java 8 Optimized Approach
    private static boolean checkRotationJava8(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }
}
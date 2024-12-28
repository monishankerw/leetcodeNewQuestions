package com.leetcode.leetcode.oops.polymorphism.diffBW_CompileAndRuntime.compile;

public class B {
    public String add(int a, int b, int c) {
        return "Sum: " + (a + b + c);
    }

    public String sub(int a, int b, int c) {
        return "Diff: " + (a - b - c);
    }

    public static void main(String[] args) {
        B b = new B();

        // Printing the results of add and sub methods
        System.out.println(b.add(1, 2, 3));
        System.out.println(b.sub(3, 1, 2));
    }
}

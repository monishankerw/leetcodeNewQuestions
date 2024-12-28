package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism;

public class Parent {
    public void test() {
        System.out.println("Parent Class:");
    }

    // Adding the print method to the Parent class
    public void print() {
        System.out.println("Parent Class print method");
    }

    public static class Subclass1 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass1:");
        }
    }

    public static class Subclass2 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass2:");
        }

        public static void main(String[] args) {
            Parent parent = new Subclass1();
            parent.print(); // Calls Subclass1's print method

            Parent parent1 = new Subclass2();
            parent1.print(); // Calls Subclass2's print method
        }
    }
}

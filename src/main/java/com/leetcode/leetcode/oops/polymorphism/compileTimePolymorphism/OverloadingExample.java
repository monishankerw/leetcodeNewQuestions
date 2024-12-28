package com.leetcode.leetcode.oops.polymorphism.compileTimePolymorphism;

class OverloadingExample {

    // Standard main method that JVM will call
    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();

        System.out.println("Overloading example in Java:");

        // Call the overloaded methods
        obj.printInfo(5);  // Call to method with an integer parameter
        obj.printInfo("Hello");  // Call to method with a string parameter
        obj.printInfo(5, "Hello");  // Call to method with an integer and string parameters
        obj.printInfo("Hello", 5);  // Call to method with a string and integer (different order)
        
        // Calling overloaded main method
        obj.main(10);
    }

    // Method with an integer parameter
    public void printInfo(int num) {
        System.out.println("Method with integer parameter: " + num);
    }

    // Overloaded method with a string parameter
    public void printInfo(String msg) {
        System.out.println("Method with string parameter: " + msg);
    }

    // Overloaded method with both integer and string (int first)
    public void printInfo(int num, String msg) {
        System.out.println("Method with int and string parameters: " + num + ", " + msg);
    }

    // Overloaded method with both string and integer (string first)
    public void printInfo(String msg, int num) {
        System.out.println("Method with string and int parameters (different order): " + msg + ", " + num);
    }

    // Overloaded main method
    public void main(int num) {
        System.out.println("Overloaded main method with integer parameter: " + num);
    }
}

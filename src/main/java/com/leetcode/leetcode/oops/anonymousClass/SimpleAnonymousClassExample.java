package com.leetcode.leetcode.oops.anonymousClass;


/*
An anonymous class must be defined inside another class is called as anonymous class.
also called as inner class
nested class not anonymous class
1. Superclass that an anonymous class extends
2. Interface that an anonymous class implements
 */
interface Greeting {
    void sayHello();
}

public class SimpleAnonymousClassExample {
    public static void main(String[] args) {
        // Anonymous class implementing the Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };

        greeting.sayHello(); // Calling the method
    }
}
package com.leetcode.leetcode.oops.polymorphism.compileTimePolymorphism.outputIntQuestion;

//Overloading methods that differ only by the `static` keyword is not allowed because overloading depends on the method's signature (name and parameter list), not the modifiers like `static`. Here's an example to illustrate this point:
//
//### Example Code:
//
//```java
class StaticOverloadExample {

    // Static method
    public static void printMessage() {
        System.out.println("This is the static method");
    }

    // Non-static method
    // Uncommenting the following line will cause a compile-time error
    /*
    public void printMessage() {
        System.out.println("This is the non-static method");
    }
    */

    public static void main(String[] args) {
        StaticOverloadExample obj = new StaticOverloadExample();

        // Call static method
        StaticOverloadExample.printMessage();

        // Uncomment the line below to cause a compile-time error
        // obj.printMessage();
    }
}
//```
//
//### Explanation:
//1. **Static Method**: `printMessage()` is defined as a static method.
//2. **Non-static Method**: If you try to declare a non-static method `printMessage()` with the same parameter list, it will cause a **compile-time error** because overloading cannot be based only on the `static` modifier.
//
//### Error:
//If you uncomment the second `printMessage()` method (non-static version), the compiler will give an error:
//```
//Method 'printMessage()' is already defined in class 'StaticOverloadExample'.
//```
//
//This shows that method overloading must differ by the parameter list and cannot differ only by the presence or absence of the `static` keyword.
//
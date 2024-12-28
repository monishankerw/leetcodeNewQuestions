package com.leetcode.leetcode.oops.polymorphism.compileTimePolymorphism;

public class StaticMethodOverloading {
/*
static methods can be overloaded,
but you cannot overload a method by changing only the return type
 */
    // Static method with an integer parameter
    public static void display(int a) {
        System.out.println("Static method with integer: " + a);
    }

    // Static method with a double parameter
    public static void display(double a) {
        System.out.println("Static method with double: " + a);
    }

    // Overloaded static method with the same name, but different number of parameters
    public static void display(int a, double b) {
        System.out.println("Static method with integer and double: " + a + ", " + b);
    }

    // Uncommenting the following method will result in a compilation error because
    // method overloading cannot be achieved just by changing the return type.
    // public static int display(int a) {
    //     return a * 2;  // Compilation Error: Method display(int) is already defined
    // }

    public static void main(String[] args) {
        // Calling overloaded static methods
        StaticMethodOverloading.display(10);           // Calls display(int)
        StaticMethodOverloading.display(10.5);         // Calls display(double)
        StaticMethodOverloading.display(10, 20.5);     // Calls display(int, double)
        
        // If you uncomment the above return type change, it will cause a compilation error.
    }
}
/*

	•	Static methods can be overloaded by changing the number of parameters or types of parameters.
	•	Overloading based only on return type is not allowed in Java. The display(int) method is already defined, so trying to change its return type will lead to a compilation error.
	•	The method signatures must differ by the parameter list (number, type, or order of parameters).

 */
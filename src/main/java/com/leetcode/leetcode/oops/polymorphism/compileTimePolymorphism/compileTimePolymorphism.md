```markdown
# Compile-Time Polymorphism in Java

## Overview
Compile-time polymorphism in Java, also known as static polymorphism or early binding, 
is achieved through **method overloading**. Method overloading allows multiple methods in the same class to have the same name but different parameter lists.

### Key Concepts:
1. **Method Overloading**: Creating multiple methods in the same class with the same name but different parameters.
2. **Static Methods**: Method overloading can be applied to static methods as well.

## Method Overloading
Method overloading allows a class to have more than one method with the same name, provided their parameter lists are different. The differences can be in the:
1. **Number of Parameters**: The methods can have different numbers of parameters.
2. **Type of Parameters**: The methods can accept parameters of different types.
3. **Order of Parameters**: The order of parameters in the method signature can be different.

### Example:
```java
public class A {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.add(10, 20));        // Calls add(int, int)
        System.out.println(obj.add(10, 20, 30));    // Calls add(int, int, int)
        System.out.println(obj.add(10.5, 20.5));    // Calls add(double, double)
    }
}
```

### Output:
```
30
60
31.0
```

### Key Points:
- **Overloading Static Methods**: Yes, static methods can be overloaded.
- **Overloading with Different Return Types**: Method overloading cannot be done by changing the return type alone. The parameter list must differ.

## Frequently Asked Questions on Compile-Time Polymorphism

### 1. **Can we overload methods that differ only by the static keyword?**
- **Answer**: No, overloading methods that differ only by the `static` keyword is not possible. The parameter list must differ.


### 2. **Can we overload methods with different return types?**
- **Answer**: No, overloading based only on return types is not allowed in Java. The parameter list must be different for method overloading.

### 3. **Can we overload a method by changing only the order of parameters?**
- **Answer**: Yes, you can overload a method by changing the order of parameters.

### 4. **Can we overload the main method in Java?**
- **Answer**: Yes, the `main` method can be overloaded, but the JVM will only call the standard `main(String[] args)` method when starting the application.

### 5. **What happens if we overload methods with different parameter lists and same return type?**
- **Answer**: The correct method is determined at compile-time based on the method signature used when calling the method.

## Summary
- **Compile-time polymorphism** is achieved through method overloading.
- **Method overloading** allows a class to have multiple methods with the same name but different parameter lists.
- **Static methods** can also be overloaded, but overloading cannot be achieved by changing only the return type or using the `static` keyword alone.

Compile-time polymorphism enhances code readability and reusability by allowing multiple methods with similar functionality to be grouped under a single method name.
```
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

Here are some multiple-choice questions (MCQs) related to the provided topic:

1. What is another name for compile-time polymorphism in Java?

	•	a) Dynamic polymorphism
	•	b) Late binding
	•	c) Static polymorphism
	•	d) Interface polymorphism

Answer: c) Static polymorphism

2. Which of the following is true about method overloading?

	•	a) Methods must have the same return type but different parameter lists.
	•	b) Methods must have different names but the same parameter list.
	•	c) Methods can have the same name but must differ in parameter lists.
	•	d) Methods can only differ by the static keyword.

Answer: c) Methods can have the same name but must differ in parameter lists.

3. Can static methods be overloaded in Java?

	•	a) Yes
	•	b) No

Answer: a) Yes

4. Which of the following will cause a compilation error during method overloading?

	•	a) Two methods with the same name but different parameter types.
	•	b) Two methods with the same name and same parameter list but different return types.
	•	c) Two methods with the same name but different numbers of parameters.
	•	d) Two methods with the same name but different order of parameters.

Answer: b) Two methods with the same name and same parameter list but different return types.

5. What determines which overloaded method gets called?

	•	a) The return type of the method
	•	b) The number and type of parameters in the method call
	•	c) The order in which methods are defined
	•	d) The visibility of the methods

Answer: b) The number and type of parameters in the method call

6. Is it possible to overload the main method in Java?

	•	a) Yes, and the JVM can call any of them during program execution.
	•	b) Yes, but the JVM only calls the main(String[] args) method.
	•	c) No, method overloading is not allowed for the main method.
	•	d) No, the main method must always have the same signature.

Answer: b) Yes, but the JVM only calls the main(String[] args) method.

7. Which of the following is a valid reason for method overloading?

	•	a) To improve code readability and reusability.
	•	b) To ensure dynamic method resolution at runtime.
	•	c) To override methods of a parent class.
	•	d) To change the return type of a method.

Answer: a) To improve code readability and reusability.

8. What will the following code output?

public class Test {
    public void display(int a) {
        System.out.println("Integer method: " + a);
    }

    public void display(double a) {
        System.out.println("Double method: " + a);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.display(10);
        obj.display(10.5);
    }
}

	•	a) Compilation error
	•	b) Integer method: 10
Double method: 10.5
	•	c) Integer method: 10
Integer method: 10.5
	•	d) Double method: 10
Double method: 10.5

Answer: b)

Integer method: 10  
Double method: 10.5  

Would you like additional questions or deeper explanations? 😊


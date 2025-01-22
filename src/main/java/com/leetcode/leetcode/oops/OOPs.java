package com.leetcode.leetcode.oops;

import com.leetcode.leetcode.oops.encapsulation.A;

import java.io.*;

public class OOPs {
    /*
    CLASS
    class help us to generate object.
    class will generate object whenever we make a request to class using new keyword.
     */
    /*
    OBJECT
    An entity that has state and behavior is known as an object.
    5 ways to create object
    1. java new operator
    2. java class new Instance() method
    3. java class new Instance() method of constructor.
    4. java object clone() method.
    5. java object  serialization and deserialization.

     */
    /*
    new keyword
    It is send to request the class to create object.
    Once class created an object new keyword gets the address of the
    object and store in a reference variable.
    claaname variablename=new claaname();
     */
    public static class A{
        public static void main(String[] args) {
            A a=new A();
            System.out.println(a);
            A a1=new A();
            System.out.println(a1);
        }
    }
/*

1. What is a Function?

A function is a block of reusable code that performs a specific task.
It can accept input parameters, process them, and return a result.
Functions are independent of objects and can be called directly in programming
languages that support procedural or functional programming.

Key Characteristics:
	•	Defined independently of classes (in procedural programming or functional programming languages).
	•	Can have input parameters and return a result.
	•	Focuses on “what to do” rather than “which object does it”.

Example (in Python):

def add(a, b):  # A simple function
    return a + b

result = add(5, 3)
print("Result:", result)  # Output: 8

2. What is a Method?

A method is a function that is associated with an object or class in object-oriented programming (OOP). Methods can operate on the data (fields) of a class and provide object-specific behavior.

Key Characteristics:
	•	Defined within a class.
	•	Can be called using an object or the class itself (for static methods).
	•	Operates on “what the object does”.

Example (in Java):

public class Calculator {
    // A method within a class
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Create an object
        System.out.println("Result: " + calc.add(5, 3)); // Call the method
    }
}

Key Differences Between Methods and Functions

Aspect	Function	Method
Association	Independent of any object.	Associated with a class or object.
Declaration	Defined globally or within another function.	Defined inside a class.
Calling	Called directly (e.g., add(a, b)).	Called using an object (e.g., object.method()).
Purpose	Focus on performing a specific task.	Focus on defining object-specific behavior.
Scope	Found in procedural or functional programming.	Found in object-oriented programming.
Examples	C, Python, JavaScript (functions exist independently).	Java, C#, Python (methods inside classes).

3. Static Methods

Static methods in object-oriented programming blur the line between functions and methods. They belong to a class rather than an instance of a class.

Example:

public class Utility {
    public static int multiply(int a, int b) { // Static method
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + Utility.multiply(5, 3)); // Called via class name
    }
}

Summary:
	•	Use functions for general-purpose tasks in procedural or functional programming.
	•	Use methods to define behaviors related to objects or classes in object-oriented programming.

 */

    /*
    In Java, access modifiers determine the visibility and accessibility of classes, methods, and fields. They define how code in one class can interact with or access another class, its methods, or its data.

Types of Access Modifiers

Modifier	Class	Package	Subclass	World
public	✔	✔	✔	✔
protected	✔	✔	✔	✘
Default (no keyword)	✔	✔	✘	✘
private	✔	✘	✘	✘

1. public

The public access modifier allows the member or class to be accessible from anywhere in the program.

Example:

public class PublicExample {
    public int number = 42; // Public field

    public void display() { // Public method
        System.out.println("Number: " + number);
    }
}

Usage:

PublicExample example = new PublicExample();
example.display(); // Accessible from anywhere

2. protected

The protected access modifier allows access within the same package and to subclasses, even if they are in different packages.

Example:

package mypackage;

public class ProtectedExample {
    protected String message = "Hello, Protected!";

    protected void displayMessage() {
        System.out.println(message);
    }
}

Usage:
	•	Accessible within the same package.
	•	Accessible in subclasses outside the package through inheritance.

package otherpackage;

import mypackage.ProtectedExample;

public class SubclassExample extends ProtectedExample {
    public void showMessage() {
        System.out.println("Message: " + message); // Accessible
    }
}

3. Default (No Modifier)

When no access modifier is specified, it is known as default (or package-private) access. The member is accessible only within the same package.

Example:

package mypackage;

class DefaultExample {
    int number = 10; // Default field

    void displayNumber() { // Default method
        System.out.println("Number: " + number);
    }
}

Usage:

DefaultExample example = new DefaultExample(); // Accessible only within the same package
example.displayNumber();

4. private

The private access modifier restricts access to the same class only. It cannot be accessed from outside the class, even by subclasses or other classes in the same package.

Example:

public class PrivateExample {
    private String secret = "This is private";

    private void showSecret() {
        System.out.println(secret);
    }

    public void accessSecret() { // Provide controlled access
        showSecret();
    }
}

Usage:

PrivateExample example = new PrivateExample();
// example.secret; // Compilation Error: secret is private
example.accessSecret(); // Accessed through a public method

Practical Use of Access Modifiers
	•	public: Use when you want unrestricted access to methods or fields.
	•	protected: Use for fields or methods intended for subclasses or the same package.
	•	Default: Use when members should be accessible only within the same package.
	•	private: Use to restrict access to sensitive data or implementation details.

Example Combining Access Modifiers

public class AccessModifierExample {
    public String publicField = "Accessible Everywhere";
    protected String protectedField = "Accessible in Subclass or Package";
    String defaultField = "Accessible in Package Only";
    private String privateField = "Accessible in This Class Only";

    public void publicMethod() {
        System.out.println("Public Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void defaultMethod() {
        System.out.println("Default Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }
}

Usage:
	•	Depending on the access modifier, these fields and methods will have different visibility across packages and classes.


     */

    /*
    CONSTRUCTOR
    ### Key Points about Constructors:
1. **Constructor Name:** The constructor must have the same name as the class.
2. **Called on Object Creation:** A constructor is called automatically when an object is created.
3. **No Return Type:** Constructors are never allowed to have a return type, not even `void`.
4. **Initialization:** It is primarily used to initialize objects.
5. **Restrictions:** Constructors cannot be `abstract`, `static`, `final`, or `synchronized`.
6. **Parameter List:** A constructor can have no parameters (non-parameterized) or multiple parameters (parameterized).
7. **Exception Handling:** A constructor can throw exceptions.

    CONSTRUCTOR OVERLOADING

When there is more than one constructor in the same class, but they have different parameter lists (either in the number or type of arguments), it is called constructor overloading.

    METHOD VS CONSTRUCTOR
    TYPE OF CONSTRUCTOR
    1. **Default Constructor:** A no-argument constructor provided by the compiler if none is explicitly defined.
2. **Parameterized Constructor:** A constructor that accepts arguments to initialize object variables.
3. **Non-Parameterized Constructor:** A constructor that doesn't take any arguments.


    CONSTRUCTOR CHAINING
    1. It is used to call constructor but this call should happen from another statement.
2. While calling constructor from another constructor this keyword should always be first statement.

package org.example.corejava.oops.constructor.constructorChaining.acssecssModifier;
//Point main class access same package so protected it can be accessed in order class of the same package.
public class Point {
protected int x,y;
public Point(int _x,int _y){
x=_x;
y=_y;
}//java does not support default argument
public static class Main{
public static void main(String[] args) {
Point p=new Point();//default constructor
System.out.println("x="+p.x+","+"y="+p.y);
}
}
}

    THIS KEYWORD
    SUPER KEYWORD
    PRIVATE CONTRACTOR
    Q. What is a private constructor?
We can hava the private constructors in java.
To make or create a constructor as private, user the private user the private keyword while declaring it.
It can only be accessed within that class.

The following are same usage scenarios when we need a private constructor:
1. Internal Constructor Chaining
2. Singleton class design pattern

Q. Do we have a copy constructor in Java?
Java does not have a built-in copy constructor.
However, you can create one by defining a constructor that takes an instance of the same class and copies its fields. For example:

```java
public class MyClass {
    private int data;

    // Copy constructor
    public MyClass(MyClass other) {
        this.data = other.data;
    }
}
```

This lets you create a copy like:

```java
MyClass original = new MyClass(10);
MyClass copy = new MyClass(original);
```

Alternatively, Java’s `clone()` method can be used, but it requires implementing `Cloneable` and handling deep copies yourself.

    COPY CONSTRUCTOR

     */
public static class Point {
    protected int x, y;

    // Default constructor
    public Point() {
        x = 0;
        y = 0;
    }

    // Parameterized constructor
    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public static class Main {
        public static void main(String[] args) {
            Point p = new Point();  // Uses the default constructor
            System.out.println("x=" + p.x + ", y=" + p.y);
        }
    }

}
    public static class Point1 {
        protected int x, y;

        // Parameterized constructor
        public Point1(int _x, int _y) {
            x = _x;
            y = _y;
        }

        public static class Main {
            public static void main(String[] args) {
                Point1 p = new Point1(0, 0);  // Calls the parameterized constructor
                System.out.println("x=" + p.x + ", y=" + p.y);
            }
        }
    }
    public static class Test {
        int x=2;
        Test(int i){
            x=i;
        }

        public static void main(String[] args) {
            Test t=new Test(5);
            System.out.println("x:"+t.x);
        }
    }
    public static class Test1 {
        Test1(int x){
            System.out.println("Constructor called"+x);
        }
        public static class Test2{
            Test1 test1=new Test1(12);
            Test2(int i){
                test1=new Test1(i);
            }

            public static void main(String[] args) {
                Test2 t2=new Test2(3);
            }
        }
    }
    public static class Test2 {
        public Test2(){
            System.out.println("1");
            new Test(10);
            System.out.println("5");

        }
        public Test2(int x){
            System.out.println("2");
            new Test2(10,21);
            System.out.println("4");
        }
        public Test2(int data,int temp){
            System.out.println("3");
        }

        public static void main(String[] args) {
            Test2 x=new  Test2();
        }
    }
    //A private constructor cannot be used to initialize an object outside the class that it is defined within
//it is no longer visible to the external class.
    public static class Helper {
        private int data;

        // Default constructor
        public Helper() {
            data = 5;
        }

        // Copy constructor
        public Helper(Helper other) {
            this.data = other.data;
        }

        public static class Test {
            public static void main(String[] args) {
                Helper h1 = new Helper();       // Original instance
                Helper h2 = new Helper(h1);     // Copy using copy constructor
                System.out.println("Original data: " + h1.data);
                System.out.println("Copied data: " + h2.data);
            }
        }
    }
    //When a constructor is marked as private, the only way to create a new object of that class from some external class is using a method that created a new object.
    public static class Temp {
        private Temp(int data) {
            System.out.println("Constructor called:");
        }

        protected static Temp create(int data) {
            Temp obj = new Temp(data);
            return obj;
        }

        public void myMethod() {
            System.out.println("Method called");
        }

        public static class Test {
            public static void main(String[] args) {
                Temp obj = Temp.create(20); // Corrected call to create an instance of Temp
                obj.myMethod();
            }
        }
    }

    // Step 1: Make the class implement Serializable
    public class Student implements Serializable {
        private String name;
        private int age;

        // Constructor
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }

    // Separate Main class
    class Main {
        public void main(String[] args) {
            // Create a Student object
            Student student = new Student("John", 20);

            // Step 2: Serialize the object
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
                oos.writeObject(student);
                System.out.println("Object Serialized: " + student);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Step 3: Deserialize the object
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
                Student deserializedStudent = (Student) ois.readObject();
                System.out.println("Object Deserialized: " + deserializedStudent);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    POLYMORPHISM

----
     -> Developing a feature such that it can take more than one form depending on sistuation is called Polymorphism.
     -> In java polymorphism is mainly divided into two types:
        1. compile time polymorphism
        2. Run time polymorphism

1. Compile time polymorphism(static,Earlybinding,Method Overloading):
    This type of polymorphism is achieved by function overloading or operator overloading.
    But Java does not support the operator overloading.

METHOD OVERLOADING: Here we create more than one method same class with same name they have provided
different number of argument and different type of argument is called as method overloading.

    METHOD OVERLOADING CAN BE POSSIBLE
1. The return type of the overload function
2. The Type of the parameter pass to the function
3. The Number of parameter pass to the function

```java


public class A {
    public int add(int a, int b){
        return a+b;
    }
    public int add(int a, int b, int c){
        return a+b+c;
    }
    static  class B{
  public static void main(String[] args) {
               A a1=new A();
            System.out.println(a1.add(10,20));
            System.out.println(a1.add(10,20,30));
        }
    }
}

---> Yes, We can overload static method.


Q. Can we overload methods that differ only be static keywords?
no


     */
    /*
    ENCAPSULATION

# Encapsulation in Java

## 1. What is Encapsulation?
Encapsulation is the concept of wrapping data (attributes) and methods (functions) that operate on the data into a single unit,
typically a class. This helps to restrict direct access to some of the object's components, which is a means of preventing unintended interference and misuse.

- **Key Points:**
  - Data is made private to prevent direct access.
  - Public methods, known as **getters** and **setters**, are provided to operate on the data.

## 2. Advantages of Encapsulation
- **Control Access to Data:** It allows for validation of values before they are set, ensuring that the object maintains a valid state.
- **Read-Only or Write-Only Access:** You can create read-only or write-only properties by only providing a getter or a setter method, respectively.

## 3. Data Hiding
- Data hiding is a principle that makes the class's variables private, restricting access from outside the class.
- **Note:** Data hiding applies to variables, not methods. Methods can still be public while their underlying data remains hidden.

## 4. How to Achieve Encapsulation in Java
To achieve encapsulation in Java, follow these steps:
1. Declare the variables of a class as private.
2. Provide public setter and getter methods to modify and view the variable values.

### Example
```java
public class Employee {
    private String name; // Private variable

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }
}
```

## 5. What are Get and Set Methods?
- **Get Method:** The getter method is used to retrieve the value of a private variable.
- **Set Method:** The setter method is used to set or update the value of a private variable.

### Example
```java
Employee emp = new Employee();
emp.setName("John Doe"); // Using setter
String empName = emp.getName(); // Using getter
```

## 6. Benefits of Encapsulation
- **Data Hiding:** Protects the internal state of the object from unintended interference.
- **Increased Flexibility:** You can change the internal implementation without affecting other parts of the code.
- **Reusability:** Encapsulated code is easier to reuse in other programs or projects.

     */
    public static class ANC {
        private int i;
        private String name;
        public int GetI(){
            return i;
        }
        public void SetI(int i){
            this.i=i;
        }
        public String GetName(){
            return name;
        }
        public void SetName(String name){
            this.name=name;
        }

        public static void main(String[] args) {
            ANC a=new ANC();
            a.SetI(12);
            a.SetName("name");
            System.out.println(a.GetI());
            System.out.println(a.GetName());
        }
    }

    /*
    INTERFACE

INTERFACE
---> Interfaces are 100% abstract.
---> All variables default by static and final.
--> An Interface consists of only incomplete/ abstract method.
--> A Java interface consists static constants and abstract methods.
--> The interface in Java is a mechanism to achieve abstraction.
--> There can be only abstract methods in the Java interface, not the method body.
--> It used to achieve abstraction and multiple inheritance in Java.
--> Java Interface also represents the IS -A relationship.
ex: Comparator Interface


  parent                class

class-------(extends)-> class
interface---(implements)-> class
interface--(extends)----> interface
class-----(not)--------> interface

Why do we use an interface?
--> It is used to achieve total abstraction.
--> Since Java support multiple inheritance in the case of class by using an interface it can achieve multiple inheritance.
--> It is also used to achieve loose coupling.
--> Interface are used to implement abstraction.


---> To declare an interface use the interface keyword. It is used to provide total abstraction. That means all the methods in an
 interface are declared with an empty body and are public and all fields are public, static and final by default.
---> A class that implements an interface must implement all the method declared in the interface. To implement interface used implements keyword.


     */
    public interface ABS {
        public void test();

        public static class B implements ABS{

            @Override
            public void test() {
                System.out.println(100);
            }

            public static void main(String[] args) {
                B b=new B();
                b.test();
            }
        }
    }


    public static interface Bank {
        public void balance();
        public void transfer();
        public static class HDFCBank implements Bank{

            @Override
            public void balance() {
                System.out.println("Logic A");
            }

            @Override
            public void transfer() {
                System.out.println("Logic B");
            }
        }
        public static class ICICBank implements  Bank{

            @Override
            public void balance() {
                System.out.println("Logic C");
            }

            @Override
            public void transfer() {
                System.out.println("Logic D");
            }
        }
        public static class User{
            public static void main(String[] args) {
                HDFCBank bank=new HDFCBank();
                bank.balance();
                bank.transfer();
                ICICBank icicBank=new ICICBank();
                icicBank.balance();
                icicBank.transfer();
            }
        }
    }

    public interface A2 {
        public void test1();
        public static interface B{
            public void test2();
            public static interface C extends A2,B{
                public void test3();
            }

            public static class D implements C {

                @Override
                public void test3() {

                }

                @Override
                public void test1() {

                }

                @Override
                public void test2() {

                }

                public static void main(String[] args) {
                    D d=new D();
                    d.test1();
                    d.test2();
                    d.test3();
                }
            }
        }
    }

    public interface B {
        public void test1();

        public static interface C {
            public void test2();

            public static class D implements B, C {

                @Override
                public void test1() {
                    System.out.println(2);
                }

                @Override
                public void test2() {
                    System.out.println(1);
                }

                public static void main(String[] args) {
                    D d = new D();
                    d.test1();
                    d.test2();
                }
            }
        }
    }

    public interface C {
        public void test1();
        public static class D{
            public void test2(){
                System.out.println(2);
            }
            public static class E  extends D implements  C{

                @Override
                public void test1() {
                    System.out.println(1);
                }

                public static void main(String[] args) {
                    E e=new E();
                    e.test1();
                    e.test2();
                }
            }
        }
    }
    /*
    ABSTRACTION

1. What is abstraction in Java?
--> Hiding of implementation details is called as abstraction.
--> We can achieved in java using interface and abstract classes.
--> We can achieve 100% abstraction using interface.



3. What is Abstract keyword?
--> Abstract keyword help us to defined incomplete method and incomplete class.
--> To develop incomplete method in interface used of abstract keyword.



public interface A{
public abstract void test();
public void example();
}

--> A method that doesn't have its body is called abstract.
--> We use the same abstract keyword to create abstract methods.


3. Abstract class:
--> An abstract class 0 to 100% uncompleted.
--> An abstract class can consist of constructor.
--> An abstract class can consist of static and non static member.
--> We can create main method in an abstract class.
--> Object of abstract class can not be created.
--> Abstract class does not support multiple inheritance.


4.
--> yes, an abstract class always has a constructor. If you do not define you own constructor, the compiler will give a
    default constructor to abstract constructor.
--> An abstract class can have parametrized constructor and the default constructor is always present in an abstract class.


5. Difference between abstract class and interface.
Interface:
--> Interface are 100% abstract.
--> support multiple inheritance.
--> All variable default by static and final.

Abstract class
--> Abstract class can be 0 to 100% uncompleted.
--> Does not support multiple inheritance.
--> We can create static and non-static variable.

7. Difference between abstraction and encapsulation?
abstraction
--> Hiding of implementation detail is called abstraction.
--> We can achieve by interface and abstract class.
--> abstraction can be o to 100% uncompleted.
--> Multiple inheritance not support.
Encapsulation:
--> Wrapping of data with method that operate on data is called encapsulation.
--> In encapsulation avoid direct access data making variable.
--> In encapsulation used getter and setter for make the variable public.
--> Datahiding is the feature of encapsulation.

     */
    public static abstract class Abs {
        int x = 10;

        public void test() {
            System.out.println(100);
        }

        public abstract void xyz();

        public static class B extends Abs {

            @Override
            public void xyz() {
                System.out.println(100);
            }

            public static void main(String[] args) {
                B b=new B();
                //A a=new A();
                b.test();
                System.out.println(b.x);
                b.xyz();
            }
        }
    }
}

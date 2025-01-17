package com.leetcode.leetcode.oops.interfaces;



public class Opps {

/*
# Access Modifiers in Java

| **Modifier**       | **Class** | **Package** | **Subclass (Different Package)** | **World (Other Classes)** |
|---------------------|-----------|-------------|-----------------------------------|---------------------------|
| **`public`**        | ✔         | ✔           | ✔                                 | ✔                         |
| **`protected`**     | ✔         | ✔           | ✔                                 | ✘                         |
| **Default** (No Modifier) | ✔         | ✔           | ✘                                 | ✘                         |
| **`private`**       | ✔         | ✘           | ✘                                 | ✘                         |

## Explanation of Modifiers

1. **`public`**:
    - Accessible from **anywhere** in the program.
    - Example:
      ```java
      public class Example {
          public String name = "Public";
      }
      ```

2. **`protected`**:
    - Accessible:
        - Within the same class.
        - Within the same package.
        - By subclasses (even in different packages).
    - Example:
      ```java
      public class Example {
          protected String name = "Protected";
      }
      ```

3. **Default** (No Modifier):
    - If no modifier is specified, the member is package-private.
    - Accessible:
        - Within the same class.
        - Within the same package.
    - Example:
      ```java
      class Example {
          String name = "Default";
      }
      ```

4. **`private`**:
    - Accessible only within the class it is declared in.
    - Ensures encapsulation.
    - Example:
      ```java
      public class Example {
          private String name = "Private";
      }
      ```

## Visual Representation

```plaintext
+-----------------------------------------------------+
|                    Access Levels                   |
+---------------+-----------+------------+-----------+
| Modifier      | Class     | Package    | Subclass  |
+---------------+-----------+------------+-----------+
| public        | ✅        | ✅         | ✅        |
| protected     | ✅        | ✅         | ✅        |
| default       | ✅        | ✅         | ❌        |
| private       | ✅        | ❌         | ❌        |
+---------------+-----------+------------+-----------+
 */

/*how to create single turn class
Here we design a class such that only once object of
class can be created through out execution of program
Exm: Runtime class,Action Servlet

Purpose of Singleton class
Example: socket or database connection
 */


    //1. make class final
    public static final class A1 {

        static A1 a=null;

        //2.make constructor private
        private A1(){}

        // 3.provide static method that returns a reference to the instance
        //4. The instance initialization concept is used to write to static method
        public static A1 getInstance(){
            if(a==null){
               A1 a=new A1();
                return a;
            }
            return a;
        }
        public static class B1{
            public static void main(String[] args) {
         A1 a1= A1.getInstance();
         A1 a2= A1.getInstance();
                System.out.println(a1);
                System.out.println(a2);
            }
        }
    }

    public static class Interfaces {
        /*
        An interface consists of only incomplete/abstract method.
        A java interface contains static constants and abstract methods.
        These can be only abstract methods in the java interface,not the method body.
        It is used to achieve abstraction and multiple inheritance in java.
        IS -A relationship
        Comparator interface

         */
        public static interface A {
            //public void test(){}//error
        }

        public static interface B {
            public void test();
        }

        public static class C implements B {

            @Override
            public void test() {
                System.out.println(111);
            }

            public static void main(String[] args) {
                C c = new C();
                c.test();
            }
        }
    /*
    interface is keyword
    It used to provide total abstraction.
    The means all the method in an interface are declered with an empty body and are public
    and all fields are public,private and final by defaults.
     */
    }

    //java support multiple interface
    public static interface D {
        public void test();

        public static interface E{
            public void test1();

        }
        public static interface F extends D,E {
            public void test2();
            public static class G implements F{

                @Override
                public void test2() {
                    System.out.println(111);
                }

                @Override
                public void test() {
                    System.out.println(222);
                }

                @Override
                public void test1() {
                    System.out.println(333);
                }

                public static void main(String[] args) {
                    G e=new G();
                    e.test();
                    e.test1();
                    e.test2();
                }
            }
        }
    }

    public static interface Bank {
        public void balance();
        public void transfer();
        public static class HDFCBank implements Bank {

            @Override
            public void balance() {
                System.out.println("1");
            }

            @Override
            public void transfer() {
                System.out.println("2");
            }
        }
        public static class ICICBank implements Bank {

            @Override
            public void balance() {
                System.out.println("3");
            }

            @Override
            public void transfer() {
                System.out.println("4");
            }
        }
        public static class User{
            public static void main(String[] args) {
                Bank.HDFCBank bank=new Bank.HDFCBank();
                bank.balance();
                bank.transfer();
                Bank.ICICBank bank1=new Bank.ICICBank();
                bank1.balance();
                bank1.transfer();
            }
        }
    }
/*
What do you means by an interface in java?
Interface are 100% abstract.
Support multiple inheritance.
All variable default by static and final.
An interface consists of only incomplete/abstract method.
In interface incomplete static method can not be develop.
 */

    /*
    ABSTRACTION
    What is ABSTRACTION in Java?
    -> Hiding of implementation detail is called ABSTRACTION.
    -> We can achieve in java by uses interface and abstract classes.
    -> We can acheive 100% abstraction using interface.

    We are an Abstract keyword?
    -> Abstract keyword helps us to define incomplete method and incomplete class.
    -> To develop incomplete method in interface used of abstract keyword is optional.

     */
    public static interface A2{
        public abstract void test();
        public void example();
    }
    /*
    A method that does not hava its body is called abstract.
    We use the same abstract keyword to create abstract methods.
     */

}

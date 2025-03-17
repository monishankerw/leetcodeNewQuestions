package com.leetcode.leetcode.java8;

import java.util.ArrayList;
import java.util.Optional;

public class Java8 {
    //Difference Between Java 7 and Java 8
    /*
    Functional Interface
1. Functional Interface
   a. A Functional Interface is an interface that contains
    only one abstract method(Incomplete method).
   b. It is also known as SAM Interface(Single Abstract Method)
   c. A Functional Interface can have any number of default and static method.
   Exam: Runnable, Camparable, ActionListener
   d. Lambda Expressions can be used and executed by representing the interface with an annotation called @FunctionalInterface.
   e. @Functional Interface annotation is used to ensure that the functional interface can not more than one abstract method.

     ############# Lambda Expression #############
     2. Lambda Expression
   -> Lambda Expression is mainly used to implement functional interface.
   -> Lambda Expression is an anonymous function.
   -> It is a function without name and does not belongs to any class.
   -> It reduces the line of java code. but the drawback is it make the code less readable.
   -> Lambda expression implement the only abstract function and therefore implement functional interface.
3. Why are use Lambda expression?
   Facilitates Functional programming.
   ->To provided the implementation of the java 8 functional Interface.
   ->Reduce lines of code.
   ->Passing behavious into method.
4. Write a java Lambda Expression to create Thread.
   ->The Runnable interface is a functional interface so we can use Lambda Expression to implement Runnable functional interface.

     */


    @FunctionalInterface
    public static interface A {
        public void test();

    }

    public static class B {
        public static void main(String[] args) {
            A b = () -> {
                System.out.println(122);
                System.out.println(111);

            };
            b.test();
        }
    }

    @FunctionalInterface
    public static interface Sum {
        public int sum(int a, int b);
    }

    public static class SumOuput {
        public static void main(String[] args) {
            Sum sum = (a, b) -> a + b;
            System.out.println(sum.sum(2, 3));
        }
    }

    @FunctionalInterface
    public static interface Test1 {
        public void number(int x, int y);
    }

    public static class TestOutput {
        public static void main(String[] args) {
            Test1 test1 = (int x, int y) -> {
                System.out.println(x);
                System.out.println(y);

            };
            test1.number(1, 2);
        }
    }

    @FunctionalInterface
    public static interface Square {
        public int square(int x);
    }

    public static class Square1 {
        public static void main(String[] args) {
            Square square = (int a) -> a * a;
            System.out.println(square.square(4));
        }
    }

    public static class Test {
        public static void main(String[] args) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(1);
            a.add(2);
            a.add(3);
            a.add(4);
            a.forEach((n) -> System.out.println(n));
            a.forEach((n) -> {
                if (n % 2 == 0) System.out.println(n);
            });


        }
    }

    /*
    Optional Class
->Optional class handle null pointer Exception.
empty()-> Returns an empty optional instance
of(T value)-> Returns an optional with the specified present non-null value.
ofNullable(T value)->Returns an optional describing the specified value, if non-null,other wise returns an empty optional.

     */
    public static class A1 {
        int x = 10;
        static A1 a;

        public static void main(String[] args) {
            Optional<A1> a1 = Optional.ofNullable(a);
            System.out.println(a1.isPresent());
            System.out.println(100);
        }
    }

    public static class B1 {
        int x = 10;
        static B1 a1;

        public static void main(String[] args) {
            try {
                System.out.println(a1.x);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(100);
        }

    }

    public static class C {
        int c = 100;

        public static void main(String[] args) {
            C c1 = null;
            Optional<C> c2 = Optional.ofNullable(c1);
            System.out.println(c2.isPresent());
            System.out.println(122);
        }
    }

    /*
            4. Default Keyword
        ->using default keyword we can created complete mmethods inside an interface.
        Note:A functional interface should consist exactly one incomplete method but can have any number of complete method in it.
        Ex2:
        @FunctionInterface
        public interface Test {
            public void test1(int x);
            default void test2(){
                System.out.println(100);
            }
            default void test3(){
                System.out.println(200);
            }
        }
        public class Main {
            public static void main(String[] args) {
                Test test=(int x)->{
                    System.out.println(x);
                };
                test.test1(1);
                test.test2();
                test.test3();
            }
        }

        ->In an Interface  we can add main method.
        public interface A{
            int x=10;
            main(){
                sout(A.x)
            }
        }
        ->We can develop complete static method in an interface.
        public interface A{
            int x=10;
            main(){
                sout(A.x);
                A.test();
            }
            public static void test(){
                sout(100);
            }
        }
     */
    @FunctionalInterface
    public static interface D {
        public void test1(int x);

        default void test2() {
            System.out.println(2);
        }

        default void test3() {
            System.out.println(3);
        }
    }


    public static class E implements D {
        @Override
        public void test1(int x) {
            System.out.println(x);
        }


        public static void main(String[] args) {
            E b1 = new E();
            b1.test1(1);
            b1.test2();
            b1.test3();
        }
    }
   @FunctionalInterface
    public static interface Test5 {
        public void test1(int x);
        default void test2(){
            System.out.println(100);
        }
        default void test3(){
            System.out.println(200);
        }
    }
    public static class Main {
        public static void main(String[] args) {
            Test5 test=(int x)->{
                System.out.println(x);
            };
            test.test1(1);
            test.test2();
            test.test3();
        }
    }
}


What happens if we add another abstract method to the functional interface?
Can a functional interface extend another interface?
How can a functional interface extend another interface?
How do default methods work in multiple interfaces?
Can a functional interface have static methods?
What is the difference between default and abstract methods?
Can we override default methods in implementing classes?
What are method references, and how do they relate to functional interfaces?
How does a lambda expression differ from an anonymous class?
Can default methods be overridden in implementing classes?
What is the use of @FunctionalInterface annotation?

How does a lambda expression differ from an anonymous class?
What are method references, and how do they relate to functional interfaces?
What is the significance of @FunctionalInterface, and is it mandatory?

Can a functional interface have static methods?
What is the difference between default and abstract methods?
Can we override default methods in implementing classes?
How does a lambda expression differ from an anonymous class?
What are method references, and how do they relate to functional interfaces?
How can a functional interface be used in method chaining?
What is the significance of @FunctionalInterface, and is it mandatory?




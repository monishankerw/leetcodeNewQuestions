package com.leetcode.leetcode.exceptions.throwAndThrows;

/*
Java throw Exception
-> throw keyword is used to throw an exception explicitly.
->we can throw either checked or unchacked exception in java by throw keyword.


1. throw keyword used inside a function.
2. throw keyword used only one exception and can not multiple exception.
3. throw keywords help us to take the memory address of exception object give to the catch block.
4. We only to throw but can not propagate exception to calling method.

throw instance i.e:
throw new exception_class("errormanage")
ex:
throw new IOException("error");

 */
public class ThrowAndThrows {
    public static class A {
        public static void main(String[] args) {
            try {
                fun();
            } catch (NullPointerException e) {
                System.out.println("Exception occurs:" + e.getMessage());
            }
        }

        private static void fun() {
            try {
                throw new NullPointerException("demo");
            } catch (NullPointerException e) {
                System.out.println("Exception occurs inside fun()::" + e.getMessage());
            }
        }
    }

    public static class B {
        public static void main(String[] args) {
            try {
                int age = 19;
                validates(age);

            } catch (ArithmeticException e) {
                System.out.println("Age:::" + e.getMessage());
            }

        }

        private static void validates(int age) {

            if (age < 18) {
                throw new ArithmeticException("Not Eligible");
            } else {

                System.out.println("Age Eligible::");
            }
        }
    }

    public static class InssuficientFunds extends Exception {
        InssuficientFunds() {
            System.out.println("Low Balance::");
        }
    }

    public static class Bank {
        public static void main(String[] args) {
            int balance = 10, amount = 1000;
            if (amount > balance) {
                try {
                    throw new InssuficientFunds();
                } catch (InssuficientFunds e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Collect Funds::");
            }
        }
    }

    public static class Except {
        public static void main(String[] args) {
            try {
                throw new Error();
            } catch (Error e) {
                try {
                    throw new RuntimeException();
                } catch (Throwable t) {
                }
            }
            System.out.println("phew");
        }

    }
}

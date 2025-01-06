package com.leetcode.leetcode.exceptions;

import com.leetcode.leetcode.oops.interfaces.E;

public class Exceptions {
//Whenever a bad user input given a program it will be hold the program execution abruptly
    //is called exception
    public static class ExcpOcc{
        public static void main(String[] args) {
            int x=10,y=0;
            int z=x/y;
            System.out.println(1);
            System.out.println(2);
        }
    }
    public static class HandleExcp {
        public static void main(String[] args) {
            try {

                int x = 10, y = 0, z;
                z = x / y;
                System.out.println("welcome");
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(122);
            System.out.println(222);
        }
    }
    public static class A {
        int x = 1;

        public static void main(String[] args) {
            try {
                // This line will throw a NumberFormatException
                Integer.parseInt("xyz");
            } finally {
                // This will always be executed
                System.out.println(1);
            }
            // This line will not be executed because the exception is not caught
            System.out.println(2);
        }
    }
    public static class B {
        //---->Whenever Exception occur or not finally block continuous to execute.
//----> finally is the extension of try and catch block.
        int x = 19;

        public static void main(String[] args) {
            try {
                Integer.parseInt("xad");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println(122);
            }
        }
    }
}

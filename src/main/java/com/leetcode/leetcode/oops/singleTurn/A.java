package com.leetcode.leetcode.oops.singleTurn;


/*how to create single turn class
Here we design a class such that only once object of
class can be created through out execution of program
Exm: Runtime class,Action Servlet

Purpose of Singleton class
Example: socket or database connection
 */


//1. make class final
public final class A {

    static A a=null;

    //2.make constructor private
    private A(){}

    // 3.provide static method that returns a reference to the instance
    //4. The instance initialization concept is used to write to static method
    public static A getInstance(){
        if(a==null){
            A a=new A();
            return a;
        }
        return a;
    }
    public static class B{
        public static void main(String[] args) {
            A a1=A.getInstance();
            A a2=A.getInstance();
            System.out.println(a1);
            System.out.println(a2);
        }
    }
}

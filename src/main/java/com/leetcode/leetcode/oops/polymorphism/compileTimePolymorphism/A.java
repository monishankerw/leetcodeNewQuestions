package com.leetcode.leetcode.oops.polymorphism.compileTimePolymorphism;

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

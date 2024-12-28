package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism;

public class A {
    public void test(){
        System.out.println(100);
    }
    public static class B extends A{
        @Override
        public void test() {
            System.out.println(200);
        }

        public static void main(String[] args) {
            A a=new A();
            a.test();
        }
    }
}

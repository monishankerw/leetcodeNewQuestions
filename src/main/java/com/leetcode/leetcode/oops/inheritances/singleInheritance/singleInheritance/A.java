package com.leetcode.leetcode.oops.inheritances.singleInheritance.singleInheritance;

public class A {
    public void  test(){
        System.out.println("A");
    }
    public static class B extends A{
        public void xyz(){
            System.out.println("xyz");
        }

        public static void main(String[] args) {
            B b=new B();
            b.test();
            b.xyz();
        }
    }
}

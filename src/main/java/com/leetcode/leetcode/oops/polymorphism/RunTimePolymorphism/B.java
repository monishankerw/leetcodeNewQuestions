package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism;

public class B {
    private void m1(){//private method are not overriden
        System.out.println("A");
    }
    protected void m2(){
        System.out.println("B");
    }
    public static class C extends B{


        public void m1() {
            System.out.println("C");
        }
        @Override
        public void m2() {//override method with more accessibility
            System.out.println("D");
        }
    }

    public static void main(String[] args) {
        B b=new B();
        b.m2();
        B b1=new C();
        b1.m2();
    }
}

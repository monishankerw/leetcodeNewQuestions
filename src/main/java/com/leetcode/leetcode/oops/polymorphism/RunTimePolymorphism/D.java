package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism;

public class D {
    void show1(){
        System.out.println("D");
    }
    public static class E extends D{
        @Override
        void show1() {
            System.out.println("E");
        }
    }

    public static void main(String[] args) {
        D d=new E();
        d.show1();
    }
}

package com.leetcode.leetcode.oops.inheritances.singleInheritance.abstraction;

public interface A {
    public abstract void test();

public static abstract class Test{
    int x=10;
    public abstract void test1();
    public void  test(){
        System.out.println("abc");
    }
private static class B extends Test{

    @Override
    public void test1() {
        System.out.println(1222);
    }

    public static void main(String[] args) {
        B b=new B();
        b.test();
        System.out.println(b.x);
        b.test1();
    }
}


    }
}


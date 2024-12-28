package com.leetcode.leetcode.oops.polymorphism.diffBW_CompileAndRuntime.run;

public class A {
    public void add(int x,int y){
        System.out.println("Add:"+(x+y));
    }

    public void sub(int x,int y){
        System.out.println("Sub:"+(x-y));
    }
public static class B extends A{
        public void multiply(int a, int b){
            System.out.println("Multiply:"+(a*b));
        }

    public static void main(String[] args) {
        A a=new A();
        a.add(1,2);
        a.sub(3,1);
        A a1=new B();
        a1.add(1,5);
        a1.sub(6,3);
        B b=new B();
        b.multiply(4,5);
    }
}
}

package com.leetcode.leetcode.oops.polymorphism.diffBW_CompileAndRuntime.compile;

public class A {
    public void add(int x,int y){
        System.out.println("Sum Of Two:"+(x+y));
    }
    public void sub(int x,int y){
        System.out.println("Diff Of Two:"+(x-y));
    }

    public static void main(String[] args) {
        A a=new A();
        a.add(1,2);
        a.sub(3,2);
    }
}

package com.leetcode.leetcode.oops.polymorphism;

public class Test extends Geeks
{
    public void myMethod()
    {
        System.out.println("GeeksforGeeks");
    }
    public void getInfo()
    {
        System.out.println("Geeks");
    }

    public static void main(String[] args)
    {
        Geeks obj = new Test();
        obj.getInfo();
    }
}
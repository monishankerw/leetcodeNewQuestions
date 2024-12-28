package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism.outputIntQuestion;

public class Base {
public void print(){
    System.out.println("Base");
}
public static class Derive extends Base{
    public void print(){
        System.out.println("Derived");
    }
}
public static class Main{
    public static void DoPrint(Base o){
        o.print();
    }
    public static void main(String[] args) {
        Base base=new Base();
        Derive derive=new Derive();
        Base base1=new Derive();
        DoPrint(base);
        DoPrint(derive);
        DoPrint(base1);
    }
}
}

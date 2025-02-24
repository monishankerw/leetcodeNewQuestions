package com.leetcode.leetcode.oops.encapsulation;

public class A {
    private int i;
    private String name;
    public int GetI(){
        return i;
    }
    public void SetI(int i){
        this.i=i;
    }
    public String GetName(){
        return name;
    }
    public void SetName(String name){
        this.name=name;
    }

    public static void main(String[] args) {
        A a=new A();
        a.SetI(12);
        a.SetName("name");
        System.out.println(a.GetI());
        System.out.println(a.GetName());
    }

}
/*

 */
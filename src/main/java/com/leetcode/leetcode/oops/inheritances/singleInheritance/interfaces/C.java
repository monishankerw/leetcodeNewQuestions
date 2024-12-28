package com.leetcode.leetcode.oops.inheritances.singleInheritance.interfaces;

public interface C {
    public void test();
    public static class D{
        public void test1(){
            System.out.println(2);
        }
        public static class E extends D implements C{

            @Override
            public void test() {
                System.out.println("3ee");
            }

            public static void main(String[] args) {
                E e=new E();
                e.test();
                e.test1();
            }
        }
    }
}

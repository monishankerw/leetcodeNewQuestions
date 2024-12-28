package com.leetcode.leetcode.oops.interfaces;


//java support multiple interface
public interface B {
    public void test();
    public static interface C{
        public void test1();
    }
    public static interface D extends B,C{
        public void test2();
        public static class E implements D{

            @Override
            public void test2() {
                System.out.println(111);
            }

            @Override
            public void test() {
                System.out.println(222);
            }

            @Override
            public void test1() {
                System.out.println(333);
            }

            public static void main(String[] args) {
                E e=new E();
                e.test();
                e.test1();
                e.test2();
            }
        }
    }
}

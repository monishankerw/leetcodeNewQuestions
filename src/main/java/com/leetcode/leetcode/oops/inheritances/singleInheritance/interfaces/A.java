package com.leetcode.leetcode.oops.inheritances.singleInheritance.interfaces;

public interface A {
    public void test();
    public static class Test implements A{

        @Override
        public void test() {
            System.out.println(122);
        }

        public static void main(String[] args) {
            Test a=new Test();
            a.test();
        }
    }
}

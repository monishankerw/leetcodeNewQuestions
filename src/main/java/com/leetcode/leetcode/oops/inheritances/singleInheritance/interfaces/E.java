package com.leetcode.leetcode.oops.inheritances.singleInheritance.interfaces;

public interface E {
    public void test();
    public static interface F extends E{
        public void test1();
        public static interface G extends F{
            public void test2();
        }
    }
    public static class H implements F{

        @Override
        public void test1() {
            System.out.println(1);
        }

        @Override
        public void test() {
            System.out.println(2);
        }

        public static void main(String[] args) {
            H h=new H();
            h.test();
            h.test1();
        }
    }
}

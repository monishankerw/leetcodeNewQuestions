package com.leetcode.leetcode.threads;

public class RunnableClass implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("Test1");
        }
    }

    public static void main(String[] args) {
        RunnableClass a=new RunnableClass();
        Thread t=new Thread(a);
        t.start();
        for (int i=0;i<1000;i++){
            System.out.println("Test2");
        }
    }
}

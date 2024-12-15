package com.leetcode.leetcode.threads;

public class ThreadClass extends Thread{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("Test1");
        }
    }

    public static void main(String[] args) {
        ThreadClass a=new ThreadClass();
        a.start();
        for (int i=0;i<1000;i++){
            System.out.println("test2");
        }
    }
}

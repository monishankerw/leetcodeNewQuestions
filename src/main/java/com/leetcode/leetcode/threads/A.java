package com.leetcode.leetcode.threads;

public class A extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread" + Thread.currentThread().getId() + "is Running");
        } catch (Exception e) {
            System.out.println("Exception Test:" + e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 122; i++) {
            System.out.println("Task2");
            A b = new A();
            b.start();
        }
    }
}

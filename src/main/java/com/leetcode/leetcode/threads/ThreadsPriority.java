package com.leetcode.leetcode.threads;

public class ThreadsPriority extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        ThreadsPriority t=new ThreadsPriority();
        t.start();
        t.setPriority(NORM_PRIORITY);
        System.out.println(t.getPriority());
        t.setPriority(MIN_PRIORITY);
        System.out.println(t.getPriority());
        t.setPriority(MAX_PRIORITY);
        System.out.println(t.getPriority());
    }
}

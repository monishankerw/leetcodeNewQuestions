package com.leetcode.leetcode.threads;

public class StarvationExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // High-priority thread
        Thread highPriorityThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("High-priority thread is running.");
                    try { Thread.sleep(50); } catch (InterruptedException e) {}
                }
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        // Low-priority threads
        for (int i = 1; i <= 3; i++) {
            Thread lowPriorityThread = new Thread(() -> {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " is running.");
                }
            });
            lowPriorityThread.setName("Low-priority Thread-" + i);
            lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
            lowPriorityThread.start();
        }

        highPriorityThread.start();
    }
}

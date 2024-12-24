package com.leetcode.leetcode.threads;

public class DaemonThreadExample {
    public static void main(String[] args) {
        // Creating a user (non-daemon) thread
        Thread userThread = new Thread(() -> {
            System.out.println("User thread is starting...");
            try {
                Thread.sleep(3000); // Simulate some work in the user thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("User thread has finished.");
        });

        // Creating a daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Daemon thread runs in background
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Set the daemonThread to be a daemon
        daemonThread.setDaemon(true);

        // Start both threads
        userThread.start();
        daemonThread.start();

        // Output the daemon status of each thread
        System.out.println("Is userThread a daemon? " + userThread.isDaemon()); // Output: false
        System.out.println("Is daemonThread a daemon? " + daemonThread.isDaemon()); // Output: true
    }
}

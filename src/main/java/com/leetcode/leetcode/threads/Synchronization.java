package com.leetcode.leetcode.threads;


//Thread Synchronization
// When two thread are operation on a common data non-synchronous manner, data will get corrupted.
public class Synchronization {
    public static class A {
        private int balance;

        public static void main(String[] args) {
            A a = new A();
            a.account();
            System.out.println("Final Balance: " + a.balance);
        }

        private void account() {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    add();
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    sub();
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        public synchronized void add() {
            for (int i = 0; i < 1000; i++) {
                balance = balance + 1;
            }
        }

        public synchronized void sub() {
            for (int i = 0; i < 1000; i++) {
                balance = balance - 1;
            }
        }
    }
    /*
    Synchronization Area:
   1. This area can be accessed by only one thread at a
    time having synchronized method and blocks.
    2. When ever we are performing updating operation
    (add,delete,remove/replace)
    i.s state of object is changing

    Non-Synchronization area
    1.This are can be accessed any number of thread having non-synchronized method and blocks.
    2. When even we are performing read operation state of object is changing

     */


    public static class SynchronizationDemo {

        static class SharedResource {
            private int balance = 0;

            // Synchronized method for updating balance (Synchronization Area)
            public synchronized void updateBalance(int amount) {
                balance += amount;
                System.out.println(Thread.currentThread().getName() + " updated balance to: " + balance);
            }

            // Non-synchronized method for reading balance (Non-Synchronization Area)
            public void readBalance() {
                System.out.println(Thread.currentThread().getName() + " read balance as: " + balance);
            }
        }

        public static void main(String[] args) {
            SharedResource resource = new SharedResource();

            // Thread for updating the balance
            Thread updateThread = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.updateBalance(10); // Increment balance by 10
                    try {
                        Thread.sleep(100); // Simulate some work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Updater");

            // Thread for reading the balance
            Thread readThread = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    resource.readBalance(); // Read balance without synchronization
                    try {
                        Thread.sleep(100); // Simulate some work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Reader");

            updateThread.start();
            readThread.start();

            try {
                updateThread.join();
                readThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
       Q. When a thread need class level look?
        If a thread wants to execute Static synchronized method it required class level lock.

        Q. What is synchronized keyword where we can applicable.
        Synchronized Keyword
         -> Synchronized keyword is modifier
         -> It is applicable on method and block but not on class.
          -> If multiple threads are trying to operate simultaneously on the same java object
          then may be a chance of data inconsistency problem.
          -> To overcome the problem we should go for synchronized keyword.

        Q. Synchronization
        If a method is made synchronized then a thread which acquired the object lock can only execute
        the method.

        Every object will have only one lock which ever thread acquired a locked will execute synchronized
        method which the other thread has a wait for the lock to be released.

        Thread will released the lock only after complete execution by doing this we are sure that once a particular thread execute completely only then the next thread
        can start and this will avoid data corruption of common data.



         */
    }
}
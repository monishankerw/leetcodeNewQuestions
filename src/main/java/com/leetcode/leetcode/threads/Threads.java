package com.leetcode.leetcode.threads;

public class Threads {
    public static class ThreadClass extends Thread{
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
    public static class A extends Thread {
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

    public static class ThreadExp extends Thread{
        @Override
        public void run() {
            System.out.println("Hello!!!!...");
        }

        public static void main(String[] args) {
            ThreadExp threadExp=new ThreadExp();
            threadExp.start();
            threadExp.stop();
            threadExp.start();
        }//Exception in thread "main" java.lang.IllegalThreadStateException
        // at java.base/java.lang.Thread.start
        //Thread cannot be started twice
    }
    public static class RunnableClass implements Runnable{

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

    public static class DaemonThreadExample {
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
    public static class DeadlockExample {
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread1: Holding lock1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread1: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread1: Holding lock1 & lock2...");
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                synchronized (lock2) {
                    System.out.println("Thread2: Holding lock2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread2: Waiting for lock1...");
                    synchronized (lock1) {
                        System.out.println("Thread2: Holding lock2 & lock1...");
                    }
                }
            });

            thread1.start();
            thread2.start();
        }
    }

    //Thread Synchronization
// When two thread are operation on a common data non-synchronous manner, data will get corrupted.
    public static class Synchronization {
        public static class A {
            private int balance;

            public static void main(String[] args) {
              Synchronization.A a = new Synchronization.A();
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
                Synchronization.SynchronizationDemo.SharedResource resource = new SynchronizationDemo.SharedResource();

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

    /*
Q.which thread executed first is depended on priority
1. Normal Priority(represent value 5) default priority
2. Max Priority(represent value 10)
3. Min Priority (represent value 1)

Q. How to get and set priority of a thread?
by using setPriority() we can set priority of a thread
by using getPriority() we can get priority of a thread

 */

    public static class ThreadsPriority extends Thread{
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

    public static class StarvationExample {
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

}

package com.leetcode.leetcode.threads;

public class ThreadExp extends Thread{
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
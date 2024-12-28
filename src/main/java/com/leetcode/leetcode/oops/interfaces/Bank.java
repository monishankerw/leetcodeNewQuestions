package com.leetcode.leetcode.oops.interfaces;

public interface Bank {
    public void balance();
    public void transfer();
    public static class HDFCBank implements Bank{

        @Override
        public void balance() {
            System.out.println("1");
        }

        @Override
        public void transfer() {
            System.out.println("2");
        }
    }
    public static class ICICBank implements Bank{

        @Override
        public void balance() {
            System.out.println("3");
        }

        @Override
        public void transfer() {
            System.out.println("4");
        }
    }
    public static class User{
        public static void main(String[] args) {
            HDFCBank bank=new HDFCBank();
            bank.balance();
            bank.transfer();
            ICICBank bank1=new ICICBank();
            bank1.balance();
            bank1.transfer();
        }
    }
}

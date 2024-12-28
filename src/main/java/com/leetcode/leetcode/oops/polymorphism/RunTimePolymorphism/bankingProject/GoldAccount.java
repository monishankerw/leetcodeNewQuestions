package com.leetcode.leetcode.oops.polymorphism.RunTimePolymorphism.bankingProject;

public class GoldAccount {
    public void onlineBanking(){
        System.out.println("Yes");
    }
    public void chqBooks(){
        System.out.println("2/years");
    }
    public void rateOfInterest(){
        System.out.println("Nill");
    }


public static class PlatinumAccount extends GoldAccount {


    @Override
    public void chqBooks() {
        System.out.println("Ulimited");    }

    @Override
    public void rateOfInterest() {
        System.out.println("6% PA");
    }

    public static void main(String[] args) {
        GoldAccount goldAccount=new GoldAccount();
        goldAccount.onlineBanking();
        goldAccount.rateOfInterest();
        goldAccount.chqBooks();
    }
}

}

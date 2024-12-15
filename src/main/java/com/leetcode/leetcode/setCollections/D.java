package com.leetcode.leetcode.setCollections;

import java.util.HashSet;
import java.util.Set;

public class D {
    public static void main(String[] args) {
        Set<String>set=new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        set.add("C");
        System.out.println("Not allow duplicate Elements:"+set);
    }
}
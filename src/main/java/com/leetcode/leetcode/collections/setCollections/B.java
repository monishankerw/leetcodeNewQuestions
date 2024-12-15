package com.leetcode.leetcode.collections.setCollections;

import java.util.HashSet;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Set<Integer>set=new HashSet<>();
        set.add(12);
        set.add(null);
    set.add(23);
    set.add(43);
    set.add(54);
        set.add(null);
        System.out.println("HashSet used only one null value: "+set);
    }
}
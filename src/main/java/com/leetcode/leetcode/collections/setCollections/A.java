package com.leetcode.leetcode.collections.setCollections;

import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Set<Integer>set=new HashSet<>();
        set.add(23);
        set.add(12);
        set.add(34);
        set.add(54);
        System.out.println("HashSet not maintain insertion order:"+set);
    }
}
 
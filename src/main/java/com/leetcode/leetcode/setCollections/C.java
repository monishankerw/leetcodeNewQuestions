package com.leetcode.leetcode.setCollections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Set<String> a=new HashSet<>();
        a.add("India");
        a.add("Australia");
        a.add("South Africa");
        System.out.println(a);
        a.remove("Australia");
        System.out.println(a);
        System.out.println("Iterating over set:");
        Iterator<String> i=a.iterator();
        while (i.hasNext())
            System.out.println(i.hasNext());
    }
}
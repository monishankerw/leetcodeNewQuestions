package com.leetcode.leetcode.collections.setCollections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Iterations {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>(Arrays.asList("abc","for","ewq","eeqq"));
        System.out.println(set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.hasNext());
        }
    }
}

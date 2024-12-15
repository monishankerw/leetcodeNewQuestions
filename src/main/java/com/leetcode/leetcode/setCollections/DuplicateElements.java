package com.leetcode.leetcode.setCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {
    public static void main(String args[]) {
        List<Integer>a=new ArrayList<>(Arrays.asList(1,2,3,1,2,4,3,5,6,4,5,4,5));
        System.out.println("Duplicate Elements:"+a);
        Set<Integer>set=new LinkedHashSet<>();
        set.addAll(a);
        a.clear();
        a.addAll(set);
        System.out.println("WithoutDuplicate Elements:"+a);

    }

 /*
 // 7. Remove Duplicate
List<Integer> removeDuplicate = a.stream().distinct().collect(Collectors.toList());
        System.out.println("Remove Duplicate::"+removeDuplicate);

  */


}


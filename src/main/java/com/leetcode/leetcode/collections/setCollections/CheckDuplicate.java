package com.leetcode.leetcode.collections.setCollections;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicate {
    public static void main(String[] args) {
        CheckDuplicate checkDuplicate=new CheckDuplicate();
        int num[]={1,2,3,4,1};
        Boolean r =checkDuplicate.duplicateCheck(num);
        System.out.println(r);
    }

    public Boolean duplicateCheck(int[] num) {
        Set<Integer> set=new HashSet<>();
        for (Integer nums:num) {
            if (set.contains(nums)) {
                return true;
            }
            set.add(nums);
        }
        return false;
    }
}
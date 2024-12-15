package com.leetcode.leetcode.listQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 4, 3, 5, 6));
        List<Integer> list1 = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(list1);
    }
    }


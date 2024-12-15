package com.leetcode.leetcode.collections.setCollections.treeset;

import java.util.*;

public class A {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(20);
        treeSet.add(12);
        treeSet.add(43);
        System.out.println(treeSet);

        //java8
        TreeSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 4, 2, 4, 5, 3, 6));
        treeSet.stream().forEach(num-> System.out.println(integers));

        //iterator using for loop
        TreeSet<Object> set = new TreeSet<>();
        for (int i=0;i<10;i++){
            set.add(i);
            System.out.println("Set::"+set);

            //iterator using for each
            TreeSet<Integer> num1 = new TreeSet<>();
            treeSet.add(30);
            treeSet.add(20);
            treeSet.add(12);
            treeSet.add(43);
for (Integer num:treeSet){
    num1.add(num);
    System.out.println(num1);

    //using iterator
    TreeSet<Integer> num2 = new TreeSet<>();
    treeSet.add(30);
    treeSet.add(20);
    treeSet.add(12);
    treeSet.add(43);
    Iterator<Integer> iterator = num2.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }

    TreeSet<Integer> treeSet3 = new TreeSet<>();
    treeSet.add(10);
    treeSet.add(20);
    treeSet.add(30);

    List<Integer> list = new ArrayList<>(treeSet);
    ListIterator<Integer> listIterator = list.listIterator();
    while (listIterator.hasNext()) {
        System.out.println(listIterator.next());
    }

}
        }
    }
}
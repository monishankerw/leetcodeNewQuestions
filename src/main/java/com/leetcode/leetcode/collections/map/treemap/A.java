package com.leetcode.leetcode.collections.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class A {
    public static void main(String[] args) {

        Map<Integer, String> map = new TreeMap<>();
        //TreeMap is key-value pair
        map.put(2,"re");
        map.put(1,"req");
        map.put(3,"aq");
        //not thread safe and not synchronized
        //sorting data in accending order
        System.out.println(map);
        try{
            map.put(null,"fr");
        }catch (NullPointerException e){
            System.out.println(e+"if add null in treemap ");
        }
        map.put(4,null);
        map.put(5,null);
        //treemap allow multiple null values
        System.out.println(map);

        for (Map.Entry<Integer,String >entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+"Value:"+entry.getValue());
        }
    }
}

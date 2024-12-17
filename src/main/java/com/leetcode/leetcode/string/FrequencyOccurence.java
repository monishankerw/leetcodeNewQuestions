package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOccurence {
    public static void main(String[] args) {
        String str = "abcaabvcd";
        //25. Count occurrences of each character using java 8
        Map<String, Long> countOccurence = Arrays.stream(str.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Count occurrences of each character:::"+countOccurence);
        frequencyOccurence(str);
    }

    private static void frequencyOccurence(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                System.out.println(map);
            }else
                map.put(c,1);
        }
        System.out.println("Frequency occurence::"+map);
    }

}

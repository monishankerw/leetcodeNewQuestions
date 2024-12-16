package com.leetcode.leetcode.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//  9. package com.primenuber;
                            public  class PrimeNumber {
                                public static void main(String strs[]) {
                                    List<Integer> number= Arrays.asList(1,2,3,4,5,6,7,8);
                                    System.out.println("Enter The Number is:"+number);
                                    List<Integer>num=number.stream().filter(PrimeNumber::isprime).collect(Collectors.toList());
                                    System.out.println("Enter The Even number Number is:"+num);
                                }
                                public static boolean isprime(int num){
                                    int number = 0;
                                    for(int i = 2; i<number/2; i++){
                                        if(number%2==0){
                                            return false;
                                        }
                                    }
                                    return true;
                                }
                            }


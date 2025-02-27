package com.leetcode.leetcode.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStreamApi{
	public static class SumOfInteger {
		public static void main(String[] args) {
			List<Integer>num=Arrays.asList(1,4,3,2,5,6,7,8,9);
			Integer sum=num.stream().reduce(0,Integer::sum);
			System.out.println(sum);
		}

	}
	public static class LongestSubString {
		public static void main(String[] args) {
			List<String>words=Arrays.asList("test","rewq","esfrww","utreee");
			
			Optional<String>log=words.stream().reduce((x,y)->x.length()>y.length()?x:y);
		System.out.println(log);
		}

	}
	//3.sum of even number
	// reduce():Terminal Operation
	// 3.REDUCE()->THE REDUCE METHOD IS USED TO REDUCE THE ELEMENTS OF A STREAM TO A SINGLE VALUE.
	//Used to perform a reduction on the elements of a stream using an associative accumulation function and returning an optional with the reduced value.

	/*
	Method	Explanation
	list.stream()	Creates a stream from the list.
	.filter(x -> x % 2 == 0)	Filters even numbers (x % 2 == 0).
	.reduce(0, (a, b) -> a + b)	Reduces the stream to a single value (sum of elements).
	*/
	public static class FindSquareOfEvenNumber {
		public static void main(String[] args) {
			List<Integer>num=Arrays.asList(1,2,3,4,5,6,7);
		Integer sum=num.stream().filter(x->x%2==0).map(x->x*x).reduce(0,Integer::sum);
			System.out.println("Sqare of even number: "+sum);
			Integer sum1=num.stream().filter(x->x%2==0).reduce(0,(a,b)->a+b);
			System.out.println("Sum of even number: "+sum1);
		}

	}
}

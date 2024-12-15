package com.leetcode.leetcode.setCollections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnionIntersection {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 5, 4, 6));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 7, 8, 9, 4));
        System.out.println("Elements Of Set A::" + a);
        System.out.println("Elements of Set B::" + b);

        //union
        Set<Integer> unions = new HashSet<>(a);
        unions.addAll(b);
        System.out.println("Unions::" + unions);

        // Union using Stream API
        //	1.	Stream API (Stream.concat):
        //	•	Stream.concat(a.stream(), b.stream()) merges the streams from sets a and b.
        //	2.	Collectors.toSet():
        //	•	Collects the merged elements into a new Set, automatically removing duplicates.
        Set<Integer> a1 = new HashSet<>(Arrays.asList(1, 2, 5, 4, 6));
        Set<Integer> b1 = new HashSet<>(Arrays.asList(3, 7, 8, 9, 4));

        Set<Integer> unionss = Stream.concat(a1.stream(), b1.stream())
                .collect(Collectors.toSet());
        System.out.println("Union using Stream API::"+unionss);

        /*
        // Union using flatMap
        Set<Integer> unions = Stream.of(a, b) // Stream of sets
                                    .flatMap(Set::stream) // Flatten into one stream of elements
                                    .collect(Collectors.toSet()); // Collect into a set

        System.out.println("Union:: " + unions);
         */


        //intersection
        Set<Integer>intersections=new HashSet<>(a);
        intersections.retainAll(b);
        System.out.println("Intersections:"+intersections);

        // Intersection using Java 8 Streams
        /*
        	1.	Stream from Set A:
	•	a.stream() creates a stream from set a.
	2.	filter(b::contains):
	•	Filters elements of a that are present in set b.
	3.	Collectors.toSet():
	•	Collects the filtered elements into a new Set.
         */
        Set<Integer> intersectionss = a.stream()
                .filter(b::contains) // Keep elements that are in both sets
                .collect(Collectors.toSet());

        System.out.println("Intersections:: " + intersectionss);

        //SYMMETRIC DIFFERENCE
        Set<Integer>symmetricDifference=new HashSet<>(unions);
        symmetricDifference.removeAll(intersections);
        System.out.println("symmetricDifference:"+symmetricDifference);

    }
}

package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionUnionSubset {
    public static class Intersection {
        public static void main(String[] args) {
            int arr1[] = {1, 2, 3, 4};
            int arr2[] = {1, 2};
            intersection(arr1, arr2);
        }

        private static void intersection(int[] arr1, int[] arr2) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int i = 0; i < arr1.length; i++) {
                s.add(arr1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                if (s.contains(arr2[i])) {
                    System.out.println(arr2[i]);
                }
            }
        }
    }

    public static class SubSet {
        public static void main(String[] args) {
            int arr1[] = {1, 2, 3, 4, 5}; // Main array
            int arr2[] = {3, 4, 12};      // Array to check as subset
            int m = arr1.length;
            int n = arr2.length;

            if (isSubset(arr1, arr2, m, n)) {
                System.out.println("arr2[] is a subset of arr1[]");
            } else {
                System.out.println("arr2[] is not a subset of arr1[]");
            }
        }

        private static boolean isSubset(int[] arr1, int[] arr2, int m, int n) {
            for (int i = 0; i < n; i++) {
                boolean found = false; // Flag to check if arr2[i] exists in arr1
                for (int j = 0; j < m; j++) {
                    if (arr2[i] == arr1[j]) {
                        found = true;
                        break; // Exit the inner loop if a match is found
                    }
                }
                if (!found) {
                    return false; // If arr2[i] is not found in arr1, return false
                }
            }
            return true; // All elements of arr2[] are found in arr1[]
        }
    }

    public static class Intersections {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {1, 2};

        /*
        usind java 8 stream api
         */
            System.out.println("Intersection with java 8 stream api::");
            Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
            Arrays.stream(arr2).filter(set::contains).distinct().forEach(System.out::println);
            intersections(arr1, arr2);
        }

        private static void intersections(int[] arr1, int[] arr2) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                set.add(arr1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                if (set.contains(arr2[i])) {
                    System.out.println(arr2[i]);
                }
            }
        }
    }


   public static class IntersectionI {
        public int[] intersect(int[] nums1, int[] nums2) {
            // Create a map to store the frequency of elements in nums1
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // List to store the intersection elements
            List<Integer> result = new ArrayList<>();
            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    result.add(num);
                    map.put(num, map.get(num) - 1); // Decrease the frequency
                }
            }

            // Convert the result list to an array
            return result.stream().mapToInt(i -> i).toArray();
        }
    }

    public class Main {
        public static void main(String[] args) {
            IntersectionI solution = new IntersectionI();

            // Example 1
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] result1 = solution.intersect(nums1, nums2);
            System.out.println("Intersection of [1, 2, 2, 1] and [2, 2]: " + Arrays.toString(result1));

            // Example 2
            int[] nums3 = {4, 9, 5};
            int[] nums4 = {9, 4, 9, 8, 4};
            int[] result2 = solution.intersect(nums3, nums4);
            System.out.println("Intersection of [4, 9, 5] and [9, 4, 9, 8, 4]: " + Arrays.toString(result2));
        }
    }
    public static class SubSets {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {3, 4};

            // Find matching subset values
            List<Integer> subsetValues = new ArrayList<>();
            boolean isSubset = isSubset(arr1, arr2, subsetValues);

            if (isSubset) {
                System.out.println("arr2[] is a subset of arr1[]");
            } else {
                System.out.println("arr2[] is not a subset of arr1[]");
            }
            System.out.println("Matching subset values: " + subsetValues);
        }

        private static boolean isSubset(int[] arr1, int[] arr2, List<Integer> subsetValues) {
            // Add all elements of arr1 to a Set for fast lookup
            Set<Integer> set1 = new HashSet<>();
            for (int num : arr1) {
                set1.add(num);
            }

            // Check elements of arr2 in the Set
            for (int num : arr2) {
                if (set1.contains(num)) {
                    subsetValues.add(num);
                } else {
                    return false; // If any element is missing, arr2 is not a subset
                }
            }
            return true;
        }
    /*
     Set<Integer> set1 = Arrays.stream(x).boxed().collect(Collectors.toSet());
     List<Integer> subset = Arrays.stream(y)
     .boxed().filter(set1::contains).collect(Collectors.toList());
     boolean isSubset=subset.size()==y.length;
     System.out.println(subset);
     */
    }
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

}

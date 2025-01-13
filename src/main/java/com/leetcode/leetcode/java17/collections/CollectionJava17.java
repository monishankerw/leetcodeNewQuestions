package com.leetcode.leetcode.java17.collections;

public class CollectionJava17 {
    /*
    Here is a comparison between Java 17 and previous versions (e.g., Java 8 and Java 9 onwards)
    based on features related to the Collections Framework.
    The differences mainly lie in the enhancements made to collections,
    such as immutable collections and stream optimizations.

1. Immutable Collections

Java 8 (and earlier):
In Java 8, to create immutable collections,
you need to use Collections.unmodifiableList, Collections.unmodifiableSet, or Collections.unmodifiableMap.

Example in Java 8:

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ImmutableCollectionsJava8 {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Orange"); // Java 9 and later
        Set<String> set = Set.of("Apple", "Banana", "Orange"); // Java 9 and later

        // Java 8 approach for immutable collections
        List<String> immutableList = Collections.unmodifiableList(list);
        Set<String> immutableSet = Collections.unmodifiableSet(set);

        // Print immutable collections
        System.out.println(immutableList);
        System.out.println(immutableSet);
    }
}

In Java 8, the creation of immutable collections was verbose
and relied on Collections.unmodifiableList, Set, and Map.

Java 17:
Java 17 improves this with the List.of(), Set.of(), and Map.of() methods,
 making it easy to create immutable collections.

Example in Java 17:

import java.util.List;
import java.util.Set;
import java.util.Map;

public class ImmutableCollectionsJava17 {
    public static void main(String[] args) {
        // Java 17 approach for immutable collections
        List<String> list = List.of("Apple", "Banana", "Orange");
        Set<String> set = Set.of("Apple", "Banana", "Orange");
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");

        // Print immutable collections
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}

In Java 17, you can easily create immutable collections without
 needing to wrap them in Collections.unmodifiable*.

2. Stream API Enhancements

Java 8:
The Stream API was introduced in Java 8 to provide a
declarative approach to processing collections.
 It allows you to apply operations such as filtering, mapping, and reducing.

Example in Java 8:

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleJava8 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        List<String> result = items.stream()
                                  .filter(item -> item.startsWith("b"))
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toList());

        System.out.println(result);  // Output: [BANANA]
    }
}

Java 17:
In Java 17, the Stream API is still available
and enhanced with additional performance optimizations.
There are no major changes to the API, but improvements are made under the hood.
 Streams remain efficient, especially in working with large datasets.

Example in Java 17:

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleJava17 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        List<String> result = items.stream()
                                  .filter(item -> item.startsWith("b"))
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toList());

        System.out.println(result);  // Output: [BANANA]
    }
}

The Stream API is backward-compatible and fully supported in Java 17 with
potential improvements in performance, especially for large datasets or parallel processing.

3. Performance Optimizations

Java 8 and Previous Versions:
In Java 8 and earlier, the focus was on providing a functional approach to collections
and introducing features like lambda expressions and the Stream API.
 Performance improvements were mostly done on a case-by-case basis for specific collections.

Java 17:
Java 17 has continued the focus on performance, particularly for the HashMap and HashSet implementations. For example, improvements in garbage collection algorithms (like G1) and better memory management have made collection operations faster in some use cases.

Example of Performance (not direct change in code but under the hood):

import java.util.HashMap;

public class PerformanceExampleJava17 {
    public static void main(String[] args) {
        // The following code will perform faster in Java 17 due to underlying optimizations
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 1_000_000; i++) {
            map.put("key" + i, "value" + i);
        }

        // Accessing the map
        System.out.println(map.get("key50000"));
    }
}

In Java 17, thanks to optimizations, operations like inserting and retrieving items in HashMap may be faster compared to earlier versions.

4. Other New Features in Java 17

Java 17 includes other minor improvements such as:
	•	List.copyOf(), Set.copyOf(), and Map.copyOf() to create unmodifiable copies of existing collections.
	•	New garbage collector improvements and more efficient memory management for large collections.
	•	Stream API optimizations for parallel processing, reducing overhead in some cases.

Summary of Key Differences:

Feature	Java 8 (and earlier)	Java 17
Immutable Collections	Created using Collections.unmodifiable*	List.of(), Set.of(), Map.of()
Stream API	Introduced in Java 8	Optimized in Java 17 (still the same API)
Performance	Some improvements in performance	Significant performance optimizations in collections
Garbage Collection	Older GC algorithms	Improved G1 and other GC algorithms

Java 17 continues to enhance and build on the features introduced in earlier versions like Java 8 and Java 9. It focuses on performance optimizations, simplicity, and new methods for immutable collections, stream operations, and garbage collection.
     */
}

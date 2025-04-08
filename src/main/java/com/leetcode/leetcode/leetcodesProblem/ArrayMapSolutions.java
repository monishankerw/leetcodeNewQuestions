package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.stream.*;

public class ArrayMapSolutions {

    // 🔹 Using Map / HashMap

    // 1. Count frequency (non-Java 8)
    public static Map<Integer, Integer> countFrequency(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // 1. Java 8
    public static Map<Integer, Long> countFrequencyJava8(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    }


    // 2. First non-repeating element
    public static Integer firstNonRepeating(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : array)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (int num : array)
            if (freq.get(num) == 1)
                return num;
        return null;
    }

    // 3. Element with max frequency
    public static Integer maxFrequencyElement(int[] array) {
        Map<Integer, Integer> freq = countFrequency(array);
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // 4. Check anagrams
    public static boolean areAnagrams(int[] arr1, int[] arr2) {
        return countFrequency(arr1).equals(countFrequency(arr2));
    }

    // 5. Indices map
    public static Map<Integer, List<Integer>> indicesMap(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.computeIfAbsent(array[i], k -> new ArrayList<>()).add(i);
        }
        return map;
    }

    // 6. Count pairs with sum
    public static int countPairsWithSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            count += map.getOrDefault(target - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    // 7. Elements appearing exactly k times
    public static List<Integer> elementsWithKTimes(int[] array, int k) {
        return countFrequency(array).entrySet().stream()
                    .filter(e -> e.getValue() == k)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
    }

    // 8. Zero sum subarray
    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sums.contains(sum)) return true;
            sums.add(sum);
        }
        return false;
    }

    // 9. Group by remainder
    public static Map<Integer, List<Integer>> groupByRemainder(int[] array, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : array) {
            map.computeIfAbsent(num % k, key -> new ArrayList<>()).add(num);
        }
        return map;
    }

    // 10. Count distinct
    public static int countDistinct(int[] array) {
        return (int) Arrays.stream(array).distinct().count();
    }

    // 🔹 Using LinkedHashMap

    // 11. Track insertion order with frequency
    public static LinkedHashMap<Integer, Integer> frequencyLinked(int[] array) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // 12. First unique element (LinkedHashMap)
    public static Integer firstUniqueLinked(int[] array) {
        LinkedHashMap<Integer, Integer> freq = frequencyLinked(array);
        return freq.entrySet().stream()
                   .filter(e -> e.getValue() == 1)
                   .findFirst()
                   .map(Map.Entry::getKey)
                   .orElse(null);
    }

    // 13. Remove duplicates preserving order
    public static List<Integer> removeDuplicates(int[] array) {
        return new ArrayList<>(new LinkedHashSet<>(Arrays.stream(array).boxed().collect(Collectors.toList())));
    }

    // 14. Frequency map preserving order (same as 11)

    // 15. First and last positions
    public static Map<Integer, int[]> firstLastIndices(int[] array) {
        Map<Integer, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (!map.containsKey(num)) map.put(num, new int[]{i, i});
            else map.get(num)[1] = i;
        }
        return map;
    }

    // 🔹 Using TreeMap

    // 16. Sorted frequency map
    public static TreeMap<Integer, Integer> frequencySorted(int[] array) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : array) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }

    // 17. Min/max frequency elements
    public static void printMinMaxFreq(TreeMap<Integer, Integer> map) {
        Map.Entry<Integer, Integer> min = Collections.min(map.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<Integer, Integer> max = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
        System.out.println("Min freq: " + min.getKey() + ", Max freq: " + max.getKey());
    }

    // 18. Closest greater element
    public static Map<Integer, Integer> closestGreater(int[] array) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int num : array) tree.put(num, 1);
        return Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.toMap(n -> n, n -> tree.higherKey(n)));
    }

    // 19. Group into bins
    public static TreeMap<Integer, List<Integer>> groupIntoSortedBins(int[] array, int binSize) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int num : array) {
            int bin = (num / binSize) * binSize;
            map.computeIfAbsent(bin, k -> new ArrayList<>()).add(num);
        }
        return map;
    }

    // 20. Merge sorted arrays
    public static TreeMap<Integer, Integer> mergeSortedArrays(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : arr2) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }

    // 🔹 Mixed Advanced Use

    // 21. Number to square map
    public static LinkedHashMap<Integer, Integer> squareMap(int[] array) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.stream(array).forEach(n -> map.put(n, n * n));
        return map;
    }

    // 22. Element to indices map
    public static Map<Integer, List<Integer>> elementIndicesMap(int[] array) {
        return IntStream.range(0, array.length)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> array[i]));
    }

    // 23. Index-value map
    public static Map<Integer, Integer> indexValueMap(int[] array) {
        return IntStream.range(0, array.length)
                        .boxed()
                        .collect(Collectors.toMap(i -> i, i -> array[i]));
    }

    // 24. Binary representation map
    public static Map<Integer, String> binaryMap(int[] array) {
        return Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.toMap(n -> n, n -> Integer.toBinaryString(n)));
    }

    // 25. Duplicates in sliding window
    public static boolean hasDuplicateInWindow(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) window.remove(nums[i - k - 1]);
            if (!window.add(nums[i])) return true;
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,4};
        System.out.println("Frequency map: " + countFrequency(arr));
        System.out.println("Freq map Java8:"+countFrequencyJava8(arr));

        System.out.println("First unique firstNonRepeating: " + firstNonRepeating(arr));
    }
}
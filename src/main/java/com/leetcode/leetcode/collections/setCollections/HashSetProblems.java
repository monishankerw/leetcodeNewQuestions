package com.leetcode.leetcode.collections.setCollections;

import java.util.*;

public class HashSetProblems {

    // 1. Check if an array contains duplicates
    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // 2. Remove duplicates from an array
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // 3. Find intersection of two arrays
    public static int[] intersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        Set<Integer> result = new HashSet<>();
        for (int num : b) if (set.contains(num)) result.add(num);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // 4. Find union of two arrays
    public static int[] union(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // 5. Find missing number in 1..n
    public static int findMissingNumber(int[] nums, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int i = 1; i <= n; i++)
            if (!set.contains(i)) return i;
        return -1;
    }

    // 6. Check if two elements sum to target
    public static boolean twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }

    // 7. Find first unique character in string
    public static int firstUniqueChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) 
            count.put(c, count.getOrDefault(c, 0) + 1);
        for (int i = 0; i < s.length(); i++) 
            if (count.get(s.charAt(i)) == 1) return i;
        return -1;
    }

    // 8. Check if two arrays are disjoint
    public static boolean areDisjoint(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        for (int num : b) if (set.contains(num)) return false;
        return true;
    }

    // 9. Find symmetric difference of two arrays
    public static int[] symmetricDifference(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int num : a) setA.add(num);
        for (int num : b) setB.add(num);
        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        setA.retainAll(setB);
        result.removeAll(setA);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // 10. Check if all characters in string are unique
    public static boolean allUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    // 11. Find single number (others appear twice)
    public static int findSingleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.iterator().next();
    }

    // 12. Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // 13. Check if string can be palindrome permutation
    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }

    // 14. Find common characters between two strings
    public static List<Character> commonChars(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> common = new HashSet<>();
        for (char c : s1.toCharArray()) set1.add(c);
        for (char c : s2.toCharArray()) 
            if (set1.contains(c)) common.add(c);
        return new ArrayList<>(common);
    }

    // 15. Check if array is subset of another
    public static boolean isSubset(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : b) set.add(num);
        for (int num : a) 
            if (!set.contains(num)) return false;
        return true;
    }

    // 16. Count distinct elements
    public static int countDistinct(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        return set.size();
    }

    // 17. Find smallest missing positive integer
    public static int smallestMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) if (num > 0) set.add(num);
        int missing = 1;
        while (set.contains(missing)) missing++;
        return missing;
    }

    // 18. Find all numbers missing in 1..n array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++)
            if (!set.contains(i)) result.add(i);
        return result;
    }

    // 19. Check for nearby duplicates within k distance
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    // 20. Find duplicate number in array
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("1. Has duplicates: " + hasDuplicates(new int[]{1,2,3,2}));
        System.out.println("2. Remove duplicates: " + Arrays.toString(removeDuplicates(new int[]{1,2,2,3})));
        System.out.println("3. Intersection: " + Arrays.toString(intersection(new int[]{1,2,3}, new int[]{2,3,4})));
        System.out.println("4. Union: " + Arrays.toString(union(new int[]{1,2}, new int[]{3,4})));
        System.out.println("5. Missing number: " + findMissingNumber(new int[]{1,2,4}, 4));
        System.out.println("6. Two sum exists: " + twoSum(new int[]{1,2,3}, 5));
        System.out.println("7. First unique char index: " + firstUniqueChar("leetcode"));
        System.out.println("8. Are disjoint: " + areDisjoint(new int[]{1,2}, new int[]{3,4}));
        System.out.println("9. Symmetric difference: " + Arrays.toString(symmetricDifference(new int[]{1,2,3}, new int[]{2,3,4})));
        System.out.println("10. All unique chars: " + allUnique("abc"));
        System.out.println("11. Single number: " + findSingleNumber(new int[]{4,1,2,1,2}));
        System.out.println("12. Longest substring: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("13. Can permute palindrome: " + canPermutePalindrome("carerac"));
        System.out.println("14. Common chars: " + commonChars("hello", "world"));
        System.out.println("15. Is subset: " + isSubset(new int[]{1,2}, new int[]{1,2,3}));
        System.out.println("16. Distinct count: " + countDistinct(new int[]{1,2,2,3}));
        System.out.println("17. Smallest missing positive: " + smallestMissingPositive(new int[]{3,4,-1,1}));
        System.out.println("18. Disappeared numbers: " + findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("19. Nearby duplicates: " + containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println("20. Find duplicate: " + findDuplicate(new int[]{1,3,4,2,2}));
    }
}
package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateRelatedProblem {
    //1. Remove duplicate and show
    public static class ShowDuplicate {
        public static void main(String[] args) {
            int[] arr = {1, 2, 1, 3, 4, 2, 5, 3, 5};

            System.out.println("Without Java 8 (Traditional Approach):");
            findDuplicatesTraditional(arr);

            System.out.println("\nWith Java 8 (Using Streams):");
            findDuplicatesWithStreams(arr);
        }

        // Method without Java 8 (Traditional Approach)
        private static void findDuplicatesTraditional(int[] arr) {
            Set<Integer> seen = new HashSet<>();
            Set<Integer> duplicates = new HashSet<>();

            for (int num : arr) {
                if (!seen.add(num)) { // If add() returns false, it's a duplicate
                    duplicates.add(num);
                }
            }

            for (int duplicate : duplicates) {
                System.out.println(duplicate);
            }
        }

        // Method with Java 8 (Using Streams)
        private static void findDuplicatesWithStreams(int[] arr) {
            Set<Integer> seen = new HashSet<>();
            Set<Integer> duplicates = Arrays.stream(arr)
                    .filter(n -> !seen.add(n)) // Keep elements that are already in the set
                    .boxed()
                    .collect(Collectors.toSet());

            duplicates.forEach(System.out::println);
        }
    }

    //2. check DuplicateI
    public static class CheckDuplicate {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 2, 1};

            // Without Java 8 (Traditional Approach)
            boolean checkDuplicateTraditional = checkDuplicateTraditional(arr);
            System.out.println("Check Duplicate (Traditional): " + checkDuplicateTraditional);

            // With Java 8 (Using Streams)
            boolean checkDuplicateWithStreams = checkDuplicateWithStreams(arr);
            System.out.println("Check Duplicate (Java 8 Streams): " + checkDuplicateWithStreams);
        }

        // Method without Java 8 (Traditional Approach)
        private static boolean checkDuplicateTraditional(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                if (!set.add(num)) { // If add() returns false, it's a duplicate
                    return true;
                }
            }
            return false;
        }

        // Method with Java 8 (Using Streams)
        private static boolean checkDuplicateWithStreams(int[] arr) {
            Set<Integer> set = new HashSet<>();
            return Arrays.stream(arr).anyMatch(n -> !set.add(n)); // Returns true if any duplicate is found
        }
    }
//3. contain DuplicateII
      public static class ContainDuplicate {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 1};
            int k = 3; // Corrected variable declaration
            boolean output = containDuplicateII(nums, k);
            System.out.println("Output::" + output);
        }

        private static boolean containDuplicateII(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int prevIndex = map.get(nums[i]);
                    if (i - prevIndex <= k) {
                        return true; // Found duplicate within range
                    }
                }
                map.put(nums[i], i); // Update the index of the current number
            }
            return false; // No duplicates within range
        }
    }

    //4. contain DuplicateIII
    public static class ContainDuplicateIII {
        public static void main(String[] args) {
            // Test Case 1
            int[] nums1 = {1, 2, 3, 1};
            int indexDiff1 = 3, valueDiff1 = 0;
            System.out.println("Output (Test Case 1): " + containsNearbyAlmostDuplicate(nums1, indexDiff1, valueDiff1));

            // Test Case 2
            int[] nums2 = {1, 5, 9, 1, 5, 9};
            int indexDiff2 = 2, valueDiff2 = 3;
            System.out.println("Output (Test Case 2): " + containsNearbyAlmostDuplicate(nums2, indexDiff2, valueDiff2));
        }

        public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Long> set = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                // Find the smallest number >= nums[i] - valueDiff
                Long ceiling = set.ceiling((long) nums[i] - valueDiff);
                if (ceiling != null && ceiling <= (long) nums[i] + valueDiff) {
                    return true; // Found a valid pair
                }

                // Add the current number to the set
                set.add((long) nums[i]);

                // Maintain the window size
                if (i >= indexDiff) {
                    set.remove((long) nums[i - indexDiff]);
                }
            }

            return false; // No valid pair found
        }
    }

    //5. Remove Duplicate From List
    public static class RemoveDuplicateFromList {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5);
            List<Integer> list1 = list.stream().distinct().collect(Collectors.toList());
            System.out.println(" Remove Duplicate From List::" + list1);
        }
    }

    public static class RemoveDuplicate {
        public static void main(String args[]) {
            List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4, 3, 5, 6, 4, 5, 4, 5));
            System.out.println("Duplicate Elements:" + a);
            Set<Integer> set = new LinkedHashSet<>();
            set.addAll(a);
            a.clear();
            a.addAll(set);
            System.out.println("WithoutDuplicate Elements:" + a);

        }
    }

    //6. Remove duplicate from shorted arrays I
    public static class RemoveDuplicateFromShortedArrays {
        public static void main(String[] args) {
            int arr[] = {1, 1, 2};
            int output = removeDuplicateFromShortedArrays(arr);
            System.out.println("RemoveDuplicateFromShortedArrays:::" + output);
        }

        private static int removeDuplicateFromShortedArrays(int[] arr) {
            if (arr.length == 0)
                return 0;
            int j = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[j - 1]) {
                    arr[j] = arr[i];
                    j++;
                }
            }
            return j;
        }

    }

    //7. Remove duplicate from shorted arrays I

    public static class RemoveDuplicateFromShortedArraysII {
        public static int removeDuplicates(int[] nums) {
            int j = 0; // Pointer for the next position to write a valid number

            for (int i = 0; i < nums.length; i++) {
                // Check if the current element is valid to be written
                if (j < 2 || nums[i] != nums[j - 2]) {
                    nums[j] = nums[i];
                    j++;
                }
            }

            return j; // Return the length of the modified array
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 1, 1, 2, 2, 3};
            int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};

            // Test case 1
            int k1 = removeDuplicates(nums1);
            System.out.println("Output length: " + k1);
            System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));

            // Test case 2
            int k2 = removeDuplicates(nums2);
            System.out.println("Output length: " + k2);
            System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));
        }
    }
    //8. Remove elements
    public static class RemoveElements {
        public static void main(String[] args) {
            int[] nums = {3, 2, 2, 3};
            int val = 3;
            int output = removeElements(nums, val);
            System.out.println("Output:" + output);
        }

        private static int removeElements(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;
        }

    }
    // Remove Duplicates from Sorted Array
    public static class RemoveDuplicates{
        public static void main(String[] args) {
            int nums[] = {1, 1, 2};
            int output = removeDuplicates(nums);
            System.out.println("Output: " + output);

            // To print the unique elements
            for (int i = 0; i < output; i++) {
                System.out.print(nums[i] + " ");
            }
        }

        private static int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0; // Handle empty array
            }

            int j = 1; // Pointer for the next unique position
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[j - 1]) { // Compare with the previous unique element
                    nums[j] = nums[i];
                    j++;
                }
            }
            return j; // `j` represents the count of unique elements
        }
    }


    //Remove Duplicates from Sorted Array II

    public static class RemoveDuplicatesSolution {
        public static void main(String[] args) {
            Solution solution = new Solution();

            // Example 1
            int[] nums1 = {1, 1, 1, 2, 2, 3};
            int length1 = solution.removeDuplicates(nums1);
            System.out.println("Output length: " + length1);
            System.out.print("Modified array: ");
            for (int i = 0; i < length1; i++) {
                System.out.print(nums1[i] + " ");
            }
            System.out.println();

            // Example 2
            int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
            int length2 = solution.removeDuplicates(nums2);
            System.out.println("Output length: " + length2);
            System.out.print("Modified array: ");
            for (int i = 0; i < length2; i++) {
                System.out.print(nums2[i] + " ");
            }
            System.out.println();
        }
    }

   public static class Solution {
        public int removeDuplicates(int[] nums) {
            int j = 0; // Pointer for the next position to write a valid number

            for (int i = 0; i < nums.length; i++) {
                // Check if the current element is valid to be written
                if (j < 2 || nums[i] != nums[j - 2]) {
                    nums[j] = nums[i];
                    j++;
                }
            }

            return j; // Return the length of the modified array
        }
    }

    //9 Move Zero


    public static class MoveZero {
        public static void main(String[] args) {
            int[] nums = {0, 1, 0, 3, 12};
            moveZeroes(nums);
            System.out.println("Array after moving zeroes: " + Arrays.toString(nums));
        }

        private static void moveZeroes(int[] nums) {
            int j = 0; // Index for placing non-zero elements

            // Step 1: Move all non-zero elements to the front
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swap(nums, i, j);
                    j++;
                }
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    //10. duplicateZeros
    public static class DuplicateZeros {
        public void duplicateZeros(int[] arr) {
            int zeros = 0;
            int n = arr.length;

            // Step 1: Count the zeros in the array
            for (int num : arr) {
                if (num == 0) {
                    zeros++;
                }
            }

            // Step 2: Work backwards
            int i = n - 1;          // Original end of the array
            int j = n + zeros - 1;  // Logical end of the array after accounting for duplicated zeros

            // Traverse the array backwards
            while (i < j) {
                if (j < n) {
                    arr[j] = arr[i];
                }
                if (arr[i] == 0) {
                    j--; // Handle duplication of zero
                    if (j < n) {
                        arr[j] = 0;
                    }
                }
                i--;
                j--;
            }
        }

        public static void main(String[] args) {
            DuplicateZeros solution = new DuplicateZeros();

            int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
            solution.duplicateZeros(arr1);
            System.out.println("Output: " + java.util.Arrays.toString(arr1)); // [1, 0, 0, 2, 3, 0, 0, 4]

            int[] arr2 = {1, 2, 3};
            solution.duplicateZeros(arr2);
            System.out.println("Output: " + java.util.Arrays.toString(arr2)); // [1, 2, 3]
        }
    }
    //11.
    public static class DuplicateElements {
        public static void main(String[] args) {
            String str = "javadeveloper";

            System.out.println("Duplicate elements in the string:");

            printDuplicateCharacters(str);
        }

        private static void printDuplicateCharacters(String str) {
            HashSet<Character> set = new HashSet<>();
            HashSet<Character> duplicates = new HashSet<>();

            for (char ch : str.toCharArray()) {
                if (!set.add(ch)) { // If adding fails, it's a duplicate
                    duplicates.add(ch);
                }
            }

            // Print all unique duplicate characters
            duplicates.forEach(System.out::print);
        }
    /*
    java8
    private static void findDuplicateCharactersUsingStreams(String str) {
        str.chars()  // Convert string to IntStream
            .mapToObj(c -> (char) c)  // Convert int to Character
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))  // Group and count
            .entrySet().stream()  // Stream the map entries
            .filter(entry -> entry.getValue() > 1)  // Filter only duplicates
            .forEach(entry -> System.out.print(entry.getKey() + " "));  // Print the duplicates
    }
     */
    }
    //12
    public static class DuplicateWord {
        public static void main(String[] args) {
            String str = "This is new word is This new word";

            // Remove punctuation (except spaces) and convert to lower case
            String input = str.replaceAll("[^a-zA-Z ]", "").toLowerCase();

            // Split the string into words
            String[] words = input.split("\\s+");

            // Use a HashMap to count the occurrences of each word
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // Print the duplicate words
            System.out.println("Duplicate Words::::");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }
    public static class RemoveDuplicateElements {
        public static void main(String[] args) {
            List<String>x=new ArrayList<>();
            x.add("a");
            x.add("b");
            x.add("c");
            x.add("a");
            x.add("b");
            x.add("a");
            System.out.println("All Elements:"+x);
            List<String> x1= x.stream().distinct().collect(Collectors.toList());
            System.out.println("Remove Duplicate:"+x1);
        }
    }
    public static class FindDuplicateElement {
        public static void main(String[] args) {
            String str = "JavaDeveloper";
            int r = 0;
            char[] x = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (x[i] == x[j]) {
                        System.out.print(x[j]);
                        r++;
                        break;
                    }
                }
            }
        }
    }

    public static class RemoveDuplicateCharacter {
        public static void main(String[] args) {
            String st="hello";
            String result=removeCharacter(st);
            System.out.println("Remove Duplicate Character:"+result);
        }

        private static String removeCharacter(String st) {
            Set<Character>set=new LinkedHashSet<>();
            for (char ch:st.toCharArray()){
                set.add(ch);
                System.out.println(set);

            }
            StringBuilder sb=new StringBuilder();
            for(char ch:set){
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    public static class RemoveDuplicateString {
        public static void main(String[] args) {
            String str = "programmming";
            String res = str.chars().mapToObj(c -> (char) c)
                    .distinct()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            System.out.println(res);
        }
    }

//    public static class RemoveString {
//        public static void main(String[] args) {
//            String str = "aabbccdef";
//            System.out.println("String without duplicates: " + removeDuplicates(str));
//        }
//
//        private static String removeDuplicates(String str) {
//            StringBuilder result = new StringBuilder();
//            for (char ch : str.toCharArray()) {
//                if (result.indexOf(String.valueOf(ch)) == -1) {
//                    result.append(ch);
//                }
//            }
//            return result.toString();
//        }
//    }
    public static class RemoveDuplicatess {
        public static void main(String[] args) {
            // Input array with duplicates
            String[] strArray = {"abc", "def", "abc", "mno", "xyz", "pqr", "xyz", "pqr"};

            System.out.println("Brute Force Method: Duplicate Elements are:");
            for (int i = 0; i < strArray.length - 1; i++) {
                for (int j = i + 1; j < strArray.length; j++) {
                    if (strArray[i].equals(strArray[j]) && i != j) {
                        System.out.println(strArray[i]);
                    }
                }
            }
        }
    }
    public static class DuplicateCharacters {
        public static void main(String[] args) {
            // Input string
            String str = "apple is fruit";

            // Print the original string
            System.out.println("The string is: " + str);

            // Call methods
            findDuplicateWithoutJava8(str);
            findDuplicateWithJava8(str);
        }

        // Without Java 8 (Traditional Approach)
        private static void findDuplicateWithoutJava8(String str) {
            System.out.print("Without Java 8: Duplicate Characters are: ");

            // Using HashSet to find duplicate characters
            Set<Character> seen = new HashSet<>();
            Set<Character> duplicates = new HashSet<>();

            for (char c : str.toCharArray()) {
                if (c != ' ') { // Exclude spaces
                    if (!seen.add(c)) { // If already present in `seen`, it's a duplicate
                        duplicates.add(c);
                    }
                }
            }

            // Print duplicate characters
            for (char c : duplicates) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        // With Java 8 (Stream API)
        private static void findDuplicateWithJava8(String str) {
            System.out.print("With Java 8: Duplicate Characters are: ");

            // Java 8 Stream approach
            Set<Character> seen = new HashSet<>();
            Set<Character> duplicates = str.chars()
                    .mapToObj(c -> (char) c) // Convert int to Character
                    .filter(c -> c != ' ' && !seen.add(c)) // Exclude spaces and track duplicates
                    .collect(Collectors.toSet());

            // Print duplicate characters
            duplicates.forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }


}
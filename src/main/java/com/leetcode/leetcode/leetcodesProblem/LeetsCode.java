
package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;

public class LeetsCode {
//1: swapping,move zero elements end

    public static class Swapping{
        public static void main(String[] args) {
            int a=10,b=20;
            System.out.println("Before Swapping:"+a+":"+b);
//         int temp=a;
//         a=b;
//         b=temp;
            a=a+b;
            b=a-b;
            a=a-b;
            System.out.println(a+"After Swapping:"+a+":"+b);
        }
    }
    //2.Move Zero
    public static class MoveZero {
        public static void main(String[] args) {
            MoveZero moveZero = new MoveZero();
            int nums[] = {1, 4, 2, 0, 97, 6, 0, 7, 0};
            int[] output = moveZero.moveZeroEnd(nums);
            System.out.println(Arrays.toString(output));
        }

        private int[] moveZeroEnd(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swapp(nums, i, j);
                    j++;
                }
            }
            return nums;
        }

        private void swapp(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }





    //2. Input: nums = [1,2,2,1,1,0]
//   Output: [1,4,2,0,0,0]
    public static class ApplyOperationArray {
        public static void main(String[] args) {
            ApplyOperationArray applyOperationArray = new ApplyOperationArray();

            int num[] = {1, 2, 2, 1, 1, 0};
            System.out.println("Original Array::" + Arrays.toString(num));
            int[] output = applyOperationArray.arrayOperation(num);
            System.out.println("Array after Operation::" + Arrays.toString(output));
        }

        private int[] arrayOperation(int[] num) {
            System.out.println("Step 1: Doubling adjacent equal elements and setting next to 0");

            // First loop: Double adjacent equal elements and set the next element to 0
            for (int i = 0; i < num.length - 1; i++) {
                System.out.println("Checking elements: num[" + i + "] = " + num[i] + " and num[" + (i + 1) + "] = " + num[i + 1]);
                if (num[i] == num[i + 1]) {
                    num[i] *= 2;
                    num[i + 1] = 0;
                    System.out.println("Modified Array after doubling: " + Arrays.toString(num));
                }
            }

            System.out.println("Step 2: Moving non-zero elements to the front");

            // Second loop: Move non-zero elements to the front
            int j = 0;
            for (int i = 0; i < num.length; i++) {
                System.out.println("Checking element at num[" + i + "] = " + num[i]);
                if (num[i] != 0) {
                    System.out.println("Swapping num[" + i + "] = " + num[i] + " with num[" + j + "] = " + num[j]);
                    swap(num, i, j);
                    System.out.println("Array after swapping: " + Arrays.toString(num));
                    j++;
                }
            }

            return num;
        }

        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            System.out.println("Swapped: num[" + i + "] = " + num[i] + ", num[" + j + "] = " + num[j]);
        }
    }


    //3.Input: nums = [0,1,2,2,3,0,4,2], val = 2
    //Output: 5, nums = [0,1,4,0,3,,,_]
    public static class RemoveArray {
        public static void main(String[] args) {
            RemoveArray removeArray = new RemoveArray();
            int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
            int val = 2;
            System.out.println("Original Array: " + Arrays.toString(nums));
            int output = removeArray.removeArray(nums, val);
            System.out.println("Array after removing value " + val + ": " + Arrays.toString(Arrays.copyOf(nums, output)));
            System.out.println("Number of elements left after removal: " + output);
        }

        private int removeArray(int[] nums, int val) {
            int j = 0; // Index for elements that are not equal to `val`
            System.out.println("Starting removal of value: " + val);

            for (int i = 0; i < nums.length; i++) {
                System.out.println("Checking element at index " + i + ": " + nums[i]);
                if (nums[i] != val) {
                    System.out.println("Element " + nums[i] + " is not equal to " + val + ", swapping with element at index " + j);
                    swap(nums, i, j);
                    System.out.println("Array after swap: " + Arrays.toString(nums));
                    j++;
                }
            }
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            System.out.println("Swapped: nums[" + i + "] = " + nums[i] + ", nums[" + j + "] = " + nums[j]);
        }
    }
    public static class PascalTriangle{
        public static void main(String[] args) {
            int numRow=5;
            System.out.println("Number of row ::"+numRow);
            PascalTriangle x=new PascalTriangle();
            List<List<Integer>> outPut =x.pascalTriangle(numRow);
            System.out.println("OUTPUT:"+outPut);
        }

        private List<List<Integer>> pascalTriangle(int numRow) {
            List<List<Integer>> result = new ArrayList<>();
            System.out.println("Results::"+result);

            for (int i = 0; i < numRow; i++) {
                System.out.println("I::"+i);
                List<Integer> row = new ArrayList<>();
                System.out.println("Row:"+row);

                row.add(1);
                System.out.println("Ro");
                for (int j = 1; j < i; j++) {
                    System.out.println("IU:"+i);
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    System.out.println("Rows:"+row);
                }

                if (i > 0) {
                    row.add(1);
                    System.out.println("Row:::"+row);

                }

                result.add(row);
                System.out.println("Result::"+result);
            }

            return result;
        }
    }
 /*   5.Valid Anagram
      6. Group Anagram
      7. Palindrome Permutation
      8. Find Resultant Array After Removing Anagrams
      9. Count Anagrams
      10. Group Shifted String
      11. Find Resultant Array After Removing Anagrams
  */
    //5.Valid Anagram

    public static class ValidAnagram{
        public static void main(String[] args) {
            String str1 = "islten";
            String str2 = "silent";
            ValidAnagram validAnagram = new ValidAnagram();
            boolean output = validAnagram.isValidAnagram(str1, str2);
            System.out.println("Anagram is valid: " + output);
        }

        private boolean isValidAnagram(String str1, String str2) {
            // Print input strings
            System.out.println("Input string 1: " + str1);
            System.out.println("Input string 2: " + str2);

            if (str1.length() != str2.length()) {
                System.out.println("Lengths are different, not an anagram");
                return false;
            }

            // Convert to char arrays
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();

            // Print char arrays before sorting
            System.out.println("Char array 1 before sorting: " + Arrays.toString(s1));
            System.out.println("Char array 2 before sorting: " + Arrays.toString(s2));

            // Sort char arrays
            Arrays.sort(s1);
            Arrays.sort(s2);

            // Print char arrays after sorting
            System.out.println("Char array 1 after sorting: " + Arrays.toString(s1));
            System.out.println("Char array 2 after sorting: " + Arrays.toString(s2));

            // Check if they are equal
            boolean result = Arrays.equals(s1, s2);
            System.out.println("Are both arrays equal: " + result);

            return result;
        }
    }

    //6. strs =
    //["eat","tea","tan","ate","nat","bat"]
    //Group Anagram


    public static class GroupAnagram {
        public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

            System.out.println("Input Strings: " + Arrays.toString(strs));  // Print the input array

            GroupAnagram groupAnagram = new GroupAnagram();
            List<List<String>> result = groupAnagram.groupAnagrams(strs);

            System.out.println("Grouped Anagrams: " + result);  // Print the final grouped anagrams
        }

        private List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> stringListMap = new HashMap<>();

            for (String s : strs) {
                // Convert the string to a char array and sort it
                char[] chars = s.toCharArray();

                // Print the original string and its char array before sorting
                System.out.println("Original String: " + s);
                System.out.println("Char Array before sorting: " + Arrays.toString(chars));

                Arrays.sort(chars);

                // Print the char array after sorting
                System.out.println("Char Array after sorting: " + Arrays.toString(chars));

                // Convert the sorted char array back to a string
                String sortedStr = new String(chars);
                System.out.println("Sorted String: " + sortedStr);  // Print the sorted version of the string

                // Group the anagrams in the map
                stringListMap.putIfAbsent(sortedStr, new ArrayList<>());
                stringListMap.get(sortedStr).add(s);

                // Print the current state of the map
                System.out.println("Map State: " + stringListMap);
            }

            // Return a list of all the grouped anagrams
            return new ArrayList<>(stringListMap.values());
        }
    }


    /*
     Sliding Window Logic
This part handles the sliding window,
 where we move the right pointer through the string and adjust the window accordingly.
         // Right pointer of the sliding window moves from 0 to s.length()
        for (int right = 0; right < s.length(); right++) {
            // Increment the count of the current character
            charCount[s.charAt(right) - 'A']++;

            // Find the maximum frequency of any character in the current window
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            // Check if the current window is valid
            if ((right - left + 1) - maxCount > k) {
                // If the window is invalid, shrink it from the left
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the result with the maximum valid window size
            result = Math.max(result, right - left + 1);
        }

     */
    public static class CharacterReplacement {
        public int characterReplacement(String s, int k) {
            int[] charCount = new int[26]; // Array to store the frequency of each character
            int left = 0;
            int maxCount = 0;
            int result = 0;

            System.out.println("Initial State: ");
            System.out.println("String: " + s);
            System.out.println("Allowed replacements (k): " + k);
            System.out.println();

            // Sliding window approach
            for (int right = 0; right < s.length(); right++) {
                // Increment the count of the current character
                charCount[s.charAt(right) - 'A']++;
                System.out.println("Right pointer at index " + right + " (character: " + s.charAt(right) + ")");
                System.out.println("charCount array: " + java.util.Arrays.toString(charCount));

                // Update the maximum frequency of a character in the current window
                maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
                System.out.println("Max frequency of any character in the window: " + maxCount);

                // If the window is invalid, shrink it from the left
                if ((right - left + 1) - maxCount > k) {
                    System.out.println("Window size exceeds allowed replacements. Shrinking window from the left.");
                    charCount[s.charAt(left) - 'A']--;
                    System.out.println("Decrement count of character '" + s.charAt(left) + "' at left pointer index " + left);
                    left++;
                    System.out.println("Left pointer moved to index " + left);
                }

                // Update the result with the maximum valid window size
                result = Math.max(result, right - left + 1);
                System.out.println("Current window size (right - left + 1): " + (right - left + 1));
                System.out.println("Current result (longest valid substring length so far): " + result);
                System.out.println("--------------------------------------");
            }

            return result; // Return the length of the longest valid substring
        }

        // Main method to test the characterReplacement method
        public static void main(String[] args) {
            CharacterReplacement solution = new CharacterReplacement();

            // Test case 1
            String s1 = "ABAB";
            int k1 = 2;
            System.out.println("Test Case 1:");
            System.out.println("Input: s = " + s1 + ", k = " + k1);
            System.out.println("Result: " + solution.characterReplacement(s1, k1));
            System.out.println("======================================\n");

            // Test case 2
            String s2 = "AABABBA";
            int k2 = 1;
            System.out.println("Test Case 2:");
            System.out.println("Input: s = " + s2 + ", k = " + k2);
            System.out.println("Result: " + solution.characterReplacement(s2, k2));
        }
    }

/*
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */

    public static class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // Step 1: Sort the array
            Arrays.sort(nums);
            System.out.println("Sorted array: " + Arrays.toString(nums));

            // Step 2: Iterate through the array
            for (int i = 0; i < nums.length - 2; i++) {

                // Skip duplicate numbers for the first number
                if (i > 0 && nums[i] == nums[i - 1]) {
                    System.out.println("Skipping duplicate for nums[i]: " + nums[i]);
                    continue;
                }

                // Step 3: Use two-pointer technique to find the other two numbers
                int left = i + 1;
                int right = nums.length - 1;
                System.out.println("Checking for triplets with nums[i] = " + nums[i]);

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    System.out.println("Current triplet: [" + nums[i] + ", " + nums[left] + ", " + nums[right] + "], sum = " + sum);

                    if (sum == 0) {
                        // Found a triplet
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        System.out.println("Found triplet: [" + nums[i] + ", " + nums[left] + ", " + nums[right] + "]");

                        // Skip duplicates for the second number
                        while (left < right && nums[left] == nums[left + 1]) {
                            System.out.println("Skipping duplicate for nums[left]: " + nums[left]);
                            left++;
                        }
                        // Skip duplicates for the third number
                        while (left < right && nums[right] == nums[right - 1]) {
                            System.out.println("Skipping duplicate for nums[right]: " + nums[right]);
                            right--;
                        }

                        // Move both pointers inward after adding a valid triplet
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++; // We need a larger sum, move left pointer to the right
                        System.out.println("Sum < 0, moving left pointer to: " + nums[left]);
                    } else {
                        right--; // We need a smaller sum, move right pointer to the left
                        System.out.println("Sum > 0, moving right pointer to: " + nums[right]);
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            ThreeSum solution = new ThreeSum();

            // Test case 1
            int[] nums1 = {-1, 0, 1, 2, -1, -4};
            System.out.println("\nTest case 1:");
            List<List<Integer>> result1 = solution.threeSum(nums1);
            System.out.println("Input: " + Arrays.toString(nums1));
            System.out.println("Output: " + result1);

            // Test case 2
            int[] nums2 = {0, 1, 1};
            System.out.println("\nTest case 2:");
            List<List<Integer>> result2 = solution.threeSum(nums2);
            System.out.println("Input: " + Arrays.toString(nums2));
            System.out.println("Output: " + result2);

            // Test case 3
            int[] nums3 = {0, 0, 0};
            System.out.println("\nTest case 3:");
            List<List<Integer>> result3 = solution.threeSum(nums3);
            System.out.println("Input: " + Arrays.toString(nums3));
            System.out.println("Output: " + result3);
        }
    }




    public static class NumIdenticalPairs {
        public int numIdenticalPairs(int[] nums) {
            // Create a hashmap to store the frequency of each number
            HashMap<Integer, Integer> map = new HashMap<>();
            int goodPairs = 0; // Variable to count the number of good pairs

            System.out.println("Initial nums array: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Iterate through the array
            for (int num : nums) {
                // Check if the number already exists in the map
                if (map.containsKey(num)) {
                    // Print when we find a pair
                    System.out.println("Found duplicate of: " + num);
                    // Add the current count of this number to goodPairs (i.e., the count of previous occurrences)
                    goodPairs += map.get(num);
                    System.out.println("Number of good pairs so far: " + goodPairs);
                }

                // Update the count of this number in the map
                map.put(num, map.getOrDefault(num, 0) + 1);
                System.out.println("Updated frequency map: " + map);
            }

            System.out.println("Final number of good pairs: " + goodPairs);
            return goodPairs;
        }

        // Main method to run the solution
        public static void main(String[] args) {
            NumIdenticalPairs solution = new NumIdenticalPairs();

            // Test case 1
            int[] nums1 = {1, 2, 3, 1, 1, 3};
            System.out.println("Test Case 1:");
            int result1 = solution.numIdenticalPairs(nums1);
            System.out.println("Output: " + result1);

            // Test case 2
            int[] nums2 = {1, 1, 1, 1};
            System.out.println("Test Case 2:");
            int result2 = solution.numIdenticalPairs(nums2);
            System.out.println("Output: " + result2);

            // Test case 3
            int[] nums3 = {1, 2, 3};
            System.out.println("Test Case 3:");
            int result3 = solution.numIdenticalPairs(nums3);
            System.out.println("Output: " + result3);
        }
    }



    public static class InterchangeableRectangles {
        public long interchangeableRectangles(int[][] rectangles) {
            // HashMap to store the frequency of each ratio (width/height in reduced form)
            HashMap<String, Long> ratioMap = new HashMap<>();
            long count = 0; // To keep track of the number of interchangeable pairs

            System.out.println("Starting to process rectangles...");

            // Iterate over all rectangles
            for (int[] rectangle : rectangles) {
                int width = rectangle[0];
                int height = rectangle[1];
                System.out.println("Processing rectangle with width: " + width + " and height: " + height);

                // Calculate the greatest common divisor (GCD) of width and height
                int gcd = gcd(width, height);
                System.out.println("GCD of width and height: " + gcd);

                // Reduce the width and height by their GCD to get the simplified ratio
                int reducedWidth = width / gcd;
                int reducedHeight = height / gcd;
                System.out.println("Reduced width: " + reducedWidth + ", Reduced height: " + reducedHeight);

                // Store the ratio as a string "width:height"
                String ratio = reducedWidth + ":" + reducedHeight;
                System.out.println("Simplified ratio: " + ratio);

                // If this ratio is already in the map, add its frequency to the count of pairs
                if (ratioMap.containsKey(ratio)) {
                    count += ratioMap.get(ratio);
                    System.out.println("Found interchangeable pair with ratio " + ratio + ", increasing count to " + count);
                }

                // Update the frequency of the current ratio in the map
                ratioMap.put(ratio, ratioMap.getOrDefault(ratio, 0L) + 1);
                System.out.println("Updated ratio map: " + ratioMap);
            }

            System.out.println("Final number of interchangeable pairs: " + count);
            return count;
        }

        // Helper method to calculate the greatest common divisor (GCD)
        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        // Main method to test the solution
        public static void main(String[] args) {
            InterchangeableRectangles solution = new InterchangeableRectangles();

            // Test case 1
            int[][] rectangles1 = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
            System.out.println("Test Case 1 Output: " + solution.interchangeableRectangles(rectangles1));

            // Test case 2
            int[][] rectangles2 = {{4, 5}, {7, 8}};
            System.out.println("Test Case 2 Output: " + solution.interchangeableRectangles(rectangles2));
        }
    }

    //Best Time to Buy and Sell Stock
    //Easy
    //Maximum Product Subarray
    //Medium
    //Degree of an Array
    //Easy
    //Longest Turbulent Subarray
    //Medium
    //Maximum Score Of Spliced Array
    //Hard
    //Maximum Absolute Sum of Any Subarray
    //Medium
    //Maximum Subarray Sum After One Operation
    //Medium
    //Substring With Largest Variance
    //Hard
    //Count Subarrays With Score Less Than K
    //Hard
    //Maximum Value of a String in an Array
    //Easy
    //Find the Substring With Maximum Cost
    //Medium
    //K Items With the Maximum Sum
    //Easy
    //Maximum Good Subarray Sum
    //Medium


    public static class MaximumProductSubarray {
        public static void main(String[] args) {
            MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
            int nums[] = {2, 3, -2, 4};

            int results = maximumProductSubarray.maxProductsSubArrays(nums);
            System.out.println("Final Output: " + results);
        }

        private int maxProductsSubArrays(int[] nums) {
            if (nums == null || nums.length == 0) {
                System.out.println("The input array is null or empty.");
                return 0;
            }

            // Initialize max, min, and result with the first element
            int maxProducts = nums[0];
            int minProducts = nums[0];
            int result = nums[0];

            System.out.println("Initial values -> maxProducts: " + maxProducts + ", minProducts: " + minProducts + ", result: " + result);

            // Loop through the array starting from the second element
            for (int i = 1; i < nums.length; i++) {
                System.out.println("\nProcessing nums[" + i + "] = " + nums[i]);

                // If the current number is negative, swap maxProducts and minProducts
                if (nums[i] < 0) {
                    System.out.println("nums[" + i + "] is negative. Swapping maxProducts and minProducts.");
                    int temp = maxProducts;
                    maxProducts = minProducts;
                    minProducts = temp;
                }

                // Update maxProducts and minProducts for the current number
                maxProducts = Math.max(nums[i], maxProducts * nums[i]);
                minProducts = Math.min(nums[i], minProducts * nums[i]);

                // Print the updated max and min products
                System.out.println("Updated maxProducts: " + maxProducts + ", minProducts: " + minProducts);

                // Update the result to store the maximum product found so far
                result = Math.max(result, maxProducts);
                System.out.println("Updated result: " + result);
            }

            // Return the maximum product subarray result
            return result;
        }
    }
    public static class KItemsWithMaximumSum {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            int maxOnes = Math.min(numOnes, k);
            k -= maxOnes;

            int maxZeros = Math.min(numZeros, k);
            k -= maxZeros;

            int maxNegOnes = Math.min(numNegOnes, k);

            return maxOnes - maxNegOnes;
        }

        public static void main(String[] args) {
            int numOnes = 3;
            int numZeros = 2;
            int numNegOnes = 0;
            int k = 2;
            KItemsWithMaximumSum kItemsWithMaximumSum=new KItemsWithMaximumSum();
            int output= kItemsWithMaximumSum.kItemsWithMaximumSum(numOnes,numZeros,numNegOnes,k);
            System.out.printf("KItemsWithMaximumSum=="+output);
        }
    }

    public static class MaximumValueOfaStringInanArray {

        public static void main(String[] args) {
            // Test case 1
            String[] strs1 = {"alic3", "bob", "3", "4", "00000"};
            System.out.println("Maximum value (Test Case 1): " + maximumValue(strs1));

            // Test case 2
            String[] strs2 = {"1", "01", "001", "0001"};
            System.out.println("Maximum value (Test Case 2): " + maximumValue(strs2));
        }

        public static int maximumValue(String[] strs) {
            int maxValue = 0;  // To store the maximum value
            System.out.println("Initial maxValue: " + maxValue);

            for (String str : strs) {
                int currentValue;
                if (isNumeric(str)) {
                    // If the string consists only of digits, convert it to its numeric value
                    currentValue = Integer.parseInt(str);
                    System.out.println("String '" + str + "' is numeric. Numeric value: " + currentValue);
                } else {
                    // If the string contains letters, use its length as its value
                    currentValue = str.length();
                    System.out.println("String '" + str + "' is alphanumeric. Length value: " + currentValue);
                }
                // Update the maxValue if currentValue is greater
                maxValue = Math.max(maxValue, currentValue);
                System.out.println("Updated maxValue: " + maxValue);
            }

            return maxValue;
        }

        // Helper function to check if a string contains only digits
        private static boolean isNumeric(String str) {
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }



    public static class FindShortestSubArray {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, Integer> count = new HashMap<>();   // To store the frequency of each number
            HashMap<Integer, Integer> first = new HashMap<>();   // To store the first occurrence index of each number
            HashMap<Integer, Integer> last = new HashMap<>();    // To store the last occurrence index of each number

            int degree = 0;  // Initialize degree of the array

            // Iterate through the array to fill the maps
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                count.put(num, count.getOrDefault(num, 0) + 1);
                if (!first.containsKey(num)) {
                    first.put(num, i);  // Record the first occurrence of num
                }
                last.put(num, i);  // Update the last occurrence of num

                // Update degree with the maximum frequency
                degree = Math.max(degree, count.get(num));
            }

            // Print the frequency count map
            System.out.println("Count map: " + count);
            // Print the first and last occurrence maps
            System.out.println("First occurrence map: " + first);
            System.out.println("Last occurrence map: " + last);
            // Print the degree of the array
            System.out.println("Degree of the array: " + degree);

            int minLength = nums.length;  // Initialize minimum length as the entire array size

            // Now iterate over the elements to find the smallest subarray with the same degree
            for (int num : count.keySet()) {
                if (count.get(num) == degree) {
                    // Calculate the length of the subarray that contains this number with the same degree
                    int subArrayLength = last.get(num) - first.get(num) + 1;
                    // Print the length of the subarray
                    System.out.println("Subarray length for number " + num + ": " + subArrayLength);
                    minLength = Math.min(minLength, subArrayLength);
                }
            }

            // Print the minimum length of the subarray found
            System.out.println("Minimum length of subarray with same degree: " + minLength);

            return minLength;
        }

        public static void main(String[] args) {
            FindShortestSubArray solution = new FindShortestSubArray();

            // Test case 1
            int[] nums1 = {1, 2, 2, 3, 1};
            System.out.println("Test case 1: ");
            System.out.println("Result: " + solution.findShortestSubArray(nums1));  // Expected output: 2

            // Test case 2
            int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
            System.out.println("Test case 2: ");
            System.out.println("Result: " + solution.findShortestSubArray(nums2));  // Expected output: 6
        }
    }
    public static class BestTimeToBuyAndSellStock {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                System.out.println("Prices array is either null or empty.");
                return 0;
            }

            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int price : prices) {
                System.out.println("Current price: " + price);

                if (price < minPrice) {
                    minPrice = price;
                    System.out.println("New minimum price found: " + minPrice);
                } else {
                    int profit = price - minPrice;
                    System.out.println("Potential profit if sold now: " + profit);

                    if (profit > maxProfit) {
                        maxProfit = profit;
                        System.out.println("New maximum profit found: " + maxProfit);
                    }
                }
            }

            System.out.println("Final maximum profit: " + maxProfit);
            return maxProfit;
        }

        public static void main(String[] args) {
            BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

            // Example 1
            int[] prices1 = {7, 1, 5, 3, 6, 4};
            System.out.println("Example 1: Prices = [7, 1, 5, 3, 6, 4]");
            int result1 = solution.maxProfit(prices1);
            System.out.println("Max Profit: " + result1);
            System.out.println();

            // Example 2
            int[] prices2 = {7, 6, 4, 3, 1};
            System.out.println("Example 2: Prices = [7, 6, 4, 3, 1]");
            int result2 = solution.maxProfit(prices2);
            System.out.println("Max Profit: " + result2);
        }
    }

    /*
    we can use a sliding window approach to determine the length of the maximum turbulent subarray.
    Key Idea:
We maintain two possible turbulent subarrays at a time:
One where the elements alternate in a "greater, less" pattern (> then <).
One where the elements alternate in a "less, greater" pattern (< then >).
Plan:
Traverse the array starting from the second element.
Keep track of two variables inc and dec:
inc: the length of a turbulent subarray where elements alternate in an increasing, then decreasing pattern.
dec: the length of a turbulent subarray where elements alternate in a decreasing, then increasing pattern.
As we traverse:
If arr[i] > arr[i - 1], update inc = dec + 1 and reset dec to 1.
If arr[i] < arr[i - 1], update dec = inc + 1 and reset inc to 1.
If arr[i] == arr[i - 1], reset both inc and dec to 1.
The result will be the maximum value of both inc and dec during the traversal.


     */
    public static class LongestTurbulentSubarray {

        private int maxTurbulenceSize(int[] arr1) {
            if (arr1.length == 1) {
                System.out.println("Array has only one element, returning 1.");
                return 1;
            }

            int inc = 1;  // Tracks length of a subarray where arr[i] > arr[i-1]
            int dec = 1;  // Tracks length of a subarray where arr[i] < arr[i-1]
            int maxLen = 1;  // Stores the maximum turbulent subarray length

            for (int i = 1; i < arr1.length; i++) {
                System.out.println("Current element: arr[" + i + "] = " + arr1[i] + ", Previous element: arr[" + (i - 1) + "] = " + arr1[i - 1]);

                if (arr1[i] > arr1[i - 1]) {
                    inc = dec + 1;  // Increase the "inc" length as the turbulent condition is satisfied
                    dec = 1;  // Reset "dec" because we are now in the increasing pattern
                    System.out.println("arr[" + i + "] > arr[" + (i - 1) + "], inc: " + inc + ", dec: " + dec);
                } else if (arr1[i] < arr1[i - 1]) {
                    dec = inc + 1;  // Increase the "dec" length as the turbulent condition is satisfied
                    inc = 1;  // Reset "inc" because we are now in the decreasing pattern
                    System.out.println("arr[" + i + "] < arr[" + (i - 1) + "], inc: " + inc + ", dec: " + dec);
                } else {
                    // arr[i] == arr[i - 1], so reset both inc and dec because there's no turbulence
                    inc = 1;
                    dec = 1;
                    System.out.println("arr[" + i + "] == arr[" + (i - 1) + "], reset inc and dec to 1.");
                }

                // Update the maximum turbulent subarray length so far
                maxLen = Math.max(maxLen, Math.max(inc, dec));
                System.out.println("Updated maxLen: " + maxLen);
            }

            return maxLen;
        }

        public static void main(String[] args) {
            LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();

            // Test case 1
            int[] arr1 = {9, 4, 2, 10, 7, 8, 8, 1, 9};
            System.out.println("Test Case 1:");
            System.out.println("Max Turbulent Size: " + longestTurbulentSubarray.maxTurbulenceSize(arr1));  // Output: 5
            System.out.println();

            // Test case 2
            int[] arr2 = {4, 8, 12, 16};
            System.out.println("Test Case 2:");
            System.out.println("Max Turbulent Size: " + longestTurbulentSubarray.maxTurbulenceSize(arr2));  // Output: 2
            System.out.println();

            // Test case 3
            int[] arr3 = {100};
            System.out.println("Test Case 3:");
            System.out.println("Max Turbulent Size: " + longestTurbulentSubarray.maxTurbulenceSize(arr3));  // Output: 1
        }
    }

    public static class Subsets {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            // Call the backtrack method to generate all subsets
            System.out.println("Starting backtracking...");
            backtrack(result, new ArrayList<>(), nums, 0);
            return result;
        }


        public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
            // Add the current subset (tempList) to the result
            System.out.println("Current subset (tempList): " + tempList);
            result.add(new ArrayList<>(tempList));
            System.out.println("Subsets so far: " + result);

            // Explore all elements starting from the index 'start'
            for (int i = start; i < nums.length; i++) {
                System.out.println("Adding " + nums[i] + " to the current subset");
                // Include the current element nums[i] in the subset
                tempList.add(nums[i]);

                // Recursively call backtrack with the next index
                System.out.println("Recursively calling backtrack with tempList: " + tempList + " and start: " + (i + 1));
                backtrack(result, tempList, nums, i + 1);

                // Exclude the last element (backtrack) and explore other subsets
                System.out.println("Removing " + tempList.get(tempList.size() - 1) + " to backtrack");
                tempList.remove(tempList.size() - 1);
            }
        }

        public static void main(String[] args) {
            Subsets sol = new Subsets();

            // Test case 1
            int[] nums1 = {1, 2, 3};
            System.out.println("Subsets of [1, 2, 3]: " + sol.subsets(nums1));

            // Test case 2
            int[] nums2 = {0};
            System.out.println("Subsets of [0]: " + sol.subsets(nums2));
        }
    }
//    Key Fixes:
//    Method Name Typo: Changed bracktrack to backtrack for consistency.
//for Loop Placement: The for loop was mistakenly placed outside of the method body. Now, it is correctly inside the backtrack method.
//            Recursion: The recursive call to backtrack should happen after adding an element to tempList and before removing it, ensuring all combinations are explored.
//    How the Code Works:
//    The backtrack method explores every possible subset by including and excluding each element.
//    After exploring a subset, it adds the current combination to the result list.
//    The backtracking technique ensures that all possible subsets are generated by recursively adding elements and then removing them to explore other possibilities.
//

    public static class TwoSum{
        public static void main(String[] args) {
            TwoSum twoSum=new TwoSum();
            // Test case 1
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            System.out.println("Test case 1: Input: " + Arrays.toString(nums1) + ", Target: " + target1);
            int[] result1 = twoSum.twoSum(nums1, target1);
            System.out.println("Output: " + Arrays.toString(result1)); // Output: [0, 1]

            // Test case 2
            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            System.out.println("\nTest case 2: Input: " + Arrays.toString(nums2) + ", Target: " + target2);
            int[] result2 = twoSum.twoSum(nums2, target2);
            System.out.println("Output: " + Arrays.toString(result2)); // Output: [1, 2]

            // Test case 3
            int[] nums3 = {3, 3};
            int target3 = 6;
            System.out.println("\nTest case 3: Input: " + Arrays.toString(nums3) + ", Target: " + target3);
            int[] result3 = twoSum.twoSum(nums3, target3);
            System.out.println("Output: " + Arrays.toString(result3)); // Output: [0, 1]

        }

        private int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i]; // Calculate the complement
                System.out.println("Iteration " + i + ":");
                System.out.println("Current number: " + nums[i]);
                System.out.println("Complement (target - current number): " + complement);

                // Check if complement exists in the map
                if (map.containsKey(complement)) {
                    System.out.println("Complement " + complement + " found in map! Indices: " + map.get(complement) + " and " + i);
                    return new int[]{map.get(complement), i}; // Return indices
                }

                // If complement not found, add the current number and its index to the map
                map.put(nums[i], i);
                System.out.println("Adding number " + nums[i] + " at index " + i + " to the map.");
                System.out.println("Map state: " + map);
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }


    public static class ProductOfArrayExceptSelf {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];

            // Step 1: Compute left product for each element
            answer[0] = 1; // Left product of the first element is 1 since no elements are to its left
            for (int i = 1; i < n; i++) {
                answer[i] = answer[i - 1] * nums[i - 1];
                System.out.println("Left product up to index " + i + ": " + Arrays.toString(answer));
            }

            // Step 2: Compute right product and multiply with left product for each element
            int rightProduct = 1; // No elements to the right of the last element
            for (int i = n - 1; i >= 0; i--) {
                answer[i] *= rightProduct; // Multiply current answer with the right product
                rightProduct *= nums[i]; // Update right product for the next element (to the left)
                System.out.println("After multiplying with right product at index " + i + ": " + Arrays.toString(answer));
            }

            return answer;
        }

        public static void main(String[] args) {
            ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

            // Test case 1
            int[] nums1 = {1, 2, 3, 4};
            System.out.println("Input: " + Arrays.toString(nums1));
            int[] result1 = solution.productExceptSelf(nums1);
            System.out.println("Output: " + Arrays.toString(result1)); // Output: [24, 12, 8, 6]

            // Test case 2
            int[] nums2 = {-1, 1, 0, -3, 3};
            System.out.println("\nInput: " + Arrays.toString(nums2));
            int[] result2 = solution.productExceptSelf(nums2);
            System.out.println("Output: " + Arrays.toString(result2)); // Output: [0, 0, 9, 0, 0]
        }

        public static class MaximumSubarray {
            public int maxSubArray(int[] nums) {
                int maxSum = nums[0];
                int currentSum = 0;
                for (int num : nums) {
                    if (currentSum < 0) {
                        currentSum = 0;
                    }
                    currentSum += num;
                    maxSum = Math.max(maxSum, currentSum);
                }
                return maxSum;
            }

            public static void main(String[] args) {
                MaximumSubarray maximumSubarray = new MaximumSubarray();
                // Test case 1
                int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
                System.out.println("Max Subarray Sum: " + maximumSubarray.maxSubArray(nums1));  // Output: 6

                // Test case 2
                int[] nums2 = {1};
                System.out.println("Max Subarray Sum: " + maximumSubarray.maxSubArray(nums2));  // Output: 1

                // Test case 3
                int[] nums3 = {5, 4, -1, 7, 8};
                System.out.println("Max Subarray Sum: " + maximumSubarray.maxSubArray(nums3));  // Output: 23
            }
        }

    }

    public static class ConcatenationOfArray {
        public static void main(String[] args) {
            ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();

            // Test case 1
            int[] nums1 = {1, 2, 1};
            int[] output1 = concatenationOfArray.concatenationOfArray(nums1);
            System.out.print("Output for nums = [1, 2, 1]: ");
            concatenationOfArray.printArray(output1);  // Expected: [1, 2, 1, 1, 2, 1]

            // Test case 2
            int[] nums2 = {1, 3, 2, 1};
            int[] output2 = concatenationOfArray.concatenationOfArray(nums2);
            System.out.print("Output for nums = [1, 3, 2, 1]: ");
            concatenationOfArray.printArray(output2);  // Expected: [1, 3, 2, 1, 1, 3, 2, 1]
        }

        // Method to concatenate the array
        private int[] concatenationOfArray(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n * 2];  // Array of size 2n

            // Fill the result array with two copies of nums
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i];
                ans[i + n] = nums[i];
                System.out.println("After setting ans[" + i + "] = " + nums[i] + " and ans[" + (i + n) + "] = " + nums[i]);
            }

            return ans;
        }

        // Helper method to print an array
        private void printArray(int[] arr) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        public static class ShuffletheArray {
            public static void main(String[] args) {
                ShuffletheArray shuffletheArray = new ShuffletheArray();

                // Test case 1
                int[] nums1 = {2, 5, 1, 3, 4, 7};
                int n1 = 3;
                int[] output1 = shuffletheArray.shuffletheArray(nums1, n1);
                System.out.print("Output for nums = [2, 5, 1, 3, 4, 7], n = 3: ");
                shuffletheArray.printArray(output1);  // Expected: [2, 3, 5, 4, 1, 7]

                // Test case 2
                int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
                int n2 = 4;
                int[] output2 = shuffletheArray.shuffletheArray(nums2, n2);
                System.out.print("Output for nums = [1, 2, 3, 4, 4, 3, 2, 1], n = 4: ");
                shuffletheArray.printArray(output2);  // Expected: [1, 4, 2, 3, 3, 2, 4, 1]

                // Test case 3
                int[] nums3 = {1, 1, 2, 2};
                int n3 = 2;
                int[] output3 = shuffletheArray.shuffletheArray(nums3, n3);
                System.out.print("Output for nums = [1, 1, 2, 2], n = 2: ");
                shuffletheArray.printArray(output3);  // Expected: [1, 2, 1, 2]
            }

            // Method to shuffle the array as per the problem statement
            private int[] shuffletheArray(int[] nums, int n) {
                int[] ans = new int[2 * n];

                // Loop to interleave the arrays as required
                for (int i = 0; i < n; i++) {
                    ans[2 * i] = nums[i];         // Place xi at even indices
                    ans[2 * i + 1] = nums[i + n]; // Place yi at odd indices
                    System.out.println("Placing xi = " + nums[i] + " at ans[" + (2 * i) + "] and yi = " + nums[i + n] + " at ans[" + (2 * i + 1) + "]");
                }

                return ans;
            }

            // Helper method to print the array
            private void printArray(int[] arr) {
                System.out.print("[");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                    if (i < arr.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
        }
    }
    public static class ReverseStringWords{
        public static void main(String[] args) {
            String str="my name is abc";
            String result=reverseString(str);
            System.out.println(result);
        }

        private static String reverseString(String str) {
            String[] words=str.trim().split("//str");
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=words.length-1;i>=0;i--){
                stringBuilder.append(words[i]);
                if(i!=0){
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        }
    }
    public static class LongestCommonPrefix {
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // Take the first string as the initial reference for comparison
            String prefix = strs[0];
            System.out.println("Initial prefix: " + prefix);

            // Iterate through the remaining strings in the array
            for (int i = 1; i < strs.length; i++) {
                System.out.println("Comparing with: " + strs[i]);

                // Compare the current prefix with each string and reduce it until a match is found
                while (strs[i].indexOf(prefix) != 0) {
                    System.out.println("Current prefix '" + prefix + "' doesn't match, reducing it.");
                    prefix = prefix.substring(0, prefix.length() - 1);
                    System.out.println("Reduced prefix: " + prefix);
                    if (prefix.isEmpty()) {
                        System.out.println("No common prefix found.");
                        return "";
                    }
                }
            }

            System.out.println("Final longest common prefix: " + prefix);
            return prefix;
        }

        public static void main(String[] args) {
            String[] strs1 = {"flower", "flow", "flight"};
            System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1));
            System.out.println();

            String[] strs2 = {"dog", "racecar", "car"};
            System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2));
        }
    }
    public static class ReverseString {
        public static void main(String[] args) {
            // Example 1
            char[] s1 = {'h', 'e', 'l', 'l', 'o'};
            System.out.println("Input: " + String.valueOf(s1));
            reverseString(s1);
            System.out.println("Output: " + String.valueOf(s1));

            // Example 2
            char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
            System.out.println("Input: " + String.valueOf(s2));
            reverseString(s2);
            System.out.println("Output: " + String.valueOf(s2));
        }

        // Reverse the string in-place
        private static void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                // Swap the elements
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                // Move towards the middle
                left++;
                right--;
            }
        }
    }
    public static class ReverseStringII {
        public static void main(String[] args) {
            String s = "abcdefg"; // Input string
            int k = 2; // Number of characters to reverse
            System.out.println("Input = " + s + " K = " + k); // Print the input string and the value of k

            String output = reverseStringII(s, k); // Call the reverseStringII method
            System.out.println("Output: " + output); // Print the final output
        }

        private static String reverseStringII(String s, int k) {
            // Convert the string into a character array so that we can modify it
            char[] ch = s.toCharArray();
            System.out.println("Character Array: " + java.util.Arrays.toString(ch)); // Print the character array

            // Loop through the string in steps of 2k
            for (int i = 0; i < ch.length; i += 2 * k) {
                System.out.println("Processing chunk starting at index " + i);

                int left = i; // Set the left pointer to the start of the current chunk
                int right = Math.min(i + k - 1, ch.length - 1); // Set the right pointer to either the kth character or the last character
                System.out.println("Reversing from index " + left + " to " + right);

                // Reverse the first k characters (or fewer if remaining characters < k)
                while (left < right) {
                    // Swap the characters at the left and right indices
                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;

                    System.out.println("Swapped: " + ch[left] + " with " + ch[right]); // Print the swap information
                    System.out.println("Current state: " + java.util.Arrays.toString(ch)); // Print the current state of the character array

                    // Move the pointers towards the center
                    left++;
                    right--;
                }
            }

            // Convert the modified character array back to a string
            return new String(ch);
        }
    }
    /*
    int right = Math.min(i + k - 1, ch.length - 1);
Explanation:
i + k - 1:

i is the current starting index of the chunk.
k is the number of characters we want to reverse in each chunk.
i + k - 1 calculates the index of the k-th character from the starting index i.
Example:

If i = 0 (starting from the first character) and k = 2, then i + k - 1 gives:
0 + 2 - 1 = 1
This means that we want to reverse the characters between index 0 and index 1 (the first two characters).
ch.length - 1:

This represents the last index in the character array ch.
Since array indices are zero-based, ch.length - 1 is the last valid index.
Example:

If ch.length = 7 (for the string "abcdefg"), then ch.length - 1 is 6, which is the index of the last character "g".
Math.min():

Math.min(a, b) returns the smaller of the two values a and b.

In this case,
Math.min(i + k - 1, ch.length - 1)
ensures that the right boundary (right) does not go beyond the last character of the array.

If i + k - 1 exceeds the length of the array, Math.min will cap the right pointer at ch.length - 1 to prevent out-of-bounds errors.

Example Scenarios:
Case 1: Full chunk within bounds
Input: "abcdefg", k = 2, i = 0
Calculation:
i + k - 1 = 0 + 2 - 1 = 1
ch.length - 1 = 6
right = Math.min(1, 6) = 1
This means the characters at index 0 and 1 will be reversed.
Case 2: Partial chunk at the end of the string
Input: "abcdefg", k = 2, i = 4 (chunk starts at index 4)
Calculation:
i + k - 1 = 4 + 2 - 1 = 5
ch.length - 1 = 6
right = Math.min(5, 6) = 5
This means the characters at index 4 and 5 will be reversed.
Case 3: Less than k characters left
Input: "abcdefg", k = 2, i = 6 (last character)
Calculation:
i + k - 1 = 6 + 2 - 1 = 7
ch.length - 1 = 6
right = Math.min(7, 6) = 6
This means only the last character (index 6, "g") will be processed, but since it's a single character, no swap is needed.
     */

    public static class ReverseVowelOfString {
        public static void main(String[] args) {

            ReverseVowelOfString solution = new ReverseVowelOfString();
            // Example 1
            String input1 = "IceCreAm";
            String output1 = solution.reverseVowels(input1);
            System.out.println("Input: " + input1);
            System.out.println("Output: " + output1);

            // Example 2
            String input2 = "leetcode";
            String output2 = solution.reverseVowels(input2);
            System.out.println("Input: " + input2);
            System.out.println("Output: " + output2);
        }

        private String reverseVowels(String s) {
            char[] ch=s.toCharArray();
            System.out.println("Character Array: " + java.util.Arrays.toString(ch)); // Print the character array
            Set<Character>vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            int left=0;
            int right=ch.length-1;
            while (left<right){
                while (left<right&&!vowels.contains(ch[left])){
                    left++;
                }
                while (left<right&&!vowels.contains(ch[right])){
                    right--;
                }
                if(left<right){
                    char temp=ch[left];
                    ch[left]=ch[right];
                    ch[right]=temp;
                    left++;
                    right--;
                }
            }
            return new String(ch);

        }
    }

    public static class ValidPalindrome {
        public static void main(String[] args) {
            ValidPalindrome sol = new ValidPalindrome();
            String s = "A man, a plan, a canal: Panama";
            System.out.println("Input:: " + s);

            // Call the isValidPalindrome method and print the result
            Boolean output = isValidPalindrome(s);
            System.out.println("Output: " + output);
        }

        private static Boolean isValidPalindrome(String s) {
            System.out.println("Step 1: Initialize StringBuilder to build the cleaned string.");

            // Initialize StringBuilder to store only valid characters
            StringBuilder stringBuilder = new StringBuilder();

            // Loop through the input string character by character
            System.out.println("Step 2: Looping through each character of the input string.");
            for (char c : s.toCharArray()) {
                // Check if the character is a letter or digit
                if (Character.isLetterOrDigit(c)) {
                    // Convert to lowercase and append to stringBuilder
                    System.out.println("Character '" + c + "' is valid. Adding '" + Character.toLowerCase(c) + "' to the cleaned string.");
                    stringBuilder.append(Character.toLowerCase(c));
                } else {
                    System.out.println("Character '" + c + "' is ignored as it is not a letter or digit.");
                }
            }

            // Convert the cleaned string to a regular string
            String cleanString = stringBuilder.toString();
            System.out.println("Step 3: Cleaned string is: " + cleanString);

            // Reverse the string using StringBuilder reverse method
            System.out.println("Step 4: Reverse the cleaned string.");
            String reverseString = stringBuilder.reverse().toString();
            System.out.println("Reversed string is: " + reverseString);

            // Compare the cleaned string and the reversed string
            System.out.println("Step 5: Compare the cleaned and reversed strings.");
            boolean isPalindrome = cleanString.equals(reverseString);
            System.out.println("Is the string a palindrome? " + isPalindrome);

            // Return the result
            return isPalindrome;
        }
    }
    public static class FirstPalindromeString{
        public static void main(String[] args) {
            String[] words={"abc","car","ada","racecar","cool"};
            String output=firstPalindromeString(words);
            System.out.println("Output:"+output);
        }

        private static String firstPalindromeString(String[] words) {
            for (String word:words){
                if(isPalindrome(word)){
                    return word;

                }
            }
            return "";
        }

        private static boolean isPalindrome(String word) {
            int left=0;
            int right=word.length()-1;
            while (left<right){
                if(word.charAt(left)!=word.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }



    public static class CountElementsWithMaximumFrequency {
        public static void main(String[] args) {
            CountElementsWithMaximumFrequency output = new CountElementsWithMaximumFrequency();
            int[] nums = {1, 2, 2, 3, 1, 4};
            System.out.println("Input array:");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            int outputs = output.countElementsWithMaximumFrequency(nums);
            System.out.println("Final Output: " + outputs);
        }

        private int countElementsWithMaximumFrequency(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int totalMaxFreq = 0;

            // Populate frequency map
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            System.out.println("Frequency map: " + map);

            // Find maximum frequency
            int maxFre = 0;
            for (int fre : map.values()) {
                maxFre = Math.max(maxFre, fre);
            }
            System.out.println("Maximum Frequency: " + maxFre);

            // Calculate total number of elements with maximum frequency
            totalMaxFreq = 0;
            for (int fre : map.values()) {
                if (fre == maxFre) {
                    totalMaxFreq += fre;
                }
            }

            System.out.println("Total elements with max frequency: " + totalMaxFreq);
            return totalMaxFreq;
        }
    }


    public static class RotateArray {
        public void rotate(int[] nums, int k) {
            int n = nums.length;  // Get the length of the array
            System.out.println("Original array: " + Arrays.toString(nums));

            // Step 1: Handle cases where k > n (to avoid unnecessary rotations)
            k = k % n;  // Only rotate k % n times if k is larger than n
            System.out.println("Effective rotation steps (k % n): " + k);

            // Step 2: Reverse the entire array
            reverse(nums, 0, n - 1);
            System.out.println("Array after reversing entire array: " + Arrays.toString(nums));

            // Step 3: Reverse the first k elements
            reverse(nums, 0, k - 1);
            System.out.println("Array after reversing first " + k + " elements: " + Arrays.toString(nums));

            // Step 4: Reverse the remaining n - k elements
            reverse(nums, k, n - 1);
            System.out.println("Array after reversing remaining elements: " + Arrays.toString(nums));
        }

        // Helper function to reverse a portion of the array
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                System.out.println("Swapping nums[" + start + "] = " + nums[start] + " and nums[" + end + "] = " + nums[end]);

                // Swap the elements at the start and end indices
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                // Move the start index forward and the end index backward
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            RotateArray solution = new RotateArray();

            // Test Case 1
            int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
            int k1 = 3;
            System.out.println("\nTest Case 1:");
            solution.rotate(nums1, k1);

            // Test Case 2
            int[] nums2 = {-1, -100, 3, 99};
            int k2 = 2;
            System.out.println("\nTest Case 2:");
            solution.rotate(nums2, k2);
        }
    }


    public static class RemoveElements {
        public static void main(String[] args) {
            int[] nums = {3, 2, 2, 3};
            System.out.println("Input: " + java.util.Arrays.toString(nums));
            int val = 3;

            RemoveElements removeElements = new RemoveElements();
            int output = removeElements.removeElements(nums, val);

            System.out.println("Output (k): " + output);
            System.out.println("Modified Array: " + java.util.Arrays.toString(nums));
        }

        private int removeElements(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                System.out.println("Iteration " + i + ": ");
                System.out.println("nums[" + i + "] = " + nums[i] + ", k = " + k);

                if (nums[i] != val) {
                    nums[k] = nums[i];
                    System.out.println("Placing " + nums[i] + " at position " + k);
                    k++;
                }

                System.out.println("Current array: " + java.util.Arrays.toString(nums));
                System.out.println("--------------------------------");
            }
            return k;
        }
    }

}


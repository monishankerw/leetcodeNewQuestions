package com.leetcode.leetcode.companywiseQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PaytmCode {
    public static class ProductExceptSelf {
        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 4};
            int[] output = productExceptSelf(nums1);
            System.out.println("Output: " + Arrays.toString(output));
        }

        private static int[] productExceptSelf(int[] nums1) {
            int n = nums1.length;
            int ans[] = new int[n];

            int leftPro = 1;
            for (int i = 0; i < n; i++) {
                ans[i] = leftPro;
                leftPro *= nums1[i];
            }
            int rightPro = 1;
            for (int i = n - 1; i >= 0; i--) {
                ans[i] = rightPro;
                rightPro *= nums1[i];

            }
            return ans;
        }
    }

    public static class Sums {
        public static void main(String[] args) {
            int[] nums = {3, 2, 4};
            int target = 6;
            int[] output = sums(nums, target);
            System.out.println("OUtput: " + Arrays.toString(output));
        }

        private static int[] sums(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int comp = target - nums[i];
                if (map.containsKey(comp)) {
                    return new int[]{
                            map.get(comp), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static class FindDuplicate {

        // Method to find the duplicate number using Floyd's Tortoise and Hare algorithm
        public int findDuplicate(int[] nums) {
            // Step 1: Tortoise and Hare to find the intersection point
            int tortoise = nums[0];
            int hare = nums[0];

            // Phase 1: Move tortoise 1 step and hare 2 steps
            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);

            // Step 2: Move tortoise to the beginning and keep hare at the intersection
            tortoise = nums[0];

            // Phase 2: Move both tortoise and hare 1 step at a time
            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            // The point where tortoise and hare meet is the duplicate number
            return hare;
        }

        // Main method to test the findDuplicate method
        public static void main(String[] args) {
            FindDuplicate solution = new FindDuplicate();

            // Test case 1
            int[] nums1 = {1, 3, 4, 2, 2};
            System.out.println("Duplicate in nums1: " + solution.findDuplicate(nums1)); // Expected output: 2

            // Test case 2
            int[] nums2 = {3, 1, 3, 4, 2};
            System.out.println("Duplicate in nums2: " + solution.findDuplicate(nums2)); // Expected output: 3

            // Test case 3
            int[] nums3 = {3, 3, 3, 3, 3};
            System.out.println("Duplicate in nums3: " + solution.findDuplicate(nums3)); // Expected output: 3
        }
    }

    //best-time-to-buy-and-sell-stock
    public static class BestTimeToBuyAndSellStock {
        public static void main(String[] args) {
            BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

            int[] prices1 = {7, 1, 5, 3, 6, 4};
            System.out.println("Max Profit: " + bestTimeToBuyAndSellStock.maxProfits(prices1)); // Output: 5

        }

        private static int maxProfits(int[] prices1) {
            if (prices1 == null || prices1.length == 0)
                return 0;
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices1) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    maxProfit = Math.max(maxProfit, price - minPrice);
                }
            }
            return maxProfit;
        }
    }

    public static class LongestSubstring {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int maxLength = 0;
            System.out.println("Processing string: " + s);
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                System.out.println("\nStep " + right + ": Character '" + c + "'");
                if (map.containsKey(c) && map.get(c) >= left) {
                    System.out.println("  Character '" + c + "' found at index " + map.get(c) + " which is >= left " + left);
                    left = Math.max(left, map.get(c) + 1);
                    System.out.println("  Updating left to " + left);
                }
                map.put(c, right);
                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                System.out.println("  Current window: from " + left + " to " + right + " (substring: '" + s.substring(left, right + 1) + "')");
                System.out.println("  Current length: " + currentLength + ", Max length so far: " + maxLength);
            }
            return maxLength;
        }

        public static void main(String[] args) {
            LongestSubstring solution = new LongestSubstring();
            String s1 = "abcabcbb";
            System.out.println("\nTest case 1: " + s1);
            System.out.println("Result: " + solution.lengthOfLongestSubstring(s1));

            String s2 = "bbbbb";
            System.out.println("\nTest case 2: " + s2);
            System.out.println("Result: " + solution.lengthOfLongestSubstring(s2));

            String s3 = "pwwkew";
            System.out.println("\nTest case 3: " + s3);
            System.out.println("Result: " + solution.lengthOfLongestSubstring(s3));
        }
    }

    public static class MaxSubArray {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("Input array is empty or null.");
            }

            int currentMax = nums[0];
            int globalMax = nums[0];

            for (int i = 1; i < nums.length; i++) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                globalMax = Math.max(globalMax, currentMax);
            }

            return globalMax;
        }

        public static void main(String[] args) {
            MaxSubArray solution = new MaxSubArray();

            int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println("Test case 1: " + solution.maxSubArray(nums1)); // Output: 6

            int[] nums2 = {1};
            System.out.println("Test case 2: " + solution.maxSubArray(nums2)); // Output: 1

            int[] nums3 = {5, 4, -1, 7, 8};
            System.out.println("Test case 3: " + solution.maxSubArray(nums3)); // Output: 23

            int[] nums4 = {-2, -3, -1};
            System.out.println("Test case 4: " + solution.maxSubArray(nums4)); // Output: -1
        }
    }

    public static class TrappedWater {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }

            int left = 0;
            int right = height.length - 1;
            int maxLeft = height[left];
            int maxRight = height[right];
            int trappedWater = 0;

            while (left <= right) {
                if (maxLeft <= maxRight) {
                    if (height[left] < maxLeft) {
                        trappedWater += maxLeft - height[left];
                    } else {
                        maxLeft = height[left];
                    }
                    left++;
                } else {
                    if (height[right] < maxRight) {
                        trappedWater += maxRight - height[right];
                    } else {
                        maxRight = height[right];
                    }
                    right--;
                }
            }

            return trappedWater;
        }

        public static void main(String[] args) {
            TrappedWater solution = new TrappedWater();

            int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println("Test case 1: " + solution.trap(height1)); // Output: 6

            int[] height2 = {4, 2, 0, 3, 2, 5};
            System.out.println("Test case 2: " + solution.trap(height2)); // Output: 9

            int[] height3 = {5, 4, -1, 7, 8}; // Note: Negative values are not per problem constraints but handled by the code
            System.out.println("Test case 3: " + solution.trap(height3)); // Output: 23 (Assumed input typo)
        }
    }

    public static class ValidParentheses {
        public static void main(String[] args) {
            ValidParentheses validParentheses = new ValidParentheses();
            String input1 = "()";
            System.out.println("Case 1: " + validParentheses.isValidParentheses(input1));
            String input2 = "()[]{}";
            System.out.println("Case2: " + validParentheses.isValidParentheses(input2));
            String input3 = "(]";
            System.out.println("Case3: " + validParentheses.isValidParentheses(input3));
            String input4 = "([])";
            System.out.println("Case4: " + validParentheses.isValidParentheses(input4));
        }

        private Boolean isValidParentheses(String input1) {

            Stack<Character>stack=new Stack<>();
            for(char c:input1.toCharArray()){
                if(c=='('||c=='{'||c=='['){
                    stack.push(c);
                } else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char top=stack.pop();
                    if((c==')'&& top!='(')||
                            (c=='}'&& top!='{')||
                            (c==']' && top!='[')){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        }
    }



package com.leetcode.leetcode.leetcodesProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicsPrograming {
    public static class ClimbingStairs {
        public static void main(String[] args) {
            int n = 3;
            int output = climbingStairs(n);
            System.out.println("output:" + output);
        }

        private static int climbingStairs(int n) {
            if (n <= 1)
                return 1;
            int f = 1, s = 1, c = 0;
            for (int i = 2; i <= n; i++) {
                c = f + s;
                f = s;
                s = c;
            }
            return c;
        }
    }

    public static class HouseRobber {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 1};
            int output = houseRobber(nums);
            System.out.println("Output:" + output);
        }

        private static int houseRobber(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            int p1 = 0, p2 = 0;
            for (int num : nums) {
                int temp = p1;
                p1 = Math.max(p1, p2 + num);
                p2 = temp;
            }
            return p1;
        }
    }

    public static class MinCostClimbingStairs {
        public static void main(String[] args) {
            int[] costs = {10, 15, 20};
            int output = minCostClimbingStairs(costs);
            System.out.println("Output:" + output);
        }

        private static int minCostClimbingStairs(int[] costs) {
            int n = costs.length;
            if (n == 2) {
                return Math.min(costs[0], costs[1]);
            }
            int first = costs[0];
            int second = costs[1];
            for (int i = 2; i < n; i++) {

                int current = costs[i] + Math.min(first, second);
                first = second;
                second = current;
            }
            return Math.min(first, second);
        }
    }

    public static class HouseRobberII {
        public static void main(String[] args) {
            int[] arr = {2, 3, 2};
            int output = houseRobberII(arr);
            System.out.println("Output:" + output);
        }

        private static int houseRobberII(int[] arr) {
            int n = arr.length;
            if (n == 1) {
                return arr[0];

            }
            int maxProfit1 = robLinear(arr, 0, n - 2);
            int maxProfit2 = robLinear(arr, 1, n - 1);

            return Math.max(maxProfit1, maxProfit2);
        }


        private static int robLinear(int[] arr, int start, int end) {
            int prevTwo = 0;
            int prevOne = 0;
            for (int i = start; i <= end; i++) {
                int current = Math.max(prevOne, prevTwo + arr[i]);
                prevTwo = prevOne;
                prevOne = current;
            }
            return prevOne;
        }
    }

    public static class CoinChangesII {
        public static void main(String[] args) {
            int amount = 5;
            int[] coins = {1, 2, 5};
            int output = coinChangesII(amount, coins);
            System.out.println("Output:" + output);
        }

        private static int coinChangesII(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }

    public static class MaximumLengthOfRepatedSubarray {
        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 2, 1};
            int[] nums2 = {3, 2, 1, 4, 7};
            int output = maximumLengthOfRepatedSubarray(nums1, nums2);
            System.out.println("output:" + output);
        }

        private static int maximumLengthOfRepatedSubarray(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];
            int maxLength = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    }
                }
            }
            return maxLength;

        }
    }

    public static class LongestValidParentheses {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int n = s.length();
            int[] dp = new int[n];
            int maxLength = 0;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }

            return maxLength;
        }

        public static void main(String[] args) {
            LongestValidParentheses solution = new LongestValidParentheses();

            // Example 1
            System.out.println(solution.longestValidParentheses("(()")); // Output: 2

            // Example 2
            System.out.println(solution.longestValidParentheses(")()())")); // Output: 4

            // Example 3
            System.out.println(solution.longestValidParentheses("")); // Output: 0
        }
    }

    public static class OneAndZeroes {
        public static void main(String[] args) {
            // Input strings and constraints
            String[] str = {"10", "0001", "111001", "1", "0"};
            int m = 5, n = 3;

            // Creating an instance and invoking the function
            OneAndZeroes oneAndZeroes = new OneAndZeroes();
            String output = String.valueOf(oneAndZeroes.oneAndZeroess(str, m, n));
            System.out.println("Output: " + output); // Final output
        }

        private int oneAndZeroess(String[] str, int m, int n) {
            // Initialize a DP table with dimensions (m+1) x (n+1)
            int[][] dp = new int[m + 1][n + 1];

            // Process each string in the input array
            for (String strs : str) {
                // Count 0's and 1's in the current string
                int count0 = 0, count1 = 0;
                for (char c : strs.toCharArray()) {
                    if (c == '0') count0++;
                    else if (c == '1') count1++;
                }

                // Print counts for current string
                System.out.println("Processing string: " + strs);
                System.out.println("Count of 0's: " + count0 + ", Count of 1's: " + count1);

                // Update the DP table from bottom-right to top-left
                for (int i = m; i >= count0; i--) {
                    for (int j = n; j >= count1; j--) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count0][j - count1]);
                        System.out.println(
                                "Updated dp[" + i + "][" + j + "] = " + dp[i][j] +
                                        " using dp[" + (i - count0) + "][" + (j - count1) + "]");
                    }
                }

                // Print DP table after processing the string
                System.out.println("DP table after processing " + strs + ":");
                for (int[] row : dp) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            }

            // The final result is stored in dp[m][n]
            return dp[m][n];
        }
    }


    public static class Triangle {
        public static int minimumTotal(List<List<Integer>> triangle) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int minPath = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                    triangle.get(i).set(j, triangle.get(i).get(j) + minPath);
                }
            }
            return triangle.get(0).get(0);
        }

        public static void main(String[] args) {
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(Arrays.asList(2));
            triangle.add(Arrays.asList(3, 4));
            triangle.add(Arrays.asList(6, 5, 7));
            triangle.add(Arrays.asList(4, 1, 8, 3));

            int result = minimumTotal(triangle);
            System.out.println("Minimum Path Sum: " + result);
        }
    }
    public static class JumpGameII{
        public static void main(String[] args) {

        int input[]={2,3,1,1,4};
        JumpGameII jumpGameII=new JumpGameII();
     int output;
            output = jumpGameII.jumpGamesII(input);
            System.out.println("Output::"+output);
    }

        private int jumpGamesII(int[] input) {
            int n=input.length;
            if(n==1)
                return 0;
            int jumps=0;
            int farthest=0;
            int currentEnd=0;
            for (int i=0;i<n-1;i++){
                farthest=Math.max(farthest,i+input[i]);
                if(i==currentEnd){
                    jumps++;
                    currentEnd=farthest;
                    if(currentEnd>=n-1)
                        break;
                }
            }
            return jumps;
        }
        }
    }


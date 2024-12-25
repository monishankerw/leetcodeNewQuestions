
        package com.leetcode.leetcode.basics;

import java.util.*;


public class Basics {

    // 1. Reverse Number
    public static class ReverseNumber {
        public static void main(String[] args) {
            int rev = 0, num = 12345;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            System.out.println("Reversed Number: " + rev);
        }
    }

    // 2. Palindrome Number
    public static class PalindromeNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number:");
            int num = sc.nextInt();
            int orgNum = num, rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            if (orgNum == rev) {
                System.out.println("Palindrome Number");
            } else {
                System.out.println("Not a Palindrome Number");
            }
        }
    }

    // 3. Swapping with Third Variable
    public static class Swapping {
        public static void main(String[] args) {
            int a = 10, b = 20;
            System.out.println("Before Swapping: " + a + " " + b);
            int temp = a;
            a = b;
            b = temp;
            System.out.println("After Swapping: " + a + " " + b);
        }
    }

    // 4. Swapping without Third Variable
    public static class SwappingWithoutThirdVariable {
        public static void main(String[] args) {
            int a = 10, b = 20;
            System.out.println("Before Swapping: " + a + " " + b);
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println("After Swapping: " + a + " " + b);
        }
    }

    // 5. Fibonacci Series
    public static class FibonacciSeries {
        public static void main(String[] args) {
            int a = 0, b = 1, c;
            System.out.print(a + " " + b);
            for (int i = 1; i <= 6; i++) {
                c = a + b;
                System.out.print(" " + c);
                a = b;
                b = c;
            }
        }
    }

    // 6. Armstrong Number
    public static class ArmstrongNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number:");
            int num = sc.nextInt();
            int orgNum = num, sum = 0, r;
            while (num != 0) {
                r = num % 10;
                sum += r * r * r;
                num /= 10;
            }
            if (orgNum == sum) {
                System.out.println("Armstrong Number");
            } else {
                System.out.println("Not an Armstrong Number");
            }
        }
    }

    // 7. Prime Number
    public static class PrimeNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number:");
            int num = sc.nextInt();
            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num > 1) {
                System.out.println("Prime Number");
            } else {
                System.out.println("Not a Prime Number");
            }
        }
    }

    // 8. Remove Duplicate Elements
    public static class RemoveDuplicateElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 2, 7, 8, 8, 3};
            System.out.println("Duplicate Elements in Array:");
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.println(arr[j]);
                    }
                }
            }
        }
    }

    // 9. Maximum and Minimum Elements in Array
    public static class MaxMinElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 7, 9, 20};
            int max = arr[0], min = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
                if (num < min) min = num;
            }
            System.out.println("Minimum Element: " + min);
            System.out.println("Maximum Element: " + max);
        }
    }

    // 10. Sorting Numbers
    public static class SortingNumbers {
        public static void main(String[] args) {
            int[] arr = {43, 6, 1, 4, 2, 7};
            Arrays.sort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        }
    }

    // 11. Second Largest Element
    public static class SecondLargestElement {
        public static void main(String[] args) {
            int[] arr = {2, 6, 3, 4, 5, 1};
            Arrays.sort(arr);
            System.out.println("Second Largest Element: " + arr[arr.length - 2]);
        }
    }

    // 12. Move Negative Numbers to One Side
    public static class MoveNegative {
        public static void main(String[] args) {
            int[] arr = {1, -2, 3, -5, 4, -7};
            Arrays.sort(arr);
            System.out.println("Array After Moving Negatives: " + Arrays.toString(arr));
        }
    }

    // 13. Move Zeroes to One Side
    public static class MoveZeroes {
        public static void main(String[] args) {
            int[] arr = {1, 0, 3, 0, 45, 0};
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    index++;
                }
            }
            System.out.println("Array After Moving Zeroes: " + Arrays.toString(arr));
        }
    }

    // 14. Frequency of Each Element in Array
    public static class FrequencyOfElements {
        public static void main(String[] args) {
            int[] arr = {10, 10, 20, 30, 20, 5, 10};
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            //freqMap.forEach((key, value) -> System.out.println(key + " -> " + value));
            System.out.println(freqMap);
        }
    }

    //15. count pair
    public static class CountPair {
        public static void main(String[] args) {
            int arr[] = {1, 2, 4, -1, -6, -2};
            int sum = 3;
            countpair(arr, sum);
        }

        private static void countpair(int[] arr, int sum) {
            int count = 0;
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr.length; j++)
                    if (arr[i] + arr[j] == sum)
                        count++;
            System.out.println(count);

        }
    }
//16.rotates arrays
    public static class Roatatearray {
        public static void main(String[] args) {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            int n = 3, j;
            for (int i = 0; i < n; i++) {
                int first = arr[0];
                for (j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                arr[j] = first;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i] + " ");
            }
        }
    }

    //17. Intersection
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
//18. singleturn class
    public static final class A {
        public static A a1 = null;

        private A() {
        }

        public static A getInstance() {
            if (a1 == null) {
                A a1 = new A();
                return a1;
            }
            return a1;
        }


        public static void main(String[] args) {
            A a1 = A.getInstance();
            A a2 = A.getInstance();
            System.out.println(a1);
            System.out.println(a2);
        }
    }

    //19. sum of arrays
    public static class Sum {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5}; // Initialize the array
            sum(arr); // Call the sum method
        }

        // Method to calculate and print the sum of elements in the array
        private static void sum(int[] arr) {
            int sum = 0;
            for (int num : arr) { // Enhanced for-loop for readability
                sum += num; // Add each element to the sum
            }
            System.out.println("The sum of the array elements is: " + sum);
        }
    }

    //20. subset
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

        //21. reverse array
        public static class ReverseArray {
            public static void main(String[] args) {
                int[] arr = {1, 2, 3, 4, 5, 6};
                System.out.println("Original Array: " + Arrays.toString(arr));
                reverseArray(arr);
                System.out.println("Reversed Array: " + Arrays.toString(arr));
            }

            private static void reverseArray(int[] arr) {
                int left = 0, right = arr.length - 1;
                while (left < right) {
                    // Swap elements
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
        }
    }

    //22. trappping rainwater
    public static class TrappingRainwater {
        public static void main(String[] args) {
            int arr[] = {6, 9, 9};
            System.out.println("Maximum Trapped Water: " + maxTrappingWater(arr));
        }

        private static int maxTrappingWater(int[] arr) {
            int n = arr.length;
            if (n < 3) return 0; // No trapping possible with less than 3 elements

            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            // Fill leftMax array
            leftMax[0] = arr[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
            }

            // Fill rightMax array
            rightMax[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
            }

            // Calculate total water trapped
            int totalWater = 0;
            for (int i = 0; i < n; i++) {
                totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
            }

            return totalWater;
        }

        //23. subarrays
       public static class Subarrays {
            static int arr[] = {1, 2, 3, 4};

            // Method to print all subarrays
            public static void subArray(int n) {
                // Pick starting point
                for (int i = 0; i < n; i++) {
                    // Pick ending point
                    for (int j = i; j < n; j++) {
                        // Print subarray between i and j
                        for (int k = i; k <= j; k++) {
                            System.out.print(arr[k] + " ");
                        }
                        System.out.println(); // New line after each subarray
                    }
                }
            }

            public static void main(String[] args) {
                System.out.println("All Non-empty Subarrays:");
                subArray(arr.length);
            }
        }
    }
}


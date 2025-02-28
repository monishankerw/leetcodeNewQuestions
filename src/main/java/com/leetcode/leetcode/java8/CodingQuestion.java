package com.leetcode.leetcode.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingQuestion {

    public static class SumArray {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};

            // Using Java 8 Streams
            int sumJava8 = Arrays.stream(arr1).sum();
            System.out.println("Sum using Java 8: " + sumJava8);

            // Using Traditional Loop (Without Java 8)
            int sum = 0;
            for (int num : arr1) {
                sum += num;
            }
            System.out.println("Sum without Java 8: " + sum);
        }
    }
    public static class MaxArray {

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};

            // Using Java 8 Streams
            int maxJava8 = Arrays.stream(arr1).max().orElse(0);
            System.out.println("Max using Java 8: " + maxJava8);

            // Using Traditional Loop (Without Java 8)
            int max = arr1[0]; // Assume first element is max
            for (int num : arr1) {
                if (num > max) {
                    max = num;
                }
            }
            System.out.println("Max without Java 8: " + max);
        }
    }
    public static class MinArray {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};

            // Using Java 8 Streams
            int minJava8 = Arrays.stream(arr1).min().orElse(0);
            System.out.println("Min using Java 8: " + minJava8);

            // Using Traditional Loop (Without Java 8)
            int min = arr1[0]; // Assume first element is min
            for (int num : arr1) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("Min without Java 8: " + min);
        }
    }

    public static class SumEven {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};

            // Using Java 8 Streams
            int sumEvenJava8 = Arrays.stream(arr1)
                    .filter(n -> n % 2 == 0) // Filter even numbers
                    .sum(); // Sum them
            System.out.println("Sum of evens using Java 8: " + sumEvenJava8);

            // Using Traditional Loop (Without Java 8)
            int sumEven = 0;
            for (int num : arr1) {
                if (num % 2 == 0) { // Check if even
                    sumEven += num;
                }
            }
            System.out.println("Sum of evens without Java 8: " + sumEven);
        }
    }

    public static class CheckDuplicates {
        public static void main(String[] args) {
            int[] arr2 = {1, 2, 3, 2};

            // Using Java 8 Streams
            boolean hasDuplicatesJava8 = Arrays.stream(arr2)
                    .distinct() // Removes duplicates
                    .count() != arr2.length; // Compare count
            System.out.println("Has duplicates using Java 8: " + hasDuplicatesJava8);

            // Using Traditional Loop (Without Java 8)
            boolean hasDuplicates = false;
            Set<Integer> seenNumbers = new HashSet<>();
            for (int num : arr2) {
                if (!seenNumbers.add(num)) { // If already exists in set, it's a duplicate
                    hasDuplicates = true;
                    break;
                }
            }
            System.out.println("Has duplicates without Java 8: " + hasDuplicates);
        }
    }

    public static class RemoveDuplicates {
        public static void main(String[] args) {
            int[] arr2 = {1, 2, 3, 2};

            // Using Java 8 Streams
            int[] uniqueJava8 = Arrays.stream(arr2)
                    .distinct() // Removes duplicates
                    .toArray(); // Converts back to array
            System.out.println("Unique array using Java 8: " + Arrays.toString(uniqueJava8));

            // Using Traditional Approach (Without Java 8)
            Set<Integer> uniqueSet = new LinkedHashSet<>(); // Maintains order
            for (int num : arr2) {
                uniqueSet.add(num); // Set ensures uniqueness
            }
            int[] unique = uniqueSet.stream().mapToInt(Integer::intValue).toArray();
            System.out.println("Unique array without Java 8: " + Arrays.toString(unique));
        }
    }


    public static class SecondLargestElement {
        public static void main(String[] args) {
            int[] arr3 = {5, 2, 8, 3};

            // Using Java 8 Streams
            int secondLargestJava8 = Arrays.stream(arr3)
                    .distinct() // Remove duplicates
                    .sorted() // Sort in ascending order
                    .skip(arr3.length - 2) // Skip to second last element
                    .findFirst()
                    .orElse(-1); // Default value if not found
            System.out.println("Second largest using Java 8: " + secondLargestJava8);

            // Using Traditional Approach (Without Java 8)
            if (arr3.length < 2) {
                System.out.println("Second largest without Java 8: -1");
                return;
            }

            int largest = Integer.MIN_VALUE, secondLargestTraditional = Integer.MIN_VALUE;
            for (int num : arr3) {
                if (num > largest) {
                    secondLargestTraditional = largest;
                    largest = num;
                } else if (num > secondLargestTraditional && num < largest) {
                    secondLargestTraditional = num;
                }
            }

            System.out.println("Second largest without Java 8: " + (secondLargestTraditional == Integer.MIN_VALUE ? -1 : secondLargestTraditional));
        }
    }

    public static class FrequencyOfElements {
        public static void main(String[] args) {
            int[] freqArr = {1, 2, 2, 3, 3, 3};

            // Using Java 8 Streams
            Map<Integer, Long> frequencyJava8 = Arrays.stream(freqArr)
                    .boxed() // Convert int to Integer
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
            System.out.println("Frequency map using Java 8: " + frequencyJava8);

            // Using Traditional Approach (Without Java 8)
            Map<Integer, Integer> frequencyTraditional = new HashMap<>();
            for (int num : freqArr) {
                frequencyTraditional.put(num, frequencyTraditional.getOrDefault(num, 0) + 1);
            }
            System.out.println("Frequency map without Java 8: " + frequencyTraditional);
        }
    }

    public static class ArrayIntersection {
        public static void main(String[] args) {
            int[] arr6 = {1, 2, 2, 3, 4}; // First array
            int[] arr7 = {2, 3, 5};       // Second array

            // Using Java 8 Streams
            Set<Integer> set = Arrays.stream(arr7) // Convert arr7 to a set for quick lookup
                    .boxed()
                    .collect(Collectors.toSet());
            int[] intersectionJava8 = Arrays.stream(arr6)
                    .filter(set::contains) // Retain only elements in set
                    .distinct() // Remove duplicates
                    .toArray();
            System.out.println("Intersection using Java 8: " + Arrays.toString(intersectionJava8));

            // Using Traditional Approach (Without Java 8)
            Set<Integer> setTraditional = new HashSet<>();
            for (int num : arr7) {
                setTraditional.add(num); // Store elements of arr7 in a set
            }

            Set<Integer> intersectionSet = new HashSet<>();
            for (int num : arr6) {
                if (setTraditional.contains(num)) { // Check if num exists in arr7
                    intersectionSet.add(num); // Use set to avoid duplicates
                }
            }

            int[] intersectionTraditional = intersectionSet.stream().mapToInt(Integer::intValue).toArray();
            System.out.println("Intersection without Java 8: " + Arrays.toString(intersectionTraditional));
        }
    }

    public static class ArrayOperations {
        public static void main(String[] args) {
            // 17. Multiply Corresponding Elements
            int[] arr8 = {1, 2, 3};
            int[] arr9 = {4, 5, 6};

            // Using Java 8 Streams
            int[] productJava8 = IntStream.range(0, Math.min(arr8.length, arr9.length))
                    .map(i -> arr8[i] * arr9[i])
                    .toArray();
            System.out.println("Element-wise product using Java 8: " + Arrays.toString(productJava8));

            // Using Traditional Approach (Without Java 8)
            int minLength = Math.min(arr8.length, arr9.length);
            int[] productTraditional = new int[minLength];
            for (int i = 0; i < minLength; i++) {
                productTraditional[i] = arr8[i] * arr9[i];
            }
            System.out.println("Element-wise product without Java 8: " + Arrays.toString(productTraditional));

            // 18. Longest Consecutive Sequence
            int[] seqArr = {100, 4, 200, 1, 3, 2};

            // Using Java 8 Streams
            Set<Integer> numSet = Arrays.stream(seqArr).boxed().collect(Collectors.toSet());
            int longestJava8 = Arrays.stream(seqArr)
                    .filter(num -> !numSet.contains(num - 1)) // Start of a sequence
                    .map(num -> {
                        int current = num, count = 0;
                        while (numSet.contains(current)) {
                            count++;
                            current++;
                        }
                        return count;
                    })
                    .max()
                    .orElse(0);
            System.out.println("Longest consecutive sequence using Java 8: " + longestJava8);

            // Using Traditional Approach (Without Java 8)
            Set<Integer> numSetTraditional = new HashSet<>();
            for (int num : seqArr) {
                numSetTraditional.add(num);
            }

            int longestTraditional = 0;
            for (int num : seqArr) {
                if (!numSetTraditional.contains(num - 1)) { // Start of a sequence
                    int currentNum = num, count = 0;
                    while (numSetTraditional.contains(currentNum)) {
                        count++;
                        currentNum++;
                    }
                    longestTraditional = Math.max(longestTraditional, count);
                }
            }
            System.out.println("Longest consecutive sequence without Java 8: " + longestTraditional);
        }
    }

    public static class ArrayOperationss {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};

            // 19. Find Missing Number
            int[] missingArr = {1, 2, 4, 5};
            int n = missingArr.length + 1;

            // Java 8
            int missingJava8 = n * (n + 1) / 2 - Arrays.stream(missingArr).sum();
            System.out.println("Missing number (Java 8): " + missingJava8);

            // Traditional Approach
            int total = n * (n + 1) / 2, sum = 0;
            for (int num : missingArr) sum += num;
            int missingTraditional = total - sum;
            System.out.println("Missing number (Traditional): " + missingTraditional);

            // 20. Check Anagram Arrays
            int[] anagram1 = {1, 2, 3}, anagram2 = {3, 2, 1};
            boolean isAnagram = Arrays.equals(Arrays.stream(anagram1).sorted().toArray(),
                    Arrays.stream(anagram2).sorted().toArray());
            System.out.println("Are anagrams: " + isAnagram);

            // 21. Flatten a 2D Array
            int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
            int[] flattened = Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray();
            System.out.println("Flattened 2D array: " + Arrays.toString(flattened));

            // 22. First Non-Repeated Element
            int[] repeatArr = {1, 2, 3, 2, 1, 4};
            Map<Integer, Long> frequencyMap = Arrays.stream(repeatArr)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
            int firstUnique = frequencyMap.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(-1);
            System.out.println("First non-repeated: " + firstUnique);

            // 23. Partition Even and Odd Numbers
            Map<Boolean, List<Integer>> partitioned = Arrays.stream(arr1)
                    .boxed()
                    .collect(Collectors.partitioningBy(n1 -> n1 % 2 == 0));
            System.out.println("Partitioned (even, odd): " + partitioned);

            // 24. Validate All Positive Numbers
            boolean allPositive = Arrays.stream(arr1).allMatch(n2 -> n2 > 0);
            System.out.println("All elements positive: " + allPositive);

            // 25. Convert String Array to Uppercase
            String[] words = {"java", "streams", "interview"};
            String[] upperWords = Arrays.stream(words).map(String::toUpperCase).toArray(String[]::new);
            System.out.println("Uppercase strings: " + Arrays.toString(upperWords));

            // 26. Find Kth Smallest Element
            int k1 = 3;
            int[] unsorted = {9, 3, 5, 1, 7};
            int kthSmallest = Arrays.stream(unsorted)
                    .sorted()
                    .skip(k1 - 1)
                    .findFirst()
                    .orElse(-1);
            System.out.println("3rd smallest element: " + kthSmallest);

            // 27. Sum of Squares of Even Numbers
            int sumOfSquares = Arrays.stream(arr1)
                    .filter(n3 -> n3 % 2 == 0)
                    .map(n3 -> n3 * n3)
                    .sum();
            System.out.println("Sum of squares of evens: " + sumOfSquares);

            // 28. Count Occurrences of a Specific Element
            int target = 2;
            long count = Arrays.stream(arr1).filter(n4 -> n4 == target).count();
            System.out.println("Count of " + target + ": " + count);

            // 29. Longest String in an Array
            String[] strings = {"apple", "banana", "kiwi"};
            String longest1 = Arrays.stream(strings).reduce((a, b) -> a.length() > b.length() ? a : b).orElse("");
            System.out.println("Longest string: " + longest1);
        }
    }


    public static class StreamOperations {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 2, 3, 3, 1}; // Sample input

            // 32. Convert Primitive Array to List
            List<Integer> list = Arrays.stream(arr1)
                    .boxed()
                    .collect(Collectors.toList());
            System.out.println("32. Array as list: " + list);

            // 33. Most Frequent Element
            Map<Integer, Long> freqMap = Arrays.stream(arr1)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

            int mostFrequent = freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(-1);
            System.out.println("33. Most frequent element: " + mostFrequent);

            // 34. Square Every Element
            int[] squared = Arrays.stream(arr1)
                    .map(n -> n * n)
                    .toArray();
            System.out.println("34. Squared array: " + Arrays.toString(squared));

            // 35. Find All Pairs with Given Sum
            int targetSum = 5;
            Set<Integer> seen = new HashSet<>();
            List<String> pairs = Arrays.stream(arr1)
                    .boxed()
                    .flatMap(x -> {
                        if (seen.contains(targetSum - x)) {
                            return Stream.of("(" + x + ", " + (targetSum - x) + ")");
                        } else {
                            seen.add(x);
                            return Stream.empty();
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println("35. Pairs summing to " + targetSum + ": " + pairs);

            // 36. Convert List to Primitive Array
            List<Integer> integerList = Arrays.asList(1, 2, 3);
            int[] primitiveArray = integerList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            System.out.println("36. List to array: " + Arrays.toString(primitiveArray));

            // 37. Check If Any Element Satisfies Condition
            boolean anyGreaterThan10 = Arrays.stream(arr1).anyMatch(n -> n > 10);
            System.out.println("37. Any element > 10: " + anyGreaterThan10);

            // 38. Sum of Elements Greater Than Threshold
            int threshold = 2;
            int sumAboveThreshold = Arrays.stream(arr1)
                    .filter(n -> n > threshold)
                    .sum();
            System.out.println("38. Sum above " + threshold + ": " + sumAboveThreshold);
        }
    }

    public static class CommonElementsJava8 {

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 5, 4};
            int[] arr2 = {3, 5, 6, 7};

            List<Integer> outputs = findCommonElements(arr1, arr2);
            System.out.println("Common Elements (Without Java 8): " + outputs);

            List<Integer> output = commonElementsJava8(arr1, arr2);
            System.out.println("Common Elements (With Java 8 Streams): " + output);
        }

        /**
         * Find common elements using Java 8 Streams.
         *
         * @param arr1 First array
         * @param arr2 Second array
         * @return List of common elements
         */
        private static List<Integer> commonElementsJava8(int[] arr1, int[] arr2) {
            return Arrays.stream(arr1)  // Convert arr1 to a stream
                    .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))  // Filter elements that exist in arr2
                    .boxed()  // Convert int values to Integer objects
                    .collect(Collectors.toList());  // Collect results into a List<Integer>
        }

        /**
         * Find common elements without Java 8 Streams.
         *
         * @param arr1 First array
         * @param arr2 Second array
         * @return List of common elements
         */
        private static List<Integer> findCommonElements(int[] arr1, int[] arr2) {
            List<Integer> commonList = new ArrayList<>();

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr1[i] == arr2[j] && !commonList.contains(arr1[i])) { // Check for common element & avoid duplicates
                        commonList.add(arr1[i]);
                        break; // Stop checking once a match is found
                    }
                }
            }
            return commonList; // ✅ Added return statement
        }
    }

    public static class ArraySplitExample {
        public static void main(String[] args) {
            int[] arr1 = {1, 6, 3, 8, 5, 9, 4};

            // 40. Split Array into Two Based on Condition (Java 8 Approach)
            Map<Boolean, List<Integer>> splitJava8 = Arrays.stream(arr1)
                    .boxed()
                    .collect(Collectors.partitioningBy(n -> n <= 5));
            System.out.println("40. Split (Java 8) (≤5, >5): " + splitJava8);

            // 40. Split Array into Two Based on Condition (Traditional Approach)
            List<Integer> lessThanOrEqualTo5 = new ArrayList<>();
            List<Integer> greaterThan5 = new ArrayList<>();

            for (int num : arr1) {
                if (num <= 5) {
                    lessThanOrEqualTo5.add(num);
                } else {
                    greaterThan5.add(num);
                }
            }
            System.out.println("40. Split (Traditional) (≤5): " + lessThanOrEqualTo5);
            System.out.println("40. Split (Traditional) (>5): " + greaterThan5);
        }
    }

    public static class ReverseArrayExample {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};

            // 1. Using Java 8 Streams
            int[] reversedStream = IntStream.range(0, arr.length)
                    .map(i -> arr[arr.length - 1 - i])
                    .toArray();
            System.out.println("Reversed array (Java 8 Streams): " + Arrays.toString(reversedStream));

            // 2. Using a Traditional Loop
            int[] reversedLoop = reverseUsingLoop(arr);
            System.out.println("Reversed array (Traditional Loop): " + Arrays.toString(reversedLoop));

            // 3. In-Place Reversal
            reverseInPlace(arr);
            System.out.println("Reversed array (In-Place): " + Arrays.toString(arr));
        }

        // Method 1: Reverse using a traditional loop
        public static int[] reverseUsingLoop(int[] arr) {
            int n = arr.length;
            int[] reversed = new int[n];

            for (int i = 0; i < n; i++) {
                reversed[i] = arr[n - 1 - i];
            }
            return reversed;
        }

        // Method 2: Reverse the array in place
        public static void reverseInPlace(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static class RotateArrayExample {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int k = 2; // Number of positions to rotate

            // 1. Java 8 Streams
            int[] rotatedStream = IntStream.range(0, arr.length)
                    .map(i -> arr[(i + arr.length - k) % arr.length])
                    .toArray();
            System.out.println("Rotated array (Java 8 Streams): " + Arrays.toString(rotatedStream));

            // 2. Using Extra Array
            int[] rotatedExtra = rotateUsingExtraArray(arr, k);
            System.out.println("Rotated array (Using Extra Array): " + Arrays.toString(rotatedExtra));

            // 3. In-Place Rotation (Reversal Algorithm)
            reverseInPlace(arr, k);
            System.out.println("Rotated array (In-Place Reversal Algorithm): " + Arrays.toString(arr));
        }

        // Method 1: Rotate using an extra array (O(n) Time, O(n) Space)
        public static int[] rotateUsingExtraArray(int[] arr, int k) {
            int n = arr.length;
            int[] rotated = new int[n];

            for (int i = 0; i < n; i++) {
                rotated[(i + k) % n] = arr[i];
            }
            return rotated;
        }

        // Method 2: In-Place Rotation using Reversal Algorithm (O(n) Time, O(1) Space)
        public static void reverseInPlace(int[] arr, int k) {
            int n = arr.length;
            k = k % n; // Handle k > n cases

            reverse(arr, 0, n - 1);   // Reverse the entire array
            reverse(arr, 0, k - 1);   // Reverse first k elements
            reverse(arr, k, n - 1);   // Reverse the remaining elements
        }

        // Helper method to reverse an array in place
        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static class MergeSortedArraysExample {
        public static void main(String[] args) {
            int[] arr1 = {1, 3, 5};
            int[] arr2 = {2, 4, 6};

            // 1. Java 8 Streams
            int[] mergedStream = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                    .sorted()
                    .toArray();
            System.out.println("Merged array (Java 8 Streams): " + Arrays.toString(mergedStream));

            // 2. Merge using Two Pointer Approach
            int[] mergedTwoPointer = mergeUsingTwoPointers(arr1, arr2);
            System.out.println("Merged array (Two Pointer Approach): " + Arrays.toString(mergedTwoPointer));
        }

        // Method 1: Two Pointer Approach (O(n) Time, O(n) Space)
        public static int[] mergeUsingTwoPointers(int[] arr1, int[] arr2) {
            int n1 = arr1.length, n2 = arr2.length;
            int[] merged = new int[n1 + n2];
            int i = 0, j = 0, k = 0;

            while (i < n1 && j < n2) {
                if (arr1[i] < arr2[j]) {
                    merged[k++] = arr1[i++];
                } else {
                    merged[k++] = arr2[j++];
                }
            }
            while (i < n1) {
                merged[k++] = arr1[i++];
            }
            while (j < n2) {
                merged[k++] = arr2[j++];
            }
            return merged;
        }
    }



    public static class PalindromeArrayCheck {
        public static void main(String[] args) {
            int[] palindromeArray = {1, 2, 3, 2, 1};
            int[] nonPalindromeArray = {1, 2, 3, 4, 5};

            // 1. Java 8 Approach
            boolean isPalindromeJava8 = isPalindromeUsingStreams(palindromeArray);
            System.out.println("Is palindrome (Java 8 Streams): " + isPalindromeJava8);

            // 2. Iterative Approach
            boolean isPalindromeIterative = isPalindromeUsingLoop(palindromeArray);
            System.out.println("Is palindrome (Iterative Approach): " + isPalindromeIterative);

            // Testing with a non-palindrome array
            System.out.println("Is palindrome (Non-palindrome test - Java 8): " + isPalindromeUsingStreams(nonPalindromeArray));
            System.out.println("Is palindrome (Non-palindrome test - Iterative): " + isPalindromeUsingLoop(nonPalindromeArray));
        }

        // Method 1: Java 8 Streams Approach
        public static boolean isPalindromeUsingStreams(int[] arr) {
            return IntStream.range(0, arr.length / 2)
                    .allMatch(i -> arr[i] == arr[arr.length - 1 - i]);
        }

        // Method 2: Two-Pointer Iterative Approach (O(n) Time, O(1) Space)
        public static boolean isPalindromeUsingLoop(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                if (arr[left] != arr[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }


    public static class MultiplyCorrespondingElements {
        public static void main(String[] args) {
            int[] arr8 = {1, 2, 3};
            int[] arr9 = {4, 5, 6};

            // 1. Java 8 Approach
            int[] productJava8 = multiplyUsingStreams(arr8, arr9);
            System.out.println("Element-wise product (Java 8 Streams): " + Arrays.toString(productJava8));

            // 2. Iterative Approach
            int[] productIterative = multiplyUsingLoop(arr8, arr9);
            System.out.println("Element-wise product (Iterative Approach): " + Arrays.toString(productIterative));
        }

        // Method 1: Java 8 Streams Approach
        public static int[] multiplyUsingStreams(int[] arr1, int[] arr2) {
            return IntStream.range(0, Math.min(arr1.length, arr2.length))
                    .map(i -> arr1[i] * arr2[i])
                    .toArray();
        }

        // Method 2: Iterative Approach
        public static int[] multiplyUsingLoop(int[] arr1, int[] arr2) {
            int minLength = Math.min(arr1.length, arr2.length);
            int[] product = new int[minLength];

            for (int i = 0; i < minLength; i++) {
                product[i] = arr1[i] * arr2[i];
            }
            return product;
        }
    }

    public static class MergeAndDeduplicateArrays {
        public static void main(String[] args) {
            int[] mergeArr1 = {1, 2, 3};
            int[] mergeArr2 = {3, 4, 5};

            // 1. Java 8 Approach
            int[] mergedUniqueJava8 = mergeAndDeduplicateUsingStreams(mergeArr1, mergeArr2);
            System.out.println("Merged unique (Java 8 Streams): " + Arrays.toString(mergedUniqueJava8));

            // 2. Iterative Approach
            int[] mergedUniqueIterative = mergeAndDeduplicateUsingSet(mergeArr1, mergeArr2);
            System.out.println("Merged unique (Iterative Approach): " + Arrays.toString(mergedUniqueIterative));
        }

        // Method 1: Java 8 Streams Approach
        public static int[] mergeAndDeduplicateUsingStreams(int[] arr1, int[] arr2) {
            return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                    .distinct()  // Removes duplicates
                    .toArray();
        }

        // Method 2: Iterative Approach using Set
        public static int[] mergeAndDeduplicateUsingSet(int[] arr1, int[] arr2) {
            Set<Integer> set = new LinkedHashSet<>();  // Preserves order and removes duplicates

            for (int num : arr1) {
                set.add(num);
            }
            for (int num : arr2) {
                set.add(num);
            }

            return set.stream().mapToInt(Integer::intValue).toArray();
        }
    }



    public static class FindElementIndex {
        public static void main(String[] args) {
            int[] arr1 = {5, 1, 3, 7, 9};
            int searchElement = 3;

            // 1. Java 8 Approach
            int indexJava8 = findIndexUsingStreams(arr1, searchElement);
            System.out.println("Index of " + searchElement + " (Java 8 Streams): " + indexJava8);

            // 2. Iterative Approach
            int indexIterative = findIndexUsingLoop(arr1, searchElement);
            System.out.println("Index of " + searchElement + " (Iterative Approach): " + indexIterative);
        }

        // Method 1: Java 8 Streams Approach
        public static int findIndexUsingStreams(int[] arr, int target) {
            return IntStream.range(0, arr.length)
                    .filter(i -> arr[i] == target)
                    .findFirst()
                    .orElse(-1);
        }

        // Method 2: Iterative Approach using a simple loop
        public static int findIndexUsingLoop(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1; // Return -1 if the element is not found
        }
    }

   public static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }

        // Method 2: Traditional Comparable Approach (Non-Java 8)
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }

    public static class SortCustomObjects {
        public static void main(String[] args) {
            Person[] people = {
                    new Person("Alice", 30),
                    new Person("Bob", 25),
                    new Person("Charlie", 35)
            };

            // 1️⃣ Java 8 Approach - Sorting using Lambda Expression
            Arrays.sort(people, Comparator.comparingInt(Person::getAge));
            System.out.println("Sorted (Java 8 Lambda): " + Arrays.toString(people));

            // 2️⃣ Traditional Comparable Approach
            Arrays.sort(people);
            System.out.println("Sorted (Traditional Comparable): " + Arrays.toString(people));
        }
    }

}

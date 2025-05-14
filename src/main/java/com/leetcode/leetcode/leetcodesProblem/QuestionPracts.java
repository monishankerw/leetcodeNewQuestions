package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionPracts {
    public static class LoopArrayBasics {
        public static void main(String[] args) {

            // 1. Print all elements of an array using for loop
            int[] arr = {1, 2, 3, 4, 5};
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

            // 2. Find the sum of array elements
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println("Sum: " + sum);

            // 3. Find the largest element
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            System.out.println("Max: " + max);

            // 4. Find the smallest element
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) min = arr[i];
            }
            System.out.println("Min: " + min);

            // 5. Reverse the array
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // 6. Count even and odd numbers
            int even = 0, odd = 0;
            for (int i : arr) {
                if (i % 2 == 0) even++;
                else odd++;
            }
            System.out.println("Even: " + even + ", Odd: " + odd);

            // 7. Print array elements using while loop
            int i = 0;
            while (i < arr.length) {
                System.out.println(arr[i]);
                i++;
            }

            // 8. Print array using do-while
            i = 0;
            do {
                System.out.println(arr[i]);
                i++;
            } while (i < arr.length);

            // 9. Find index of element 3
            for (i = 0; i < arr.length; i++) {
                if (arr[i] == 3) {
                    System.out.println("Index of 3: " + i);
                    break;
                }
            }

            // 10. Copy array
            int[] copy = new int[arr.length];
            for (i = 0; i < arr.length; i++) {
                copy[i] = arr[i];
            }

            // 11. Count occurrences of 2
            int count = 0;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] == 2) count++;
            }
            System.out.println("2 appears: " + count + " times");

            // 12. Sort array (basic bubble sort)
            int[] a = {5, 3, 1, 4, 2};
            for (i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }

            // 13. Print only even elements
            for (int num : arr) {
                if (num % 2 == 0) System.out.println(num);
            }

            // 14. Print alternate elements
            for (i = 0; i < arr.length; i += 2) {
                System.out.println(arr[i]);
            }

            // 15. Find second largest
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
            for (int num : arr) {
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num > second && num != first) {
                    second = num;
                }
            }
            System.out.println("Second largest: " + second);

            // 16. Calculate average
            sum = 0;
            for (int num : arr) sum += num;
            System.out.println("Average: " + (double) sum / arr.length);

            // 17. Check if array is sorted
            boolean isSorted = true;
            for (i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    isSorted = false;
                    break;
                }
            }
            System.out.println("Sorted: " + isSorted);

            // 18. Shift array left by 1
            int firstElem = arr[0];
            for (i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = firstElem;

            // 19. Count prime numbers in array
            int primeCount = 0;
            for (int num : arr) {
                if (isPrime(num)) primeCount++;
            }
            System.out.println("Prime count: " + primeCount);

            // 20. Print all pairs in array
            for (i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }

        // Helper method for checking prime
        public static boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static class Swapping {
        public static void main(String[] args) {
            int a = 10, b = 20;
            System.out.print("Before Swapping:" + a + " " + b + " " + swappingThreeVariables(a, b));
            System.out.print("Before Swapping:" + a + " " + b + " " + swappingTwoVariables(a, b));

        }


        //swapping using third variable
        private static String swappingThreeVariables(int a, int b) {
            int c = a;
            a = b;
            b = c;
            return "After Swapping" + a + " " + b;
        }
    }

    //swapping using two variable
    private static String swappingTwoVariables(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return "After Swapping" + a + " " + b;
    }

    //Factorial of n is the product of all positive
    public static class Factorial {
        public static void main(String[] args) {
            int num = 12;
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact = fact * i;

            }
            System.out.println(num + " :" + fact);

        }
    }

    //Array Partition

    public static class ArrayPartition {
        public static void main(String[] args) {
            int[] arr = {1, 4, 2, 3};
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < arr.length; i += 2) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }

    // Largest Number Finder
    public static class LargestNumber {
        public static void main(String[] args) {
            int num1 = 7, num2 = 9, num3 = 10;
            if (num1 >= num2 && num2 >= num3) {
                System.out.println(num1 + "num1 is greater");
            } else if (num2 >= num1 && num2 >= num3) {
                System.out.println(num1 + "num2 is greater");
            } else {
                System.out.println(num3 + "num3 is greater");

            }
        }
    }

    // sum of digits
    public static class SumOfDigits {
        public static void main(String[] args) {
            int num = 987;
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            System.out.println(sum);
        }
    }

    //count Digits
    public static class CountDigits {
        public static void main(String[] args) {
            int count = 0;
            long num = 29845315;
            long temp = num;
            while (temp != 0) {
                temp /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    // Armstrong Number
    public static class ArmstrongNumber {
        public static void main(String[] args) {
            int num = 153;
            int org_num = num;
            int sum = 0, r;
            while (num != 0) {
                r = num % 10;
                sum += r * r * r;
                num /= 10;
            }
            if (org_num == sum) {
                System.out.println("Arg Num::");
            } else {
                System.out.println("Not Arm Strong");
            }
        }
    }

    // Fibonacci Series
    public static class FibSeries {
        public static void main(String[] args) {
            int a = 0, b = 1, c;
            System.out.println(a + " " + b);
            for (int i = 2; i < 10; i++) {
                c = a + b;
                System.out.println(" " + c);
                a = b;
                b = c;
            }
            System.out.println();
        }
    }

    // Prime Number
    public static class PrimeNumber {
        public static void main(String[] args) {
            int num = 7;
            System.out.println("Prime Number:" + isPrimeNumber(num));
        }

        private static Boolean isPrimeNumber(int num) {
            if (num < 2)
                return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    //Reverse Number
    public static class ReverseNumber {
        public static void main(String[] args) {
            int num = 12345;
            int rev = 0;
            while (num != 0) {

                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            System.out.println(rev);
        }
    }

    //Palindrome Number
    public static class PalindromeNumber {
        public static void main(String[] args) {
            int num = 12321;
            int org_num = num;
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            if (org_num == rev) {
                System.out.println("Pal");
            } else
                System.out.println("not pal");

        }
    }

    //Sum of Arrays
    public static class SumOfArrays {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            System.out.println("Sum Of Arrays:" + sum);
        }
    }

    //count Pair
    public static class CountPair {
        public static void main(String[] args) {
            int arr[] = {1, 2, 4, -1, -6, -2};
            int sum = 3;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] + arr[j] == sum)
                        count++;
                }
            }
            System.out.println(count);
        }
    }

    //subArrays
    public static class SubArrays {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4};
            int n = arr.length;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    //Reverse Array
    public static class ReverseArray {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5, 6};
            int left = 0, right = arr.length - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            // Print the reversed array
            System.out.print("Reversed Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }

    //Largest Elements
    public static class LargestElements {
        public static void main(String[] args) {
            int arr[] = {2, 5, 1, 7, 8, 67};
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println(max);
        }
    }

    //Maximum and Minimum elements in array
    public static class MaxAndMin {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 5, 6, 89};
            int max = arr[0], min = arr[0];
            for (int num : arr) {
                if (num > max)
                    max = num;
                if (num < min)
                    min = num;
            }
            System.out.println(max);
            System.out.println(min);
        }
    }

    public static class SortWithoutInbuilt {
        public static void main(String[] args) {
            int[] arr = {1, 2, 12, 34, 5, 4, 3};
            int temp, n = arr.length;

            // Selection sort
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            // Print sorted array
            System.out.print("Sorted Array: ");
            for (int x : arr) {
                System.out.print(x + " ");
            }

            // Print the largest element
            System.out.println("\nLargest element: " + arr[n - 1]);
        }
    }

    //Sorting with inbuilt method
    public static class SortingWithInbuildMethod {
        public static void main(String[] args) {
            int[] arr = {1, 7, 5, 87, 4, 3};
            Arrays.sort(arr);
            System.out.println("Sorted Arrays:" + Arrays.toString(arr));
            //second largest elements
            System.out.println("Second largest Elements:" + arr[arr.length - 2]);
        }
    }

    //Move Negative Number
    public static class MoveNegative {
        public static void main(String[] args) {
            int[] arr = {1, -2, 3, -5, 4, -7};
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    //Move zero to one side
    public static class MoveZero {
        public static void main(String[] args) {
            int[] arr = {1, 0, 3, 0, 45, 0};
            int index = 0;

            // Move non-zero elements forward
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    index++;
                }
            }

            System.out.println("After moving zeros to the end: " + Arrays.toString(arr));
        }
    }

    //Rotates Arrays
    public static class RotatesArrays {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int n = 3; // Number of left rotations

            int length = arr.length;
            for (int i = 0; i < n; i++) {
                int first = arr[0];
                for (int j = 0; j < length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[length - 1] = first;
            }

            // Print rotated array
            System.out.print("Rotated Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }

    public static class TrappingRainWater {
        public static void main(String[] args) {
            int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println("Trapped water: " + trap(height));
        }

        public static int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0, water = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    leftMax = Math.max(leftMax, height[left]);
                    water += leftMax - height[left];
                    left++;
                } else {
                    rightMax = Math.max(rightMax, height[right]);
                    water += rightMax - height[right];
                    right--;
                }
            }
            return water;
        }
    }

    //Count even and odd elements
    public static class CountEvenAndOdd {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int even = 0, odd = 0;

            for (int x : arr) {
                if (x % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            System.out.println("Even: " + even + ", Odd: " + odd);
        }
    }

    //Search an elements in array

    public static class SearchAnElement {
        public static void main(String[] args) {
            int[] arr = {1, 2, 5, 4, 3, 7};
            int target = 4;
            boolean found = false;

            for (int num : arr) {
                if (num == target) {
                    found = true;
                    break;
                }
            }

            System.out.println("Found: " + found);
        }
    }

    // duplicate Show in the arrays
    public static class DuplicateShows {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 1, 2, 4, 5};
            duplicateShow(arr);
            duplicateShowJava8(arr);
            boolean duplicateCheck = isDuplicateCheck(arr);
            System.out.println(duplicateCheck);
            boolean duplicateCheckJava8 = isDuplicateCheckJava8(arr);
            System.out.println(duplicateCheckJava8);
            // Remove Duplicate From List
            List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 5);
            removeDuplicateShowList(list);
            //Show Duplicate Value of character
            String str = "javaDeveloper";
            showDuplicateChact(str);
            showDuplicateChactJava8(str);
            removeDups(str);
            removeDupsJava8(str);
            String strs = "apple is fruit";
            duplicateShowWordSentences(strs);
            showDuplicateInSentanceWithJava8(strs);

        }

        private static void duplicateShow(int[] arr) {
            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> duplicates = new HashSet<>();
/*
	•	set: Tracks elements seen for the first time.
	•	duplicates: Stores values that appeared more than once.
	•	set.add(num):
	•	Returns true if it’s the first time seeing num.
	•	Returns false if num was already seen → it’s a duplicate.
	•	So if add() returns false, we add it to duplicates.
 */
            for (int num : arr) {
                if (!seen.add(num)) {
                    duplicates.add(num);
                }
            }
            for (int duplicate : duplicates) {
                System.out.println(duplicate);
            }
        }
    }

    private static void duplicateShowJava8(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        Set<Integer> duplicates =
                Arrays.stream(arr).filter(n -> !seen.add(n)).boxed().collect(Collectors.toSet());
        duplicates.forEach(System.out::println);
    }

    private static boolean isDuplicateCheck(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicateCheckJava8(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        return Arrays.stream(arr).anyMatch(n -> !seen.add(n));
        //Return true if at least one elements matches the predicate.
        //Return false if no elements match.
    }

    private static void removeDuplicateShowList(List<Integer> list) {
        List<Integer> rremoveDuplicateShowList = list.stream().distinct().toList();
        System.out.println(rremoveDuplicateShowList);
    }

    private static void showDuplicateChact(String str) {
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!seen.add(ch)) {
                duplicates.add(ch);
            }
        }
        System.out.println(duplicates);
    }

    private static void showDuplicateChactJava8(String str) {
        str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " "));
    }

    private static void removeDups(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            System.out.println("Remove Duplicates From word:" + set);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : set) {
            sb.append(ch);
        }

        System.out.println(sb);
    }

    private static void removeDupsJava8(String str) {
        String removeDupsJava8 = str.chars().mapToObj(c -> (char) c).distinct().map(String::valueOf).collect(Collectors.joining());
        System.out.println(removeDupsJava8);
    }


    private static void duplicateShowWordSentences(String strs) {
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        for (char ch : strs.toCharArray()) {
            if (ch != ' ') {
                if (!seen.add(ch)) {
                    duplicates.add(ch);
                }
            }
        }
        for (char dup : duplicates) {
            System.out.println("duplicateShowWordSentences::" + dup);


        }
    }

    private static void showDuplicateInSentanceWithJava8(String str) {
        Set<Character> set = new HashSet<>();
//•	str.chars() converts the string into an IntStream of character codes.
//filter() method, which determines whether a character should be included in the resulting collection.
        Set<Character> duplicates = str.chars().mapToObj(c -> (char) c)
                .filter(c -> c != ' ' && !set.add(c))
                .collect(Collectors.toSet());
        duplicates.forEach(c -> System.out.println(c + " "));
        System.out.println();
    }

    public static class RemoveDuplicates {
        public static void main(String[] args) {
            // Input array with duplicates
            String[] strArray = {"abc", "def", "abc", "mno", "xyz", "pqr", "xyz", "pqr"};

            findDuplicateWithoutJava8(strArray);
            findDuplicateWithJava8(strArray);
        }

        private static void findDuplicateWithoutJava8(String[] strArray) {
            System.out.println("Brute Force Method: Duplicate Elements are:");
            for (int i = 0; i < strArray.length - 1; i++) {
                for (int j = i + 1; j < strArray.length; j++) {
                    if (strArray[i].equals(strArray[j]) && i != j) {
                        System.out.println(strArray[i]);
                    }
                }
            }
        }

        private static void findDuplicateWithJava8(String[] strArray) {
            System.out.println("Using Java 8 Streams: Duplicate Elements are:");

            Set<String> set = new HashSet<>();
            Set<String> duplicates = Arrays.stream(strArray)
                    .filter(e -> !set.add(e)) // If add() returns false, it's a duplicate
                    .collect(Collectors.toSet());

            System.out.println(duplicates);
        }
    }

    //common elements
    public static class CommonElements {
        public static void main(String[] args) {
            int[] arr1 = {4, 2, 3, 1, 6};
            int[] arr2 = {6, 7, 8, 4};
            commonElementJava8(arr1, arr2);
            List<Integer> commElets = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr1[i] == arr2[j]) {
                        if (!commElets.contains(arr1[i])) {
                            commElets.add(arr1[i]);
                        }
                    }
                }
            }
            System.out.println(commElets);
        }

        private static void commonElementJava8(int[] arr1, int[] arr2) {
            List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
            List<Integer> compEles = list1.stream().filter(list2::contains).distinct().toList();
            System.out.println("commonElementJava8::" + compEles);

        }

    }

    public static class RotateArray {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int n = 3;
            n = n % arr.length;
            reverses(arr, 0, n - 1);
            reverses(arr, n, arr.length - 1);
            reverses(arr, 0, arr.length - 1);

            for (int var : arr) {
                System.out.print(var + " ");
            }

        }

        private static void reverses(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end--] = temp;
            }
        }
    }

    //intersection
    public static class Intersection {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {1, 2};
            intersectionss(arr1, arr2);
            intersectionssJava8(arr1, arr2);
            subSet(arr1, arr2);
            subSetJava8(arr1, arr2);
        }


        private static void intersectionss(int[] arr1, int[] arr2) {
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

    private static void intersectionssJava8(int[] arr1, int[] arr2) {
        Set<Integer> intersection = Arrays.stream(arr1).boxed().filter(nums -> Arrays.stream(arr2).anyMatch(x -> x == nums)).collect(Collectors.toSet());
        System.out.println(intersection);
    }


    private static void subSet(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        boolean isSubset = true;
        for (int num : arr2) {
            if (!set.contains(num)) {
                isSubset = false;
                break;
            }
        }
        System.out.println(isSubset ? "arr2 is a subset" : "arr2 is not a subset");
    }

    private static void subSetJava8(int[] arr1, int[] arr2) {
        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        boolean isSubSet = Arrays.stream(arr2).allMatch(set::contains);
        System.out.println(isSubSet ? "arr2 is a subset" : "arr2 is not a subset");
    }

    public static class PrefixCommonArrayAlternative {
        public static int[] findPrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            Set<Integer> seenA = new HashSet<>();
            Set<Integer> seenB = new HashSet<>();
            Set<Integer> common = new HashSet<>();
            int[] result = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                seenA.add(A[i]);
                seenB.add(B[i]);

                // Check A[i] in seenB
                if (seenB.contains(A[i]) && !common.contains(A[i])) {
                    count++;
                    common.add(A[i]);
                }

                // Check B[i] in seenA
                if (seenA.contains(B[i]) && !common.contains(B[i])) {
                    count++;
                    common.add(B[i]);
                }

                result[i] = count;
            }

            return result;
        }

        public static void main(String[] args) {
            int[] A = {1, 3, 2, 4};
            int[] B = {3, 1, 2, 4};

            int[] result = findPrefixCommonArray(A, B);
            System.out.println("Prefix Common Array: " + Arrays.toString(result)); // [0, 2, 3, 4]
        }
    }

    public static class ArraysPartition {
        public static void main(String[] args) {
            int[] arr = {1, 4, 3, 2};
            int sum = 0;
            Arrays.stream(arr);
            for (int i = 0; i < arr.length; i += 2) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }

    public static class Anagram {
        public static void main(String[] args) {
            int arr1[] = {1, 2, 3};
            int arr2[] = {3, 2, 1};
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean isAnagram = Arrays.equals(arr1, arr2);
            System.out.println("isAnagram:" + isAnagram);
            boolean checkAnagram = isAnagramJava8(arr1, arr2);
            System.out.println("Anagram java 8:" + checkAnagram);
        }

        private static boolean isAnagramJava8(int[] arr1, int[] arr2) {
            return Arrays.equals(Arrays.stream(arr1).sorted().toArray(),
                    Arrays.stream(arr2).sorted().toArray());
        }
    }

    public static class MaxFreq {
        public static void main(String[] args) {
            int[] arr = {1, 3, 2, 4, 3, 3, 2, 1, 4, 3, 1, 1, 2, 3, 4};

            Map<Integer, Integer> map = freqOccus(arr);
            System.out.println("Freq Occ (Traditional): " + map);

            Map<Integer, Long> mapJava8 = freqOccusJava8(arr);
            System.out.println("Freq Occ (Java 8): " + mapJava8);
        }

        // Traditional approach
        private static Map<Integer, Integer> freqOccus(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return map;
        }

        // Java 8 stream-based approach
        private static Map<Integer, Long> freqOccusJava8(int[] arr) {
            return Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }

    public static class FreqOccur {
        public static void main(String[] args) {
            String str = "anbabsbddad";
            Map<Character, Integer> map = freqOccs(str);
            System.out.println("Fre occ:" + map);
            Map<Character, Long> mapJava8 = freqOccsJava8(str);
            System.out.println("Fre occ mapJava8:" + mapJava8);
        }


        private static Map<Character, Integer> freqOccs(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }

        private static Map<Character, Long> freqOccsJava8(String str) {
            return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                    Collectors.counting()));
        }

    }

    public static class AnagramString {
        public static void main(String[] args) {
            String s1 = "anagram";
            String s2 = "nagrama";

            boolean isAnagram = areAnagrams(s1, s2);
            System.out.println("Are Anagrams? " + isAnagram);
            boolean isAnagramJava8 = areAnagramsJava8s(s1, s2);
            System.out.println("Are Anagrams? " + isAnagramJava8);
        }

        private static boolean areAnagrams(String s1, String s2) {
            if (s1.length() != s2.length()) return false;

            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();

            for (char c : s1.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }

            for (char c : s2.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            return map1.equals(map2);
        }
    }

    private static boolean areAnagramsJava8s(String s1, String s2) {
        return Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
    }

    public static class NonRepeating {
        public static void main(String[] args) {
            int[] arr = {1, 2, 2, 3, 1, 4, 2, 3};
            String result = nonRepeating(arr);
            System.out.println("First Non-Repeating: " + result);
            String results = nonRepeatingJava8(arr);
            System.out.println("First Non-Repeating: " + results);
        }


        private static String nonRepeating(int[] arr) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            // Step 1: Count frequencies
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Find the first non-repeating element
            for (int num : arr) {
                if (freqMap.get(num) == 1) {
                    return String.valueOf(num);
                }
            }

            return "None";
        }
    }

    private static String nonRepeatingJava8(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // maintains insertion order
                        Collectors.counting()
                ));

        return freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .findFirst()
                .orElse("None");
    }

    public static class FirstNonRepChart {
        public static void main(String[] args) {
            String str = "swiss";
            firstNonRepChart(str);
        }

        private static String firstNonRepChart(String str) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return String.valueOf(entry.getKey());
                }
            }
            return "No Unique class";
        }
    }

    public static class MaxFreqsOccursElemShow {

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 1, 2, 4, 3, 5, 3, 1, 2, 1};

            System.out.println("---- Java 7 Approach ----");
            findMaxFreqJava7(arr);

            System.out.println("---- Java 8 Approach ----");
            findMaxFreqJava8(arr);
        }

        // ✅ Java 7 Approach
        private static void findMaxFreqJava7(int[] arr) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            // Count frequencies
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Find max
            int maxFreq = 0, maxKey = -1;
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            System.out.println("Max Frequency Element (Java 7): " + maxKey + " => " + maxFreq);
        }

        // ✅ Java 8 Approach
        private static void findMaxFreqJava8(int[] arr) {
            Map<Integer, Long> freqMap = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Map.Entry<Integer, Long> maxEntry = freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .orElse(null);

            if (maxEntry != null) {
                System.out.println("Max Frequency Element (Java 8): " + maxEntry.getKey() + " => " + maxEntry.getValue());
            } else {
                System.out.println("No data found.");
            }
        }
    }

    public static class FirstNonRepeatedNumber {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 3, 5, 6};
            Integer map = firstNonRepeatedNumber(arr);
            System.out.println("FirstNonRepeatedNumber:" + map);
            Integer mapJava8 = firstNonRepeatedNumberJava8(arr);
            System.out.println("FirstNonRepeatedNumber mapJava8:" + mapJava8);
        }


        private static Integer firstNonRepeatedNumber(int[] arr) {
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }

    private static Integer firstNonRepeatedNumberJava8(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        x -> x,
                        LinkedHashMap::new,  // maintains insertion order
                        Collectors.counting()
                ));

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)         // extract only the key
                .findFirst()
                .orElse(-1);                    // return -1 if not found
    }

    public static class CharFreq {
        public static void main(String[] args) {
            char[] ch = {'a', 'd', 'a', 'f', 'e', 'r'};
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : ch) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            charFreqJava8(ch);
        }

        private static void charFreqJava8(char[] ch) {
            Map<Character, Long> map = new String(ch).chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            map.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        public static class WordOccFreq {

            public static void main(String[] args) {
                String sentence = "Test I Test My Test abc pqr";

                System.out.println("---- Java 7 Approach ----");
                wordFreqJava7(sentence);

                System.out.println("---- Java 8 Approach ----");
                wordFreqJava8(sentence);
            }

            // ✅ Java 7 version (traditional for-loop)
            private static void wordFreqJava7(String sentence) {
                Map<String, Integer> map = new HashMap<>();
                String[] words = sentence.toLowerCase().split("\\s+");

                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }

                System.out.println("Word Frequencies (Java 7): " + map);
            }

            // ✅ Java 8 version (stream-based)
            private static void wordFreqJava8(String sentence) {
                Map<String, Long> map = Arrays.stream(sentence.toLowerCase().split("\\s+"))
                        .collect(Collectors.groupingBy(
                                word -> word,
                                LinkedHashMap::new,
                                Collectors.counting()
                        ));

                System.out.println("Word Frequencies (Java 8): " + map);
            }
        }

        public static class FirstNonRepChart {
            public static void main(String[] args) {
                String str = "swiss";

                // Java 7 version
                String result7 = firstNonRepChartJava7(str);
                System.out.println("Java 7 - First Non-Repeating Character: " + result7);

                // Java 8 version
                String result8 = firstNonRepChartJava8(str);
                System.out.println("Java 8 - First Non-Repeating Character: " + result8);
            }

            // ✅ Java 7 approach
            private static String firstNonRepChartJava7(String str) {
                Map<Character, Integer> map = new LinkedHashMap<>();
                for (char c : str.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 1) {
                        return String.valueOf(entry.getKey());
                    }
                }
                return "No Unique Character";
            }

            // ✅ Java 8 approach
            private static String firstNonRepChartJava8(String str) {
                Map<Character, Long> freqMap = str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new, // preserves order
                                Collectors.counting()
                        ));

                return freqMap.entrySet().stream()
                        .filter(e -> e.getValue() == 1)
                        .map(e -> String.valueOf(e.getKey()))
                        .findFirst()
                        .orElse("No Unique Character");
            }
        }

        //Non-Repeating Character Finder
        public static class NonRepeatingCharacterFinder {
            public static void main(String[] args) {
                String str = "hello world java";
                nonRepeatingCharacterFinder(str);
            }

            private static List<Character> nonRepeatingCharacterFinder(String str) {
                str = str.replaceAll("\\s+", " ");
                Map<Character, Integer> freMap = new LinkedHashMap<>();
                List<Character> nonRepeatedChars = new ArrayList<>();
                for (char c : str.toCharArray()) {
                    freMap.put(c, freMap.getOrDefault(c, 0) + 1);
                }
                for (Map.Entry<Character, Integer> entry : freMap.entrySet()) {
                    if (entry.getValue() == 1) {
                        nonRepeatedChars.add(entry.getKey());
                    }
                }
                return nonRepeatedChars;
            }
        }
    }

    public static class NonRepeatingCharacterFinder {

        public static void main(String[] args) {
            String str = "hello world java";

            System.out.println("---- Java 7 Approach ----");
            List<Character> result7 = findNonRepeatingJava7(str);
            System.out.println("Non-Repeating Characters (Java 7): " + result7);

            System.out.println("---- Java 8 Approach ----");
            List<Character> result8 = findNonRepeatingJava8(str);
            System.out.println("Non-Repeating Characters (Java 8): " + result8);
        }

        // ✅ Java 7 version
        private static List<Character> findNonRepeatingJava7(String str) {
            str = str.replaceAll("\\s+", ""); // remove all spaces
            Map<Character, Integer> freqMap = new LinkedHashMap<>();
            List<Character> nonRepeated = new ArrayList<>();

            for (char c : str.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == 1) {
                    nonRepeated.add(entry.getKey());
                }
            }

            return nonRepeated;
        }

        // ✅ Java 8 version
        private static List<Character> findNonRepeatingJava8(String str) {
            return str.replaceAll("\\s+", "")
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    //Index First Non Repeating char
    public static class IndexFirstNonRepeatingChars {

        public static void main(String[] args) {
            String str = "loveleetcode";

            System.out.println("---- Java 7 Approach ----");
            int indexJava7 = indexFirstNonRepeatingJava7(str);
            System.out.println("First Non-Repeating Char Index (Java 7): " + indexJava7);

            System.out.println("---- Java 8 Approach ----");
            int indexJava8 = indexFirstNonRepeatingJava8(str);
            System.out.println("First Non-Repeating Char Index (Java 8): " + indexJava8);
        }

        // ✅ Java 7 approach
        private static int indexFirstNonRepeatingJava7(String str) {
            Map<Character, Integer> charCount = new LinkedHashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return str.indexOf(entry.getKey());
                }
            }

            return -1;
        }

        // ✅ Java 8 approach
        private static int indexFirstNonRepeatingJava8(String str) {
            Map<Character, Long> freqMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ));

            return freqMap.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(e -> str.indexOf(e.getKey()))
                    .findFirst()
                    .orElse(-1);
        }
    }

    //print indices of elements
    public static class PrintIndicesOfElements {
        public static void main(String[] args) {
            int[] arr = {12, 3, 1, 3, 2, 2, 4};
            printIndicesOfElements(arr);
            printIndicesOfElementsJava(arr);
        }


        // 1. Print Indices of Elements
        private static void printIndicesOfElements(int[] arr) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
            System.out.println(map);
        }

        /**
         * This method takes an array of integers and prints out a map of element to its indices.
         * It uses Java 8 Stream API to perform the operation.
         *
         * @param arr The input array
         */
        // 2. Print Indices of Elements (Java 8)
        private static void printIndicesOfElementsJava(int[] arr) {
            LinkedHashMap<Integer, List<Integer>> map = IntStream.range(0, arr.length)
                    .boxed()
                    .collect(Collectors.groupingBy(
                            i -> arr[i],
                            LinkedHashMap::new,
                            Collectors.toList()
                    ));
            System.out.println(map);
        }

    }

    public static class GroupWordsByLength {

        public static void main(String[] args) {
            groupWordsByLengthJava7s();
            groupWordsByLengthJava8s();
        }


        private static void groupWordsByLengthJava7s() {
            List<String> words = Arrays.asList("hi", "hello", "world", "yes", "no");
            Map<Integer, List<String>> grouped = new HashMap<>();

            for (String word : words) {
                int len = word.length();
                if (!grouped.containsKey(len)) {
                    grouped.put(len, new ArrayList<>());
                }
                grouped.get(len).add(word);
            }

            System.out.println("Group by Length (Java 7): " + grouped);
        }
    }

    private static void groupWordsByLengthJava8s() {
        List<String> words = Arrays.asList("hi", "hello", "world", "yes", "no");

        Map<Integer, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Group by Length (Java 8): " + grouped);
    }

    public static class ElementsMoreThanonce {
        public static void main(String[] args) {
            int[] arr = {12, 3, 1, 3, 2, 2, 4};
            elementsMoreThanonce(arr);
            elementsMoreThanOnceJava8(arr);
        }


        private static void elementsMoreThanonce(int[] arr) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                freq.entrySet().stream().filter(e -> e.getValue() > 1)
                        .forEach(e -> System.out.println("Duplicate: " + e.getKey()));
            }
        }
    }

    private static void elementsMoreThanOnceJava8(int[] arr) {
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        e -> e,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println("Duplicate: " + e.getKey()));
    }

    public class ArrayToMap {
        public static void main(String[] args) {
            String[] str = {"a", "b", "c"};
            arrayToMap(str);
            arrayToMapJava8(str);
        }

        private static void arrayToMap(String[] str) {
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < str.length; i++) {
                map.put(i, str[i]);
            }
            System.out.println("Traditional: " + map);
        }

        private static void arrayToMapJava8(String[] str) {
            Map<Integer, String> map = IntStream.range(0, str.length)
                    .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, str[i]))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            System.out.println("Java 8: " + map);
        }
    }
}
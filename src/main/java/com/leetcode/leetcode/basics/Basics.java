
package com.leetcode.leetcode.basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Basics {

    // 1. Reverse Number
    public static class ReverseNumber {
        public static void main(String[] args) {
            int num = 12345;

            // Traditional approach (Without Java 8)
            System.out.println("Reversed Number (Traditional): " + reverseNumberTraditional(num));

            // Java 8 approach (Using Streams)
            System.out.println("Reversed Number (Java 8): " + reverseNumberStreams(num));
        }

        // Traditional approach (Without Java 8)
        public static int reverseNumberTraditional(int num) {
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return rev;
        }

        // Java 8 approach (Using Streams)
        public static int reverseNumberStreams(int num) {
            //Converts num to a String, reverses it using StringBuilder, and then parses it back to an int.
            return Integer.parseInt(
                    new StringBuilder(String.valueOf(num))
                            .reverse()
                            .toString()
            );
        }
    }

    // 2. Palindrome Number
    public static class PalindromeNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number:");
            int num = sc.nextInt();

            // Traditional approach (Without Java 8)
            if (isPalindromeTraditional(num)) {
                System.out.println("Palindrome Number (Traditional)");
            } else {
                System.out.println("Not a Palindrome Number (Traditional)");
            }

            // Java 8 approach (Using Streams)
            if (isPalindromeJava8(num)) {
                System.out.println("Palindrome Number (Java 8)");
            } else {
                System.out.println("Not a Palindrome Number (Java 8)");
            }

            sc.close();
        }

        // Traditional approach (Without Java 8)
        public static boolean isPalindromeTraditional(int num) {
            int orgNum = num, rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return orgNum == rev;
        }

        // Java 8 approach (Using Streams)
        public static boolean isPalindromeJava8(int num) {
            String original = String.valueOf(num);
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        }
    }

    //3. swapping number
    public static class Swapping {
        public static void main(String[] args) {
            int a = 10, b = 20;

            // Swapping with Third Variable
            System.out.println("Before Swapping (With Third Variable): " + a + " " + b);
            int[] swappedWithVar = swapWithThirdVariable(a, b);
            System.out.println("After Swapping (With Third Variable): " + swappedWithVar[0] + " " + swappedWithVar[1]);

            // Swapping without Third Variable
            System.out.println("Before Swapping (Without Third Variable): " + a + " " + b);
            int[] swappedWithoutVar = swapWithoutThirdVariable(a, b);
            System.out.println("After Swapping (Without Third Variable): " + swappedWithoutVar[0] + " " + swappedWithoutVar[1]);

            // Java 8 Approach using Streams
            System.out.println("Before Swapping (Java 8 Stream): " + a + " " + b);
            int[] swappedUsingStream = swapUsingJava8(a, b);
            System.out.println("After Swapping (Java 8 Stream): " + swappedUsingStream[0] + " " + swappedUsingStream[1]);
        }

        // 1. Swapping with Third Variable (Traditional)
        public static int[] swapWithThirdVariable(int a, int b) {
            int temp = a;
            a = b;
            b = temp;
            return new int[]{a, b};
        }

        // 2. Swapping without Third Variable (Traditional)
        public static int[] swapWithoutThirdVariable(int a, int b) {
            a = a + b;
            b = a - b;
            a = a - b;
            return new int[]{a, b};
        }

        // 3. Swapping using Java 8 (Streams & Array Manipulation)
        public static int[] swapUsingJava8(int a, int b) {
            return Arrays.stream(new int[]{b, a}).toArray();
        }
    }


    // 4. Fibonacci Series

    public static class FibonacciSeries {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of terms: ");
            int n = sc.nextInt();

            System.out.println("\nFibonacci Series (Iterative):");
            printFibonacciIterative(n);

            System.out.println("\nFibonacci Series (Recursive):");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacciRecursive(i) + " ");
            }

            System.out.println("\n\nFibonacci Series (Java 8 Stream):");
//                    printFibonacciStream(n);
        }

        // **1. Iterative Approach (Traditional)**
        public static void printFibonacciIterative(int n) {
            int a = 0, b = 1, c;
            System.out.print(a + " " + b);
            for (int i = 2; i < n; i++) {
                c = a + b;
                System.out.print(" " + c);
                a = b;
                b = c;
            }
            System.out.println();
        }

        // **2. Recursive Approach**
        public static int fibonacciRecursive(int n) {
            if (n <= 1) return n;
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }

        // **3. Java 8 Stream Approach**
//                public static void printFibonacciStream(int n) {
//                    IntStream.iterate(0, new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
//                            .limit(n)
//                            .map(arr -> arr[0])
//                            .forEach(num -> System.out.print(num + " "));
//                }
    }

    // 5. Armstrong Number
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

//    6.Factorial Program in Java: Factorial of n is the product of all positive

    public static class Factorial {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number which you want for Factorial: ");
            int num = sc.nextInt();
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact = fact * i;
                System.out.println("Factorial of" + num + "is" + fact);
            }
        }
    }

    //7. LargestNumberFinder
    public static class LargestNumberFinder {
        public static void main(String[] args) {
            // 1. Using if-else condition
            int num1 = 7, num2 = 9, num3 = 10;

            if (num1 >= num2 && num1 >= num3) {
                System.out.println(num1 + " is the largest number.");
            } else if (num2 >= num1 && num2 >= num3) {
                System.out.println(num2 + " is the largest number.");
            } else {
                System.out.println(num3 + " is the largest number.");
            }

            // 2. Using Collections.max() method with ArrayList
            ArrayList<Integer> x = new ArrayList<>();
            x.add(12);
            x.add(22);
            x.add(54);

            System.out.println(Collections.max(x) + " is the largest number.");
        }
    }

    //8 SumOfDigits

    public static class SumOfDigits {
        public static void main(String[] args) {
            int n = 987; // Input number

            // Without Java 8 (Using While Loop)
            System.out.println("Sum using While Loop: " + sumUsingWhileLoop(n));

            // With Java 8 (Using Streams)
            System.out.println("Sum using Java 8 Streams: " + sumUsingJava8Streams(n));
        }

        // Method 1: Without Java 8 (Using While Loop)
        public static int sumUsingWhileLoop(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10; // Extract last digit and add to sum
                n /= 10; // Remove last digit
            }
            return sum;
        }

        // Method 2: With Java 8 (Using Streams)
        public static int sumUsingJava8Streams(int n) {
            return String.valueOf(n) // Convert number to String
                    .chars() // Convert to IntStream of characters
                    .map(Character::getNumericValue) // Convert char to int
                    .sum(); // Sum up the digits
        }
    }
    //9 CountDigits


    public static class CountDigits {
        public static void main(String[] args) {
            // Input number
            long num = 29845315;

            // 1. Count digits using a while loop
            System.out.println("Number of digits using While Loop: " + countUsingWhileLoop(num));

            // 2. Count digits by converting the number to a string
            System.out.println("Number of digits using String: " + countUsingString(num));

            // 3. Count digits using Java 8 Streams
            System.out.println("Number of digits using Java 8 Streams: " + countUsingJava8Streams(num));
        }

        // Method 1: Using While Loop
        public static int countUsingWhileLoop(long num) {
            int count = 0;
            long temp = num; // Preserve original number
            while (temp != 0) {
                temp /= 10; // Remove last digit
                count++;
            }
            return count;
        }

        // Method 2: Using String Conversion
        public static int countUsingString(long num) {
            return Long.toString(num).length(); // Convert to string and get length
        }

        // Method 3: Using Java 8 Streams
        public static int countUsingJava8Streams(long num) {
            return (int) String.valueOf(num) // Convert number to String
                    .chars() // Convert to IntStream of characters
                    .count(); // Count number of characters
        }
    }
    // 10. Prime Number


    public static class PrimeNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number:");
            int num = sc.nextInt();
            sc.close();

            // 1. Traditional Method (Loop-based)
            System.out.println("Using Loop: " + (isPrimeUsingLoop(num) ? "Prime Number" : "Not a Prime Number"));

            // 2. Java 8 Stream-based Approach
            System.out.println("Using Java 8 Streams: " + (isPrimeUsingStreams(num) ? "Prime Number" : "Not a Prime Number"));
        }

        // Method 1: Traditional Approach (Using Loop)
        public static boolean isPrimeUsingLoop(int num) {
            if (num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) { // Optimization: check up to sqrt(num)
                if (num % i == 0) {
                    return false; // Not a prime number
                }
            }
            return true; // Prime number
        }

        // Method 2: Java 8 Streams Approach
        public static boolean isPrimeUsingStreams(int num) {
            if (num < 2) return false;
            return IntStream.rangeClosed(2, (int) Math.sqrt(num)) // Stream of numbers from 2 to sqrt(num)
                    .noneMatch(i -> num % i == 0); // If any number divides num, it's not prime
        }
    }

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

    public static class DuplicateCharacters {
        public static void main(String[] args) {
            // Input string
            String str = "apple is fruit";

            // Convert the string to a character array
            char[] charArray = str.toCharArray();

            // Print the original string
            System.out.println("The string is: " + str);
            System.out.print("Duplicate Characters in the string are: ");

            // Using a HashSet to keep track of characters
            HashSet<Character> seen = new HashSet<>();
            HashSet<Character> duplicates = new HashSet<>();

            for (char c : charArray) {
                if (seen.contains(c)) {
                    duplicates.add(c);
                } else {
                    seen.add(c);
                }
            }

            // Print duplicate characters
            for (char c : duplicates) {
                if (c != ' ') { // Exclude spaces
                    System.out.print(c + " ");
                }
            }
        }
    }

    public static class CommonElementsInArrays {
        public static void main(String[] args) {
            // 1. By using nested for loop
            Integer[] array1 = {4, 2, 3, 1, 6};
            Integer[] array2 = {6, 7, 8, 4};
            List<Integer> commonElements = new ArrayList<>();

            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    if (array1[i].equals(array2[j])) {
                        if (!commonElements.contains(array1[i])) { // Avoid duplicates
                            commonElements.add(array1[i]);
                        }
                    }
                }
            }
            System.out.println("Common Elements using for loop: " + commonElements);

            // 2. Using ArrayList with retainAll method
            ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
            ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
            list1.retainAll(list2);
            System.out.println("Common Elements using retainAll: " + list1);

            // 3. By using Java Streams
            String[] array3 = {"Java", "JavaScript", "C", "C++"};
            String[] array4 = {"Python", "C#", "Java", "C++"};
            List<String> list3 = new ArrayList<>(Arrays.asList(array3));
            List<String> list4 = new ArrayList<>(Arrays.asList(array4));

            List<String> commonElementsStream = list3.stream()
                    .filter(list4::contains)
                    .collect(Collectors.toList());
            System.out.println("Common Elements using Streams: " + commonElementsStream);
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

    public static class FirstAndLastElement {
        public static void main(String[] args) {
            // Input ArrayList
            ArrayList<Integer> list = new ArrayList<>();
            list.add(4);
            list.add(2);
            list.add(3);
            list.add(1);
            list.add(6);

            // Find the first and last elements
            int first = list.get(0); // First element
            int last = list.get(list.size() - 1); // Last element

            // Output results
            System.out.println("First element is: " + first);
            System.out.println("Last element is: " + last);
        }
    }

    public static class SecondLargestAndSmallest {
        public static void main(String[] args) {
            // Input array
            int[] array = {4, 2, 3, 1, 0, 6, 12, 15, 20};

            // Sort the array
            Arrays.sort(array);

            // Second largest and second smallest
            int secondLargest = array[array.length - 2];
            int secondSmallest = array[1];

            // Output results
            System.out.println("Second Largest element is: " + secondLargest);
            System.out.println("Second Smallest element is: " + secondSmallest);
        }
    }

    public static class LargestElement {
        public static void main(String[] args) {
            // Initialize array
            int[] arr = new int[]{25, 11, 7, 75, 56};

            // Initialize max with the first element of the array
            int max = arr[0];

            // Loop through the array
            for (int i = 1; i < arr.length; i++) {
                // Compare each element with max
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            // Print the largest element
            System.out.println("Largest element present in the given array: " + max);
        }
    }

    public static class SplitAlphanumeric {
        public static void main(String[] args) {
            // Input string
            String str = "Welcome234To567Java89Programming0@#!!";

            // Buffers to hold different types of characters
            StringBuffer alpha = new StringBuffer();
            StringBuffer num = new StringBuffer();
            StringBuffer special = new StringBuffer();

            // Iterate through the string
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (Character.isDigit(c)) {
                    num.append(c); // Add to numeric buffer
                } else if (Character.isAlphabetic(c)) {
                    alpha.append(c); // Add to alphabetic buffer
                } else {
                    special.append(c); // Add to special character buffer
                }
            }

            // Print results
            System.out.println("Alphabets: " + alpha);
            System.out.println("Numbers: " + num);
            System.out.println("Special Characters: " + special);
        }
    }

    public static class SortArrayWithoutInbuilt {
        public static void main(String[] args) {
            // Input array
            int[] array = {10, 5, 20, 63, 12, 57, 88, 60};
            int temp, size = array.length;

            // Manual sorting using nested loops
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (array[i] > array[j]) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }

            // Output sorted array
            System.out.print("Array sorted: ");
            for (int i : array) {
                System.out.print(i + " ");
            }

            // Print the 3rd largest element
            System.out.println("\nThird largest number is: " + array[size - 3]);
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

    public static class WordOccurrences {
        public static void main(String[] args) {
            // Input string and word to search for
            String string = "Java is a programming language. Java is widely used in software Testing";
            String word = "Java";

            // Convert the string to lowercase for case-insensitive comparison
            String[] words = string.toLowerCase().split("\\s+"); // Split string by spaces
            String targetWord = word.toLowerCase();

            int occurrences = 0;

            // Count occurrences of the word
            for (String w : words) {
                if (w.equals(targetWord)) {
                    occurrences++;
                }
            }

            // Output the result
            System.out.println("Occurrences of the word '" + word + "': " + occurrences);
        }
    }

    public static class WordCount {
        public static void main(String[] args) {
            // Input string
            String str = "Alice is girl and Bob is boy";

            // HashMap to store word counts
            Map<String, Integer> hashMap = new HashMap<>();

            // Split the string into words
            String[] words = str.split("\\s+");

            // Count occurrences of each word
            for (String word : words) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }

            // Output the word count
            System.out.println("Word occurrences: " + hashMap);
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

    public static class PrefixCommonArrayOptimized {
        public static int[] findPrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            Set<Integer> seen = new HashSet<>();
            int[] C = new int[n];
            int commonCount = 0;

            for (int i = 0; i < n; i++) {
                if (seen.contains(A[i])) {
                    commonCount++;
                } else {
                    seen.add(A[i]);
                }

                if (seen.contains(B[i])) {
                    commonCount++;
                } else {
                    seen.add(B[i]);
                }

                C[i] = commonCount;
            }

            return C;
        }

        public static void main(String[] args) {
            int[] A = {1, 3, 2, 4};
            int[] B = {3, 1, 2, 4};

            int[] result = findPrefixCommonArray(A, B);
            System.out.println(Arrays.toString(result));  // Output: [0, 2, 3, 4]
        }
    }
}


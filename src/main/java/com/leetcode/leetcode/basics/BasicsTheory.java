package com.leetcode.leetcode.basics;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class BasicsTheory {
    /*
    1. Variables
	•	Definition: Variables are symbolic names for data stored in memory, allowing us to manipulate and access the data during program execution.
	•	Characteristics:
	•	Each variable has a name, type, and value.
	•	The type determines the kind of data a variable can hold.
	•	Variables must be declared before use.

		•	A variable is a named container to store data.
	•	Example: int num = 5;
Here:
	•	int is the data type.
	•	num is the variable name.
	•	5 is the value stored in the variable.


     	1.	Declare and initialize a variable:
     int age = 25; // integer variable
float price = 99.99f; // float variable (suffix 'f' for float values)
char grade = 'A'; // character variable
boolean isPassed = true; // boolean variable

	2.	Modify and reuse a variable:
	int num = 10;
num = num + 5; // num now holds the value 15
System.out.println("Updated Value: " + num);
     */

    /*
    2. Data Types

Primitive Data Types:
	•	int: Stores integers.
	•	float: Stores decimal values with single precision.
	•	char: Stores a single character.
	•	boolean: Represents logical values (true or false).

	•	int: Stores integers (e.g., 5, -10).
	•	float: Stores decimal numbers (e.g., 3.14).
	•	char: Stores a single character (e.g., 'A').
	•	boolean: Stores true or false.
Non-Primitive Data Types:
	•	String: Stores text data.
	•	Arrays: Store multiple values of the same type.
	•	Objects: User-defined or complex data types.

•	String: Stores sequences of characters (e.g., "Hello").
	•	Arrays, Objects, etc.

     */

    /*
    3. Operators

Arithmetic Operators:

3. Operators
	•	Arithmetic Operators: +, -, *, /, %
	•	Example: a + b adds a and b.
	•	Relational Operators: ==, !=, <, >, <=, >=
	•	Example: a > b checks if a is greater than b.
	•	Logical Operators: &&, ||, !
	•	Example: (a > 0 && b < 10) evaluates if both conditions are true.
Used for mathematical calculations.
	•	Examples: + (addition), - (subtraction), * (multiplication), / (division), % (modulus).

	int a = 10, b = 3;
System.out.println("Sum: " + (a + b)); // 13
System.out.println("Difference: " + (a - b)); // 7
System.out.println("Product: " + (a * b)); // 30
System.out.println("Quotient: " + (a / b)); // 3
System.out.println("Remainder: " + (a % b)); // 1

 Used to compare two values.
	•	Examples: == (equal to), != (not equal), <, >, <=, >=.
	int a = 10, b = 20;
System.out.println(a > b); // false
System.out.println(a == 10); // true

   Logical Operators:

Used to combine multiple conditions.
	•	Examples: && (logical AND), || (logical OR), ! (logical NOT).

int age = 25;
System.out.println(age > 18 && age < 30); // true
System.out.println(age > 30 || age == 25); // true
System.out.println(!(age > 18)); // false
     */
    /*

Basic Level (1–25)
	1.	Print “Hello, World!”
	2.	Add two numbers.
	3.	Swap two numbers without using a third variable.
	4.	Find the largest of three numbers.
	5.	Check if a number is even or odd.
	6.	Find the factorial of a number.
	7.	Reverse a given number.
	8.	Check if a number is a palindrome.
	9.	Print the Fibonacci series up to n terms.
	10.	Find the sum of digits of a number.
	11.	Count the number of digits in a number.
	12.	Print all prime numbers up to n.
	13.	Check if a number is a perfect square.
	14.	Generate a multiplication table for a number.
	15.	Print all Armstrong numbers in a given range.
	16.	Check if a number is a perfect number.
	17.	Convert Celsius to Fahrenheit and vice versa.
	18.	Check if a year is a leap year.
	19.	Find the greatest of four numbers.
	20.	Calculate the sum of all natural numbers up to n.
	21.	Print a right-angle triangle pattern of stars.
	22.	Calculate compound interest.
	23.	Find the smallest number in an array.
	24.	Count vowels and consonants in a string.
	25.	Print ASCII values of all characters from A to Z.

Intermediate Level (26–50)
	26.	Find the second largest number in an array.
	27.	Sort an array in ascending and descending order.
	28.	Find the GCD and LCM of two numbers.
	29.	Find the square root of a number without using built-in functions.
	30.	Check if two strings are anagrams.
	31.	Check if a number is a strong number.
	32.	Find the first non-repeating character in a string.
	33.	Reverse a string without using extra space.
	34.	Convert a binary number to decimal.
	35.	Convert a decimal number to binary.
	36.	Find the power of a number using recursion.
	37.	Find the maximum sum of a subarray (Kadane’s algorithm).
	38.	Print all permutations of a string.
	39.	Find the intersection of two arrays.
	40.	Rotate an array to the left by k positions.
	41.	Find the number of trailing zeros in a factorial.
	42.	Count the frequency of each word in a string.
	43.	Check if an array is sorted.
	44.	Merge two sorted arrays into one sorted array.
	45.	Find the longest common prefix in a list of strings.
	46.	Check if a number is a power of 2.
	47.	Implement linear search and binary search.
	48.	Transpose a matrix.
	49.	Multiply two matrices.
	50.	Check if a number is a Harshad number.

Advanced Level (51–75)
	51.	Implement bubble sort, insertion sort, and selection sort.
	52.	Find the longest substring without repeating characters.
	53.	Count the number of set bits in a binary representation of a number.
	54.	Solve the Tower of Hanoi problem.
	55.	Generate all subsets of a set.
	56.	Find the longest increasing subsequence in an array.
	57.	Implement a queue using two stacks.
	58.	Find the median of two sorted arrays.
	59.	Detect a cycle in a linked list.
	60.	Find the nth Fibonacci number using dynamic programming.
	61.	Find the minimum number of coins for a given amount.
	62.	Implement a stack with push, pop, and getMin operations in O(1).
	63.	Count the number of islands in a 2D grid.
	64.	Find the maximum area of a rectangle in a histogram.
	65.	Implement the Sieve of Eratosthenes to find primes.
	66.	Solve the N-Queens problem.
	67.	Implement Dijkstra’s shortest path algorithm.
	68.	Implement a binary search tree and perform basic operations.
	69.	Serialize and deserialize a binary tree.
	70.	Check if two binary trees are identical.
	71.	Find the diameter of a binary tree.
	72.	Solve the “knapsack problem” using dynamic programming.
	73.	Find the longest palindromic substring.
	74.	Generate all valid parentheses combinations for n pairs.
	75.	Find the maximum profit in stock trading with at most two transactions.

Real-World Application Problems (76–100)
	76.	Create a simple calculator.
	77.	Validate an email address using regex.
	78.	Build a command-line to-do list application.
	79.	Simulate a basic ticket booking system.
	80.	Check if a string is a valid IP address.
	81.	Parse a CSV file and calculate statistics.
	82.	Build a URL shortener logic.
	83.	Implement basic encryption and decryption using Caesar cipher.
	84.	Design a parking lot system with multiple levels.
	85.	Implement a library management system.
	86.	Simulate a vending machine.
	87.	Create a simple chat application.
	88.	Build a temperature conversion API using REST principles.
	89.	Simulate a banking system (create accounts, deposit, withdraw).
	90.	Implement the logic for a simple Tic-Tac-Toe game.
	91.	Build a basic shopping cart system.
	92.	Simulate a movie ticket booking system with seat selection.
	93.	Create a game leaderboard and implement rank calculation.
	94.	Write logic for a scheduling system (e.g., calendar events).
	95.	Develop a quiz application with a scoring system.
	96.	Create a password strength checker.
	97.	Implement logic for file compression and decompression.
	98.	Simulate a traffic light system.
	99.	Write a program to encrypt and decrypt messages using RSA.
	100.	Create an algorithm to match job seekers with job postings.

     */
    //Print “Hello, World!
    public static class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }

    //Write a program to add two numbers.
    public static class AddNumbers {
        public static void main(String[] args) {
//            int a = 5, b = 7;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = a + b;
            System.out.println("Sum: " + sum);
        }
    }

    //Write a program to swap two numbers without using a third variable.
    public static class SwapNumbers {
        public static void main(String[] args) {
//            int a = 5, b = 10;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Before: a = " + a + ", b = " + b);
            a = a + b;
            b = a - b;
            a = a - b;
            /*
            int c=a;
            a=b;
            b=c
             */
            System.out.println("After: a = " + a + ", b = " + b);
        }
    }
    //Find the largest of three numbers.

    public static class LargestNumber {
        public static void main(String[] args) {
//            int a = 10, b = 20, c = 15;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a > b && a > c) {
                System.out.println(a + " is the largest.");
            } else if (b > c) {
                System.out.println(b + " is the largest.");
            } else {
                System.out.println(c + " is the largest.");
            }
        }
    }

    //Check whether a number is positive, negative, or zero.
    public static class CheckNumber {
        public static void main(String[] args) {
            int num = -10;
            if (num > 0) {
                System.out.println("Positive");
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        // check even and odd
        public static class EvenOdd {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a number::");
                int num = sc.nextInt();
                if (num % 2 == 0) {
                    System.out.println("Even Number");
                } else {
                    System.out.println("Odd Number");
                }
            }
        }

        //Check if a number is divisible by 3 and 5.
        public static class DivisibleCheck {
            public static void main(String[] args) {
                int num = 15;
                if (num % 3 == 0 && num % 5 == 0) {
                    System.out.println(num + " is divisible by 3 and 5.");
                } else {
                    System.out.println(num + " is not divisible by 3 and 5.");
                }
            }
        }

        //Reverse a three-digit number.
        public static class ReverseNumber {
            public static void main(String[] args) {
                int num = 123, reversed = 0;
                while (num != 0) {
                    int digit = num % 10;
                    reversed = reversed * 10 + digit;
                    num /= 10;
                }
                System.out.println("Reversed number: " + reversed);
            }
        }
    }

    //Check if a number is a perfect square.
    public static class PerfectSquareCheck {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number to check if it's a perfect square: ");
            int number = scanner.nextInt();

            if (isPerfectSquare(number)) {
                System.out.println(number + " is a perfect square.");
            } else {
                System.out.println(number + " is not a perfect square.");
            }
        }

        public static boolean isPerfectSquare(int num) {
            if (num < 0) {
                return false; // Negative numbers cannot be perfect squares
            }

            int sqrt = (int) Math.sqrt(num); // Compute the square root
            return sqrt * sqrt == num; // Check if the square of sqrt equals the number
        }
    }

    //Convert Celsius to Fahrenheit and vice versa.
    public static class TemperatureConverter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Temperature Conversion Menu:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Choose an option (1 or 2): ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
            } else if (choice == 2) {
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.println("Temperature in Celsius: " + celsius);
            } else {
                System.out.println("Invalid choice! Please select 1 or 2.");
            }

            scanner.close();
        }

        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 9 / 5) + 32;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }
    }

    //Check if a number is a perfect number.
    public static class PerfectNumberCheck {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number to check if it's a perfect number: ");
            int number = scanner.nextInt();

            if (isPerfectNumber(number)) {
                System.out.println(number + " is a perfect number.");
            } else {
                System.out.println(number + " is not a perfect number.");
            }
        }

        public static boolean isPerfectNumber(int num) {
            if (num <= 1) {
                return false; // Perfect numbers are greater than 1
            }

            int sum = 0;
            // Find divisors and calculate their sum
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }

            // Check if the sum of divisors equals the number
            return sum == num;
        }
    }

    //Calculate the sum of all natural numbers up to n.
    public static class SumOfNaturalNumber {
        public static void main(String[] args) {

            int sum = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the natural Number:");
            int n = sc.nextInt();
            for (int i = 1; i < n; i++) {
                sum = sum + i;
            }
            System.out.println("Sum of Natural Number: " + sum);
        }
    }

    //Calculating Simple Interest
    public static class SimpleInterest {
        public static void main(String[] args) {
            // Declare variables
            float principal = 10000f; // Principal amount
            float rate = 5.5f; // Annual interest rate
            int time = 2; // Time in years

            // Calculate simple interest
            float interest = (principal * rate * time) / 100;

            // Display result
            System.out.println("Simple Interest: " + interest);
        }
    }

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

//    Factorial Program in Java: Factorial of n is the product of all positive

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

    public static class SumOfDigits {
        public static void main(String[] args) {
            int n = 987; // Input number
            int sum = 0;

            // Calculate sum of digits using while loop
            while (n != 0) {
                sum = sum + n % 10; // Add the last digit to the sum
                n = n / 10; // Remove the last digit
            }

            System.out.println("Using While Loop: " + sum); // Output the sum
        }
    }

    //	Count the number of digits in a number.
    public static class CountDigits {
        public static void main(String[] args) {
            // Input number
            long num = 29845315;

            // 1. Count digits using a while loop
            int count = 0;
            long temp = num; // Temporary variable to preserve original number

            while (temp != 0) {
                temp = temp / 10; // Remove the last digit
                count++; // Increment count
            }

            System.out.println("Number of digits using While Loop: " + count);

            // 2. Count digits by converting the number to a string
            String result = Long.toString(num); // Convert the number to a string
            System.out.println("Number of digits using String: " + result.length());
        }
    }

    // 7. Prime Number
    //Print all prime numbers up to n.
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

    public static class FindVowel {
        public static void main(String[] args) {
            String str = "Test Engin";
            int v = 0, c = 0;
            String small = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                char ch = small.charAt(i);
                if (ch != ' ' && (ch >= 'a' && ch <= 'z')) {
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        v++;
                    } else {
                        c++;
                    }
                }
            }
            System.out.println("Vowel::" + v);
            System.out.println("Con::" + c);


        }
    }

    public static class PrintASCII {
        public static void main(String[] args) {
            System.out.println("ASCII values of characters from A to Z:");
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.println(ch + " -> " + (int) ch);
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

    public static class RemoveDuplicates {
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

    public static class FindSmallest {
        public static void main(String[] args) {
            int[] numbers = {34, 78, 12, 90, 5, 67};
            int smallest = findSmallestNumber(numbers);
            System.out.println("The smallest number in the array is: " + smallest);
        }

        public static int findSmallestNumber(int[] array) {
            int smallest = array[0]; // Assume the first element is the smallest
            for (int num : array) {
                if (num < smallest) {
                    smallest = num; // Update smallest if a smaller number is found
                }
            }
            return smallest;
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

    public static class ArraySorter {

        public static void main(String[] args) {
            // Example array
            Integer[] array = {5, 2, 8, 7, 1};

            // Sorting in ascending order
            sortAscending(array);

            // Sorting in descending order
            sortDescending(array);
        }

        // Method to sort array in ascending order
        public static void sortAscending(Integer[] array) {
            Arrays.sort(array);  // Sort in ascending order
            System.out.println("Array sorted in ascending order: " + Arrays.toString(array));
        }

        // Method to sort array in descending order
        public static void sortDescending(Integer[] array) {
            Arrays.sort(array, Collections.reverseOrder());  // Sort in descending order
            System.out.println("Array sorted in descending order: " + Arrays.toString(array));
        }
    }

    public static class GCDAndLCM {

        public static void main(String[] args) {
            int num1 = 36;
            int num2 = 60;

            int gcd = findGCD(num1, num2);
            int lcm = findLCM(num1, num2, gcd);

            System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
            System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
        }

        // Method to find GCD using the Euclidean Algorithm
        public static int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        // Method to find LCM using the formula: LCM(a, b) = (a * b) / GCD(a, b)
        public static int findLCM(int a, int b, int gcd) {
            return (a * b) / gcd;
        }
    }

    public static class SquareRootCalculator {

        public static void main(String[] args) {
            double number = 25; // Example input
            double precision = 0.00001; // Define the precision level

            double sqrt = findSquareRoot(number, precision);
            System.out.println("Square root of " + number + " is approximately: " + sqrt);
        }

        // Method to calculate square root using Newton's method
        public static double findSquareRoot(double number, double precision) {
            if (number < 0) {
                throw new IllegalArgumentException("Square root of a negative number is undefined in real numbers.");
            }
            if (number == 0 || number == 1) {
                return number;
            }

            double guess = number / 2.0; // Initial guess
            while (Math.abs(guess * guess - number) > precision) {
                guess = (guess + number / guess) / 2.0;
            }
            return guess;
        }
    }

    public static class Anagram {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";
            boolean result = anagram(str1, str2);

            if (result) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        }

        private static boolean anagram(String str1, String str2) {
            // If lengths are not the same, they can't be anagrams
            if (str1.length() != str2.length()) {
                return false;
            }

            // Convert strings to character arrays
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            // Sort the character arrays
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            // Compare the sorted arrays
            return Arrays.equals(arr1, arr2);
        }
    }

    public static class StrongNumber {

        public static void main(String[] args) {
            int number = 145; // Example input
            if (isStrongNumber(number)) {
                System.out.println(number + " is a Strong Number.");
            } else {
                System.out.println(number + " is not a Strong Number.");
            }
        }

        // Method to check if a number is a strong number
        public static boolean isStrongNumber(int number) {
            int originalNumber = number;
            int sum = 0;

            while (number > 0) {
                int digit = number % 10;  // Extract the last digit
                sum += factorial(digit); // Add factorial of the digit to the sum
                number /= 10;            // Remove the last digit
            }

            return sum == originalNumber; // Check if the sum equals the original number
        }

        // Method to calculate the factorial of a digit
        public static int factorial(int n) {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }

    public static class FirstNonRepeatingCharacter {

        public static void main(String[] args) {
            String str = "swiss"; // Example input
            char result = findFirstNonRepeatingCharacter(str);

            if (result != '\0') {
                System.out.println("The first non-repeating character is: " + result);
            } else {
                System.out.println("No non-repeating character found.");
            }
        }

        // Method to find the first non-repeating character in a string
        public static char findFirstNonRepeatingCharacter(String str) {
            HashMap<Character, Integer> charCount = new HashMap<>();

            // Count the frequency of each character
            for (char ch : str.toCharArray()) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }

            // Find the first character with a count of 1
            for (char ch : str.toCharArray()) {
                if (charCount.get(ch) == 1) {
                    return ch;
                }
            }

            return '\0'; // Return null character if no non-repeating character is found
        }
    }

    //Reverse a string without using extra space.
    public static class ReverseString {

        public static void reverseString(char[] str) {
            int left = 0;
            int right = str.length - 1;

            while (left < right) {
                // Swap characters
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;

                // Move pointers
                left++;
                right--;
            }
        }

        public static void main(String[] args) {
            String input = "hello";
            char[] str = input.toCharArray();

            reverseString(str);
            System.out.println("Reversed String: " + new String(str));
        }
    }

    //Convert a binary number to decimal.
    public static class BinaryToDecimal {

        public static int binaryToDecimal(String binary) {
            int decimal = 0;
            int power = 0;

            // Iterate from the last character to the first
            for (int i = binary.length() - 1; i >= 0; i--) {
                char bit = binary.charAt(i);

                // Multiply the bit by 2^power and add to the result
                if (bit == '1') {
                    decimal += Math.pow(2, power);
                }
                power++;
            }
            return decimal;
        }

        public static void main(String[] args) {
            String binary = "1011"; // Example binary number
            int decimal = binaryToDecimal(binary);
            System.out.println("Binary: " + binary + " -> Decimal: " + decimal);
        }
    }

    //Convert a decimal number to binary.
    public static class DecimalToBinary {

        public static String decimalToBinary(int decimal) {
            StringBuilder binary = new StringBuilder();

            while (decimal > 0) {
                int remainder = decimal % 2; // Get the remainder (0 or 1)
                binary.append(remainder);   // Append the remainder to the binary string
                decimal = decimal / 2;     // Update decimal to the quotient
            }

            // Reverse the binary string since remainders are calculated in reverse order
            return binary.reverse().toString();
        }

        public static void main(String[] args) {
            int decimal = 11; // Example decimal number
            String binary = decimalToBinary(decimal);
            System.out.println("Decimal: " + decimal + " -> Binary: " + binary);
        }
    }

    //Find the power of a number using recursion.
    public static class PowerCalculator {

        public static long power(int base, int exponent) {
            // Base case: any number to the power of 0 is 1
            if (exponent == 0) {
                return 1;
            }
            // Recursive case: base^exponent = base * base^(exponent-1)
            return base * power(base, exponent - 1);
        }

        public static void main(String[] args) {
            int base = 2;      // Example base
            int exponent = 5;  // Example exponent

            long result = power(base, exponent);
            System.out.println(base + " to the power of " + exponent + " is: " + result);
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
            Basics.A a1 = Basics.A.getInstance();
            Basics.A a2 = Basics.A.getInstance();
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


    public static class UtilityProgramss {

        // 31. Check if a number is a strong number
        public static boolean isStrongNumber(int num) {
            int sum = 0, temp = num;
            while (temp > 0) {
                sum += factorial(temp % 10);
                temp /= 10;
            }
            return sum == num;
        }

        private static int factorial(int n) {
            if (n == 0 || n == 1) return 1;
            return n * factorial(n - 1);
        }

        // 32. Find the first non-repeating character in a string
        public static char firstNonRepeatingChar(String str) {
            Map<Character, Integer> countMap = new LinkedHashMap<>();
            for (char c : str.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) return entry.getKey();
            }
            return '\0'; // Return null character if none found
        }

        // 33. Reverse a string without using extra space
        public static void reverseString(char[] str) {
            int left = 0, right = str.length - 1;
            while (left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }

        // 34. Convert a binary number to decimal
        public static int binaryToDecimal(String binary) {
            return Integer.parseInt(binary, 2);
        }

        // 35. Convert a decimal number to binary
        public static String decimalToBinary(int decimal) {
            return Integer.toBinaryString(decimal);
        }

        // 36. Find the power of a number using recursion
        public static int power(int base, int exp) {
            if (exp == 0) return 1;
            return base * power(base, exp - 1);
        }

        // 37. Find the maximum sum of a subarray (Kadane’s Algorithm)
        public static int maxSubarraySum(int[] arr) {
            int maxSum = Integer.MIN_VALUE, currentSum = 0;
            for (int num : arr) {
                currentSum = Math.max(num, currentSum + num);
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }

        // 38. Print all permutations of a string
        public static void printPermutations(String str) {
            permuteHelper(str.toCharArray(), 0);
        }

        private static void permuteHelper(char[] chars, int index) {
            if (index == chars.length - 1) {
                System.out.println(new String(chars));
                return;
            }
            for (int i = index; i < chars.length; i++) {
                swap(chars, i, index);
                permuteHelper(chars, index + 1);
                swap(chars, i, index); // Backtrack
            }
        }

        private static void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        // 39. Find the intersection of two arrays
        public static int[] arrayIntersection(int[] arr1, int[] arr2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> intersection = new HashSet<>();
            for (int num : arr1) set1.add(num);
            for (int num : arr2) {
                if (set1.contains(num)) intersection.add(num);
            }
            return intersection.stream().mapToInt(Integer::intValue).toArray();
        }

        // 40. Rotate an array to the left by k positions
        public static void rotateArrayLeft(int[] arr, int k) {
            k %= arr.length;
            reverse(arr, 0, k - 1);
            reverse(arr, k, arr.length - 1);
            reverse(arr, 0, arr.length - 1);
        }

        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            // Example usage of all methods

            // 31. Strong number
            System.out.println("31. Is Strong Number: " + isStrongNumber(145));

            // 32. First non-repeating character
            System.out.println("32. First Non-Repeating Character: " + firstNonRepeatingChar("swiss"));

            // 33. Reverse string
            char[] str = "hello".toCharArray();
            reverseString(str);
            System.out.println("33. Reversed String: " + new String(str));

            // 34. Binary to Decimal
            System.out.println("34. Binary to Decimal: " + binaryToDecimal("1010"));

            // 35. Decimal to Binary
            System.out.println("35. Decimal to Binary: " + decimalToBinary(10));

            // 36. Power of a number
            System.out.println("36. Power: " + power(2, 3));

            // 37. Maximum subarray sum
            int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println("37. Max Subarray Sum: " + maxSubarraySum(arr));

            // 38. Print all permutations
            System.out.println("38. Permutations of 'abc':");
            printPermutations("abc");

            // 39. Intersection of two arrays
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {3, 4, 5, 6};
            System.out.println("39. Array Intersection: " + Arrays.toString(arrayIntersection(arr1, arr2)));

            // 40. Rotate array to the left
            int[] rotateArr = {1, 2, 3, 4, 5};
            rotateArrayLeft(rotateArr, 2);
            System.out.println("40. Rotated Array: " + Arrays.toString(rotateArr));
        }
    }

    public class UtilityPrograms {

        // 41. Find the number of trailing zeros in a factorial
        public static int findTrailingZeros(int n) {
            int count = 0;
            int powerOf5 = 5;
            while (n / powerOf5 > 0) {
                count += n / powerOf5;
                powerOf5 *= 5;
            }
            return count;
        }

        // 42. Count the frequency of each word in a string
        public static void countWordFrequency(String input) {
            String[] words = input.split("\\s+");
            Map<String, Integer> wordCount = new HashMap<>();

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
        }

        // 43. Check if an array is sorted
        public static boolean isSorted(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) return false;
            }
            return true;
        }

        // 44. Merge two sorted arrays into one sorted array
        public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length + arr2.length];
            int i = 0, j = 0, k = 0;

            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    result[k++] = arr1[i++];
                } else {
                    result[k++] = arr2[j++];
                }
            }

            while (i < arr1.length) result[k++] = arr1[i++];
            while (j < arr2.length) result[k++] = arr2[j++];

            return result;
        }

        // 45. Find the longest common prefix in a list of strings
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }

        // 46. Check if a number is a power of 2
        public static boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }

        // 47. Linear Search
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }

        // 47. Binary Search
        public static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) return mid;
                else if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return -1;
        }

        // 48. Transpose a matrix
        public static int[][] transposeMatrix(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            int[][] transposed = new int[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }
            return transposed;
        }

        // 49. Multiply two matrices
        public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
            int rows1 = mat1.length, cols1 = mat1[0].length, cols2 = mat2[0].length;
            int[][] result = new int[rows1][cols2];

            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    for (int k = 0; k < cols1; k++) {
                        result[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return result;
        }

        // 50. Check if a number is a Harshad number
        public static boolean isHarshad(int num) {
            int sum = 0, temp = num;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return num % sum == 0;
        }

        public static void main(String[] args) {
            // Example Usage
            System.out.println("41. Trailing Zeros: " + findTrailingZeros(100));
            System.out.println("\n42. Word Frequency:");
            countWordFrequency("hello world hello everyone");

            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("\n43. Is Sorted: " + isSorted(arr));

            int[] arr1 = {1, 3, 5};
            int[] arr2 = {2, 4, 6};
            System.out.println("\n44. Merged Array: " + Arrays.toString(mergeSortedArrays(arr1, arr2)));

            String[] strs = {"flower", "flow", "flight"};
            System.out.println("\n45. Longest Common Prefix: " + longestCommonPrefix(strs));

            System.out.println("\n46. Is Power of Two: " + isPowerOfTwo(16));

            System.out.println("\n47. Linear Search: " + linearSearch(arr, 3));
            System.out.println("47. Binary Search: " + binarySearch(arr, 3));

            int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
            System.out.println("\n48. Transposed Matrix: " + Arrays.deepToString(transposeMatrix(matrix)));

            int[][] mat1 = {{1, 2}, {3, 4}};
            int[][] mat2 = {{5, 6}, {7, 8}};
            System.out.println("\n49. Multiplied Matrix: " + Arrays.deepToString(multiplyMatrices(mat1, mat2)));

            System.out.println("\n50. Is Harshad: " + isHarshad(18));
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


    public static class ComprehensiveUtilityPrograms {

        // 51. Sorting Algorithms: Bubble, Insertion, Selection
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        public static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

        public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) minIndex = j;
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // 52. Longest substring without repeating characters
        public static int longestSubstringWithoutRepeating(String s) {
            Set<Character> set = new HashSet<>();
            int maxLen = 0, left = 0;
            for (int right = 0; right < s.length(); right++) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left++));
                }
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }

        // 53. Count set bits
        public static int countSetBits(int n) {
            int count = 0;
            while (n > 0) {
                count += n & 1;
                n >>= 1;
            }
            return count;
        }

        // 54. Tower of Hanoi
        public static void towerOfHanoi(int n, char from, char to, char aux) {
            if (n == 0) return;
            towerOfHanoi(n - 1, from, aux, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            towerOfHanoi(n - 1, aux, to, from);
        }

        // 55. Generate all subsets
        public static void generateSubsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            generateSubsetHelper(nums, 0, new ArrayList<>(), result);
            System.out.println(result);
        }

        private static void generateSubsetHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
            if (index == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }
            current.add(nums[index]);
            generateSubsetHelper(nums, index + 1, current, result);
            current.remove(current.size() - 1);
            generateSubsetHelper(nums, index + 1, current, result);
        }

        // 56. Longest Increasing Subsequence
        public static int longestIncreasingSubsequence(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int maxLen = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }

        // 57. Queue using two stacks
        static class QueueUsingTwoStacks {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            public void enqueue(int x) {
                stack1.push(x);
            }

            public int dequeue() {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                return stack2.isEmpty() ? -1 : stack2.pop();
            }
        }

        // 58. Median of two sorted arrays
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] merged = mergeSortedArrays(nums1, nums2);
            int n = merged.length;
            if (n % 2 == 0) {
                return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
            } else {
                return merged[n / 2];
            }
        }

        private static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
            int[] merged = new int[nums1.length + nums2.length];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            }
            while (i < nums1.length) merged[k++] = nums1[i++];
            while (j < nums2.length) merged[k++] = nums2[j++];
            return merged;
        }

        // 59. Detect cycle in a linked list
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        public static boolean detectCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        // 60. Find nth Fibonacci number using dynamic programming
        public static int fibonacci(int n) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        public static void main(String[] args) {
            // Demonstrate one example from each
            System.out.println("Bubble Sort: ");
            int[] arr = {5, 3, 8, 6, 2};
            bubbleSort(arr);
            System.out.println(Arrays.toString(arr));

            System.out.println("Longest Substring: " + longestSubstringWithoutRepeating("abcabcbb"));

            System.out.println("Count Set Bits: " + countSetBits(5));

            System.out.println("Tower of Hanoi: ");
            towerOfHanoi(3, 'A', 'C', 'B');

            System.out.println("Generate Subsets: ");
            generateSubsets(new int[]{1, 2, 3});

            System.out.println("Longest Increasing Subsequence: " + longestIncreasingSubsequence(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

            QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            System.out.println("Queue Dequeue: " + queue.dequeue());

            System.out.println("Median of Two Sorted Arrays: " + findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        }
    }


    public static class AdvancedUtilityPrograms {

        // 61. Minimum number of coins for a given amount
        public static int minCoins(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }

        // 62. Stack with push, pop, and getMin in O(1)
        static class MinStack {
            private Stack<Integer> stack = new Stack<>();
            private Stack<Integer> minStack = new Stack<>();

            public void push(int x) {
                stack.push(x);
                if (minStack.isEmpty() || x <= minStack.peek()) {
                    minStack.push(x);
                }
            }

            public void pop() {
                if (stack.pop().equals(minStack.peek())) {
                    minStack.pop();
                }
            }

            public int top() {
                return stack.peek();
            }

            public int getMin() {
                return minStack.peek();
            }
        }

        // 63. Count the number of islands in a 2D grid
        public static int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int numIslands = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        numIslands += dfs(grid, i, j);
                    }
                }
            }
            return numIslands;
        }

        private static int dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return 0;
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            return 1;
        }

        // 64. Maximum area of a rectangle in a histogram
        public static int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0, i = 0;
            while (i <= heights.length) {
                int h = (i == heights.length) ? 0 : heights[i];
                if (stack.isEmpty() || h >= heights[stack.peek()]) {
                    stack.push(i++);
                } else {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
            }
            return maxArea;
        }

        // 65. Sieve of Eratosthenes
        public static List<Integer> sieveOfEratosthenes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) primes.add(i);
            }
            return primes;
        }

        // 66. Solve N-Queens problem
        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> results = new ArrayList<>();
            solveNQueensHelper(n, 0, new int[n], results);
            return results;
        }

        private static void solveNQueensHelper(int n, int row, int[] queens, List<List<String>> results) {
            if (row == n) {
                results.add(constructBoard(queens, n));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isValid(queens, row, col)) {
                    queens[row] = col;
                    solveNQueensHelper(n, row + 1, queens, results);
                }
            }
        }

        private static boolean isValid(int[] queens, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
            }
            return true;
        }

        private static List<String> constructBoard(int[] queens, int n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }

        // 67. Dijkstra's shortest path algorithm
        public static int[] dijkstra(int[][] graph, int src) {
            int V = graph.length;
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{src, 0});
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int u = curr[0];
                int d = curr[1];
                if (d > dist[u]) continue;
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }
            return dist;
        }

        // Main Method to Demonstrate Selected Functions
        public static void main(String[] args) {
            // 61. Minimum Coins Example
            int[] coins = {1, 2, 5};
            int amount = 11;
            System.out.println("Minimum Coins: " + minCoins(coins, amount));

            // 62. MinStack Example
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            System.out.println("Min: " + minStack.getMin()); // -3
            minStack.pop();
            System.out.println("Top: " + minStack.top()); // 0
            System.out.println("Min: " + minStack.getMin()); // -2

            // 63. Number of Islands
            char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println("Number of Islands: " + numIslands(grid));

            // 64. Largest Rectangle in Histogram
            int[] heights = {2, 1, 5, 6, 2, 3};
            System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));

            // 65. Sieve of Eratosthenes
            System.out.println("Primes up to 30: " + sieveOfEratosthenes(30));

            // 66. N-Queens
            System.out.println("N-Queens (4): " + solveNQueens(4));

            // 67. Dijkstra's Algorithm
            int[][] graph = {
                    {0, 10, 0, 0, 0},
                    {10, 0, 5, 0, 0},
                    {0, 5, 0, 20, 1},
                    {0, 0, 20, 0, 2},
                    {0, 0, 1, 2, 0}
            };
            System.out.println("Shortest Paths from Node 0: " + Arrays.toString(dijkstra(graph, 0)));
        }
    }


    public static class BinaryTreeAndAlgorithms {

        // 68. Implement Binary Search Tree and Basic Operations
        static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                this.val = val;
                left = right = null;
            }
        }

        static class BinarySearchTree {
            TreeNode root;

            // Insert a node
            public void insert(int key) {
                root = insertRec(root, key);
            }

            private TreeNode insertRec(TreeNode root, int key) {
                if (root == null) {
                    root = new TreeNode(key);
                    return root;
                }
                if (key < root.val) root.left = insertRec(root.left, key);
                else if (key > root.val) root.right = insertRec(root.right, key);
                return root;
            }

            // In-order traversal
            public void inorder(TreeNode root) {
                if (root != null) {
                    inorder(root.left);
                    System.out.print(root.val + " ");
                    inorder(root.right);
                }
            }
        }

        // 69. Serialize and Deserialize a Binary Tree
        public static String serialize(TreeNode root) {
            if (root == null) return "null,";
            return root.val + "," + serialize(root.left) + serialize(root.right);
        }

        public static TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeHelper(nodes);
        }

        private static TreeNode deserializeHelper(Queue<String> nodes) {
            String val = nodes.poll();
            if (val.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }

        // 70. Check if Two Binary Trees are Identical
        public static boolean isIdentical(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
        }

        // 71. Find the Diameter of a Binary Tree
        public static int diameterOfBinaryTree(TreeNode root) {
            int[] diameter = {0};
            depth(root, diameter);
            return diameter[0];
        }

        private static int depth(TreeNode node, int[] diameter) {
            if (node == null) return 0;
            int left = depth(node.left, diameter);
            int right = depth(node.right, diameter);
            diameter[0] = Math.max(diameter[0], left + right);
            return Math.max(left, right) + 1;
        }

        // 72. Solve the Knapsack Problem using Dynamic Programming
        public static int knapsack(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            int[][] dp = new int[n + 1][capacity + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= capacity; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
            return dp[n][capacity];
        }

        // 73. Find the Longest Palindromic Substring
        public static String longestPalindrome(String s) {
            int n = s.length();
            if (n == 0) return "";
            boolean[][] dp = new boolean[n][n];
            int start = 0, maxLength = 1;

            for (int i = 0; i < n; i++) dp[i][i] = true;

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j)) {
                        if (len == 2) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                        if (dp[i][j] && len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLength);
        }

        // 74. Generate All Valid Parentheses Combinations for n Pairs
        public static List<String> generateParentheses(int n) {
            List<String> result = new ArrayList<>();
            generateParenthesesHelper(result, "", 0, 0, n);
            return result;
        }

        private static void generateParenthesesHelper(List<String> result, String current, int open, int close, int max) {
            if (current.length() == max * 2) {
                result.add(current);
                return;
            }
            if (open < max) generateParenthesesHelper(result, current + "(", open + 1, close, max);
            if (close < open) generateParenthesesHelper(result, current + ")", open, close + 1, max);
        }

        // 75. Maximum Profit in Stock Trading with At Most Two Transactions
        public static int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int[] left = new int[n];
            int[] right = new int[n];

            int minPrice = prices[0];
            for (int i = 1; i < n; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            }

            int maxPrice = prices[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxPrice = Math.max(maxPrice, prices[i]);
                right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            }

            int maxProfit = 0;
            for (int i = 0; i < n; i++) {
                maxProfit = Math.max(maxProfit, left[i] + right[i]);
            }
            return maxProfit;
        }

        // Main Method for Testing
        public static void main(String[] args) {
            // Binary Search Tree
            BinarySearchTree bst = new BinarySearchTree();
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(1);
            bst.inorder(bst.root); // Output: 1 3 5 7

            // Serialize and Deserialize
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(4);
            root.right.right = new TreeNode(5);
            String serialized = serialize(root);
            System.out.println("\nSerialized: " + serialized);
            TreeNode deserialized = deserialize(serialized);
            System.out.println("Deserialized Root: " + deserialized.val);

            // Check Identical Trees
            System.out.println("Identical Trees: " + isIdentical(root, deserialized));

            // Diameter of Binary Tree
            System.out.println("Diameter: " + diameterOfBinaryTree(root));

            // Knapsack
            int[] weights = {1, 2, 3};
            int[] values = {10, 15, 40};
            int capacity = 6;
            System.out.println("Knapsack Max Value: " + knapsack(weights, values, capacity));

            // Longest Palindromic Substring
            System.out.println("Longest Palindrome: " + longestPalindrome("babad"));

            // Generate Parentheses
            System.out.println("Parentheses Combinations: " + generateParentheses(3));

            // Max Profit with Two Transactions
            int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
            System.out.println("Max Profit: " + maxProfit(prices));
        }
    }
    /*
    Mini-Project: Employee Salary Calculator

This project uses variables, data types, and operators to calculate an employee’s gross salary based on conditions.

Problem Statement:
	•	Input the basic salary of an employee.
	•	Calculate the following based on the salary:
	•	HRA (House Rent Allowance): 20% of basic salary.
	•	DA (Dearness Allowance): 50% of basic salary.
	•	Tax Deduction:
	•	10% tax if gross salary > ₹50,000.
	•	5% tax if gross salary ≤ ₹50,000.
	•	Calculate and display the gross salary and net salary.
     */


    public static class SalaryCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input basic salary
            System.out.print("Enter basic salary: ");
            double basicSalary = scanner.nextDouble();

            // Calculate HRA and DA
            double hra = basicSalary * 0.2;
            double da = basicSalary * 0.5;

            // Calculate gross salary
            double grossSalary = basicSalary + hra + da;

            // Calculate tax
            double tax;
            if (grossSalary > 50000) {
                tax = grossSalary * 0.1; // 10% tax
            } else {
                tax = grossSalary * 0.05; // 5% tax
            }

            // Calculate net salary
            double netSalary = grossSalary - tax;

            // Display results
            System.out.println("Gross Salary: " + grossSalary);
            System.out.println("Tax Deducted: " + tax);
            System.out.println("Net Salary: " + netSalary);

            scanner.close();
        }
    }

    /*
    1. Currency Converter

Problem Statement:

Write a program to convert an amount in one currency to another (e.g., USD to INR). Use a fixed conversion rate.
     */
    public static class CurrencyConverter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Conversion rate (USD to INR)
            double conversionRate = 82.5;

            // Input amount in USD
            System.out.print("Enter amount in USD: ");
            double usd = scanner.nextDouble();

            // Convert to INR
            double inr = usd * conversionRate;

            // Display result
            System.out.println(usd + " USD = " + inr + " INR");

            scanner.close();
        }
    }

    /*
    2. Temperature Converter

Problem Statement:

Convert temperature from Celsius to Fahrenheit and vice versa. The formula for conversion is:
	•	Fahrenheit = (Celsius * 9/5) + 32
	•	Celsius = (Fahrenheit - 32) * 5/9
     */

    public static class TemperatureConverters {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input temperature and conversion choice
            System.out.print("Enter temperature: ");
            double temperature = scanner.nextDouble();
            System.out.print("Convert to (C)elsius or (F)ahrenheit? ");
            char choice = scanner.next().charAt(0);

            if (choice == 'C' || choice == 'c') {
                double celsius = (temperature - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + celsius);
            } else if (choice == 'F' || choice == 'f') {
                double fahrenheit = (temperature * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
            } else {
                System.out.println("Invalid choice.");
            }

            scanner.close();
        }
    }
    /*
    3. Grade Calculator

Problem Statement:

Accept marks for five subjects, calculate the average, and assign a grade:
	•	Grade A: Average >= 90
	•	Grade B: Average >= 75 and < 90
	•	Grade C: Average >= 50 and < 75
	•	Grade F: Average < 50
     */

    public static class GradeCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input marks for 5 subjects
            System.out.print("Enter marks for 5 subjects: ");
            int subject1 = scanner.nextInt();
            int subject2 = scanner.nextInt();
            int subject3 = scanner.nextInt();
            int subject4 = scanner.nextInt();
            int subject5 = scanner.nextInt();

            // Calculate total and average
            int total = subject1 + subject2 + subject3 + subject4 + subject5;
            double average = total / 5.0;

            // Determine grade
            char grade;
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 75) {
                grade = 'B';
            } else if (average >= 50) {
                grade = 'C';
            } else {
                grade = 'F';
            }

            // Display results
            System.out.println("Total Marks: " + total);
            System.out.println("Average: " + average);
            System.out.println("Grade: " + grade);

            scanner.close();
        }
    }

    /*
    4. Simple Calculator

Problem Statement:

Write a calculator that performs basic arithmetic operations (+, -, *, /, %). Input two numbers and an operator from the user.
     */

    public static class SimpleCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input numbers and operator
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.print("Enter an operator (+, -, *, /, %): ");
            char operator = scanner.next().charAt(0);

            // Perform operation
            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero.");
                    }
                    break;
                case '%':
                    result = num1 % num2;
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println("Invalid operator.");
            }

            scanner.close();
        }
    }

    /*
    5. Leap Year Checker

Problem Statement:

Check whether a given year is a leap year or not. A leap year satisfies the following:
	•	Divisible by 4
	•	Not divisible by 100 unless divisible by 400

     */

    public static class LeapYearChecker {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input year
            System.out.print("Enter a year: ");
            int year = scanner.nextInt();

            // Check leap year
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }

            scanner.close();
        }
    }
    /*
    6. BMI Calculator

Problem Statement:

Calculate the Body Mass Index (BMI) based on the formula:
	•	BMI = weight (kg) / height² (m²)
	•	Categorize the result as:
	•	Underweight: BMI < 18.5
	•	Normal weight: 18.5 <= BMI < 24.9
	•	Overweight: 25 <= BMI < 29.9
	•	Obese: BMI >= 30
     */

    public static class BMICalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input weight and height
            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.print("Enter height (m): ");
            double height = scanner.nextDouble();

            // Calculate BMI
            double bmi = weight / (height * height);

            // Categorize BMI
            System.out.println("BMI: " + bmi);
            if (bmi < 18.5) {
                System.out.println("Category: Underweight");
            } else if (bmi < 24.9) {
                System.out.println("Category: Normal weight");
            } else if (bmi < 29.9) {
                System.out.println("Category: Overweight");
            } else {
                System.out.println("Category: Obese");
            }

            scanner.close();
        }
    }
    /*
    Project: Student Management System

Objective:

Build a console-based Student Management System where you can:
	1.	Add student details (Name, Age, Grade, ID, etc.).
	2.	Display a list of all students.
	3.	Search for a student by ID.
	4.	Delete a student record.
	5.	Update student details.
	6.	Calculate the average grade of all students.

	Requirements:
	•	Use variables to store student details.
	•	Use data types like int, String, and double.
	•	Implement operators for calculations and conditions.
	•	Use arrays or lists for storing multiple student records.
     */


    static class Student {
        int id;
        String name;
        int age;
        double grade;

        public Student(int id, String name, int age, double grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
        }
    }

    public static class StudentManagementSystem {
        static ArrayList<Student> students = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Delete Student");
                System.out.println("5. Update Student Details");
                System.out.println("6. Calculate Average Grade");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        searchStudentById();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        updateStudent();
                        break;
                    case 6:
                        calculateAverageGrade();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        // Add a new student
        public static void addStudent() {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            System.out.print("Enter Grade: ");
            double grade = scanner.nextDouble();

            students.add(new Student(id, name, age, grade));
            System.out.println("Student added successfully!");
        }

        // Display all students
        public static void displayStudents() {
            if (students.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                System.out.println("\nList of Students:");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }

        // Search for a student by ID
        public static void searchStudentById() {
            System.out.print("Enter Student ID to search: ");
            int id = scanner.nextInt();
            for (Student student : students) {
                if (student.id == id) {
                    System.out.println("Student Found: " + student);
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        // Delete a student by ID
        public static void deleteStudent() {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            for (Student student : students) {
                if (student.id == id) {
                    students.remove(student);
                    System.out.println("Student removed successfully!");
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        // Update student details
        public static void updateStudent() {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            for (Student student : students) {
                if (student.id == id) {
                    System.out.print("Enter new Name: ");
                    scanner.nextLine(); // Consume newline
                    student.name = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    student.age = scanner.nextInt();
                    System.out.print("Enter new Grade: ");
                    student.grade = scanner.nextDouble();
                    System.out.println("Student details updated successfully!");
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        // Calculate average grade
        public static void calculateAverageGrade() {
            if (students.isEmpty()) {
                System.out.println("No students available to calculate average grade.");
                return;
            }
            double totalGrade = 0;
            for (Student student : students) {
                totalGrade += student.grade;
            }
            double average = totalGrade / students.size();
            System.out.println("Average Grade: " + average);
        }
    }
    /*
    Right-Angled Triangle
*
**
***
****
*****
     */

    public static class RightAngledTriangle {
        public static void main(String[] args) {
            int n = 5; // Number of rows for the triangle

            // Loop through each row
            for (int i = 1; i <= n; i++) {
                // Print '*' i times for the current row
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                // Move to the next line after printing '*' for the current row
                System.out.println();
            }
        }
    }

    /*
    Inverted Triangle
*****
****
***
**
*
     */
    public static class InvertedTriangle {
        public static void main(String[] args) {
            for (int i = 5; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    /*
  Pyramid
      *
     ***
    *****
   *******
  *********
  */
    public static class Pyramid {
        public static void main(String[] args) {
            int n = 5; // Number of rows for the pyramid

            // Outer loop for each row
            for (int i = 1; i <= n; i++) {
                // Print spaces before the stars
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }

                // Print stars for the current row
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("*");
                }

                // Move to the next line after printing each row
                System.out.println();
            }
        }
    }

    /*
Diamond
*
* *
* *
* *
* *
* *
*
*/
    public static class Diamond {
        public static void main(String[] args) {
            int n = 7; // Total number of rows (must be odd for symmetry)

            // Loop through each row
            for (int i = 1; i <= n; i++) {
                // Print the first '*' for each row
                System.out.print("*");

                // For rows other than the first and last, print spaces and another '*'
                if (i > 1 && i < n) {
                    for (int j = 1; j < i - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(" *");
                }

                // Move to the next line
                System.out.println();
            }
        }
    }

    /*
Butterfly Pattern
*       *
**     **
***   ***
**** ****
*********
**** ****
***   ***
**     **
*       *
*/
    public static class Butterfly {
        public static void main(String[] args) {
            int n = 5; // Number of rows for the upper and lower parts

            // Upper part of the butterfly
            for (int i = 1; i <= n; i++) {
                // Print the left side stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                // Print spaces in the middle
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }
                // Print the right side stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                // Move to the next line
                System.out.println();
            }

            // Lower part of the butterfly
            for (int i = n; i >= 1; i--) {
                // Print the left side stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                // Print spaces in the middle
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }
                // Print the right side stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                // Move to the next line
                System.out.println();
            }
        }
    }

    /*
    Incremental Numbers
    1
    12
    123
    1234
    */
    public static class IncrementalNumbers {
        public static void main(String[] args) {
            int n = 4; // Number of rows

            // Loop through each row
            for (int i = 1; i <= n; i++) {
                // Print numbers from 1 to i
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                // Move to the next line
                System.out.println();
            }
        }
    }

    /*
   Number Pyramid
      1
     121
    12321
   1234321
   */
    public static class NumberPyramid {
        public static void main(String[] args) {
            int n = 4; // Number of rows

            // Outer loop for rows
            for (int i = 1; i <= n; i++) {
                // Print spaces for alignment
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }

                // Print numbers in increasing order
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }

                // Print numbers in decreasing order
                for (int j = i - 1; j >= 1; j--) {
                    System.out.print(j);
                }

                // Move to the next row
                System.out.println();
            }
        }
    }

    /*
Floyd's Triangle
   1
   2 3
   4 5 6
   7 8 9 10
*/
    public static class FloydsTriangle {
        public static void main(String[] args) {
            int n = 4; // Number of rows
            int num = 1; // Start number

            // Outer loop for each row
            for (int i = 1; i <= n; i++) {
                // Inner loop to print numbers in the current row
                for (int j = 1; j <= i; j++) {
                    System.out.print(num + " ");
                    num++; // Increment number after printing
                }
                // Move to the next line after printing each row
                System.out.println();
            }
        }
    }

    /*
    Triangle of Letters
       A
       AB
       ABC
       ABCD
    */
    public static class TriangleOfLetters {
        public static void main(String[] args) {
            int n = 4; // Number of rows

            // Outer loop for each row
            for (int i = 1; i <= n; i++) {
                // Inner loop to print letters from A to the current row letter
                for (int j = 1; j <= i; j++) {
                    System.out.print((char) ('A' + j - 1)); // Convert number to corresponding letter
                }
                // Move to the next line after printing each row
                System.out.println();
            }
        }
    }

    /*
Inverted Triangle
   EDCBA
   DCBA
   CBA
   BA
   A
*/
    public static class InvertedTriangleOfLetters {
        public static void main(String[] args) {
            int n = 5; // Number of rows (starting letter is 'E')

            // Outer loop for each row
            for (int i = n; i >= 1; i--) {
                // Inner loop to print letters in reverse order
                for (int j = i; j >= 1; j--) {
                    System.out.print((char) ('A' + j - 1)); // Convert number to corresponding letter
                }
                // Move to the next line after printing each row
                System.out.println();
            }
        }
    }

    /*
Checkerboard Pattern
* * * *
* * * *
* * * *
* * * *
*/
    public static class CheckerboardPattern {
        public static void main(String[] args) {
            int n = 4; // Number of rows and columns

            // Outer loop for rows
            for (int i = 1; i <= n; i++) {
                // Inner loop for columns
                for (int j = 1; j <= n; j++) {
                    System.out.print("* "); // Print '*' followed by space
                }
                // Move to the next line after each row
                System.out.println();
            }
        }
    }

    /*
    Zig-Zag Pattern
    * * *
    * * *
    */
    public static class ZigZagPattern {
        public static void main(String[] args) {
            int n = 2; // Number of rows

            // Outer loop for rows
            for (int i = 1; i <= n; i++) {
                // Inner loop to print * with space in each row
                for (int j = 1; j <= 3; j++) {
                    System.out.print("* ");
                }
                // Move to the next line after each row
                System.out.println();
            }
        }
    }

    /*
Sandglass Pattern
*****
 ***
  *
 ***
*****
*/
    public static class SandglassPattern {
        public static void main(String[] args) {
            int n = 5; // Number of rows (upper half)

            // Upper half of the sandglass
            for (int i = n; i >= 1; i -= 2) {
                // Print leading spaces for alignment
                for (int j = 0; j < (n - i) / 2; j++) {
                    System.out.print(" ");
                }
                // Print stars for the current row
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            // Lower half of the sandglass
            for (int i = 3; i <= n; i += 2) {
                // Print leading spaces for alignment
                for (int j = 0; j < (n - i) / 2; j++) {
                    System.out.print(" ");
                }
                // Print stars for the current row
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    /*

1. If-Else Conditions

Basics:
	•	The if-else condition is used to execute a block of code based on a boolean condition.
	•	Syntax:

if (condition) {
    // Code to execute if condition is true
} else {
    // Code to execute if condition is false
}

Advanced:
	•	Nested If-Else:
Multiple conditions can be checked in a sequence.

if (condition1) {
    // Code if condition1 is true
} else if (condition2) {
    // Code if condition2 is true
} else {
    // Code if none of the above conditions are true
}


	•	Use in Real Life:
Example: Calculate tax based on income brackets.

2. Switch

Basics:
	•	The switch statement is used to simplify a chain of if-else conditions when checking a single variable against multiple values.
	•	Syntax:

switch (variable) {
    case value1:
        // Code if variable == value1
        break;
    case value2:
        // Code if variable == value2
        break;
    default:
        // Code if none of the cases match
}

Advanced:
	•	Fall-through: Cases without break statements will execute sequentially.

switch (day) {
    case "Monday":
    case "Tuesday":
        System.out.println("Workday");
        break;
    default:
        System.out.println("Weekend");
}


	•	Expression-Based Switch (Java 12+):

int result = switch (variable) {
    case value1 -> 1;
    case value2 -> 2;
    default -> 0;
};


	•	Use in Real Life:
Example: Perform operations based on user input (+, -, *, /).

3. For Loop

Basics:
	•	Used to iterate a block of code a fixed number of times.
	•	Syntax:

for (initialization; condition; increment/decrement) {
    // Code to execute
}

Advanced:
	•	Nested For Loop:
Loops inside another loop for multi-dimensional operations.

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        System.out.print("*");
    }
    System.out.println();
}


	•	Use in Real Life:
Example: Generate multiplication tables or patterns.

4. While Loop

Basics:
	•	Used when the number of iterations is not known in advance.
	•	Syntax:

while (condition) {
    // Code to execute
}

Advanced:
	•	Combine with break/continue to control flow dynamically.
	•	Infinite While Loop:

while (true) {
    // Code to execute forever unless a break occurs
    break;
}


	•	Use in Real Life:
Example: Wait for user input until a specific key is pressed.

5. Do-While Loop

Basics:
	•	Similar to while, but executes the block at least once.
	•	Syntax:

do {
    // Code to execute
} while (condition);

Advanced:
	•	Combine with if for conditional execution.
	•	Example:
Validate user input until they provide valid data.

int input;
do {
    input = scanner.nextInt();
} while (input <= 0);


	•	Use in Real Life:
Example: Input validation in forms.

6. For-Each Loop

Basics:
	•	Simplifies iteration over collections or arrays.
	•	Syntax:

for (dataType item : collection) {
    // Code to execute
}

Advanced:
	•	Works with Streams (Java 8+):

list.stream().forEach(System.out::println);


	•	Use in Real Life:
Example: Display all items in a shopping cart.

7. Functions

Basics:
	•	A reusable block of code that performs a specific task.
	•	Syntax:

returnType functionName(parameters) {
    // Code
    return value; // Optional
}

Advanced:
	•	Overloading:
Define multiple functions with the same name but different parameters.

int add(int a, int b);
double add(double a, double b);


	•	Recursion:
A function that calls itself.

int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}


	•	Use in Real Life:
Example: Compute factorial or Fibonacci numbers.

8. Arrays

Basics:
	•	A collection of elements of the same data type.
	•	Syntax:

dataType[] arrayName = new dataType[size];

Advanced:
	•	Multi-Dimensional Arrays:
Represent tables or grids.

int[][] matrix = new int[rows][cols];


	•	Sorting and Searching:
Use algorithms like Bubble Sort or Binary Search.

Arrays.sort(array);
int index = Arrays.binarySearch(array, key);


	•	Use in Real Life:
Example: Store and process exam scores.

Logical Flow Examples:
	1.	Find Maximum in an Array:

int max = arr[0];
for (int num : arr) {
    if (num > max) {
        max = num;
    }
}


	2.	Pattern Printing (For Loop):

for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}


	3.	Factorial Using Recursion:

int factorial(int n) {
    return (n == 0) ? 1 : n * factorial(n - 1);
}



     */

    public static class StudentGradeManagementSystem {
        // Array to store student details
        static String[] studentNames = new String[100];
        static int[] rollNumbers = new int[100];
        static int[] marks = new int[100];
        static char[] grades = new char[100];
        static int studentCount = 0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Display menu
                System.out.println("\nStudent Grade Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Calculate Grades");
                System.out.println("3. Display All Students");
                System.out.println("4. Find Top Performer");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        calculateGrades();
                        break;
                    case 3:
                        displayAllStudents();
                        break;
                    case 4:
                        findTopPerformer();
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        // Feature 1: Add Student
        public static void addStudent(Scanner scanner) {
            System.out.print("Enter student name: ");
            studentNames[studentCount] = scanner.next();
            System.out.print("Enter roll number: ");
            rollNumbers[studentCount] = scanner.nextInt();
            System.out.print("Enter marks (out of 100): ");
            marks[studentCount] = scanner.nextInt();
            studentCount++;
            System.out.println("Student added successfully!");
        }

        // Feature 2: Calculate Grades
        public static void calculateGrades() {
            for (int i = 0; i < studentCount; i++) {
                if (marks[i] >= 90) {
                    grades[i] = 'A';
                } else if (marks[i] >= 80) {
                    grades[i] = 'B';
                } else if (marks[i] >= 70) {
                    grades[i] = 'C';
                } else if (marks[i] >= 60) {
                    grades[i] = 'D';
                } else {
                    grades[i] = 'F';
                }
            }
            System.out.println("Grades calculated successfully!");
        }

        // Feature 3: Display All Students
        public static void displayAllStudents() {
            if (studentCount == 0) {
                System.out.println("No students to display.");
                return;
            }

            System.out.println("\nStudent Details:");
            for (int i = 0; i < studentCount; i++) {
                System.out.println("Name: " + studentNames[i] +
                        ", Roll Number: " + rollNumbers[i] +
                        ", Marks: " + marks[i] +
                        ", Grade: " + (grades[i] != '\0' ? grades[i] : "N/A"));
            }
        }

        // Feature 4: Find Top Performer
        public static void findTopPerformer() {
            if (studentCount == 0) {
                System.out.println("No students to evaluate.");
                return;
            }

            int topIndex = 0;
            for (int i = 1; i < studentCount; i++) {
                if (marks[i] > marks[topIndex]) {
                    topIndex = i;
                }
            }

            System.out.println("Top Performer:");
            System.out.println("Name: " + studentNames[topIndex] +
                    ", Roll Number: " + rollNumbers[topIndex] +
                    ", Marks: " + marks[topIndex] +
                    ", Grade: " + grades[topIndex]);
        }
    }

    /*
    	1.	Library Management System
	2.	Simple Banking System
	3.	Quiz Game
	4.	Expense Tracker
	5.	Number Guessing Game
	6.	To-Do List
	7.	Temperature Conversion Tool
	8.	Inventory Management System
	9.	Restaurant Billing System
	10.	Basic Calendar Application
	11.	Digital Clock
	12.	Word Counter Tool

     */



    public static class UtilityProgramsss {

        // 1. Library Management System
        public static class Library {
            private Map<String, Boolean> books = new HashMap<>();

            public void addBook(String bookName) {
                books.put(bookName, true); // true means available
            }

            public void borrowBook(String bookName) {
                if (books.getOrDefault(bookName, false)) {
                    books.put(bookName, false); // borrowed
                    System.out.println("You have borrowed: " + bookName);
                } else {
                    System.out.println("Book is not available.");
                }
            }

            public void returnBook(String bookName) {
                if (!books.getOrDefault(bookName, true)) {
                    books.put(bookName, true); // returned
                    System.out.println("You have returned: " + bookName);
                } else {
                    System.out.println("Book was not borrowed.");
                }
            }

            public void viewBooks() {
                System.out.println("Library Books:");
                for (Map.Entry<String, Boolean> entry : books.entrySet()) {
                    System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Available" : "Not Available"));
                }
            }
        }

        // 2. Simple Banking System
        public static class BankAccount {
            private double balance = 0.0;

            public void deposit(double amount) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            }

            public void withdraw(double amount) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrew: $" + amount);
                } else {
                    System.out.println("Insufficient funds.");
                }
            }

            public void checkBalance() {
                System.out.println("Balance: $" + balance);
            }
        }

        // 3. Quiz Game
        public static class QuizGame {
            private Map<String, String> questionsAndAnswers = new HashMap<>();
            private int score = 0;

            public void addQuestion(String question, String answer) {
                questionsAndAnswers.put(question, answer);
            }

            public void startGame() {
                Scanner scanner = new Scanner(System.in);
                for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
                    System.out.print(entry.getKey() + ": ");
                    String userAnswer = scanner.nextLine();
                    if (userAnswer.equalsIgnoreCase(entry.getValue())) {
                        score++;
                    }
                }
                System.out.println("Your score: " + score + "/" + questionsAndAnswers.size());
            }
        }

        // 4. Expense Tracker
        public static class ExpenseTracker {
            private double totalExpenses = 0.0;

            public void addExpense(double amount) {
                totalExpenses += amount;
                System.out.println("Expense added: $" + amount);
            }

            public void viewExpenses() {
                System.out.println("Total Expenses: $" + totalExpenses);
            }
        }

        // 5. Number Guessing Game
        public static class NumberGuessingGame {
            private int numberToGuess;

            public void startGame() {
                Random rand = new Random();
                numberToGuess = rand.nextInt(100) + 1;
                Scanner scanner = new Scanner(System.in);
                int guess;
                System.out.println("Guess a number between 1 and 100:");
                while (true) {
                    guess = scanner.nextInt();
                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Correct! The number was " + numberToGuess);
                        break;
                    }
                }
            }
        }

        // 6. To-Do List
        public static class ToDoList {
            private List<String> tasks = new ArrayList<>();

            public void addTask(String task) {
                tasks.add(task);
                System.out.println("Task added: " + task);
            }

            public void removeTask(String task) {
                tasks.remove(task);
                System.out.println("Task removed: " + task);
            }

            public void viewTasks() {
                System.out.println("To-Do List:");
                for (String task : tasks) {
                    System.out.println(task);
                }
            }
        }

        // 7. Temperature Conversion Tool
        public static class TemperatureConverter {
            public static double celsiusToFahrenheit(double celsius) {
                return (celsius * 9/5) + 32;
            }

            public static double fahrenheitToCelsius(double fahrenheit) {
                return (fahrenheit - 32) * 5/9;
            }
        }

        // 8. Inventory Management System
        public static class Inventory {
            private Map<String, Integer> items = new HashMap<>();

            public void addItem(String item, int quantity) {
                items.put(item, items.getOrDefault(item, 0) + quantity);
                System.out.println(quantity + " " + item + "(s) added.");
            }

            public void removeItem(String item, int quantity) {
                if (items.containsKey(item) && items.get(item) >= quantity) {
                    items.put(item, items.get(item) - quantity);
                    System.out.println(quantity + " " + item + "(s) removed.");
                } else {
                    System.out.println("Insufficient stock.");
                }
            }

            public void viewInventory() {
                System.out.println("Inventory:");
                for (Map.Entry<String, Integer> entry : items.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        // 9. Restaurant Billing System
        public static class RestaurantBilling {
            private Map<String, Double> menu = new HashMap<>();
            private Map<String, Integer> order = new HashMap<>();

            public void addToMenu(String item, double price) {
                menu.put(item, price);
            }

            public void placeOrder(String item, int quantity) {
                if (menu.containsKey(item)) {
                    order.put(item, order.getOrDefault(item, 0) + quantity);
                } else {
                    System.out.println("Item not on menu.");
                }
            }

            public void viewBill() {
                double total = 0.0;
                System.out.println("Bill:");
                for (Map.Entry<String, Integer> entry : order.entrySet()) {
                    double itemPrice = menu.get(entry.getKey());
                    total += itemPrice * entry.getValue();
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " x $" + itemPrice);
                }
                System.out.println("Total: $" + total);
            }
        }

        // 10. Basic Calendar Application
        public static class BasicCalendar {
            public void showCurrentDate() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("Current Date: " + sdf.format(new Date()));
            }
        }

        // 11. Digital Clock
        public static class DigitalClock {
            public void startClock() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println(sdf.format(new Date()));
                    }
                }, 0, 1000);
            }
        }

        // 12. Word Counter Tool
        public static class WordCounter {
            public void countWords(String text) {
                String[] words = text.split("\\s+");
                System.out.println("Word Count: " + words.length);
            }
        }

        public static void main(String[] args) {
            // Example Usage:

            // Library Management System
            Library library = new Library();
            library.addBook("Harry Potter");
            library.borrowBook("Harry Potter");
            library.viewBooks();

            // Simple Banking System
            BankAccount bank = new BankAccount();
            bank.deposit(1000);
            bank.withdraw(500);
            bank.checkBalance();

            // Quiz Game
            QuizGame quiz = new QuizGame();
            quiz.addQuestion("What is 2 + 2?", "4");
            quiz.startGame();

            // Expense Tracker
            ExpenseTracker expenseTracker = new ExpenseTracker();
            expenseTracker.addExpense(50.0);
            expenseTracker.viewExpenses();

            // Number Guessing Game
            NumberGuessingGame guessingGame = new NumberGuessingGame();
            guessingGame.startGame();

            // To-Do List
            ToDoList todoList = new ToDoList();
            todoList.addTask("Buy groceries");
            todoList.viewTasks();

            // Temperature Conversion Tool
            double celsius = 25;
            double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
            System.out.println(celsius + "°C = " + fahrenheit + "°F");

            // Inventory Management System
            Inventory inventory = new Inventory();
            inventory.addItem("Apple", 10);
            inventory.viewInventory();

            // Restaurant Billing System
            RestaurantBilling billing = new RestaurantBilling();
            billing.addToMenu("Burger", 5.99);
            billing.placeOrder("Burger", 2);
            billing.viewBill();

            // Basic Calendar Application
            BasicCalendar calendar = new BasicCalendar();
            calendar.showCurrentDate();

            // Digital Clock
            DigitalClock clock = new DigitalClock();
            clock.startClock();

            // Word Counter Tool
            WordCounter wordCounter = new WordCounter();
            wordCounter.countWords("This is a sample sentence.");
        }
    }
    public static class Simplecalculator {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Simple Calculator");
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        scanner.close();
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator. Please use +, -, *, or /.");
                    scanner.close();
                    return;
            }

            System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            scanner.close();
        }
    }

    public class UtilityProgramsAdv {

        // 76. Create a simple calculator
        public static double calculator(double a, double b, String operation) {
            switch (operation) {
                case "add":
                    return a + b;
                case "subtract":
                    return a - b;
                case "multiply":
                    return a * b;
                case "divide":
                    return a / b;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }
        }

        // 77. Validate an email address using regex
        public static boolean isValidEmail(String email) {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            return email.matches(regex);
        }

        // 78. Build a command-line to-do list application
        public static void todoList() {
            List<String> todoList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Todo");
                System.out.println("2. View Todos");
                System.out.println("3. Remove Todo");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == 1) {
                    System.out.print("Enter Todo: ");
                    todoList.add(scanner.nextLine());
                } else if (choice == 2) {
                    System.out.println("Todos:");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ". " + todoList.get(i));
                    }
                } else if (choice == 3) {
                    System.out.print("Enter Todo number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    todoList.remove(removeIndex);
                } else if (choice == 4) {
                    break;
                }
            }
        }

        // 79. Simulate a basic ticket booking system
        public static void ticketBookingSystem() {
            Scanner scanner = new Scanner(System.in);
            int availableTickets = 50;
            while (availableTickets > 0) {
                System.out.println("Available tickets: " + availableTickets);
                System.out.print("Enter number of tickets to book: ");
                int ticketsToBook = scanner.nextInt();
                if (ticketsToBook <= availableTickets) {
                    availableTickets -= ticketsToBook;
                    System.out.println(ticketsToBook + " tickets booked successfully!");
                } else {
                    System.out.println("Not enough tickets available.");
                }
            }
        }

        // 80. Check if a string is a valid IP address
        public static boolean isValidIPAddress(String ip) {
            String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
            return ip.matches(regex);
        }

        // 81. Parse a CSV file and calculate statistics
        public static void parseCSV(String filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int lineCount = 0;
                int columnCount = 0;
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(",");
                    lineCount++;
                    columnCount = Math.max(columnCount, columns.length);
                }
                System.out.println("Lines: " + lineCount + ", Columns: " + columnCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 82. Build a URL shortener logic
        private static Map<String, String> urlDatabase = new HashMap<>();
        private static String baseUrl = "http://short.ly/";
        private static int idCounter = 1;

        public static String shortenUrl(String longUrl) {
            String shortUrl = baseUrl + idCounter++;
            urlDatabase.put(shortUrl, longUrl);
            return shortUrl;
        }

        public static String getOriginalUrl(String shortUrl) {
            return urlDatabase.get(shortUrl);
        }

        // 83. Implement basic encryption and decryption using Caesar cipher
        public static String caesarEncrypt(String text, int shift) {
            StringBuilder result = new StringBuilder();
            for (char i : text.toCharArray()) {
                if (Character.isLetter(i)) {
                    char base = (Character.isLowerCase(i)) ? 'a' : 'A';
                    result.append((char) ((i - base + shift) % 26 + base));
                } else {
                    result.append(i);
                }
            }
            return result.toString();
        }

        public static String caesarDecrypt(String text, int shift) {
            return caesarEncrypt(text, 26 - shift);
        }

        // 84. Design a parking lot system with multiple levels
        public static class ParkingLot {
            private int capacity;
            private int availableSpots;

            public ParkingLot(int capacity) {
                this.capacity = capacity;
                this.availableSpots = capacity;
            }

            public boolean parkCar() {
                if (availableSpots > 0) {
                    availableSpots--;
                    return true;
                } else {
                    return false;
                }
            }

            public void leaveCar() {
                if (availableSpots < capacity) {
                    availableSpots++;
                }
            }

            public int getAvailableSpots() {
                return availableSpots;
            }
        }

        // 85. Implement a library management system
        public static class Library {
            private List<String> books = new ArrayList<>();

            public void addBook(String book) {
                books.add(book);
            }

            public void borrowBook(String book) {
                if (books.contains(book)) {
                    books.remove(book);
                    System.out.println("You borrowed: " + book);
                } else {
                    System.out.println("Book not available");
                }
            }

            public void returnBook(String book) {
                books.add(book);
                System.out.println("You returned: " + book);
            }

            public void viewBooks() {
                System.out.println("Books in library: " + books);
            }
        }

        // 86. Simulate a vending machine
        public static void vendingMachine() {
            Map<String, Integer> items = new HashMap<>();
            items.put("Soda", 1);
            items.put("Chips", 2);
            items.put("Candy", 1);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Items available: ");
                for (String item : items.keySet()) {
                    System.out.println(item + " - " + items.get(item) + " dollars");
                }
                System.out.print("Enter item to buy or type 'exit': ");
                String choice = scanner.nextLine();
                if (choice.equals("exit")) break;
                if (items.containsKey(choice)) {
                    System.out.print("Enter amount: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (amount >= items.get(choice)) {
                        System.out.println("You bought " + choice);
                        items.put(choice, items.get(choice) - amount);
                    } else {
                        System.out.println("Not enough money");
                    }
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }

        // 87. Create a simple chat application (simulated)
        public static void chatApp() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                System.out.println("Bot: " + message);
            }
        }

        // 88. Build a temperature conversion API using REST principles (Simulated with methods)
        public static double convertToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }

        public static double convertToFahrenheit(double celsius) {
            return (celsius * 9 / 5) + 32;
        }

        // 89. Simulate a banking system (create accounts, deposit, withdraw)
        public static class BankAccount {
            private String accountHolder;
            private double balance;

            public BankAccount(String accountHolder) {
                this.accountHolder = accountHolder;
                this.balance = 0.0;
            }

            public void deposit(double amount) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            }

            public void withdraw(double amount) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawn: " + amount);
                } else {
                    System.out.println("Insufficient balance");
                }
            }

            public void checkBalance() {
                System.out.println("Balance: " + balance);
            }
        }

        // 90. Implement the logic for a simple Tic-Tac-Toe game
        public static void ticTacToe() {
            char[][] board = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };
            char currentPlayer = 'X';

            while (true) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + "'s turn.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                int col = scanner.nextInt();

                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    if (checkWin(board, currentPlayer)) {
                        printBoard(board);
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    }
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Cell already occupied, try again.");
                }
            }
        }

        public static void printBoard(char[][] board) {
            System.out.println("-----");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static boolean checkWin(char[][] board, char player) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                        (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                    return true;
                }
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            // Example usage:
            System.out.println("Calculator Result: " + calculator(10, 5, "add"));
            System.out.println("Valid Email: " + isValidEmail("test@domain.com"));
            todoList(); // Uncomment for interactive to-do list
            ticketBookingSystem(); // Uncomment for ticket booking simulation
            System.out.println("Valid IP: " + isValidIPAddress("192.168.1.1"));
            parseCSV("example.csv"); // Provide path to CSV file for statistics
            System.out.println("Shortened URL: " + shortenUrl("https://www.example.com"));
            System.out.println("Original URL: " + getOriginalUrl("http://short.ly/1"));
            System.out.println("Encrypted: " + caesarEncrypt("Hello", 3));
            System.out.println("Decrypted: " + caesarDecrypt("Khoor", 3));
            BankAccount account = new BankAccount("John");
            account.deposit(1000);
            account.withdraw(500);
            account.checkBalance();
            ticTacToe(); // Uncomment for Tic-Tac-Toe simulation
        }
    }


    public static class ExtendedUtilityPrograms {

        // 91. Build a basic shopping cart system
        public static class ShoppingCart {
            private Map<String, Integer> cart = new HashMap<>();

            public void addItem(String item, int quantity) {
                cart.put(item, cart.getOrDefault(item, 0) + quantity);
            }

            public void removeItem(String item) {
                cart.remove(item);
            }

            public void viewCart() {
                System.out.println("Shopping Cart:");
                for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            public double calculateTotal(Map<String, Double> itemPrices) {
                double total = 0.0;
                for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                    total += itemPrices.getOrDefault(entry.getKey(), 0.0) * entry.getValue();
                }
                return total;
            }
        }

        // 92. Simulate a movie ticket booking system with seat selection
        public static class MovieTicketBooking {
            private boolean[][] seats = new boolean[5][5]; // 5x5 seating grid

            public boolean bookSeat(int row, int col) {
                if (row < 0 || row >= 5 || col < 0 || col >= 5 || seats[row][col]) {
                    return false; // Seat already booked or invalid
                }
                seats[row][col] = true;
                return true;
            }

            public void displaySeats() {
                System.out.println("Available Seats:");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print((seats[i][j] ? "X" : "O") + " ");
                    }
                    System.out.println();
                }
            }
        }

        // 93. Create a game leaderboard and implement rank calculation
        public static class Leaderboard {
            private Map<String, Integer> scores = new HashMap<>();

            public void addScore(String player, int score) {
                scores.put(player, scores.getOrDefault(player, 0) + score);
            }

            public void displayLeaderboard() {
                List<Map.Entry<String, Integer>> leaderboard = new ArrayList<>(scores.entrySet());
                leaderboard.sort((a, b) -> b.getValue() - a.getValue()); // Sort by score descending
                System.out.println("Leaderboard:");
                for (Map.Entry<String, Integer> entry : leaderboard) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        // 94. Write logic for a scheduling system (e.g., calendar events)
        public static class Scheduler {
            private Map<String, String> events = new HashMap<>();

            public void scheduleEvent(String date, String eventDescription) {
                events.put(date, eventDescription);
            }

            public void viewEvents() {
                System.out.println("Scheduled Events:");
                for (Map.Entry<String, String> entry : events.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        // 95. Develop a quiz application with a scoring system
        public static class QuizApp {
            private Map<String, String> questionsAndAnswers = new HashMap<>();
            private int score = 0;

            public void addQuestion(String question, String answer) {
                questionsAndAnswers.put(question, answer);
            }

            public void takeQuiz() {
                Scanner scanner = new Scanner(System.in);
                for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
                    System.out.print(entry.getKey() + ": ");
                    String userAnswer = scanner.nextLine();
                    if (userAnswer.equalsIgnoreCase(entry.getValue())) {
                        score++;
                    }
                }
                System.out.println("Your score: " + score + "/" + questionsAndAnswers.size());
            }
        }

        // 96. Create a password strength checker
        public static boolean isStrongPassword(String password) {
            return password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*\\d.*") &&
                    password.matches(".*[!@#$%^&*].*");
        }

        // 97. Implement logic for file compression and decompression (using basic ZIP)
        public static void compressFile(String filePath, String zipFilePath) {
            try (FileInputStream fis = new FileInputStream(filePath);
                 FileOutputStream fos = new FileOutputStream(zipFilePath);
                 ZipOutputStream zos = new ZipOutputStream(fos)) {
                zos.putNextEntry(new ZipEntry(new File(filePath).getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void decompressFile(String zipFilePath, String destDirectory) {
            try (FileInputStream fis = new FileInputStream(zipFilePath);
                 ZipInputStream zis = new ZipInputStream(fis)) {
                ZipEntry entry = zis.getNextEntry();
                while (entry != null) {
                    String fileName = entry.getName();
                    File newFile = new File(destDirectory + File.separator + fileName);
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                    zis.closeEntry();
                    entry = zis.getNextEntry();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 98. Simulate a traffic light system
        public static void trafficLight() {
            String[] states = {"Red", "Green", "Yellow"};
            for (String state : states) {
                System.out.println("Traffic light is: " + state);
                try {
                    Thread.sleep(2000); // Simulate each light duration
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 99. Write a program to encrypt and decrypt messages using RSA
        public static String encryptMessage(String message, PublicKey publicKey) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        }

        public static String decryptMessage(String encryptedMessage, PrivateKey privateKey) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            return new String(decryptedMessage);
        }

        // 100. Create an algorithm to match job seekers with job postings
        public static class JobMatchingSystem {
            private List<String> jobSeekers = new ArrayList<>();
            private List<String> jobPostings = new ArrayList<>();

            public void addJobSeeker(String jobSeeker) {
                jobSeekers.add(jobSeeker);
            }

            public void addJobPosting(String jobPosting) {
                jobPostings.add(jobPosting);
            }

            public void matchJobs() {
                System.out.println("Job Seeker and Job Posting Matches:");
                for (String seeker : jobSeekers) {
                    for (String posting : jobPostings) {
                        if (posting.contains(seeker)) { // Simple matching by keyword
                            System.out.println(seeker + " matched with " + posting);
                        }
                    }
                }
            }
        }

        public static void main(String[] args) throws Exception {
            // Example usage:
            ShoppingCart cart = new ShoppingCart();
            cart.addItem("Laptop", 1);
            cart.addItem("Phone", 2);
            Map<String, Double> itemPrices = Map.of("Laptop", 1000.00, "Phone", 500.00);
            System.out.println("Total: $" + cart.calculateTotal(itemPrices));

            MovieTicketBooking movie = new MovieTicketBooking();
            movie.bookSeat(1, 1);
            movie.displaySeats();

            Leaderboard leaderboard = new Leaderboard();
            leaderboard.addScore("Alice", 100);
            leaderboard.addScore("Bob", 150);
            leaderboard.displayLeaderboard();

            Scheduler scheduler = new Scheduler();
            scheduler.scheduleEvent("2025-01-30", "Team Meeting");
            scheduler.viewEvents();

            QuizApp quizApp = new QuizApp();
            quizApp.addQuestion("What is 2 + 2?", "4");
            quizApp.takeQuiz();

            System.out.println("Password Strength: " + isStrongPassword("Password123!"));

            compressFile("sample.txt", "sample.zip");
            decompressFile("sample.zip", "output");

            trafficLight();

            // Example of RSA encryption/decryption (simplified)
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            String encryptedMessage = encryptMessage("Hello RSA", keyPair.getPublic());
            System.out.println("Encrypted: " + encryptedMessage);
            String decryptedMessage = decryptMessage(encryptedMessage, keyPair.getPrivate());
            System.out.println("Decrypted: " + decryptedMessage);

            JobMatchingSystem jobMatchingSystem = new JobMatchingSystem();
            jobMatchingSystem.addJobSeeker("Developer");
            jobMatchingSystem.addJobPosting("Java Developer");
            jobMatchingSystem.matchJobs();
        }
    }
}

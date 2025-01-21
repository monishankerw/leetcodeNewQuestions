package com.leetcode.leetcode.basics;

import java.util.*;
import java.util.stream.Collectors;

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
    public static class HelloWorld{
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }
//Write a program to add two numbers.
    public static class AddNumbers {
        public static void main(String[] args) {
//            int a = 5, b = 7;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int sum = a + b;
            System.out.println("Sum: " + sum);
        }
    }
    //Write a program to swap two numbers without using a third variable.
    public static class SwapNumbers {
        public static void main(String[] args) {
//            int a = 5, b = 10;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a=sc.nextInt();
            int b=sc.nextInt();
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
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the two number: ");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
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
        public static class EvenOdd{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number::");
        int num=sc.nextInt();
        if(num%2==0){
            System.out.println("Even Number");
        }else {
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
    public static class SumOfNaturalNumber{
    public static void main(String[] args) {

        int sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the natural Number:");
        int n=sc.nextInt();
        for (int i=1;i<n;i++){
            sum=sum+i;
        }
        System.out.println("Sum of Natural Number: "+sum);
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
        public static void main(String [] args) {
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
            String str="Test Engin";
            int v=0,c=0;
            String small  = str.toLowerCase();
            for (int i=0;i<str.length();i++){
                char ch=small.charAt(i);
                if(ch!=' '&& (ch>='a'&&ch<='z')){
                    if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                        v++;
                    }else{
                        c++;
                    }
                }
            }
            System.out.println("Vowel::"+v);
            System.out.println("Con::"+c);


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
            int[] arr = new int[] {25, 11, 7, 75, 56};

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
    public static class InvertedTriangle{
        public static void main(String[] args) {
            for(int i=5;i>=1;i--){
                for(int j=1;j<=i;j++){
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

1. Library Management System

Objective:

A console-based program to manage books in a library, including adding books, searching for a book, and displaying all available books.

Features:
	•	Add books (title, author, ISBN, availability).
	•	Search for a book by title or ISBN.
	•	Display all available books.
	•	Mark a book as borrowed or returned.

Concepts Used:
	•	Arrays to store book details.
	•	Functions for modularity (e.g., addBook(), searchBook(), displayBooks()).
	•	Loops to iterate over books.
	•	Conditionals for availability status.

2. Simple Banking System

Objective:

Simulate basic banking operations like creating an account, depositing money, withdrawing money, and checking the balance.

Features:
	•	Create an account with a unique account number.
	•	Deposit money and update the balance.
	•	Withdraw money if the balance is sufficient.
	•	Check account details.

Concepts Used:
	•	Variables for account details (name, account number, balance).
	•	Loops to perform repeated transactions.
	•	Conditionals for withdrawal checks.
	•	Functions for operations (createAccount(), deposit(), withdraw(), checkBalance()).

3. Quiz Game

Objective:

Create a simple quiz game with multiple-choice questions.

Features:
	•	Present 5-10 questions with 4 options each.
	•	Let the user choose the correct option.
	•	Keep track of the score and display it at the end.

Concepts Used:
	•	Arrays to store questions, options, and answers.
	•	Loops to iterate through questions.
	•	Conditionals to check answers.
	•	Variables for score tracking.

4. Expense Tracker

Objective:

Track daily expenses and calculate total expenses for the week or month.

Features:
	•	Add daily expenses (e.g., food, travel, groceries).
	•	View total expenses for the week or month.
	•	Categorize expenses (e.g., Food: ₹500, Travel: ₹300).

Concepts Used:
	•	Arrays for storing expense categories and amounts.
	•	Loops to calculate total expenses.
	•	Conditionals for filtering expenses by category.
	•	Functions for operations like addExpense(), viewExpenses(), calculateTotal().

5. Number Guessing Game

Objective:

Create a game where the computer generates a random number, and the user has to guess it.

Features:
	•	Generate a random number between 1 and 100.
	•	Provide hints like “too high” or “too low.”
	•	Track the number of attempts.
	•	Allow restarting the game.

Concepts Used:
	•	Variables for random number and user input.
	•	Loops to allow multiple guesses.
	•	Conditionals for hint generation.
	•	Random number generation using Math.random() or similar libraries.

6. To-Do List

Objective:

Create a console-based program to manage daily tasks.

Features:
	•	Add tasks to the list.
	•	Mark tasks as complete.
	•	Display all tasks (completed and pending).
	•	Delete tasks.

Concepts Used:
	•	Arrays to store tasks.
	•	Loops for task iteration.
	•	Conditionals for task status.
	•	Functions for modularity (e.g., addTask(), markComplete(), deleteTask(), viewTasks()).

7. Temperature Conversion Tool

Objective:

Convert temperatures between Celsius, Fahrenheit, and Kelvin.

Features:
	•	Take input for temperature and the conversion type.
	•	Perform conversion based on formulas:
	•	Celsius to Fahrenheit: ￼
	•	Fahrenheit to Celsius: ￼
	•	Celsius to Kelvin: ￼
	•	Display the converted value.

Concepts Used:
	•	Variables for temperature and conversion type.
	•	Conditionals for selecting the conversion type.
	•	Functions for conversion logic.

8. Inventory Management System

Objective:

Track and manage product inventory.

Features:
	•	Add products (name, ID, quantity, price).
	•	Update inventory (add/remove stock).
	•	Display all products with details.
	•	Calculate the total inventory value.

Concepts Used:
	•	Arrays for storing product details.
	•	Loops for inventory updates and display.
	•	Conditionals for validation (e.g., sufficient stock).
	•	Functions for modularity.

9. Restaurant Billing System

Objective:

Create a simple billing system for a restaurant.

Features:
	•	Display a menu with items and prices.
	•	Allow users to select items and quantities.
	•	Calculate the total bill, including tax (e.g., 5% GST).
	•	Generate a receipt with itemized details.

Concepts Used:
	•	Arrays to store menu items and prices.
	•	Loops to handle multiple orders.
	•	Variables for total calculation.
	•	Functions for operations like displayMenu(), calculateBill(), generateReceipt().

10. Basic Calendar Application

Objective:

Display a calendar for a given month and year, and allow the user to add reminders.

Features:
	•	Input: Month and year.
	•	Display the calendar with days and dates.
	•	Add reminders for specific dates.
	•	View all reminders for the month.

Concepts Used:
	•	Arrays for storing dates and reminders.
	•	Loops to generate the calendar.
	•	Conditionals for checking leap years and valid dates.
	•	Functions for modularity.

11. Digital Clock

Objective:

Display the current time that updates every second.

Features:
	•	Display time in HH:MM:SS format.
	•	Allow user to set an alarm for a specific time.
	•	Alert the user when the alarm time is reached.

Concepts Used:
	•	Loops for updating the clock.
	•	Conditionals for alarm check.
	•	Use Thread.sleep() or equivalent for delays.

12. Word Counter Tool

Objective:

Analyze a paragraph and count the number of words, sentences, and characters.

Features:
	•	Input: A paragraph from the user.
	•	Output:
	•	Total words.
	•	Total sentences.
	•	Total characters (including and excluding spaces).

Concepts Used:
	•	Strings for storing the paragraph.
	•	Loops for iteration.
	•	Functions for counting logic.
	•	Conditionals for checking sentence boundaries.

     */
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
}

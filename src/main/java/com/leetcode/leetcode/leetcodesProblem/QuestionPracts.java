package com.leetcode.leetcode.leetcodesProblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
            String strs= "apple is fruit";
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
        Set<Character>seen=new HashSet<>();
        Set<Character>duplicates=new HashSet<>();
        for (char ch:strs.toCharArray()){
            if(ch!=' '){
                if(!seen.add(ch)){
                    duplicates.add(ch);
                }
            }
        }
            for (char dup:duplicates){
                System.out.println("duplicateShowWordSentences::"+dup);


        }
    }
    private static void showDuplicateInSentanceWithJava8(String str) {
        Set<Character>set=new HashSet<>();
//•	str.chars() converts the string into an IntStream of character codes.
//filter() method, which determines whether a character should be included in the resulting collection.
        Set<Character>duplicates=str.chars().mapToObj(c->(char)c)
                .filter(c->c!=' '&&!set.add(c))
                .collect(Collectors.toSet());
        duplicates.forEach(c->System.out.println(c+" "));
        System.out.println();
    }

}



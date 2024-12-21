package com.leetcode.leetcode.basics.pattern;

public class PatternProblem {
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
}

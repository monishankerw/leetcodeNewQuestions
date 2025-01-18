package com.leetcode.leetcode.basics;

import java.util.ArrayList;
import java.util.Scanner;

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
//Write a program to add two numbers.
    public static class AddNumbers {
        public static void main(String[] args) {
            int a = 5, b = 7;
            int sum = a + b;
            System.out.println("Sum: " + sum);
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

      //Write a program to swap two numbers without using a third variable.
      public static class SwapNumbers {
          public static void main(String[] args) {
              int a = 5, b = 10;
              System.out.println("Before: a = " + a + ", b = " + b);
              a = a + b;
              b = a - b;
              a = a - b;
              System.out.println("After: a = " + a + ", b = " + b);
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
   //Find the largest of three numbers.

    public static class LargestNumber {
        public static void main(String[] args) {
            int a = 10, b = 20, c = 15;
            if (a > b && a > c) {
                System.out.println(a + " is the largest.");
            } else if (b > c) {
                System.out.println(b + " is the largest.");
            } else {
                System.out.println(c + " is the largest.");
            }
        }
    }
    //Calculating Simple Interest
    public class SimpleInterest {
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

    public static class TemperatureConverter {
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
}

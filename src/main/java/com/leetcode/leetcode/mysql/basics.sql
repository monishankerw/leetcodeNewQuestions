CREATE DATABASE company;
use company;

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    salary DECIMAL(10, 2)
    );

    INSERT INTO employees (first_name, last_name, department, salary)
VALUES
('John1', 'Doe1', 'IT', 50000),
('John2', 'Doe2', 'HR', 52000),
('John3', 'Doe3', 'Finance', 54000),
('John4', 'Doe4', 'Marketing', 56000),
('John5', 'Doe5', 'Sales', 58000),
('John6', 'Doe6', 'Operations', 60000),
('John100', 'Doe100', 'Admin', 70000);

# Read the emp name whose salary is 54000/-
SELECT first_name, last_name
FROM employees
WHERE salary = 54000;

# Read the emp name whose salary is greate than 54000/-

SELECT first_name, last_name
FROM employees
WHERE salary >= 54000;

# Give empid names is John1,John2
SELECT employee_id
FROM employees
WHERE first_name IN ('John1', 'John2');
# sort the data lower to higher decending order
SELECT employee_id
FROM employees
ORDER BY employee_id DESC;

SELECT employee_id
FROM employees
ORDER BY employee_id ASC;

SELECT employee_id
FROM employees
ORDER BY 1 ASC;

# sort data in reverse Alphabetical order

SELECT *
FROM employees
ORDER BY first_name DESC;

# Applying Multiple sort criteria
SELECT first_name, department
FROM employees
ORDER BY first_name, department;

# Limiting the number of records displayed
SELECT *
FROM employees
LIMIT 5;
# Select the sum of all salary
SELECT SUM(salary) AS total_salary FROM employees;

# count total number of employees in the company
SELECT COUNT(*) AS total_employees FROM employees;
# count the number of employees in city wise
SELECT city, COUNT(*) AS num_employees
FROM employees
GROUP BY city;

# Group the employees based on department then count empid wise and print the count in accending order.
SELECT department, COUNT(employee_id) AS num_employees
FROM employees
GROUP BY department
ORDER BY num_employees ASC;

#convert all the employees first_name in uppercase.

UPDATE employees
SET first_name = UPPER(first_name);













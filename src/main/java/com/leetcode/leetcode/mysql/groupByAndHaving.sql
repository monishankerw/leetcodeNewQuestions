GROUP BY and HAVING Clauses in SQL

The GROUP BY clause is used to group rows based on one or more columns,
 typically to apply aggregate functions like SUM, COUNT, AVG, etc., to each group.
The HAVING clause is used to filter groups based on aggregate function results.

Syntax:

SELECT column1, aggregate_function(column2)
FROM table_name
GROUP BY column1
HAVING aggregate_function(column2) condition;

Example 1: Group Employees by Department and Count Employees

Query:

SELECT department, COUNT(employee_id) AS employee_count
FROM employees
GROUP BY department;

Explanation:
	1.	GROUP BY department: Groups employees based on their department.
	2.	COUNT(employee_id): Counts the number of employees in each department.

Output (Example):

Department	Employee_Count
IT	2
HR	1
Finance	1

Example 2: Use HAVING to Filter Groups

Query:

SELECT department, COUNT(employee_id) AS employee_count
FROM employees
GROUP BY department
HAVING COUNT(employee_id) > 1;

Explanation:
	•	The HAVING clause filters the groups to include only those departments with more than 1 employee.

Output:

Department	Employee_Count
IT	2

Key Differences Between WHERE and HAVING:

Feature	WHERE	HAVING
When Applied	Filters rows before grouping.	Filters groups after grouping.
Aggregate Functions	Cannot use aggregate functions.	Can use aggregate functions.

Example 3: Group Employees by Department and Calculate Total Salary

Query:

SELECT department, SUM(salary) AS total_salary
FROM employees
GROUP BY department;

Output:

Department	Total_Salary
IT	110000
HR	52000

Example 4: Filter Departments with Total Salary > 100,000

Query:

SELECT department, SUM(salary) AS total_salary
FROM employees
GROUP BY department
HAVING SUM(salary) > 100000;

Output:

Department	Total_Salary
IT	110000

Using GROUP BY and HAVING together allows for powerful data aggregation and filtering,
which is essential in generating meaningful reports from your database.

Here are examples of how to use GROUP BY and HAVING with the employees table:

1. Group Employees by Department and Count Total Employees

Query:

SELECT department, COUNT(employee_id) AS total_employees
FROM employees
GROUP BY department;

Explanation:
	•	Groups employees by department.
	•	Counts the number of employees in each department.

Output (Example):

Department	Total_Employees
IT	2
HR	1
Finance	1

2. Filter Departments with More than 1 Employee

Query:

SELECT department, COUNT(employee_id) AS total_employees
FROM employees
GROUP BY department
HAVING COUNT(employee_id) > 1;

Explanation:
	•	Adds a HAVING clause to filter out groups (departments) that have only 1 employee.

Output:

Department	Total_Employees
IT	2

3. Group Employees by Department and Calculate Total Salary

Query:

SELECT department, SUM(salary) AS total_salary
FROM employees
GROUP BY department;

Explanation:
	•	Groups employees by department.
	•	Calculates the total salary for each department using the SUM function.

Output:

Department	Total_Salary
IT	100000
HR	52000
Finance	54000

4. Filter Departments with Total Salary Above ₹60,000

Query:

SELECT department, SUM(salary) AS total_salary
FROM employees
GROUP BY department
HAVING SUM(salary) > 60000;

Explanation:
	•	Filters departments where the total salary exceeds ₹60,000.

Output:

Department	Total_Salary
IT	100000

5. Group Employees by Department and Find Average Salary

Query:

SELECT department, AVG(salary) AS average_salary
FROM employees
GROUP BY department;

Explanation:
	•	Groups employees by department.
	•	Calculates the average salary for each department using the AVG function.

Output:

Department	Average_Salary
IT	50000
HR	52000

6. Find Departments with Average Salary Greater Than ₹55,000

Query:

SELECT department, AVG(salary) AS average_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 55000;

Explanation:
	•	Filters departments where the average salary is greater than ₹55,000.

Output:

Department	Average_Salary
Finance	56000

Summary:
	•	Use GROUP BY to group data based on a specific column (e.g., department).
	•	Use aggregate functions (COUNT, SUM, AVG, etc.) to perform operations on each group.
	•	Use HAVING to filter groups based on aggregate function results.
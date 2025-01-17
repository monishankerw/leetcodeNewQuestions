
USE EMPLOYEE;
CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID INT(6),        
    NAME VARCHAR(20),          
    SALARY DECIMAL(8, 2)      
);

INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(100, 'Jennifer', 4400);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(100, 'Jennifer', 4400);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(101, 'Michael', 13000);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(101, 'Michael', 13000);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(101, 'Michael', 13000);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(102, 'Pat', 6000);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(102, 'Pat', 6000);
INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, SALARY) VALUES(103, 'Den', 11000);

select * from EMPLOYEE;
# 1. How to select UNIQUE records from a table using a SQL Query?
SELECT EMPLOYEE_ID,NAME,SALARY FROM EMPLOYEE GROUP BY EMPLOYEE_ID,NAME,SALARY;
DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID NOT IN (SELECT MIN(EMPLOYEE_ID)FROM EMPLOYEE GROUP BY EMPLOYEE_ID, NAME, SALARY);
CREATE TABLE Departments(
 Department_ID INT(6),
 Department_Name varchar(50)
);
INSERT INTO DEPARTMENTS VALUES('10','Administration');
INSERT INTO DEPARTMENTS VALUES('20','Marketing');
INSERT INTO DEPARTMENTS VALUES('30','Purchasing');
INSERT INTO DEPARTMENTS VALUES('40','Human Resources');
INSERT INTO DEPARTMENTS VALUES('50','Shipping');
INSERT INTO DEPARTMENTS VALUES('60','IT');
INSERT INTO DEPARTMENTS VALUES('70','Public Relations');
INSERT INTO DEPARTMENTS VALUES('80','Sales');

# . How to read TOP 5 records from a table using a SQL query?
USE EMPLOYEE;
SELECT * FROM EMPLOYEE.DEPARTMENTS;
SELECT * FROM DEPARTMENTS LIMIT 5;

# 4. How to read LAST 5 records from a table using a SQL query?
SELECT * FROM EMPLOYEE.DEPARTMENTS ORDER BY DEPARTMENT_ID DESC LIMIT 5;

# JOIN OR INNER JOIN
# select a.col as A, b.col as B from Table_A a JOIN Table_B b ON a.col=b.col;
# LEFT JOIN
# SELECT a.COL as A,b.COL as B FROM TABLE_A a LEFT OUTER JOIN TABLE_B b ON a.COL = b.COL;

# RIGHT JOIN
# SELECT a.COL as A,b.COL as B FROM TABLE_A a RIGHT OUTER JOIN TABLE_B b ON a.COL = b.COL;

# FULL JOIN
# SELECT a.COL as A, b.COL as B FROM TABLE_A a FULL OUTER JOIN TABLE_B b ON a.COL = b.COL;

#  How to find the employee with second MAX Salary using a SQL query?
#How to find the employee with third MAX Salary using a SQL query without using Analytic Functions?







 

















Basic SQL Queries

	1.	What is SQL?
	•	Basic question to test your understanding of SQL.
	2.	Select all columns from a table:

SELECT * FROM employees;


	3.	Select specific columns from a table:

SELECT first_name, last_name FROM employees;


	4.	Select distinct values from a column (e.g., department):

SELECT DISTINCT department FROM employees;


	5.	Find all employees in a specific department (e.g., ‘IT’):

SELECT * FROM employees WHERE department = 'IT';


	6.	Select employees with a salary greater than a certain value (e.g., 50000):

SELECT first_name, last_name, salary FROM employees WHERE salary > 50000;


	7.	Sort employees by salary in ascending order:

SELECT first_name, last_name, salary FROM employees ORDER BY salary ASC;


	8.	Sort employees by first name in reverse alphabetical order:

SELECT first_name, last_name FROM employees ORDER BY first_name DESC;


	9.	Count the number of employees:

SELECT COUNT(*) AS total_employees FROM employees;


	10.	Find the employee(s) with the highest salary:

SELECT first_name, last_name, salary FROM employees WHERE salary = (SELECT MAX(salary) FROM employees);

Intermediate SQL Queries

	1.	Group employees by department and count the number of employees in each department:

SELECT department, COUNT(employee_id) AS num_employees FROM employees GROUP BY department;


	2.	Find the average salary of employees in each department:

SELECT department, AVG(salary) AS avg_salary FROM employees GROUP BY department;


	3.	Select employees with salaries greater than the average salary:

SELECT first_name, last_name, salary FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);


	4.	Join two tables (e.g., employees and departments):

SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department = d.department_id;


	5.	Find employees whose names start with ‘J’:

SELECT first_name, last_name FROM employees WHERE first_name LIKE 'J%';


	6.	Find employees whose salary is between a certain range (e.g., 50000 and 60000):

SELECT first_name, last_name, salary FROM employees WHERE salary BETWEEN 50000 AND 60000;


	7.	Select the second-highest salary from the employees table:

SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);


	8.	Update an employee’s salary (e.g., increase salary by 10%):

UPDATE employees
SET salary = salary * 1.1
WHERE employee_id = 1;


	9.	Delete an employee from the employees table (e.g., employee_id = 5):

DELETE FROM employees WHERE employee_id = 5;


	10.	Insert a new employee into the employees table:

INSERT INTO employees (first_name, last_name, department, salary)
VALUES ('John7', 'Doe7', 'Marketing', 62000);

Advanced SQL Queries

	1.	Create a stored procedure to get employees by department:

DELIMITER //
CREATE PROCEDURE GetEmployeesByDepartment(IN dept_name VARCHAR(50))
BEGIN
SELECT first_name, last_name
FROM employees
WHERE department = dept_name;
END //
DELIMITER ;


	2.	Create a trigger to log salary changes:

DELIMITER //
CREATE TRIGGER BeforeSalaryUpdate
BEFORE UPDATE ON employees
FOR EACH ROW
BEGIN
IF OLD.salary <> NEW.salary THEN
INSERT INTO salary_log (employee_id, old_salary, new_salary, change_date)
VALUES (OLD.employee_id, OLD.salary, NEW.salary, NOW());
END IF;
END //
DELIMITER ;


	3.	Create an index on the salary column for faster queries:

CREATE INDEX idx_salary ON employees (salary);


	4.	Create a view to show employees in the IT department with salaries greater than 50000:

CREATE VIEW IT_Employees AS
SELECT first_name, last_name, salary
FROM employees
WHERE department = 'IT' AND salary > 50000;


	5.	Optimize a query using window functions (e.g., ranking employees by salary):

SELECT first_name, last_name, salary,
RANK() OVER (ORDER BY salary DESC) AS salary_rank
FROM employees;


	6.	Find employees with salaries higher than the average salary in their department:

SELECT e.first_name, e.last_name, e.salary
FROM employees e
WHERE e.salary > (
SELECT AVG(salary)
FROM employees
WHERE department = e.department
);


	7.	Find the employees who are in the same department as the employee with the highest salary:

SELECT first_name, last_name
FROM employees
WHERE department = (SELECT department FROM employees WHERE salary = (SELECT MAX(salary) FROM employees));


	8.	Use a subquery to select employees who have worked in the company for more than 5 years (assuming a hire_date column exists):

SELECT first_name, last_name, hire_date
FROM employees
WHERE hire_date < (SELECT DATE_SUB(CURDATE(), INTERVAL 5 YEAR));


	9.	Find employees who are not assigned to any department:

SELECT first_name, last_name
FROM employees
WHERE department IS NULL;


	10.	Implement a recursive query to calculate the hierarchical structure of employees (e.g., manager-subordinate relationships):

WITH RECURSIVE EmployeeHierarchy AS (
SELECT employee_id, first_name, manager_id
FROM employees
WHERE manager_id IS NULL
UNION ALL
SELECT e.employee_id, e.first_name, e.manager_id
FROM employees e
INNER JOIN EmployeeHierarchy eh ON e.manager_id = eh.employee_id
)
SELECT * FROM EmployeeHierarchy;

Bonus: Real-World Scenario

	1.	Given a transactions table with transaction_id, amount, and transaction_date, write a query to find the total amount spent per month for the last 6 months.
	2.	Write a query to find the most popular department in terms of the number of employees.
	3.	Write a query to find the employees who have not made any changes to their salary in the last year (assuming a salary_change_date column exists).


create schema companys;
use companys;
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    salary DECIMAL(10, 2),
    branch VARCHAR(50)
);


INSERT INTO employees (first_name, salary, branch)
VALUES
('John1', 50000, 'IT'),
('John2', 52000, 'HR'),
('John3', 54000, 'Finance'),
('John4', 56000, 'Marketing'),
('John5', 58000, 'Sales'),
('John6', 60000, 'Operations'),
('John7', 60000, 'IT'), -- Duplicate salary for testing
('John8', 62000, 'Admin'),
('John9', 64000, 'Finance'),
('John10', 66000, 'HR');





select distinct salary from employees order by salary desc limit 1 offset 1;

The query you provided retrieves the 2nd highest salary from the employees table using DISTINCT, ORDER BY, LIMIT, and OFFSET. Here’s the explanation:

Query:

SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

Explanation:
	1.	SELECT DISTINCT salary:
	•	Ensures that duplicate salaries are not considered (e.g., if multiple employees have the same salary).
	2.	ORDER BY salary DESC:
	•	Orders the salaries in descending order, with the highest salary at the top.
	3.	LIMIT 1:
	•	Restricts the result to a single row.
	4.	OFFSET 1:
	•	Skips the first row (the highest salary) and starts fetching from the second row (the 2nd highest salary).

How It Works:
	1.	Suppose the employees table has the following salaries:

Salary
60000
58000
54000
52000
50000


	2.	After applying DISTINCT, duplicate salaries are removed:

Salary
60000
58000
54000
52000
50000


	3.	The ORDER BY salary DESC arranges them in descending order:

Salary
60000
58000
54000
52000
50000


	4.	OFFSET 1 skips the first row (60000), leaving:

Salary
58000
54000
52000
50000


	5.	LIMIT 1 retrieves only the first row from the remaining list:

Salary
58000

Result:

For the above table, the query will return:

58000

Nth Highest Salary Using This Method:

To get the Nth highest salary:
	•	Use OFFSET N-1 (e.g., for the 3rd highest salary, use OFFSET 2).

Example for 3rd highest salary:

SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 2;

Query:

SELECT *
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 2;

Explanation:

This query retrieves the 3rd highest paid employee from the employees table. Here’s how it works:
	1.	ORDER BY salary DESC:
	•	Arranges all employees in descending order based on their salary, with the highest-paid employee at the top.
	2.	LIMIT 1:
	•	Restricts the result to only one row.
	3.	OFFSET 2:
	•	Skips the first two rows (i.e., the two highest salaries) and starts fetching from the 3rd row.

Example Table:

Suppose the employees table has the following data:

Employee_ID	First_Name	Last_Name	Department	Salary
1	John1	Doe1	IT	60000
2	John2	Doe2	HR	58000
3	John3	Doe3	Finance	54000
4	John4	Doe4	Marketing	52000
5	John5	Doe5	Sales	50000

Steps:
	1.	ORDER BY salary DESC:
	•	Employees sorted by salary in descending order:

Employee_ID	First_Name	Last_Name	Department	Salary
1	John1	Doe1	IT	60000
2	John2	Doe2	HR	58000
3	John3	Doe3	Finance	54000
4	John4	Doe4	Marketing	52000
5	John5	Doe5	Sales	50000


	2.	OFFSET 2:
	•	Skips the first two rows:

Employee_ID	First_Name	Last_Name	Department	Salary
3	John3	Doe3	Finance	54000
4	John4	Doe4	Marketing	52000
5	John5	Doe5	Sales	50000


	3.	LIMIT 1:
	•	Fetches only the first row from the remaining data:

Employee_ID	First_Name	Last_Name	Department	Salary
3	John3	Doe3	Finance	54000

Result:

The query will return:

Employee_ID	First_Name	Last_Name	Department	Salary
3	              John3	 Doe3	    Finance	   54000








SQL (Structured Query Language) is a standard language used to interact with relational databases. It allows users to perform operations such as retrieving, inserting, updating, and deleting data, as well as managing database structures.

Main Components of SQL

1. Data Query Language (DQL)

Used to retrieve data from a database.
•	Command: SELECT
•	Example:

SELECT column1, column2
FROM table_name
WHERE condition;



2. Data Manipulation Language (DML)

Used to modify data in a database.
•	Commands:
•	INSERT: Adds new records.
•	UPDATE: Modifies existing records.
•	DELETE: Removes records.
•	Examples:

INSERT INTO employees (name, department, salary) VALUES ('John', 'IT', 60000);

UPDATE employees SET salary = 65000 WHERE name = 'John';

DELETE FROM employees WHERE name = 'John';



3. Data Definition Language (DDL)

Used to define or modify database structure.
•	Commands:
•	CREATE: Creates tables, views, indexes, etc.
•	ALTER: Modifies an existing structure.
•	DROP: Deletes tables, views, etc.
•	TRUNCATE: Removes all records from a table.
•	Examples:

CREATE TABLE employees (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
department VARCHAR(50),
salary DECIMAL(10, 2)
);

ALTER TABLE employees ADD COLUMN email VARCHAR(100);

DROP TABLE employees;



4. Data Control Language (DCL)

Used to control access to data.
•	Commands:
•	GRANT: Gives permissions to users.
•	REVOKE: Removes permissions.
•	Examples:

GRANT SELECT, INSERT ON employees TO 'username'@'localhost';

REVOKE INSERT ON employees FROM 'username'@'localhost';



5. Transaction Control Language (TCL)

Used to manage database transactions.
•	Commands:
•	COMMIT: Saves changes permanently.
•	ROLLBACK: Undoes changes made in the current transaction.
•	SAVEPOINT: Sets a point to roll back to within a transaction.
•	Examples:

BEGIN TRANSACTION;
INSERT INTO employees (name, department, salary) VALUES ('Alice', 'HR', 50000);
ROLLBACK;

BEGIN TRANSACTION;
INSERT INTO employees (name, department, salary) VALUES ('Bob', 'IT', 60000);
COMMIT;

Common SQL Clauses
•	WHERE: Filters records.
•	GROUP BY: Groups records by one or more columns.
•	ORDER BY: Sorts records.
•	JOIN: Combines rows from multiple tables.
•	HAVING: Filters grouped records.
•	LIMIT: Restricts the number of returned rows.

Example: A Complex Query

SELECT department, COUNT(*) AS employee_count, AVG(salary) AS avg_salary
FROM employees
WHERE salary > 50000
GROUP BY department
HAVING COUNT(*) > 1
ORDER BY avg_salary DESC
LIMIT 5;

Use Cases
•	Banking systems.
•	E-commerce websites.
•	Inventory management.
•	Reporting and analytics.

Let me know if you’d like help with a specific SQL concept or query!



CREATE DATABASE employee_db;
USE employee_db;




CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(50),
    DepartmentID INT
);
CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);
INSERT INTO Employees (EmployeeID, Name, DepartmentID) VALUES
(1, 'Alice', 101),
(2, 'Bob', 102),
(3, 'Charlie', 103),
(4, 'David', 101),
(5, 'Eve', 104);

INSERT INTO Departments (DepartmentID, DepartmentName) VALUES
(101, 'HR'),
(102, 'IT'),
(103, 'Finance'),
(105, 'Marketing');
select * from Employees;

select * from Departments;

#JOIN:If u want to display contain of two difference table that belong to difference table then we used to join operation.

# INNER JOIN: Give the matching record from both table
SELECT Employees.EmployeeID, Employees.Name, Departments.DepartmentName
FROM Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;


#LEFT JOIN: Give all the record from left table only match record right table.

SELECT Employees.EmployeeID, Employees.Name, Departments.DepartmentName
FROM Employees
LEFT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;

#RIGHT JOIN: Give all the record from right table only match record left table.
SELECT Employees.EmployeeID, Employees.Name, Departments.DepartmentName
FROM Employees
RIGHT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;

#give me the matching record from below two table and output should consist of C,D,E.
#-> X1->A,B,C & X2->E,A,D
select x1.B,x1.C,X2.D,X2.E from x1 inner join x2 on x1.A=x2.A;

#give me the matching record from table T1 and matching record from table T2 and output should consist of B,C,D.
#-> X1->A,B,C & X2->D,A,E
select T1.B,T1.C,T2.D,T2.E from T1 left join T2 on T1.A=T2.A;


A Venn diagram is often used to visualize how different types of SQL joins work by showing how rows from two tables interact. Here's a breakdown of different types of joins with a focus on a Venn diagram concept:

1. **INNER JOIN**: Returns only the matching rows from both tables.
   - **Venn Diagram**: The overlapping section of two circles (Table 1 and Table 2), representing the rows that have matching values in both tables.

2. **LEFT JOIN**: Returns all rows from the left table (Table 1) and the matching rows from the right table (Table 2). If no match is found, NULL values are returned for columns from the right table.
   - **Venn Diagram**: The entire left circle (Table 1) including the intersection (matching rows), with unmatched rows from the left side.

3. **RIGHT JOIN**: Returns all rows from the right table (Table 2) and the matching rows from the left table (Table 1). If no match is found, NULL values are returned for columns from the left table.
   - **Venn Diagram**: The entire right circle (Table 2) including the intersection (matching rows), with unmatched rows from the right side.

4. **FULL OUTER JOIN**: Returns all rows when there is a match in either table. Rows from both tables are returned, with `NULL` values where no match exists.
   - **Venn Diagram**: Both circles, including the intersection, with unmatched rows from both tables included.

### Visual Representation of Join Types:

To visualize these joins as Venn diagrams:
1. **Table 1** is represented by the left circle.
2. **Table 2** is represented by the right circle.
3. **Intersection** represents matching records.

To illustrate the different types of SQL joins using two tables, we can represent them using a Venn diagram. Below are the explanations and visual representations of INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL OUTER JOIN using two hypothetical tables, `Table A` and `Table B`.

### Tables

Assume we have the following two tables:

**Table A**
| ID | Name    |
|----|---------|
| 1  | Alice   |
| 2  | Bob     |
| 3  | Charlie  |

**Table B**
| ID | City     |
|----|----------|
| 1  | New York |
| 2  | Los Angeles |
| 4  | Chicago  |

### Venn Diagram Representations

1. **INNER JOIN**
   - Returns only the rows that have matching values in both tables.
   - **Result:** Rows with IDs 1 and 2.

   ![INNER JOIN Venn Diagram](https://www.vdcharts.com/venn-images/inner-join.png)

2. **LEFT JOIN (or LEFT OUTER JOIN)**
   - Returns all rows from the left table (Table A) and the matched rows from the right table (Table B). If there's no match, NULL values are returned for columns from Table B.
   - **Result:** Rows with IDs 1, 2, and 3 (Charlie gets NULL for City).

   ![LEFT JOIN Venn Diagram](https://www.vdcharts.com/venn-images/left-join.png)

3. **RIGHT JOIN (or RIGHT OUTER JOIN)**
   - Returns all rows from the right table (Table B) and the matched rows from the left table (Table A). If there's no match, NULL values are returned for columns from Table A.
   - **Result:** Rows with IDs 1, 2, and 4 (Chicago gets NULL for Name).

   ![RIGHT JOIN Venn Diagram](https://www.vdcharts.com/venn-images/right-join.png)

4. **FULL OUTER JOIN**
   - Returns all rows when there is a match in either left (Table A) or right (Table B) table records. Rows without a match will have NULL values in the corresponding columns.
   - **Result:** Rows with IDs 1, 2, 3, and 4 (Charlie and Chicago get NULLs for the respective non-matching table).

   ![FULL OUTER JOIN Venn Diagram](https://www.vdcharts.com/venn-images/full-outer-join.png)

### Summary

- **INNER JOIN:** Only matched rows from both tables.
- **LEFT JOIN:** All rows from the left table and matched rows from the right.
- **RIGHT JOIN:** All rows from the right table and matched rows from the left.
- **FULL OUTER JOIN:** All rows from both tables, including unmatched rows.










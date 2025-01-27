use employee;
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DECIMAL(10, 2),
    joining_date DATE
);
INSERT INTO employee (name, department, salary, joining_date) VALUES
('Alice', 'HR', 50000, '2020-05-10'),
('Bob', 'IT', 60000, '2019-03-15'),
('Charlie', 'IT', 70000, '2021-07-20'),
('Diana', 'HR', 55000, '2022-01-10'),
('Eve', 'Finance', 80000, '2018-10-05'),
('Frank', 'Finance', 75000, '2017-11-11'),
('Grace', 'HR', 52000, '2021-04-01');

# Perform Aggregate Functions

# 1. Count the total number of employees
select count(*) total_employee from employee;

# 2. Calculate the total salary paid
select sum(salary) total_emp_salary from employee;

# 3. Find the average salary of employees
select AVG(salary) total_avg_salary from employee;

# 4. Find the minimum and maximum salary
SELECT MIN(salary) AS minimum_salary, MAX(salary) AS maximum_salary FROM employee;

# 5.Group employees by department and calculate total salary
 SELECT department, SUM(salary) AS total_salary
FROM employee GROUP BY department;

 # 6. Group employees by department and count employees
 SELECT department, COUNT(*) AS employee_count
FROM employee GROUP BY department;

#7.Find departments with total salary greater than ₹150,000
SELECT department, SUM(salary) AS total_salary
FROM employee
GROUP BY department
HAVING SUM(salary) > 150000;

CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,  -- Unique product identifier
    ProductName VARCHAR(100) NOT NULL,          -- Name of the product
    Category VARCHAR(50),                      -- Product category
    Price DECIMAL(10, 2),                      -- Price of the product
    QuantityInStock INT     -- Date the product was added
);
INSERT INTO Products (ProductName, Category, Price, QuantityInStock)
VALUES
    ('Smartphone', 'Electronics', 700.00, 100),
    ('Table', 'Furniture', 150.00, 30),
    ('Chair', 'Furniture', 75.00, 200);

    select count(ProductId) from Products;
    #counts the number of products with a price greater than $50:
    select count(ProductId) from Products where price >50;
    # you want to count all rows, regardless of the column values, you can use COUNT(*):
    SELECT COUNT(*) FROM Products;
    SELECT COUNT(DISTINCT Category) FROM Products;













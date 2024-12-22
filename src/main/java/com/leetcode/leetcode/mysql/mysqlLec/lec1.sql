
# Give me maximum salary from the employee tables
SELECT MAX(salary) FROM company.employees;

# Give me minimum salary from the employee tables
SELECT MIN(salary) FROM company.employees;

# Give me average salary from the employee tables
SELECT AVG(salary) FROM company.employees;

# Give me sum of  salary from all the employee tables
SELECT SUM(salary) FROM company.employees;

# COUNT the number of employee in the company
SELECT COUNT(employee_id) FROM company.employees;

#Convert all the employee_first name in uppercase

SELECT  ucase(first_name) FROM company.employees;

#Convert all the employee_first name in lowercase

SELECT  lcase(first_name) FROM company.employees;
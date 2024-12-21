In MySQL, constraints are used to enforce rules on the data in a table. These constraints ensure the accuracy, integrity, and reliability of the data stored in the database. Below are the common types of constraints available in MySQL:

### 1. **NOT NULL Constraint**
Ensures that a column cannot have a `NULL` value. It forces the column to have a value.

```sql
CREATE TABLE employees (
    id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);
```

- In the example, `id`, `first_name`, and `last_name` cannot be `NULL`.

### 2. **UNIQUE Constraint**
Ensures that all values in a column are unique (no duplicate values).

```sql
CREATE TABLE employees (
    email VARCHAR(100) UNIQUE
);
```

- The `email` column will not allow duplicate values.

### 3. **PRIMARY KEY Constraint**
Uniquely identifies each record in a table. A primary key combines the `NOT NULL` and `UNIQUE` constraints.

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE
);
```

- The `id` column is the primary key and must contain a unique, non-null value for each row.

### 4. **FOREIGN KEY Constraint**
Enforces a link between two tables by ensuring that a column's value in one table corresponds to a value in another table (known as referential integrity).

```sql
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100)
);

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);
```

- The `dept_id` in the `employees` table must match an existing `dept_id` in the `departments` table.

### 5. **CHECK Constraint**
Ensures that the values in a column meet a specific condition. MySQL started supporting the `CHECK` constraint from version 8.0.16.

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    age INT CHECK (age >= 18)
);
```

- The `age` column will only allow values greater than or equal to 18.

### 6. **DEFAULT Constraint**
Sets a default value for a column if no value is provided during insertion.

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    hire_date DATE DEFAULT CURRENT_DATE
);
```

- The `hire_date` column will have the current date by default if no value is provided.

### 7. **AUTO_INCREMENT Constraint**
Automatically generates a unique number for the column when a new record is inserted. This is usually applied to the primary key.

```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);
```

- The `id` column will automatically increment with each new row.

### 8. **INDEX Constraint**
Creates an index on columns for faster retrieval. It's not technically a constraint but improves performance when querying data.

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    INDEX (last_name)
);
```

- The index on `last_name` improves the speed of searches on that column.

### 9. **UNIQUE with Composite Key**
Ensures that the combination of two or more columns is unique across the table.

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    UNIQUE (first_name, last_name)
);
```

- This ensures that no two employees can have the same combination of `first_name` and `last_name`.

### 10. **ON DELETE/ON UPDATE with FOREIGN KEY**
These constraints specify what happens to the foreign key when the referenced record is updated or deleted.

```sql
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
```

- `ON DELETE CASCADE`: If a row in the `departments` table is deleted, all rows in the `employees` table that reference it will also be deleted.
- `ON UPDATE CASCADE`: If a `dept_id` is updated in the `departments` table, the corresponding `dept_id` in the `employees` table will be updated automatically.

---

### Summary of Constraints in MySQL:
1. **NOT NULL**: Ensures a column cannot store `NULL` values.
2. **UNIQUE**: Ensures all values in a column or set of columns are unique.
3. **PRIMARY KEY**: A combination of `NOT NULL` and `UNIQUE`. Identifies each row uniquely.
4. **FOREIGN KEY**: Links two tables and ensures referential integrity.
5. **CHECK**: Ensures that values meet a specified condition (introduced in MySQL 8.0.16).
6. **DEFAULT**: Sets a default value for a column.
7. **AUTO_INCREMENT**: Automatically generates a unique number for each new record.
8. **INDEX**: Improves query performance by indexing columns.
9. **UNIQUE (Composite)**: Ensures the combination of multiple columns is unique.
10. **ON DELETE/ON UPDATE**: Defines the behavior of foreign key actions when referenced records are deleted or updated.

Let me know if you need further clarification or examples of specific constraints!
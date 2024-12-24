Q. What is Normalisation in Sql?
Normalisation is the process to eliminate data redundancy
and enhance data integrity in the table.
Normalization also helps to organize the data in the database.

Q. What is Denormalization with example?
The goal of demormalization is to move data from normalized tables
back into a single table to have the data where it is needed.

################################################ Join Operations  ############################################
CREATE DATABASE school;
use school;
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE
);

INSERT INTO students VALUES
(1, 'John', 'Doe', '2000-01-15'),
(2, 'Jane', 'Smith', '2001-04-22'),
(3, 'Alice', 'Johnson', '1999-11-09'),
(4, 'Bob', 'Davis', '2002-07-30');

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100)
);

INSERT INTO courses VALUES
(101, 'Mathematics'),
(102, 'Computer Science'),
(103, 'Physics'),
(104, 'Chemistry');

CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO enrollments VALUES
(1, 1, 101),
(2, 1, 102),
(3, 2, 103),
(4, 3, 102),
(5, 4, 101),
(6, 4, 104);

CREATE TABLE grades (
    grade_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade CHAR(1),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO grades VALUES
(1, 1, 101, 'A'),
(2, 1, 102, 'B'),
(3, 2, 103, 'A'),
(4, 3, 102, 'C'),
(5, 4, 101, 'B'),
(6, 4, 104, 'A');

CREATE TABLE professors (
    professor_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO professors VALUES
(1, 'Dr. Alice', 'Walker', 101),
(2, 'Dr. John', 'Brown', 102),
(3, 'Dr. Bob', 'Taylor', 103),
(4, 'Dr. Sarah', 'Green', 104);


Let's create a more comprehensive example using a `student` scenario with multiple tables, demonstrating how to perform various JOIN operations.

### Sample Tables

1. **students** table: Contains information about students.
   ```sql
   CREATE TABLE students (
       student_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       dob DATE
   );

   INSERT INTO students VALUES
   (1, 'John', 'Doe', '2000-01-15'),
   (2, 'Jane', 'Smith', '2001-04-22'),
   (3, 'Alice', 'Johnson', '1999-11-09'),
   (4, 'Bob', 'Davis', '2002-07-30');
   ```

2. **courses** table: Contains details of courses.
   ```sql
   CREATE TABLE courses (
       course_id INT PRIMARY KEY,
       course_name VARCHAR(100)
   );

   INSERT INTO courses VALUES
   (101, 'Mathematics'),
   (102, 'Computer Science'),
   (103, 'Physics'),
   (104, 'Chemistry');
   ```

3. **enrollments** table: Links students to the courses they are enrolled in.
   ```sql
   CREATE TABLE enrollments (
       enrollment_id INT PRIMARY KEY,
       student_id INT,
       course_id INT,
       FOREIGN KEY (student_id) REFERENCES students(student_id),
       FOREIGN KEY (course_id) REFERENCES courses(course_id)
   );

   INSERT INTO enrollments VALUES
   (1, 1, 101),
   (2, 1, 102),
   (3, 2, 103),
   (4, 3, 102),
   (5, 4, 101),
   (6, 4, 104);
   ```

4. **grades** table: Contains grades for students in their courses.
   ```sql
   CREATE TABLE grades (
       grade_id INT PRIMARY KEY,
       student_id INT,
       course_id INT,
       grade CHAR(1),
       FOREIGN KEY (student_id) REFERENCES students(student_id),
       FOREIGN KEY (course_id) REFERENCES courses(course_id)
   );

   INSERT INTO grades VALUES
   (1, 1, 101, 'A'),
   (2, 1, 102, 'B'),
   (3, 2, 103, 'A'),
   (4, 3, 102, 'C'),
   (5, 4, 101, 'B'),
   (6, 4, 104, 'A');
   ```

5. **professors** table: Contains details about professors.
   ```sql
   CREATE TABLE professors (
       professor_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       course_id INT,
       FOREIGN KEY (course_id) REFERENCES courses(course_id)
   );

   INSERT INTO professors VALUES
   (1, 'Dr. Alice', 'Walker', 101),
   (2, 'Dr. John', 'Brown', 102),
   (3, 'Dr. Bob', 'Taylor', 103),
   (4, 'Dr. Sarah', 'Green', 104);
   ```

---

### JOIN Operations

#### 1. **INNER JOIN**: List students with their courses and grades.

```sql
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name, g.grade
FROM students s
INNER JOIN enrollments e ON s.student_id = e.student_id
INNER JOIN courses c ON e.course_id = c.course_id
INNER JOIN grades g ON s.student_id = g.student_id AND c.course_id = g.course_id;
```
This will return a list of students, the courses they are enrolled in, and their grades.

#### 2. **LEFT JOIN**: List all students with their courses, even if they don't have grades assigned.

```sql
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name, g.grade
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses c ON e.course_id = c.course_id
LEFT JOIN grades g ON s.student_id = g.student_id AND c.course_id = g.course_id;
```
This query will return all students, their enrolled courses, and the grades if available (NULL if no grade is assigned).

#### 3. **RIGHT JOIN**: List all courses with their students and grades, even if there are no students enrolled.

```sql
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name, g.grade
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses c ON e.course_id = c.course_id
RIGHT JOIN grades g ON s.student_id = g.student_id AND c.course_id = g.course_id;
```
This query will return all courses and the students enrolled in them along with their grades. If a course has no students or grades, it will still be listed with NULL values for student names and grades.

#### 4. **FULL OUTER JOIN**: MySQL doesn't directly support `FULL OUTER JOIN`, but we can simulate it using `UNION`.

```sql
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name, g.grade
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses c ON e.course_id = c.course_id
LEFT JOIN grades g ON s.student_id = g.student_id AND c.course_id = g.course_id
UNION
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name, g.grade
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses c ON e.course_id = c.course_id
RIGHT JOIN grades g ON s.student_id = g.student_id AND c.course_id = g.course_id;
```
This query simulates a `FULL OUTER JOIN`, which combines all students and courses, showing NULLs for missing data from either side.

#### 5. **CROSS JOIN**: List all combinations of students and courses.

```sql
SELECT s.first_name AS student_first_name, s.last_name AS student_last_name,
       c.course_name
FROM students s
CROSS JOIN courses c;
```
This query will return all possible combinations of students and courses (Cartesian product).

---

These JOIN operations demonstrate how you can manipulate and combine data from multiple tables to achieve different results, based on your business requirements.

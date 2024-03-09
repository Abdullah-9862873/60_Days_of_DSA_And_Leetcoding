-- (1) creating a database
CREATE DATABASE practice;

-- (2) using a database
USE practice;

-- (3) droping a database and table
DROP DATABASE practice;
DROP TABLE students;

-- (4) IF EXISTS
DROP DATABASE IF EXISTS practice;

-- (5) IF NOT EXISTS
CREATE DATABASE IF NOT EXISTS practice;

-- (6) creating a table -- single column primary key (More than one col is down below)
CREATE TABLE courses (
course_id INT PRIMARY KEY UNIQUE NOT NULL,
subjects VARCHAR(50) NOT NULL
);

-- (7) insert 
INSERT INTO courses
(course_id, subjects)
VALUES
(101, "Computer Science"),
(104, "Physics"),
(107, "Chemistry"),
(201, "Statistics"),
(302, "Mathematics");


-- (8) show tables
SHOW TABLES;

-- (9) show database
SHOW DATABASES;

-- (10) select
SELECT * FROM students;
SELECT roll_no AS id, name FROM students;

-- (11) FOREIGN KEY --- can have duplicate values
CREATE TABLE students (
roll_no INT PRIMARY KEY UNIQUE NOT NULL,
name VARCHAR(50) NOT NULL,
course_id INT NOT NULL,
city VARCHAR(50) NOT NULL,
marks INT NOT NULL,
FOREIGN KEY (course_id) REFERENCES courses(course_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

-- more than one column primary key
CREATE TABLE students (
roll_no INT UNIQUE NOT NULL,
name VARCHAR(50) NOT NULL,
course_id INT NOT NULL,
city VARCHAR(50) NOT NULL,
marks INT NOT NULL,
PRIMARY KEY (name, roll_no)
);

INSERT INTO students
(roll_no, name, course_id, city, marks)
VALUES
(01, "Abdullah",101, "skp", 90),
(02, "Ahmed",104, "lhr", 80),
(03, "Ali",101, "lhr", 85),
(04, "Hamza",107, "skp", 78),
(05, "Abdullah",302, "fsd", 95),
(06, "Usama",201, "fsd", 72),
(07, "Aleena",201, "jhang", 60),
(08, "Hamna",101, "jaranwala", 85);

-- (12) constraints
CREATE TABLE bloodGroups (
roll_no INT NOT NULL UNIQUE PRIMARY KEY,
name VARCHAR(50)  NOT NULL,
blood_grp VARCHAR(50),
age INT NOT NULL,
CONSTRAINT my_checks CHECK (age >= 18)
);

CREATE TABLE bloodGroups (
roll_no INT NOT NULL UNIQUE PRIMARY KEY,
name VARCHAR(50)  NOT NULL,
blood_grp VARCHAR(50),
age INT NOT NULL CHECK (age >= 18)
);

INSERT INTO bloodGroups
(roll_no, name, blood_grp, age)
VALUES
(01, "Abdullah", "B+", 22),
(02, "Ahmed", "AB+", 21),
(03, "Ali", "B-", 18),
(04, "Hamza", "O-", 30),
(05, "Abdullah", "AB+", 24),
(06, "Usama", "B+", 19),
(07, "Aleena", "B-", 24),
(08, "Hamna", "AB-", 21);

-- (13) DISTINCT
SELECT DISTINCT name FROM students;

-- (14) WHERE
SELECT * FROM bloodGroups WHERE age = 18;
SELECT * FROM students WHERE marks > 85;

-- (15) AND OR NOT !=
SELECT * FROM students WHERE (marks >= 85 AND city = "skp");
SELECT * FROM students WHERE (marks >= 85 oR city = "jhang");
SELECT * FROM students WHERE NOT city="skp";
SELECT * FROM students WHERE marks != 85;

-- (16) Order by
SELECT * FROM students ORDER BY marks DESC LIMIT 3;
SELECT * FROM students ORDER BY marks ASC ;

-- (17) Aggregate functions
SELECT city, COUNT(name) as COUNT, AVG(marks) as average, MAX(marks) as max, MIN(marks) as min, SUM(marks) as sum
FROM students
GROUP BY city;

-- (18) HAVING
SELECT city, COUNT(name) as names, AVG(marks) as Avg
FROM students
GROUP BY city
HAVING AVG(marks) > 80;

-- (19) UPDATE
SET SQL_SAFE_UPDATES = 0;
UPDATE students
SET marks = marks + 1
WHERE marks >= 85;

-- (20) Delete
DELETE FROM students
WHERE marks < 33;

-- (21) Alter
ALTER TABLE students
RENAME TO student;

-- (22) Add col, Change Col, Modify Col
-- column added
ALTER TABLE student
ADD COLUMN height FLOAT default 0;

-- column deleted
ALTER TABLE student
DROP COLUMN height;

-- datatype of column change
ALTER TABLE student
MODIFY COLUMN height INT;

-- name and datatype of column change
ALTER TABLE student
CHANGE COLUMN height student_heights FLOAT;



-- (23) JOINS
CREATE TABLE temp_student (
student_id INT PRIMARY KEY UNIQUE,
name VARCHAR(50) NOT NULL
);

CREATE TABLE temp_course (
student_id INT PRIMARY KEY UNIQUE NOT NULL,
course VARCHAR(50) NOT NULL
);

INSERT INTO temp_student 
(student_id, name)
VALUES
(101, "adam"),
(102, "bob"),
(103, "casey");

INSERT INTO temp_course
(student_id, course)
VALUES
(102,"english"),
(105,"math"),
(103,"science"),
(107,"computer science");

-- inner join gives common information among two tables
SELECT *
FROM temp_student as a
INNER JOIN temp_course as b
ON a.student_id = b.student_id;

-- left join gives common information + all information of A table

SELECT *
FROM temp_student as a
LEFT JOIN temp_course as b
ON a.student_id = b.student_id;


-- right join gives common information + all information of B table

SELECT *
FROM temp_student as a
RIGHT JOIN temp_course as b
ON a.student_id = b.student_id;

-- full join gives all information of A + common information + all information of B
SELECT *
FROM temp_student as a
LEFT JOIN temp_course as b
ON a.student_id = b.student_id
UNION
SELECT *
FROM temp_student as a
RIGHT JOIN temp_course as b
ON a.student_id = b.student_id;

-- left exclusive join ... Only gives the data of A table which is not common with B table
SELECT *
FROM temp_student as a
LEFT JOIN temp_course as b
ON a.student_id = b.student_id
WHERE b.student_id IS NULL;

-- RIGHT exclusive join ... Only gives the data of b table which is not common with A table
SELECT *
FROM temp_student as a
RIGHT JOIN temp_course as b
ON a.student_id = b.student_id
WHERE a.student_id IS NULL;

-- SELFT JOIN ... joins one table with itself to get some meaningful information
CREATE TABLE employee (
id INT PRIMARY KEY UNIQUE,
name VARCHAR(50) ,
manager_id INT
);

INSERT INTO employee
(id, name, manager_id)
VALUES
(101, "adam", 103),
(102, "bob", 104),
(103, "casey", null),
(104, "donald", 103),
(105, "adam", 103);

SELECT a.name as manager_name, b.name
FROM employee as a
JOIN employee as b
ON a.id = b.manager_id;

-- (24) UNION
-- gives only the common values
SELECT * FROM employee
UNION
SELECT * FROM employee;

-- Union all gives duplicate values too
SELECT * FROM employee
UNION ALL
SELECT * FROM employee;

-- (25) views
CREATE VIEW view1 AS 
SELECT student_id, name 
FROM temp_student;


SELECT * FROM view1;

-- (26) IN
SELECT * 
FROM student
WHERE name IN ("Abdullah", "Ahmed");

-- (27) BETWEEN
SELECT *
FROM student
WHERE roll_no BETWEEN 1 AND 3;

-- (28) To get second last person 
SELECT *
FROM student
ORDER BY roll_no DESC
LIMIT 1 OFFSET 1;


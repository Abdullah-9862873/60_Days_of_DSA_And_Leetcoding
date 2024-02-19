CREATE DATABASE college;
USE college;


CREATE TABLE student (
rollno INT PRIMARY KEY,
name VARCHAR(50),
marks INT NOT NULL,
grade VARCHAR(1), 
city VARCHAR(20),
subject VARCHAR(50)
);

INSERT INTO student
(rollno, name, marks, grade, city, subject)
VALUES
(101, "Anil", 78, "C", "Pune", "Computer Science"),
(102, "Bhumika", 93, "A", "Mumbai", "Physics"),
(103, "Chetan", 85, "B", "Mumbai", "Physics"),
(104, "Dhruv", 96, "A", "Delhi", "Computer Science"),
(105, "Emanuel", 12, "F", "Delhi", "Chemistry"),
(106, "Farah", 82, "B", "Delhi", "Computer Science");


SHOW TABLES;
SELECT * FROM student;
SELECT city FROM student;
SELECT DISTINCT city FROM student;

SELECT * FROM student WHERE (marks >= 80);
SELECT * FROM student WHERE (marks > 80 AND city = "Mumbai");

-- WHERE CLAUSE OPERATORS----------------------------------
-- LOGICAL OPERATORS
SELECT * FROM student WHERE (marks > 80 AND city = "Mumbai");
SELECT * FROM student WHERE (marks > 80 OR city = "Mumbai");
SELECT * FROM student WHERE NOT (marks > 80 AND city = "Mumbai");
SELECT * FROM student WHERE marks BETWEEN 70 AND 90;
SELECT * FROM student WHERE city IN ("Mumbai", "Pune");
SELECT * FROM student WHERE name LIKE 'A%';
SELECT * FROM student WHERE city LIKE 'M%';
-- Following is to select all the students from the student table who scored higher than any of the marks computer science subject in student table
SELECT * FROM student WHERE marks > ANY (SELECT marks FROM student WHERE subject = 'Computer Science') AND subject != 'Computer Science';

-- CLAUSES
-- LIMIT CLAUSE
SELECT * FROM student LIMIT 3; 
SELECT * FROM student WHERE (marks > 75) LIMIT 3; 

-- ORDER BY CLAUSE 
SELECT * FROM student ORDER BY rollno ASC;
SELECT * FROM student ORDER BY rollno DESC;
SELECT * FROM student ORDER BY rollno asc;

-- To get top 3 students of the class
SELECT *
FROM student
ORDER BY marks DESC
LIMIT 3;


-- Aggregate functions
SELECT MAX(marks) FROM student;
SELECT * from student where marks = (SELECT MIN(marks) FROM student);
SELECT AVG(marks) FROM student;
SELECT COUNT(marks) FROM student;
SELECT SUM(marks) FROM student;

-- Group By Clause

SELECT city
FROM student
GROUP BY city;


SELECT city, COUNT(rollno) AS student_count, MIN(marks) AS min_marks, MAX(marks) AS max_marks, AVG(marks) AS avg_marks
FROM student
GROUP BY city;

-- Write a query to find avg marks in each city in ascending order
SELECT city, AVG(marks) AS average_marks
FROM student
GROUP BY city
ORDER BY AVG(marks);

SELECT grade, COUNT(name)
FROM student
GROUP BY grade
ORDER BY grade;

-- Having Clause (Used to apply conditions like WHERE clause but on groups)
SELECT city, COUNT(name) as names
FROM student
GROUP BY city
HAVING max(marks) > 85
ORDER BY city;

SELECT city
FROM student
WHERE grade = "A"
GROUP BY city
HAVING MAX(marks) > 93
ORDER BY city ASC;

-- Using Update 
-- Setting the safe update mode off in sql
SET SQL_SAFE_UPDATES = 0;

UPDATE student
SET grade = "O"
WHERE grade = "A";

UPDATE student
SET marks = 92, grade = "O"
WHERE name = "Emanuel";

UPDATE student
SET marks = 32
WHERE name = "Emanuel";

DELETE FROM student
WHERE marks < 33;

SELECT * FROM student;

CREATE TABLE dept(
id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE teacher(
id INT PRIMARY KEY,
name VARCHAR(50),
dept_id INT,
FOREIGN KEY (dept_id) REFERENCES dept(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);


SHOW TABLES;
-- Alter command

ALTER TABLE student
ADD COLUMN age INT NOT NULL;

SELECT * FROM student;

UPDATE student
SET age = 18;

ALTER TABLE student
DROP COLUMN age;

ALTER TABLE student
RENAME TO students;

SHOW TABLES;

-- Used to rename the column
ALTER TABLE student
CHANGE COLUMN subject subjects VARCHAR(50);

-- Used to change the datatype of column
ALTER TABLE student
MODIFY COLUMN marks FLOAT NOT NULL;

SELECT * FROM student;

-- Following are the example usage of DROP.. Drop with Table is used to delete the table
-- DROP TABLE table_name
-- DROP DATABASE database_name
-- DROP VIEW view_name
-- DROP INDEX index_name ON table_name

-- Following are the example usage of truncate... Truncate is used to delete the data of the table 
TRUNCATE TABLE student;

ALTER TABLE student
CHANGE COLUMN name full_name VARCHAR(50);

DELETE FROM student
WHERE marks < 80;

ALTER TABLE student
DROP COLUMN grade;

SELECT * FROM student;
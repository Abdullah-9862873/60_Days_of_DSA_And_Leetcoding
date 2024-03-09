CREATE DATABASE college;
USE college;

ALTER TABLE students
ADD COLUMN city VARCHAR(50);

CREATE TABLE students(
rollno INT PRIMARY KEY,
name VARCHAR(50),
marks INT,
city VARCHAR(50)
);

INSERT INTO students
(rollno, name, marks, city)
VALUES
(101, "anil", 78, "pune"),
(102, "bhumika", 93, "mumbai"),
(103, "chetan", 85, "mumbai"),
(104, "dhruv", 96, "delhi"),
(105, "emanuel", 92, "delhi"),
(106, "farah", 82, "delhi");

-- Find the names of all the students who scored more than average marks
SELECT name, marks
FROM students
WHERE marks > (SELECT AVG(marks) FROM students);

-- Find the names of all the students with even roll numbers
SELECT name, rollno
FROM students
WHERE rollno IN (SELECT rollno FROM students WHERE rollno%2=0);

-- Find the name of the student that scored maximum in Delhi
SELECT name
FROM students
WHERE city = "mumbai" AND marks = (SELECT MAX(marks) FROM students where city="mumbai");
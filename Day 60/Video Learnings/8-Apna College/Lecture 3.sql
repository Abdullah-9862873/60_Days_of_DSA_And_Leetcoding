
CREATE DATABASE college;
USE college;

CREATE TABLE student (
student_id INT,
name VARCHAR(50),
PRIMARY KEY (student_id)
);

CREATE TABLE course(
student_id INT,
course VARCHAR(50),
PRIMARY KEY (student_id)
);

INSERT INTO student
(student_id, name)
VALUES
(101, "adam"),
(102, "bob"),
(103, "casey");

INSERT INTO course
(student_id, course)
VALUES
(102, "english"),
(105, "math"),
(103, "science"),
(107, "computer science");

-- Inner JOIN
SELECT * 
FROM student as a
INNER JOIN course as b
ON a.student_id = b.student_id;

-- Left Join
SELECT *
FROM student as a
LEFT JOIN course as b
ON a.student_id = b.student_id;

-- Right Join
SELECT *
FROM student as a
RIGHT JOIN course as b
ON a.student_id = b.student_id;

-- Full Join
SELECT *
FROM student as a
LEFT JOIN course as b
ON a.student_id = b.student_id
UNION
SELECT * 
FROM student as a 
RIGHT JOIN course as b
ON a.student_id = b.student_id;

-- Left Exclusive Join...  A's data that is not similar with B
SELECT *
FROM student as a
LEFT JOIN course as b
ON a.student_id = b.student_id
WHERE b.student_id IS NULL;

-- Right Exclusive Join ... B's data that is not similar with A
SELECT *
FROM student as a 
RIGHT JOIN course as b
ON a.student_id = b.student_id
WHERE a.student_id IS NULL;


-- Self JOIN
CREATE TABLE employee(
id INT PRIMARY KEY,
name VARCHAR(50),
manager_id INT
);

INSERT INTO employee
(id, name, manager_id)
VALUES
(101, "adam", 103),
(102, "bob", 104),
(103, "casey", null),
(104, "donald", 103);

SELECT a.name as manager_name, b.name
FROM employee as a
JOIN employee as b
ON a.id = b.manager_id;

-- Union.. Provides unique common values
SELECT * FROM employee
UNION
SELECT * FROM employee;

-- Union All.. Provides duplicate common values too
SELECT * FROM employee
UNION ALL
SELECT * FROM employee;



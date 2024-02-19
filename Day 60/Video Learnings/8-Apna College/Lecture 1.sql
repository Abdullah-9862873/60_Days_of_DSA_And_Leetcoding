CREATE DATABASE temp1;
CREATE DATABASE IF NOT EXISTS temp1;

create database temp2;

CREATE DATABASE college;
drop database if exists temp1;
drop database temp2;
drop database if exists temp3;

USE college;

CREATE TABLE student (
id INT PRIMARY KEY,
name VARCHAR(50),
age INT NOT NULL
);

INSERT INTO student VALUES(1,"Abdullah",22);

SELECT * FROM student;

SHOW DATABASES;
SHOW TABLES;

INSERT INTO student
(id, name, age)
VALUES
(12, "Ab", 21),
(13, "Ali", 22);

CREATE TABLE info (
id INT PRIMARY KEY,
name VARCHAR(50),
salary INT
);

INSERT INTO info
(id, name, salary)
VALUES
(1,"adam",25000),
(2,"bob",30000),
(3,"casey",40000);

SELECT * FROM info;

USE college;
SHOW TABLES;
DROP TABLE info;

CREATE TABLE newTable (
id INT NOT NULL,
name VARCHAR(50) NOT NULL,
PRIMARY KEY (id, name)
);

SHOW TABLES;
DROP TABLE IF EXISTS newTable;
DROP TABLE IF EXISTS student;

-- Making a customer table

CREATE TABLE customer(
id INT PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE temp (
cust_id INT,
FOREIGN KEY (cust_id) REFERENCES customer(id)
);

SHOW TABLES;

INSERT INTO customer
(id, name)
VALUES
(1, "Abdullah"),
(2, "Ahmed");

SELECT * FROM customer;

CREATE TABLE employee (
emp_id INT,
emp_name VARCHAR(50),
salary INT DEFAULT 25000
);
INSERT INTO employee VALUES (1, "Abdullah",30000);
INSERT INTO employee
(emp_id, emp_name)
VALUES
(2, "Ahmed");

SELECT * FROM employee;

-- Check constraint with more than one entries

-- In the following all the entries must have age>=18 and city == Lahore

CREATE TABLE city(
id INT PRIMARY KEY,
city VARCHAR(50),
age INT,
CONSTRAINT my_check CHECK (age >= 18 AND city = "Lahore")
);

-- Other way to apply check

CREATE TABLE newTab(
age INT CHECK (age >= 18)
);

-- will throw error
INSERT INTO city
(id, city, age)
VALUES
(1, "Sheikhupura", 21);

-- Will not throw error
INSERT INTO city
(id, city, age)
VALUES
(1, "Lahore", 21);

INSERT INTO newTab (age) VALUES (22);
create database college;
use college;
CREATE TABLE student (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50),
    marks DOUBLE
);
DESC student;
INSERT INTO student VALUES
(101, 'Rahul', 85.5);
SELECT * FROM student;
DELETE FROM student WHERE roll_no = 101;
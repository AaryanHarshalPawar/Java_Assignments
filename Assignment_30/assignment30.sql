CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

CREATE TABLE IF NOT EXISTS employees (
    emp_id      INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    department  VARCHAR(50)  NOT NULL,
    designation VARCHAR(50)  NOT NULL,
    salary      DOUBLE       NOT NULL
);

CREATE TABLE IF NOT EXISTS patients (
    patient_id       INT PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(100) NOT NULL,
    age              INT          NOT NULL,
    disease          VARCHAR(100) NOT NULL,
    treatment_status VARCHAR(30)  NOT NULL
);

INSERT INTO employees (name, department, designation, salary) VALUES
    ('Rahul Sharma', 'IT', 'Developer', 55000),
    ('Priya Patil', 'HR', 'HR Executive', 42000),
    ('Amit Joshi', 'Finance', 'Accountant', 48000);

INSERT INTO patients (name, age, disease, treatment_status) VALUES
    ('Sneha Kulkarni', 34, 'Typhoid', 'Under Treatment'),
    ('Rohan Deshmukh', 52, 'Diabetes', 'Admitted'),
    ('Meera Iyer', 27, 'Fracture', 'Recovered');

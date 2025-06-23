CREATE DATABASE etudiants;
USE demo_jdbc;

CREATE TABLE IF NOT EXISTS students(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(150),
lastname VARCHAR(150),
classroom_num INT,
degree_date DATE;
);
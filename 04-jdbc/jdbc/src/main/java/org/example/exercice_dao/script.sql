CREATE DATABASE bank;
USE bank;

CREATE TABLE customer(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
lastname VARCHAR(150),
firstname VARCHAR(150),
phone VARCHAR(20)
);

CREATE TABLE bank_account(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL,
balance INT,
CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE transactions(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
bank_account_id INT NOT NULL,
amount INT,
status VARCHAR(150),
CONSTRAINT fk_bank_account_id FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
);

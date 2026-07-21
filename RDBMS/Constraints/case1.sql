CREATE DATABASE covid_assignment2;
USE covid_assignment2;
CREATE TABLE covid_cases (
    Country VARCHAR(50),
    Report_Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Last_Updated TIMESTAMP,
    PRIMARY KEY (Country, Report_Date)
);

INSERT INTO covid_cases
VALUES ('India','2025-07-01',1000,20,900,NOW());

SELECT * FROM covid_cases;
SHOW TABLES;
SHOW DATABASES;
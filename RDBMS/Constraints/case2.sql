USE covid_assignment2;

DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
    Country VARCHAR(50) PRIMARY KEY,
    Continent VARCHAR(50)
);

CREATE TABLE covid_cases (
    Country VARCHAR(50),
    Report_Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Last_Updated TIMESTAMP,
    PRIMARY KEY (Country, Report_Date),
    FOREIGN KEY (Country) REFERENCES countries(Country)
);

INSERT INTO countries VALUES
('India','Asia'),
('USA','North America'),
('Japan','Asia');

INSERT INTO covid_cases
VALUES ('India','2025-07-01',1000,20,900,NOW());

SELECT * FROM countries;
SELECT * FROM covid_cases;
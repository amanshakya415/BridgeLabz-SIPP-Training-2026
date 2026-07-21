USE covid_assignment2;

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Country VARCHAR(50),
    Report_Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    UNIQUE (Country, Report_Date)
);

INSERT INTO covid_cases
(Country, Report_Date, Confirmed_Cases, Deaths, Recoveries)
VALUES
('India','2025-07-01',1000,20,900);

SELECT * FROM covid_cases;
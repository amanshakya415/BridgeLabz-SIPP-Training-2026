USE covid_assignment2;

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    Country VARCHAR(50) NOT NULL,
    Report_Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT,
    Recoveries INT DEFAULT 0,
    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Country, Report_Date)
);

INSERT INTO covid_cases
(Country, Report_Date, Confirmed_Cases, Deaths)
VALUES
('India','2025-07-01',1000,20);

SELECT * FROM covid_cases;
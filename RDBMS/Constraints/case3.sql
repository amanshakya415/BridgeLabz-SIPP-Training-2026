USE covid_assignment2;

-- Agar countries table foreign key ki wajah se issue kare to pehle foreign key checks off kar do
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS covid_cases;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE covid_cases (
    Country VARCHAR(50) NOT NULL,
    Report_Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT,
    Recoveries INT,
    Last_Updated TIMESTAMP,
    PRIMARY KEY (Country, Report_Date),
    CONSTRAINT chk_deaths CHECK (Deaths <= Confirmed_Cases)
);

INSERT INTO covid_cases
(Country, Report_Date, Confirmed_Cases, Deaths, Recoveries, Last_Updated)
VALUES
('India','2025-07-01',1000,20,900,NOW());

SELECT * FROM covid_cases;
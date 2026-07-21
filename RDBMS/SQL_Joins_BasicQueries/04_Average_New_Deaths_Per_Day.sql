SELECT
    report_date,
    AVG(new_deaths) AS average_new_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;

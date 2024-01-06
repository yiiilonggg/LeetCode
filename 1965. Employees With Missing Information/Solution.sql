# Write your MySQL query statement below
SELECT Combined.employee_id
FROM (
    SELECT *
    FROM Employees
    LEFT JOIN Salaries
        USING(employee_id)
    UNION
    SELECT *
    FROM Employees
    RIGHT JOIN Salaries
        USING(employee_id)
    ) Combined
WHERE Combined.name IS NULL
    OR Combined.salary IS NULL
ORDER BY Combined.employee_id

# Write your MySQL query statement below
SELECT employee_id,
    IF(employee_id % 2 = 1 AND SUBSTR(name, 1, 1) != "M", salary, 0) bonus
FROM Employees
ORDER BY employee_id

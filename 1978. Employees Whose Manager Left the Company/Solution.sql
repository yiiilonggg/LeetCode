# Write your MySQL query statement below
SELECT employee_id
FROM Employees
WHERE manager_id NOT IN(
        SELECT employee_id
        FROM Employees
        WHERE employee_id IS NOT NULL)
    AND salary < 30000
ORDER BY employee_id

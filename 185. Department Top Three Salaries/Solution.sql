# Write your MySQL query statement below
SELECT D.name Department,
    E.name Employee,
    E.salary Salary
FROM Employee E
LEFT JOIN Department D
    ON E.departmentId = D.id
WHERE (SELECT COUNT(DISTINCT E1.salary)
    FROM Employee E1
    WHERE E1.salary > E.salary
        AND E.departmentId = E1.departmentId) < 3

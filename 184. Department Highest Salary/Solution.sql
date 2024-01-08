# Write your MySQL query statement below
SELECT D.name Department,
    E.name Employee,
    E.salary Salary
FROM Employee E
LEFT JOIN (SELECT departmentId,
        MAX(salary) highest
    FROM Employee
    GROUP BY departmentId) H
    ON E.departmentId = H.departmentId
LEFT JOIN Department D
    ON E.departmentId = D.id
WHERE E.salary = H.highest

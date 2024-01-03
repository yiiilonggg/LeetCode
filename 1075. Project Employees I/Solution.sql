# Write your MySQL query statement below
SELECT project_id, ROUND((SUM(experience_years) / COUNT(experience_years)), 2) average_years
FROM (SELECT project_id, experience_years
        FROM Project
        LEFT JOIN Employee
            ON Project.employee_id = Employee.employee_id) proj
GROUP BY project_id

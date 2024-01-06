# Write your MySQL query statement below
SELECT query_name,
    ROUND(AVG(rating / position), 2) quality,
    ROUND(100 * SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) / COUNT(rating), 2) poor_query_percentage
FROM Queries
GROUP BY query_name
HAVING query_name IS NOT NULL

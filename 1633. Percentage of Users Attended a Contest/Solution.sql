# Write your MySQL query statement below
SELECT Register.contest_id,
    ROUND(100 * COUNT(*) / total_users.total, 2) percentage
FROM Register
CROSS JOIN (
    SELECT COUNT(*) total
    FROM Users
    ) total_users
GROUP BY Register.contest_id
ORDER BY percentage DESC, contest_id ASC

# Write your MySQL query statement below
SELECT ROUND(COUNT(A1.player_id) / (
    SELECT COUNT(DISTINCT A3.player_id)
    FROM Activity A3), 2) fraction
FROM Activity A1
LEFT JOIN (SELECT A2.player_id,
        MIN(A2.event_date) first
    FROM Activity A2
    GROUP BY A2.player_id) M
    ON A1.player_id = M.player_id
WHERE DATEDIFF(A1.event_date, M.first) = 1

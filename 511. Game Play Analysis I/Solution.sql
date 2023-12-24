# Write your MySQL query statement below
SELECT player_id, MIN(a2.event_date) first_login
FROM Activity a2
GROUP BY a2.player_id


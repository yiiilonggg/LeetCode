# Write your MySQL query statement below
SELECT requester_id id,
    COUNT(DISTINCT accepter_id) num
FROM (
    SELECT requester_id,
        accepter_id
    FROM RequestAccepted
    UNION
    SELECT accepter_id "requester_id",
        requester_id "accepter_id"
    FROM RequestAccepted) Combined
GROUP BY requester_id
ORDER BY num DESC
LIMIT 1

# Write your MySQL query statement below
SELECT request_at "Day",
    ROUND(SUM(status != "completed") / COUNT(*), 2) "Cancellation Rate"
FROM Trips T1
LEFT JOIN Users U1
    ON T1.client_id = U1.users_id
LEFT JOIN Users U2
    ON T1.driver_id = U2.users_id
WHERE U1.banned = "No"
    AND U2.banned = "No"
    AND T1.request_at BETWEEN "2013-10-01" AND "2013-10-03"
GROUP BY T1.request_at

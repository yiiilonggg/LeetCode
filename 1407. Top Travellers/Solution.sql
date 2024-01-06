# Write your MySQL query statement below
SELECT Users.name,
    SUM(IFNULL(Rides.distance, 0)) travelled_distance
FROM Users
LEFT JOIN Rides
    ON Users.id = Rides.user_id
GROUP BY Users.id
ORDER BY travelled_distance DESC, Users.name ASC

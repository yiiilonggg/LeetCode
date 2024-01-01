# Write your MySQL query statement below
SELECT actor_id, director_id
FROM (
    SELECT actor_id, director_id, COUNT(*) num
    FROM ActorDirector
    GROUP BY actor_id, director_id
    ) nActorDirector
WHERE num >= 3

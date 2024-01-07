# Write your MySQL query statement below
SELECT S1.score,
    (
        SELECT COUNT(DISTINCT score)
        FROM Scores S2
        WHERE S1.score <= S2.score
    ) 'rank'
FROM Scores S1
ORDER BY S1.score DESC

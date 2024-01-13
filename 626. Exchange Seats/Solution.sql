# Write your MySQL query statement below
SELECT S.id,
    (CASE
        WHEN S.id % 2 = 0 THEN E.student
        WHEN O.student IS NULL THEN S.student
        ELSE O.student
    END) student
FROM Seat S
LEFT JOIN (SELECT id, student FROM Seat) O
    ON S.id = O.id - 1
LEFT JOIN (SELECT id, student FROM Seat) E
    ON S.id = E.id + 1
GROUP BY S.id

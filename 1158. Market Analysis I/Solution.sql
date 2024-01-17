-- Write your PostgreSQL query statement below
SELECT U.user_id buyer_id,
    U.join_date,
    COUNT(N.order_id) orders_in_2019
FROM Users U
LEFT JOIN(
    SELECT *
    FROM Orders
    WHERE DATE_PART('year', order_date) = 2019) N
    ON U.user_id = N.buyer_id
GROUP BY U.user_id, U.join_date

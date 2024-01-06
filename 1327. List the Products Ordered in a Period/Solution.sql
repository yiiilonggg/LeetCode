# Write your MySQL query statement below
SELECT product_name, SUM(Orders.unit) unit
FROM Products
LEFT JOIN Orders
    ON Products.product_id = Orders.product_id
WHERE Orders.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY Products.product_name
HAVING unit >= 100

# Write your MySQL query statement below
SELECT SalesPerson.name
FROM SalesPerson
WHERE SalesPerson.sales_id NOT IN (
    SELECT sales_id
    FROM Orders
    LEFT JOIN Company
        ON Company.com_id = Orders.com_id
    WHERE Company.name = "RED"
)

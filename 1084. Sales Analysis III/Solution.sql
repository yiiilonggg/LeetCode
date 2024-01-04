# Write your MySQL query statement below
SELECT Sales.product_id, Product.product_name
FROM Sales
LEFT JOIN Product
    ON Sales.product_id = Product.product_id
GROUP BY product_id
HAVING SUM(CASE WHEN sale_date NOT BETWEEN '2019-01-01' AND '2019-03-31' THEN 1 ELSE 0 END) = 0

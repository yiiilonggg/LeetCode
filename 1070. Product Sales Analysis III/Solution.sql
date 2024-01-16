-- Write your PostgreSQL query statement below
SELECT product_id,
    year first_year,
    quantity,
    price
FROM Sales S
WHERE (product_id, year) IN (
    SELECT product_id,
        MIN(year)
    FROM Sales
    GROUP BY product_id
)

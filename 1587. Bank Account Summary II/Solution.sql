# Write your MySQL query statement below
SELECT Users.name,
    SUM(Transactions.amount) balance
FROM Transactions
LEFT JOIN Users
    ON Transactions.account = Users.account
GROUP BY Transactions.account
HAVING balance > 10000

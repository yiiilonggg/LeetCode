# Write your MySQL query statement below
SELECT id,
    SUM(IF(month = "Jan", revenue, null)) Jan_Revenue,
    SUM(IF(month = "Feb", revenue, null)) Feb_Revenue,
    SUM(IF(month = "Mar", revenue, null)) Mar_Revenue,
    SUM(IF(month = "Apr", revenue, null)) Apr_Revenue,
    SUM(IF(month = "May", revenue, null)) May_Revenue,
    SUM(IF(month = "Jun", revenue, null)) Jun_Revenue,
    SUM(IF(month = "Jul", revenue, null)) Jul_Revenue,
    SUM(IF(month = "Aug", revenue, null)) Aug_Revenue,
    SUM(IF(month = "Sep", revenue, null)) Sep_Revenue,
    SUM(IF(month = "Oct", revenue, null)) Oct_Revenue,
    SUM(IF(month = "Nov", revenue, null)) Nov_Revenue,
    SUM(IF(month = "Dec", revenue, null)) Dec_Revenue
FROM Department
GROUP BY id

# Write your MySQL query statement below
WITH banned_users AS(
    SELECT users_id FROM Users 
    WHERE banned="Yes"
)

SELECT 
request_at AS Day,
ROUND(SUM(CASE WHEN status ='cancelled_by_client' OR status ='cancelled_by_driver' THEN 1.00 ELSE 0 END)/COUNT(*),2) AS 'Cancellation Rate'
FROM Trips
WHERE client_id NOT IN(SELECT * FROM banned_users)
AND driver_id NOT IN (SELECT * FROM banned_users)
AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY  request_at;
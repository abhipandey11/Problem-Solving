# Write your MySQL query statement below
SELECT d.name as Department,e.name as Employee,e.salary as Salary 
FROM Employee e JOIN Department d ON e.departmentId=d.id 
WHERE 3>(
    SELECT COUNT(DISTINCT e2.Salary) FROM Employee e2 WHERE e2.departmentId=e.departmentId AND e2.salary>e.salary
);
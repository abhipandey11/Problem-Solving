# Write your MySQL query statement below
SELECT d.name as Department,e.name as Employee,e.salary as Salary 
FROM Employee e JOIN Department d ON e.departmentId=d.id 
WHERE (e.departmentId,e.Salary) IN(SELECT departmentId,MAX(Salary) FROM Employee GROUP BY departmentId);
---------------------------------------------------------------------------------------------------------

# Write your MySQL query statement below
WITH rnk_table AS(
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        RANK() OVER ( 
            PARTITION BY d.name
            ORDER BY e.salary DESC) AS rnk
    FROM 
        Employee e
    LEFT JOIN 
        Department d
        ON e.departmentId = d.id
)

SELECT
    Department, 
    Employee, 
    Salary
FROM rnk_table
WHERE rnk = 1

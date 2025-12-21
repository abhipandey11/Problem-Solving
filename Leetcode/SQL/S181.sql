# Write your MySQL query statement below
SELECT e1.name AS Employee FROM Employee e2 INNER JOIN Employee e1 ON e1.ManagerId=e2.id WHERE e1.salary>e2.salary;
#------------------#

# Write your MySQL query statement below
SELECT e.name AS Employee FROM Employee e WHERE e.salary>(SELECT salary FROM Employee WHERE id=e.managerId);
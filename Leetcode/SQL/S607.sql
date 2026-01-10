# Write your MySQL query statement below

select name from SalesPerson
where name not in(
select sp.name as salespersonname from orders o
left join salesperson sp
on o.sales_id = sp.sales_id
left join company c
on o.com_id = c.com_id
    where c.name = 'RED');
-----------------------------------------

# Write your MySQL query statement below
SELECT name FROM SalesPerson
WHERE name NOT IN(SELECT s.name as name FROM SalesPerson s INNER JOIN Orders o
ON s.sales_id=o.sales_id 
WHERE o.com_id IN(SELECT com_id FROM Company WHERE name='RED'));
# Write your MySQL query statement below
with cte as(
    select id, email, row_number() over(partition by email order by id) 
    as rownum from person)
delete from person
where id in (select id from cte where rownum>1);



-----------------------------------------------------------------------------
# Write your MySQL query statement below
DELETE p1 FROM person as p1 INNER JOIN person as p2 on p1.email=p2.email AND p1.id>p2.id;
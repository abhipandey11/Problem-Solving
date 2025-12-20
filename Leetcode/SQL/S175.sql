# Write your MySQL query statement below
Select Person.lastName,Person.firstName,Address.city,Address.state
FROM Person
LEFT JOIN Address
ON Person.PersonId=Address.PersonId;
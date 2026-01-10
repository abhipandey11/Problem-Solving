# Write your MySQL query statement below
SELECT st.student_id,st.student_name,sb.subject_name,COUNT(ex.student_id) AS attended_exams
FROM students st CROSS JOIN subjects sb left join Examinations ex
ON st.student_id=ex.student_id AND sb.subject_name=ex.subject_name
group by sb.subject_name,st.student_id,st.student_name
order by st.student_id, sb.subject_name;

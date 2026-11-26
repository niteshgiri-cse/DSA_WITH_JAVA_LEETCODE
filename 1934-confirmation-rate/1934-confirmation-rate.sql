select
   s.user_id, 
coalesce(round(sum(case when c.action='confirmed' then 1.0 else 0 end)/nullif(count(c.action),0),2),0) as  confirmation_rate
from Signups s
left join Confirmations c
 on s.user_id=c.user_id
group by s.user_id;
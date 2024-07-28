create table teens(
	name text,
	gender text
);

insert into teens(name, gender) values('Вася', 'М');
insert into teens(name, gender) values('Маша', 'Ж');
insert into teens(name, gender) values('Петя', 'М');
insert into teens(name, gender) values('Аня', 'Ж');

select t1.name as male, t2.name as female
from teens t1 cross join teens t2
where t1.gender = 'М' and t2.gender = 'Ж'; 

select * from employees emp 
	left join departments dp on emp.department_name = dp.name;

select * from employees emp 
	right join departments dp on emp.department_name = dp.name;

select * from employees emp 
	full join departments dp on emp.department_name = dp.name;

select * from employees emp 
	cross join departments dp;

select * from employees emp 
	left join departments dp on emp.department_name = dp.name
where emp.department_name is null;

select * from employees emp 
         left join departments dp on emp.department_name = dp.name
union
select * from employees emp 
	right join departments dp on emp.department_name = dp.name;









create table departments(
	name text unique
);

create table employees(
	name text,
	department_name text references departments(name)
);

insert into departments(name) values('Backend');
insert into departments(name) values('Testing');
insert into departments(name) values('Frontend');

insert into employees(name, department_name) values('Cаша', 'Testing');
insert into employees(name, department_name) values('Иван', 'Backend');
insert into employees(name, department_name) values('Андрей', 'Backend');
insert into employees(name, department_name) values('Олег','Frontend');
insert into employees(name ,department_name) values('Алексей', null);












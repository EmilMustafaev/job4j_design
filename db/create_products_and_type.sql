create table type(
	id serial primary key,
	name text
);

create table product(
    id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price float
);















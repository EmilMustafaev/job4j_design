create table users(
	id serial primary key,
	username varchar(255) unique
);

create table profile(
	id serial primary key,
	user_id int references users(id) unique
	);
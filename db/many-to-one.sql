create table publisher(
	id serial primary key,
	name varchar(255)
);

create table book(
	id serial primary key,
	name varchar(255),
	publisher_id int references publisher(id)
);
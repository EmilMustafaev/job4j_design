create table participants(
	id serial primary key,
	name varchar(255)
);

create table projects(
	id serial primary key,
	name varchar(255)
);

create table participants_projects(
	id serial primary key,
	participant_id int references participants(id),
	project_id int references projects(id)
);
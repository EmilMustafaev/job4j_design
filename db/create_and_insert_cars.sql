create table car_bodies(
	id serial primary key,
	name text
);

create table car_engines(
	id serial primary key,
	name text
);

create table car_transmissions(
	id serial primary key,
	name text
);

create table cars(
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('Седан');
insert into car_bodies(name) values('Хетчбек');
insert into car_bodies(name) values('Пикап');

insert into car_engines(name) values('Полный привод');
insert into car_engines(name) values('Задний привод');
insert into car_engines(name) values('Передний привод');

insert into car_transmissions(name) values('Механика');
insert into car_transmissions(name) values('Автомат');

insert into cars(name, body_id, engine_id, transmission_id) values('Ford', 3, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('BMW', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Priora', 2, 3, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Dodge', 3, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Mersedes', 2, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('AUDI', 2, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('KIA', 1, null, 1);
insert into cars(name, body_id, engine_id, transmission_id) values(null, null, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('LI1', null, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('VW', null, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Ferrari', null, 2, null);
insert into cars(name, body_id, engine_id, transmission_id) values('Jeep', null, 2, null);















	

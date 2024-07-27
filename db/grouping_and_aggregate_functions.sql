create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values('Device1', 4678.50);
insert into devices(name, price) values('Device2', 8953.50);
insert into devices(name, price) values('Device3', 2345.50);

insert into people(name) values('Вася');
insert into people(name) values('Аня');
insert into people(name) values('Андрей');

insert into devices_people(device_id, people_id) values(3, 1), (1, 1), (2, 1);
insert into devices_people(device_id, people_id) values(2, 2), (1, 2);
insert into devices_people(device_id, people_id) values(1, 3), (3, 3);

select avg(price) from devices;

select p.name, avg(d.price) 
from people as p join devices_people as dp on p.id = dp.people_id
join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) 
from people as p join devices_people as dp on p.id = dp.people_id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;


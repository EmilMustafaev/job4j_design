create table publisher(
	id serial primary key,
	name text
);

create table books(
	id serial primary key,
	name text,
	publisher_id int references publisher(id)
);

insert into publisher(name) values('Издатель 1');
insert into publisher(name) values('Издатель 2');
insert into publisher(name) values('Издатель 3');

insert into books(name, publisher_id) values('Книга1', 2);
insert into books(name, publisher_id) values('Книга2', 1);
insert into books(name, publisher_id) values('Книга3', 3);
insert into books(name) values('Книга4');
insert into books(name) values('Книга5');

select bk.name, pl.name 
from books as bk join publisher as pl on bk.publisher_id = pl.id;

select bk.name Книга, pl.name Издательство
from books as bk join publisher as pl on bk.publisher_id = pl.id;

select bk.name as "Название книги", pl.name Издательство
from books as bk join publisher as pl on bk.publisher_id = pl.id;






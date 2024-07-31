create table books(
	id serial primary key,
	name text,
	publisher text,
	pages int
);

insert into books (name, publisher, pages) values('Book1', 'Publisher1', 1000);
insert into books (name, publisher, pages) values('Book2', 'Pulisher2', 250);
insert into books (name, publisher, pages) values('Book3', 'Pulisher3', 390);
insert into books (name, publisher, pages) values('Book4', 'Pulisher4', 458);
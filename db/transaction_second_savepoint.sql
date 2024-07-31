--transaction 2
begin transaction;
insert into books (name, publisher, pages) values('Book6', 'Pulisher6', 689);
insert into books (name, publisher, pages) values('Book7', 'Pulisher7', 279);
savepoint second_savepoint;
delete from books where name = 'Book1';
update books set pages = 111 where name = 'Book7';
rollback to second_savepoint;
select * from books;
release savepoint second_savepoint;

commit;






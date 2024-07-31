--transaction 1
begin transaction;
insert into books (name, publisher, pages) values('Book5', 'Pulisher5', 999);
select * from books;
savepoint first_savepoint;
delete from books where name = 'Book3'
select * from books;
rollback to first_savepoint;
select * from books;

commit;
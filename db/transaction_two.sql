--transaction 2
begin transaction isolation level serializable;
select sum(pages) from books;
update books set pages = 393 where name = 'Book4';
commit;
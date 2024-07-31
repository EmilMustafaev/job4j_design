--transaction 1
begin transaction isolation level serializable;
select sum(pages) from books;
update books set pages = 895 where name = 'Book2';
commit;

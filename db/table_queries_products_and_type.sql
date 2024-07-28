select from product where type_id = 1;

select from product where name like '%мороженое%';

select from product where expired_date > current_date;

select from product where price = (select max(price) from product);

select t.name , count(p.id) from product as p
join type as t on p.type_id = t.id
group by t.name;

select from product where type_id = 1 or type_id = 2;

select t.name , count(p.id) from product as p
join type as t on p.type_id = t.id
group by t.name
having count(p.id) < 10;

select name, type_id from product;

create or replace function calculate_tax_after_insert()
returns trigger as $$
begin
    update products
    set price = price * 1.10
    where id in (select id from products where id > (select max(id) from products) - (select count(*) from new_table));
    return null;
end;
$$ language plpgsql;

create trigger calculate_tax_after_insert_trigger
after insert 
	on products
referencing new table as
inserted 
for each statement
    execute procedure calculate_tax_after_insert();




create or replace function calculate_tax_before_insert()
returns trigger as $$
begin
    new.price := new.price * 1.10;
    return new;
end;
$$ language plpgsql;

create trigger calculate_tax_before_insert_trigger
before insert
on products
for each row
execute procedure calculate_tax_before_insert();
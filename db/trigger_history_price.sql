create or replace function log_price_change()
returns trigger as $$
begin
    insert into history_of_price(name, price, date)
    values (NEW.name, NEW.price, current_date);
    return new;
end;
$$ language plpgsql;

create trigger after_insert_product
after insert
on products
for each row
execute procedure log_price_change();
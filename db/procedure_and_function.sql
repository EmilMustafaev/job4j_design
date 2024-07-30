create
or replace procedure delete_data(u_id integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products
	where id = u_id;
    END
$$;

create
or replace function f_delete_data(u_id integer)
returns void
language 'plpgsql'
as $$
    BEGIN
        delete from products
	where id = u_id;
    END
$$;

create
or replace procedure delete_data_where_count_zero()
language 'plpgsql'
as $$
    BEGIN
        delete from products
	where count = 0;
    END
$$;

create
or replace function f_delete_data_where_count_zero()
returns void
language 'plpgsql'
as $$
    BEGIN
        delete from products
	where count = 0;
    END
$$;
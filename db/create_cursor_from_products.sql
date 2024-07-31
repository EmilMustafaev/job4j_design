BEGIN;
DECLARE
cursor_products_two scroll cursor for
select * from products;

MOVE LAST FROM cursor_products_two;

FETCH BACKWARD 5 FROM cursor_products_two;
FETCH BACKWARD 8 FROM cursor_products_two;
FETCH BACKWARD 5 FROM cursor_products_two;
FETCH PRIOR FROM cursor_products_two;

CLOSE cursor_products_two;

COMMIT;




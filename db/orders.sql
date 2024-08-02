CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders(amount, customer_id) VALUES(7390, 3);
INSERT INTO orders(amount, customer_id) VALUES(2653, 1);
INSERT INTO orders(amount, customer_id) VALUES(5432, 2);
INSERT INTO orders(amount, customer_id) VALUES(4145, 4);


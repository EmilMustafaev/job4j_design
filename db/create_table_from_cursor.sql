create table products
(
    id    serial primary key,
    name  varchar(50),
    count integer default 0,
    price integer
);
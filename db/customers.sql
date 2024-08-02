CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers(first_name, last_name, age, country) 
	 VALUES('Пупкин', 'Василий', 25, 'Россия');     
INSERT INTO customers(first_name, last_name, age, country) 
	VALUES('Смит', 'Джон', 38, 'США');
INSERT INTO customers(first_name, last_name, age, country) 
	VALUES('Штраус', 'Йохан', 17, 'Германия');
INSERT INTO customers(first_name, last_name, age, country) 
	VALUES('Роберто', 'Карлос', 53, 'Мексика');
INSERT INTO customers(first_name, last_name, age, country) 
	VALUES('Джонсон', 'Эллис', 22, 'Канада');
INSERT INTO customers(first_name, last_name, age, country) 
	VALUES('Браун', 'Боб', 76, 'Австралия');

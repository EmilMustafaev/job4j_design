insert into type(name) values('СЫР');
insert into type(name) values('МОЛОКО');
insert into type(name) values('КОЛБАСА');

insert into product(name, type_id, expired_date, price) 
	values('Сыр моцарелла', 1, '10.08.2026', 400.35);
insert into product(name, type_id, expired_date, price) 
	values('Копченная колбаса', 3, '18.03.2023', 704.57);
insert into product(name, type_id, expired_date, price) 
	values('Шоколадное молоко', 2, '04.09.2025', 334.12);
insert into product(name, type_id, expired_date, price) 
	values('Сыр моцарелла', 1, '13.01.2022', 547.89);
insert into product(name, type_id, expired_date, price) 
	values('Вареная колбаса', 3, '19.10.2027', 892.78);
insert into product(name, type_id, expired_date, price) 
	values('Мороженое', 2, '05.03.2021', 140.67);
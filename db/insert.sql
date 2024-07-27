insert into categories(name) values('Категория');
select * from categories;

insert into states(name) values('Статус заявки');
select * from states;

insert into users(name) values('Пользователь');
select * from users;

insert into roles(name, user_id) values('Роль', 1);
select * from roles;

insert into rules(name) values('Права роли');
select * from rules;

insert into items(name, user_id, categorie_id, state_id) values('Заявка', 1, 1, 1);
select * from items;

insert into comments(name, item_id) values('Комментарий', 1);
select * from comments;

insert into attachs(name, item_id) values('Приложенный файл', 1);
select * from attachs;

insert into roles_rules(role_id, rule_id) values(1, 1);
select * from roles_rules;
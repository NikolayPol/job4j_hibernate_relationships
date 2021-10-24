CREATE TABLE models (
    id SERIAL PRIMARY KEY,
    name TEXT,
    brand_id int not null references brands(id)
);

CREATE TABLE brands (
    id SERIAL PRIMARY KEY,
    name TEXT
);

insert into brands(name) values ('AUDI');

insert into models(name, brand_id) values ('AUDI Q7',1);
insert into models(name, brand_id) values ('AUDI S5',1);
insert into models(name, brand_id) values ('AUDI TT',1);


CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name TEXT
);
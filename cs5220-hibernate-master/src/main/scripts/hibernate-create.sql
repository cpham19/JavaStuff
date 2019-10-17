create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 100 );

create table employees (
    id              integer primary key,
    name            varchar(255),
    supervisor_id   integer references employees(id)
);

create table customers (
	id              integer primary key,
	name            varchar(255),
	address         varchar(255),
);

create table customer_phones (
	customer_id     integer references customers(id),
	phone			varchar(255),
	phone_order		integer,
);

create table accounts (
	id				integer primary key,
	balance			float,
	created_on		Date,
	owner_id		integer references customers(id),
);

--create table account_owners (
--	account_id		integer references accounts(id),
--	owner_id		integer references customers(id),
--);

insert into employees (id, name, supervisor_id) values (1, 'Sue', null);
insert into employees (id, name, supervisor_id) values (2, 'Joe', 1);
insert into employees (id, name, supervisor_id) values (3, 'Tom', 2);

insert into customers (id, name, address) values (1, 'Calvin', '123 Fake Street');
insert into customers (id, name, address) values (2, 'Paul', '1234 Fake Street');
insert into customers (id, name, address) values (3, 'Tom', '12345 Fake Street');

insert into customer_phones (customer_id, phone, phone_order) values (1, '(123) 123-4567', 1);
insert into customer_phones (customer_id, phone, phone_order) values (1, '(123) 456-4567', 0);
insert into customer_phones (customer_id, phone, phone_order) values (1, '(123) 864-4567', 2);
insert into customer_phones (customer_id, phone, phone_order) values (2, '(421) 543-4567', 0);
insert into customer_phones (customer_id, phone, phone_order) values (3, '(543) 532-4537', 0);

insert into accounts (id, balance, created_on, owner_id) values (1, 2.54, '2014-02-15', 1);
insert into accounts (id, balance, created_on, owner_id) values (2, 122.54, '2013-01-17', 2);
insert into accounts (id, balance, created_on, owner_id) values (3, 2225.54, '2012-05-20', 3);
insert into accounts (id, balance, created_on, owner_id) values (4, 14442.54, '2014-02-17', 1);

--insert into account_owners (account_id, owner_id) values (1, 1);
--insert into account_owners (account_id, owner_id) values (2, 2);
--insert into account_owners (account_id, owner_id) values (3, 3);

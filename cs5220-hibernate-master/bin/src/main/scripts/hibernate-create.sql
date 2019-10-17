create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 100 );

create table employees (
    id              integer primary key,
    name            varchar(255),
    supervisor_id   integer references employees(id)
);

insert into employees (id, name, supervisor_id) values (1, 'Sue', null);
insert into employees (id, name, supervisor_id) values (2, 'Joe', 1);
insert into employees (id, name, supervisor_id) values (3, 'Tom', 2);

create table hibernate_sequence (
    next_val    bigint
);

insert into hibernate_sequence values ( 100 );

create table users (
    id          integer primary key,
    username    varchar(255) unique,
    password    varchar(255),
    enabled     BIT not null default 1
);

-- {noop} tells Spring Security that the password is not encrypted.
insert into users values (1, 'admin', '{noop}1234', 1);
insert into users values (2, 'cysun', '{noop}abcd', 1);

create table authorities (
    username    varchar(255) not null references users(username),
    authority   varchar(255)
);

insert into authorities values('admin', 'ADMIN');

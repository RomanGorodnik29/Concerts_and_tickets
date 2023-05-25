CREATE TABLE credentials
(
    id       bigint auto_increment,
    email    varchar(49)  not null unique,
    password varchar(255) not null,
    primary key (id)
);
CREATE TABLE locations
(
    id       bigint       not null,
    title    varchar(50)  not null,
    address  varchar(255) not null,
    capacity int      not null,
    primary key (id)
);

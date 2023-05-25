CREATE TABLE users
(
    id             bigint auto_increment,
    credentials_id bigint,
    phone_number   varchar(15)  not null,
    firstname      varchar(100) null,
    surname        varchar(100),
    PRIMARY KEY (id),
    foreign key (credentials_id) references credentials (id)
);
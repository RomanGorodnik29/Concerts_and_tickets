CREATE TABLE roles
(
    id        bigint auto_increment,
    role_name varchar(20) NOT NULL unique,
    PRIMARY KEY (id)
);


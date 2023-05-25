CREATE TABLE artists
(
    users_id    bigint       NOT NULL,
    nickname    varchar(40)  NOT NULL,
    avatar      varchar(255) NOT NULL,
    id          bigint       NOT NULL,
    short_quote varchar(60)  not null,
    long_quote  varchar(255) not null,
    PRIMARY KEY (id),
    foreign key (users_id) references users (id)
);
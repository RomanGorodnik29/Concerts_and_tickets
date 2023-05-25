CREATE TABLE artists_genres
(
    id         bigint not null,
    artists_id bigint NOT NULL,
    genres_id  bigint NOT NULL,
    primary key (id),
    foreign key (artists_id) references artists (id),
    foreign key (genres_id) references genres (id)
);

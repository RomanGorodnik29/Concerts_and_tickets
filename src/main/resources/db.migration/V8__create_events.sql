CREATE TABLE events
(
    id              bigint       NOT NULL,
    title           varchar(255) not null,
    artists_id      bigint DEFAULT NULL,
    locations_id    bigint DEFAULT NULL,
    descriptions     text         NOT NULL,
    occupied_places int      NOT NULL,
    age_limit       int      NOT NULL,
    dates            date         NOT NULL,
    continuance     TIME         NOT NULL,
    price           int      NOT NULL,
    PRIMARY KEY (id),
    foreign key (artists_id) references artists (id),
    foreign key (locations_id) references locations (id)
);


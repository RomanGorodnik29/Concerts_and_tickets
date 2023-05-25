create table user_roles
(
    cred_id bigint not null,
    role_id bigint not null,
    foreign key (cred_id) references credentials (id),
    foreign key (role_id) references roles (id)
);

insert into user_roles
values (1, 2)
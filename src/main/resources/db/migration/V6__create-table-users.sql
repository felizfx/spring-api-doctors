create table users(

    id serial not null,
    login varchar(80) not null,
    password varchar(255) not null,

    primary key(id)

);
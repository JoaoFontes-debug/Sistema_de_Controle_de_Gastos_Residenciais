
create table if not exists person (
     id bigint auto_increment primary key,
     name varchar(50) not null,
     email varchar(50) not null,
     password varchar(50) not null,
     age varchar(10) not null,
     role varchar not null
);



create table if not exists transactions (
    id bigint auto_increment primary key,
    description varchar(180) not null,
    amount decimal(10,2) not null,
    type varchar(50),
    person_id bigint not null,
    constraint transactions_person foreign key (person_id) references person(id)

);
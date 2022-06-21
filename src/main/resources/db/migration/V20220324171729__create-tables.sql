create table answer
(
    id             bigserial not null,
    correct_answer varchar(255),
    question_id    int8,
    primary key (id)
);
create table answers_list
(
    id      int8 not null,
    answers varchar(255)
);
create table question
(
    id       bigserial not null,
    question varchar(255),
    type     varchar(255),
    user_id  int8,
    primary key (id)
);
create table statistic
(
    id          bigserial not null,
    is_answered boolean   not null,
    question_id int8,
    user_id     int8,
    primary key (id)
);
create table system_user
(
    id       bigserial not null,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    role     varchar(255),
    surname  varchar(255),
    primary key (id)
);
alter table answer
    add constraint FK8frr4bcabmmeyyu60qt7iiblo foreign key (question_id) references question;
alter table answers_list
    add constraint FKpu4dypr7irsqcl8qb7wcyhovw foreign key (id) references answer;
alter table question
    add constraint FKm3m8i4cjgcdktywm6w8iqgch3 foreign key (user_id) references system_user;
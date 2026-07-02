create database MyDataBase;
use MyDataBase;
Create table Course
(
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);
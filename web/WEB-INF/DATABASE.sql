SQL>
drop table person;

Table dropped.
    SQL
>
create sequence person_seq start with 1 increment by 1;

Sequence
created.

SQL>
create table person
(
    id     number,
    name   varchar2(20),
    family varchar2(20),
    salary number
);

Table created.
    SQL
>

create schema if not exists student;
use student;

create table if not exists student (
	student_id int not null auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);

create table if not exists course (

	id int not null auto_increment primary key,
	student_id int not null,
    name varchar(50) not null,
    score int
);
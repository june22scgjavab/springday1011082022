drop database if exists customerpassport_db;
create database customerpassport_db;
use  customerpassport_db;

create table passport(
id int primary key,
date_of_issue date,
date_of_expiry date
);

insert into passport(id,date_of_issue,date_of_expiry) VALUES(1111,'2000-10-12','2010-10-12');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(2222,'2001-09-13','2011-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(3333,'2005-10-23','2015-10-23');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(4444,'2001-09-13','2011-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(5555,'2006-05-06','2016-05-06');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(6666,'1981-09-13','1991-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(7777,'1998-09-13','2008-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(8888,'2020-09-13','2030-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(9999,'2020-09-13','2030-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(9111,'2020-09-13','2030-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(9222,'2020-09-13','2030-09-13');
insert into passport(id,date_of_issue,date_of_expiry) VALUES(9333,'2020-09-13','2030-09-13');






create table customer(
   customer_id int auto_increment,
   email_id varchar(50),
   name varchar(20),
   date_of_birth date,
    passport_id int,
    constraint ps_customer_id_pk primary key (customer_id),
    constraint ps_passport_id_fk foreign key(passport_id) references passport(id)
);


insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (1, 'martin@infy.com', 'Martin', '1980-10-21',1111);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (2, 'tim@infy.com', 'Tim', '1985-11-23',2222);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (3, 'jack@infy.com', 'Jack', '1978-06-23',3333);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (4, 'sunita@infy.com', 'Sunita', '1978-06-23',4444);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (5, 'abhay@infy.com', 'Abhay', '1980-10-21',5555);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (6, 'suresh@infy.com', 'Suresh', '1978-06-23',6666);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (7, 'radha@infy.com', 'Radha',  '1985-11-23',7777);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (8, 'sohail@infy.com', 'Sohail', '1980-10-21',8888);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (9, 'sunita02@infy.com', 'Sunita', '1980-07-13',9999);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (10, 'jack02@infy.com', 'Jack', '1974-12-16',9111);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (11, 'sunita03@infy.com', 'Sunita', '1999-05-23',9222);
insert into customer (customer_id, email_id, name, date_of_birth,passport_id) values (12, 'sunita04@infy.com', 'Sunita', '2000-10-13',9333);
commit;
select * from customer;
select * from passport;
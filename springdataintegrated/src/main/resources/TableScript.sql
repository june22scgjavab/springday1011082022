drop database if exists customerpassport_db;
create database customerpassport_db;
use  customerpassport_db;


create table customer(
   customer_id int,
   email_id varchar(50),
   name varchar(20),
   date_of_birth date,
   constraint ps_customer_id_pk primary key (customer_id)
);


insert into customer (customer_id, email_id, name, date_of_birth) values (1, 'martin@infy.com', 'Martin', '1980-10-21');
insert into customer (customer_id, email_id, name, date_of_birth) values (2, 'tim@infy.com', 'Tim', '1985-11-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (3, 'jack@infy.com', 'Jack', '1978-06-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (4, 'sunita@infy.com', 'Sunita', '1978-06-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (5, 'abhay@infy.com', 'Abhay', '1980-10-21');
insert into customer (customer_id, email_id, name, date_of_birth) values (6, 'suresh@infy.com', 'Suresh', '1978-06-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (7, 'radha@infy.com', 'Radha',  '1985-11-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (8, 'sohail@infy.com', 'Sohail', '1980-10-21');
insert into customer (customer_id, email_id, name, date_of_birth) values (9, 'sunita02@infy.com', 'Sunita', '1980-07-13');
insert into customer (customer_id, email_id, name, date_of_birth) values (10, 'jack02@infy.com', 'Jack', '1974-12-16');
insert into customer (customer_id, email_id, name, date_of_birth) values (11, 'sunita03@infy.com', 'Sunita', '1999-05-23');
insert into customer (customer_id, email_id, name, date_of_birth) values (12, 'sunita04@infy.com', 'Sunita', '2000-10-13');
commit;
select * from customer;
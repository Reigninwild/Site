-- create database script
   
drop database if exists reigninwild;
   
-- create database  FootballManager
create database reigninwild; 
   
use reigninwild;                  
create table users (
user_id int not null primary key AUTO_INCREMENT,
username varchar(20) not null unique,
password varchar (20) not null,
email varchar(30) not null unique,
user_group varchar (30) not null
);


create table news(
news_id int not null primary key AUTO_INCREMENT,
news_text varchar(10000),
news_title varchar(200),
news_text_ru varchar(10000),
news_date date not null,
news_author int,
constraint fk_news_author foreign key (news_author) references users(user_id) on delete cascade
);


create table emails(
email_id int not null primary key AUTO_INCREMENT,
email varchar(30) unique
);

create table media(
media_id int not null primary key AUTO_INCREMENT,
url varchar(200),
description varchar(100)б
type varchar(1)
);

  insert into users (user_id,username,password,email,user_group) values (1,'administrator','20142014','reigninwild@gmail.com','ROLE_ADMIN');

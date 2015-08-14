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
   
   
create table materials(
material_id int not null primary key AUTO_INCREMENT,
material_type varchar(20),
material_desc varchar(200),
marerial_name varchar(30) not null,
material_pic varchar(100)
);

create table crafts(
craft_id int not null primary key AUTO_INCREMENT,
item_id int not null,
material_id int not null,
material_count int,
item_desc varchar(200),
constraint fk_item_id foreign key (item_id) references materials(material_id) on delete cascade,
constraint fk_material_id foreign key (material_id) references materials(material_id) on delete cascade
);

create table news(
news_id int not null primary key AUTO_INCREMENT,
news_text varchar(10000),
news_date date not null,
news_author int,
constraint fk_news_author foreign key (news_author) references users(user_id) on delete cascade
);


create table guides(
guide_id int not null primary key AUTO_INCREMENT,
guide_text varchar(1000),
guide_date date not null,
guide_author int,
constraint fk_news_author2 foreign key (guide_author) references users(user_id) on delete cascade
);


  insert into users (user_id,username,password,email,user_group) values (1,'administrator','20142014','reigninwild@gmail.com','ROLE_ADMIN');

 
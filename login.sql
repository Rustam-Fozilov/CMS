create database cms;
use cms;

create table admins (
	adminId int not null auto_increment,
    username varchar(255),
    password varchar(255),
    primary key(adminId)
);

insert into admins(username, password)
value ('admin', 'admin');
create database cms;
use cms;


select * from admins;
select * from users;
select * from teachers;
select * from courses;


create table admins(
	AdminId int not null auto_increment,
    Ismi varchar(255),
    Familiyasi varchar(255),
    Telefon varchar(255),
    Email varchar(255),
    username varchar(255),
    parol varchar(255),
    primary key (AdminId)
);

truncate table admins;

create table users(
	UserId int not null auto_increment,
	Ismi varchar(255),
    Familiyasi varchar(255),
    Telefon varchar(255),
    Email varchar(255),
    Fani varchar(255),
    Guruhi varchar(255),
    primary key(UserId)
);


create table teachers(
	TeacherId int not null auto_increment,
	Ismi varchar(255),
    Familiyasi varchar(255),
    Telefon varchar(255),
    Email varchar(255),
    Fani varchar(255),
	username varchar(255),
    parol varchar(255),
    primary key(TeacherId)
);


create table courses(
	CourseId int not null auto_increment,
    Nomi varchar(255),
    Davomiyligi varchar(255),
    Oqituvchi varchar(255),
    Narxi int,
    primary key(CourseId)
);


create table groupss(
	GroupId int not null auto_increment,
    primary key(GroupId)
); /* run qilinmagan */


insert into admins(Ismi, Familiyasi, Telefon, Email, username, parol)
values 	('Rustam', 'Fozilov', '+998977672097', 'rustamfozilov@gmail.com', 'Rustam19', 'RustamAdmin'),
		('Mohir', 'Mahmudov', '+998999020352', 'mohirmahmudov@gmail.com', 'Mohir19', 'MohirAdmin');
        

insert into users(Ismi, Familiyasi, Telefon, Email, Fani, Guruhi)
values 	('Akmal', 'Umarov', '+998904450022', 'akmalumarov@gmail.com', 'Matematika', '1 - guruh'),
		('Eldor', 'Sharipov', '+998991235476', 'eldorsharipov@gmail.com', 'Ingliz tili', '1 - guruh');



insert into teachers(Ismi, Familiyasi, Telefon, Email, Fani, username, parol)
values 	('Davron', 'Ergashev', '+998901237898', 'davronergashev@gmail.com', 'Matematika', 'Davronbek', 'DavronE98'),
		('Tohir', 'Hamidov', '+998993227899', 'tohirhamidov@gmail.com', 'Ingliz tili', 'Tohirbek', 'TohirH99');


insert into courses(Nomi, Davomiyligi, Oqituvchi, Narxi)
values 	('IELTS', '4 oy', 'Tohir Hamidov', 1000000),
		('Matematika', '12 oy', 'Davron Ergashev', 600000);











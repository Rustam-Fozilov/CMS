create database cms;
use cms;


select * from admins;
select * from users;
select * from teachers;
select * from courses;
select * from payments;
select * from attendance;


create table admins(
	AdminId int not null auto_increment,
    FIO varchar(255),
    Telefon varchar(255),
    username varchar(255),
    parol varchar(255),
    primary key (AdminId)
);

create table attendance(
	AttendanceId int not null auto_increment,
    FIO varchar(255),
    Fani varchar(255),
    Statusi varchar(255),
    Sana date,
    primary key (AttendanceId)
);


create table users(
	UserId int not null auto_increment,
	FIO varchar(255),
    Telefon varchar(255),
    Fani varchar(255),
    Guruhi varchar(255),
    primary key(UserId)
);


create table teachers(
	TeacherId int not null auto_increment,
	FIO varchar(255),
    Telefon varchar(255),
    Fani varchar(255),
    Guruhi varchar(255),
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

create table payments(
	PaymentId int not null auto_increment,
    FIO varchar(255),
    Fani varchar(255),
    Miqdori int,
    Oy varchar(255),
    Sana date,
    primary key(PaymentId)
);


insert into payments(FIO, Fani, Miqdori, Oy, Sana)
values 	('Akmal Umarov', 'IELTS', 200000, 'Mart', '2020-05-05');

insert into admins(FIO, Telefon, username, parol)
values 	('Rustam Fozilov', '+998977672097', 'Rustam19', 'RustamAdmin'),
		('Mohir Mahmudov', '+998999020352', 'Mohir19', 'MohirAdmin');


insert into users(FIO, Telefon, Fani, Guruhi)
values 	('Akmal Umarov', '+998904450022', 'Matematika', '1 - guruh'),
		('Eldor Sharipov', '+998991235476', 'Ingliz tili', '1 - guruh');



insert into teachers(FIO, Telefon, Fani, Guruhi, username, parol)
values 	('Davron Ergashev', '+998901237898', 'Matematika', '1 - guruh', 'Davronbek', 'DavronE98'),
		('Tohir Hamidov', '+998993227899', 'Ingliz tili', '1 - guruh', 'Tohirbek', 'TohirH99');


insert into courses(Nomi, Davomiyligi, Oqituvchi, Narxi)
values 	('IELTS', '4 oy', 'Tohir Hamidov', 1000000),
		('Matematika', '12 oy', 'Davron Ergashev', 600000);


insert into admins(username, parol)
values 	('1', '1');


insert into teachers(username, parol)
values 	('2', '2');





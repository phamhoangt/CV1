create database db_student;
use db_student;
create table Students(
	id Varchar(50),
    firstName varchar(100),
    secondName varchar(100),
    address varchar(255)
);
insert into Students values
("SV02", "Nguyễn Văn", "Mạnh", "Hưng Yên"),
("SV03", "Phạm Quốc", "Hoàng", "Hải Phòng"),
("SV04", "Dương Thị Mai", "Phương", "Thái Nguyên");
insert into db_student.Students values
("SV06", "Nguyễn Thanh", "Tùng", "Nam Định"),
("SV07", "Trương Hà Tấn", "Vũ", "Hà Nội")
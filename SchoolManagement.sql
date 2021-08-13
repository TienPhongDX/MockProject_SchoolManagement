create database SchoolManagement
go
use SchoolManagement
go
create table account(
account_id int primary key not null identity(1,1),
username varchar(255) not null,
password varchar(255) not null
)
go
create table role(
role_id int primary key not null identity(1,1),
role_name varchar(255) not null
)
go
create table account_role(
account_id int not null,
role_id int not null
constraint pk primary key (account_id,role_id),
constraint fk_account foreign key (account_id) references account(account_id),
constraint fk_role foreign key (role_id) references role(role_id)
)
go
create table Teacher (
	teacherID int primary key not null,
	name nvarchar(50) not null,
	birthday date not null,
	gender nvarchar(10) not null check (gender = N'Nam' or gender = N'Nữ'),
	[address] nvarchar(100) not null,
	phone varchar(10) not null,
	subjectID int not null,
	salary float not null,
	photo text not null
)
go
create table Student (
	studentID int primary key not null,
	name nvarchar(50) not null,
	birthday date not null,
	gender nvarchar(10) not null check (gender = N'Nam' or gender = N'Nữ'),
	[address] nvarchar(100) not null,
	phone varchar(10) not null,
	class_studying int,
	photo text not null
)
go
create table Class (
	classID int identity(1,1) primary key not null,
	gradeID int not null,
	className varchar(10) not null,
	teacherCnID int not null,
	size int check (size>0) not null,
	startYear int not null
)
go
create table Grade (
	gradeID int primary key not null
)
go
create table [Day] (
	dayID int primary key not null
)
go
create table [Subject] (
	subjectID int identity(1,1) primary key not null,
	subjectName nvarchar(50) not null
)
go
create table Period (
	periodID int primary key not null
)
go
create table Timetable (
	classID int not null,
	dayID int not null,
	periodID int not null,
	teacherID int not null,
	constraint PK_Timetable primary key (classID, dayID, periodID)
)
go
create table StartYear (
	startYear int primary key not null
)
go
create table Mark (
	studentID int not null,
	subjectID int not null,
	classID int not null,
	semester int not null,
	hs1 float check (hs1 between 0 and 10) not null,
	hs2 float check (hs2 between 0 and 10) not null,
	hs3 float check (hs3 between 0 and 10) not null,
	total float not null,
	constraint PK_Mark primary key (studentID, subjectID, classID, semester)
)
go
create table Report (
	studentID int not null,
	classID int not null,
	result nvarchar(10) not null check (result = N'Giỏi' or result = N'Khá' or result = N'TB' or result = N'Yếu'),
	comment ntext,
	constraint PK_Report primary key (studentID, classID)
)
go
create table Semester (
	semester int primary key not null
)
go
create table News (
	newsID int identity(1,1) primary key not null,
	title nvarchar(100) not null,
	thumbnail text not null,
	content ntext not null,
	createdDate date not null
)
go
alter table account
add unique(username)
go
alter table Teacher
add foreign key (teacherID) references Account(account_id)
go
alter table Teacher
add foreign key (subjectID) references [Subject](subjectID)
go
alter table Student
add foreign key (studentID) references Account(account_id)
go
alter table Student
add foreign key (class_studying) references Class(classID)
go
alter table Class
add foreign key (gradeID) references Grade(gradeID)
go
alter table Class
add foreign key (teacherCnID) references Teacher(teacherID)
go
alter table Class
add foreign key (startYear) references StartYear(startYear)
go
alter table Timetable
add foreign key (classID) references Class(classID)
go
alter table Timetable
add foreign key (dayID) references [Day](dayID)
go
alter table Timetable
add foreign key (periodID) references Period(periodID)
go
alter table Timetable
add foreign key (teacherID) references Teacher(teacherID)
go
alter table Mark
add foreign key (studentID) references Student(studentID)
go
alter table Mark
add foreign key (subjectID) references [Subject](subjectID)
go
alter table Mark
add foreign key (classID) references Class(classID)
go
alter table Mark
add foreign key (semester) references Semester(semester)
go
alter table Report
add foreign key (studentID) references Student(studentID)
go
alter table Report
add foreign key (classID) references Class(classID)
go
insert into Grade (gradeID) values (6), (7), (8), (9)
go
insert into [Day] (dayID) values (2), (3), (4), (5), (6), (7)
go
insert into [Subject](subjectName) values (N'Toán'), (N'Ngữ văn'), (N'Vật lý'), (N'Sinh học'), (N'Lịch sử')
go
insert into Period(periodID) values (1), (2), (3), (4), (5), (6), (7), (8), (9), (10)
go
insert into StartYear(startYear) values (2021)
go
insert into Semester(semester) values (1), (2)
go
insert into [Role](role_name) values ('ROLE_ADMIN'), ('ROLE_TEACHER'), ('ROLE_STUDENT')
go
insert into Account(username, [password]) values ('phongnt49', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('huytd15', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('longph9', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('anhhlt2', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('hoangtn4', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'),
('bigdata', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('android', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('iot', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('java', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK'), ('python', '$2a$09$GtXba9SVh08S15KHghe7ieuY98G5Wbrnezb2B6XtOV2KzAT0FQeRK')
go
insert into Account_Role(account_id, role_id) values (1, 1), (2, 2), (3, 3), (4, 1), (5, 2), (6, 3), (7, 3), (8, 3), (9, 3), (10, 3)
go
insert into Teacher(teacherID, name, birthday, gender, [address], phone, subjectID, salary, photo) values
(2, N'Trần Đức Huy', '1/1/1990', N'Nam', N'123 ABC', '0123456789', 2, 12000000, 'https://images.unsplash.com/photo-1461800919507-79b16743b257?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80'), 
(5, N'Trần Nhật Hoàng', '12/31/1990', N'Nam', N'789 XYZ', '0987654321', 5, 21000000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS9DHf2qi7IjphLhWEaZ2dqr6WPFX-j2KQ2w&usqp=CAU')
go
insert into Class(gradeID, className, teacherCnID, size, startYear) values
(6, '6/1', 2, 3, 2021), (7, '7/1', 5, 3, 2021)
go
insert into Student(studentID, name, birthday, gender, [address], phone, class_studying, photo) values
(3, N'Phạm Huỳnh Long', '2/2/2015', N'Nam', N'456 MNO', '0456789231', 1, 'https://static.scientificamerican.com/sciam/cache/file/A77DFDA8-AC26-437C-89EE952536452F3D_source.jpg?w=590&h=800&3A03143B-80C0-4682-BC1170570B5C7389'),
(6, N'Lê Thị Big Data', '2/29/2016', N'Nữ', N'12/3 BigData', '0963852741', 1, 'https://files.ondemandhosting.info/imagecache/cropfit@w=250/data/www.youthforhumanrights.org/files/human-rights-listing/youth-for-human-rights-image-26-right-to-education_en.jpg?_=a5d1a04,%201x%20https://files.ondemandhosting.info/imagecache/cropfit@w=500/data/www.youthforhumanrights.org/files/human-rights-listing/youth-for-human-rights-image-26-right-to-education_en.jpg?_=a5d1a04%202x'),
(7, N'Phan Hồng Android', '9/11/2015', N'Nữ', N'8/9 Android', '0147258369', 1, 'https://i2.wp.com/media.globalnews.ca/videostatic/828/475/SophiaThumbnail.jpg?w=1040&quality=70&strip=all'),
(8, N'Trần Thừa Iot', '6/6/2014', N'Nam', N'10 Chợ Đồng Loan', '0258741369', 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOd1s2B9wiH40TkjVvfUAQWSUdJvtz9RMwSQ&usqp=CAU'),
(9, N'Võ Hoàng Java', '4/1/2014', N'Nữ', N'15 Python', '0753912486', 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8CYd5Zm5eHyMBDjoHncZxeYLhFvLLYsO2tw&usqp=CAU'),
(10, N'Na Diệu Python', '1/4/2014', N'Nữ', N'45 Java', '0256322156', 2, 'https://static.wikia.nocookie.net/thecreatureworldcc/images/0/07/Human.jpg/revision/latest?cb=20190620200732')
go
insert into Timetable(classID, dayID, periodID, teacherID) values
(1, 2, 1, 2), (1, 2, 2, 2), (1, 3, 6, 5), (1, 3, 7, 5),
(2, 2, 1, 5), (2, 2, 2, 5), (2, 3, 6, 2), (2, 3, 7, 2)
go
insert into Mark(studentID, subjectID, classID, semester, hs1, hs2, hs3, total) values
(3, 2, 1, 1, 5, 5, 5, 5), (3, 5, 1, 2, 6, 6, 6, 6),
(6, 2, 1, 1, 5, 5, 5, 5), (6, 5, 1, 2, 6, 6, 6, 6),
(7, 2, 1, 1, 5, 5, 5, 5), (7, 5, 1, 2, 6, 6, 6, 6), 
(8, 2, 2, 1, 5, 5, 5, 5), (8, 5, 2, 2, 6, 6, 6, 6), 
(9, 2, 2, 1, 5, 5, 5, 5), (9, 5, 2, 2, 6, 6, 6, 6), 
(10, 2, 2, 1, 10, 10, 10, 10), (10, 5, 2, 2, 10, 10, 10, 10)
go
insert into Report(studentID, classID, result, comment) values
(3, 1, N'TB', N'F'), (6, 1, N'TB', N'F'), (7, 1, N'TB', N'F'), (8, 2, N'TB', N'F'), (9, 2, N'TB', N'F'), (10, 2, N'Giỏi', N'Gkê')
go
insert into News(title, thumbnail, content, createdDate) values
(N'Tiêu đề không hề giật tít', 'https://blog.webico.vn/wp-content/uploads/2018/07/GIAT-TIT.jpg', N'Đây là một bài viết bình thường', '12/12/2020')

select * from Account
select * from [Role]
select * from account_role
select * from Teacher
select * from Student
select * from Class
select * from Grade
select * from [Day]
select * from [Subject]
select * from Period
select * from Timetable
select * from StartYear
select * from Mark
select * from Report
select * from Semester
select * from News



/*exec insert_teacher ('','','','','','','','','','')*/

create procedure insert_teacher(@username varchar(255), @password varchar(255), @name nvarchar(50), @birthday date, @gender nvarchar(10), @address nvarchar(100), @phone varchar(10), @subjectID int, @salary float, @photo text)
as begin
	insert into account(username, [password]) values (@username, @password);
	declare @id as int;
	select @id = (account_id) from Account where username = @username;
	insert into account_role(account_id, role_id) values (@id, 2);
	insert into Teacher(teacherID, name, birthday, gender, [address], phone, subjectID, salary, photo)
	values (@id, @name, @birthday, @gender, @address, @phone, @subjectID, @salary, @photo);
end

create procedure delete_teacher(@id int)
as begin
	delete from Teacher where teacherID = @id
	delete from account_role where account_id = @id
	delete from account where account_id = @id
end


drop database SchoolManagement
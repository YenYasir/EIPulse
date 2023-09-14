
use eipulse;

drop table EmployeeInfo;
drop table Emergency;
drop table Contact;
drop table EmployeePermission;
drop table Login;
drop table Permission;
drop table Employee;
drop table Dept;
drop table Title;

CREATE TABLE Dept(
DeptId		int not null AUTO_INCREMENT,
DeptName	nvarchar(30) not null,
DeptOffice	nvarchar(30)not null,
primary key (DeptId)
)AUTO_INCREMENT=100;

CREATE TABLE Title(
TitleId		int not null AUTO_INCREMENT,
TitleName	nvarchar(30) not null,
primary key (TitleId)
)AUTO_INCREMENT=100;

CREATE TABLE Employee(
EmpId		int not null AUTO_INCREMENT,
IdNumber	nvarchar(20) not null,
EmpName		nvarchar(20)not null,
Gender		nvarchar(10),
JobAge		double not null,
Birth		nvarchar(20)not null,
Photo		blob null,
primary key (EmpId)
)AUTO_INCREMENT=1000;

CREATE TABLE EmployeeInfo(
EmpId		int not null,
DeptId		int not null,
TitleId		int not null,
primary key (EmpId),
foreign key(EmpId) references Employee(EmpId),
foreign key(DeptId) references Dept(DeptId),
foreign key(TitleId) references Title(TitleId)
);

CREATE TABLE Contact(
EmpId		int not null,
Email		nvarchar(30)not null,
Phone		nvarchar(30) not null,
Tel		nvarchar(30) default null,
Address	nvarchar(30)not null,
primary key (EmpId),
foreign key(EmpId) references Employee(EmpId)
);

CREATE TABLE Emergency(
EmergencyId			 int not null AUTO_INCREMENT,
EmergencyName		 nvarchar(30)not null,
EmergencyPhone		 nvarchar(30)not null,
EmergencyRelationship	 nvarchar(30)not null,
EmpId	int not null,
primary key (EmergencyId),
foreign key(EmpId) references Employee(EmpId)
);


create table Permission(
PermissionId int  not null AUTO_INCREMENT,
Grade nvarchar(50) not null,
Info nvarchar(255) null,
primary key (PermissionId)
);



create table EmployeePermission(
EmpId int not null,
PermissionId int not null,
primary key (EmpId,PermissionId),
foreign key(EmpId) references Employee(EmpId),
foreign key(PermissionId) references Permission(PermissionId)
);


CREATE TABLE Login(
EmpId  int not null,
PassWord nvarchar(50)not null,
primary key (EmpId),
foreign key(EmpId) references Employee(EmpId)
);

INSERT INTO Dept(DeptName,DeptOffice)
VALUES('人事','就人事'),('行政','就行政'),('總務','就總務');

INSERT INTO Title(TitleName)
VALUES('工讀生'),('菜鳥'),('組長'),('經理');

INSERT INTO Permission(Grade,Info)
VALUES('新增員工','就是新增員工'),
('查詢員工','就是查詢員工'),
('編輯員工權限','111');

INSERT INTO Employee (IdNumber, EmpName, Gender,JobAge, Birth)
VALUES
('A123456789', '王小明', '男',4.5, '1990-01-01'),
('B987654321', '陳美麗', '女',3, '1985-05-15'),
('C456789012', '李大宇', '男',2, '1992-11-30'),
('D789012345', '林靜心', '女',1, '1988-07-20'),
('E234567890', '張文彬', '男',4, '1995-03-05'),
('F567890123', '黃美玲', '女',10, '1997-12-18'),
('G890123456', '劉小華', '男',12, '1987-09-02'),
('H123456789', '陳怡君', '女',11.5, '1994-06-10'),
('I345678901', '吳宏偉', '男',10.5, '1998-04-03'),
('J678901234', '許雅琪', '女',9.5, '1991-08-05');

INSERT INTO EmployeeInfo(EmpId,DeptId,TitleId)
VALUES(1000,100,103),
(1001,101,101),
(1002,100,100),
(1003,100,102),
(1004,100,100),
(1005,100,100),
(1006,100,101),
(1007,100,101),
(1008,101,103),
(1009,102,103);

INSERT INTO Emergency (EmergencyName, EmergencyPhone, EmergencyRelationship, EmpId)
VALUES
('張三', '091-111-1111', '父親', 1000),
('李四', '092-222-2222', '母親', 1001),
('王五', '093-333-3333', '兄弟', 1002),
('陳六', '094-444-4444', '姐妹', 1003),
('林七', '095-555-5555', '其他', 1004),
('吳八', '096-666-6666', '朋友', 1005),
('朱九', '097-777-7777', '父親', 1006),
('鄭十', '098-888-8888', '母親', 1007),
('郭十一', '099-999-9999', '兄弟', 1008),
('廖十二', '091-101-1010', '姐妹', 1009);


INSERT INTO Contact (EmpId,Phone, Tel, Address, Email)
VALUES
  (1000,'0912345678', '02-12345678', '台北市中山區', 'zhangsan@email.com'),
  (1001,'0987654321', NULL, '新北市板橋區', 'lisi@email.com'),
  (1002,'0912345678', '02-23456789', '台北市信義區', 'wangwu@email.com'),
  (1003,'0987654321', '02-34567890', '台北市大安區', 'zhaoliu@email.com'),
  (1004,'0912345678', '03-12345678', '桃園市中壢區', 'liuqi@email.com'),
  (1005,'0987654321', '03-23456789', '新竹市東區', 'chenba@email.com'),
  (1006,'0912345678', '04-12345678', '台中市西屯區', 'qianjiu@email.com'),
  (1007,'0987654321', '04-23456789', '台中市北區', 'sunti@email.com'),
  (1008,'0912345678', '05-12345678', '台南市東區', 'zhouyiyi@email.com'),
  (1009,'0987654321', '05-23456789', '台南市南區', 'wushi@email.com');
  
  

  
INSERT INTO Login (EmpId,PassWord) VALUES
(1000,'100'),
(1001,'950215'),
(1002,'880930'),
(1003,'920712'),
(1004,'850425'),
(1005,'981103'),
(1006,'910618'),
(1007,'970308'),
(1008,'871220'),
(1009,'941005');


INSERT INTO EmployeePermission(EmpId,PermissionId)
VALUES(1000,1),
(1000,3),
(1003,2),
(1008,1),
(1008,2),
(1009,1),
(1009,2)
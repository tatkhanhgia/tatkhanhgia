use quanlythianhvan;
create table thisinh(
	SBD varchar(10) not null ,
    ho nvarchar(20),
    ten nvarchar(10),
    gioitinh tinyint,
    ngaysinh DATE,
    noisinh nvarchar(20),
    cmnd varchar(15),
    ngaycap date,
    noicap nvarchar(20),
    sdt varchar(10),
    email varchar(30),
    phongthi varchar(10),
    khoathi varchar(10),
    primary key (SBD, khoathi)
);
create table phongthi(
	tenphong varchar(10) not null,
    khoathi varchar(10),
    primary key (tenphong,khoathi)
);
create table khoathi(
	tenkhoa varchar(10) not null primary key,
    ngaythi date 
);
alter table thisinh add foreign key (phongthi) references phongthi(tenphong);
alter table thisinh add foreign key (khoathi) references khoathi(tenkhoa);
alter table phongthi add foreign key (Khoathi) references khoathi(tenkhoa);

insert into khoathi values ('Khoa001','2021-11-10');
insert into khoathi values ('Khoa002','2021-12-10');
insert into khoathi values ('Khoa004','2022-02-10');
insert into phongthi values ('A2P01','Khoa001');
insert into phongthi values ('A2P02','Khoa001');
insert into phongthi values ('B1P03','Khoa001');
insert into phongthi values ('B1P04','Khoa001');
insert into phongthi values ('A2P01','Khoa002');
insert into phongthi values ('A2P02','Khoa002');
insert into phongthi values ('B1P03','Khoa002');
insert into phongthi values ('B1P04','Khoa002');
insert into phongthi values ('A2P01','Khoa004');
insert into phongthi values ('A2P02','Khoa004');
insert into phongthi values ('B1P03','Khoa004');
insert into phongthi values ('B1P04','Khoa004');
insert into `thisinh` values('A2001',N'Tất Khánh',N'Gia',1,'2000-07-09','TPHCM','079200011188','2017-07-06','TPHCM','0566477847','khanhgia07092000@gmail.com','A2P01','Khoa001');
insert into `thisinh` values('A2001',N'Tất Khánh',N'Gia',1,'2000-07-09','TPHCM','079200011188','2017-07-06','TPHCM','0566477847','khanhgia07092000@gmail.com','A2P01','Khoa002');
insert into `thisinh` values('A2002',N'Nguyễn Thị Huyền',N'Trang',0,'2002-01-09','TPHCM','079200011189','2017-07-06','Quảng Bình','0566477848','huyentrang@gmail.com','A2P02','Khoa001');
insert into `thisinh` values('B1001',N'Nguyễn Thị',N'Mai',0,'2001-11-29','TPHCM','079200011111','2017-07-06','Quảng Nam','0566817848','mainguyen@gmail.com','B1P03','Khoa001');
insert into `thisinh` values('B1002',N'Nguyễn Phương',N'Nam',1,'1999-01-09','TPHCM','079278911189','2017-07-06','TPHCM','0566027848','HELLO@gmail.com','B1P04','Khoa001');

select *
from thisinh
where thisinh.SBD like "A2%" and khoathi ="Khoa001";

select tenkhoa
from khoathi
where datediff(ngaythi,date(now()))>=0;

select tenphong, count(*)
from phongthi, thisinh
where tenphong = thisinh.phongthi and thisinh.khoathi = phongthi . khoathi and thisinh.khoathi ="Khoa001"
	and thisinh.SBD  like "A2%"
group by phongthi.tenphong
having count(*) <30;



delete from thisinh where SBD = 'B1003';

select * from khoathi;
select * from phongthi;
select * from thisinh;
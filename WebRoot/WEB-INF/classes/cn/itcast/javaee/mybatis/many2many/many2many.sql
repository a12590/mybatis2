--mysql

create table students(
	sid int(5) primary key,
	sname varchar(10)
);

create table courses(
	cid int(5) primary key,
	cname varchar(10)
);

create table middles(
	msid int(5),
	mcid int(5),
	primary key(msid,mcid)
);

insert into students(sid,sname) values(1,'込込');
insert into students(sid,sname) values(2,'最最');

insert into courses(cid,cname) values(1,'java');
insert into courses(cid,cname) values(2,'android');

insert into middles(msid,mcid) values(1,1);
insert into middles(msid,mcid) values(1,2);
insert into middles(msid,mcid) values(2,1);
insert into middles(msid,mcid) values(2,2);

select * from students;
select * from courses;
select * from middles;










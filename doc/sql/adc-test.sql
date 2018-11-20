create table SCORES(
sid varchar2(7),
sname varchar2(15),
score number(3)
)
create table TS_STUDENT(
id varchar2(7),
name varchar2(15),
xuehao number(5),
classes number (3)
)
insert into SCORES(sid,sname,score) values('123','王五',78);
insert into SCORES(sid,sname,score) values('124','张六',80);
insert into SCORES(sid,sname,score) values('125','马六',95);

insert into TS_STUDENT(id,name,xuehao,classes) values('123','王五',111,1);
insert into TS_STUDENT(id,name,xuehao,classes) values('124','张六',112,1);
insert into TS_STUDENT(id,name,xuehao,classes) values('125','马六',113,2);
 alter table  TS_STUDENT add constraint  pk_stuid  primary key(id)
alter table SCORES add constraint fk_sidandid foreign key(sid) references TS_STUDENT(id)
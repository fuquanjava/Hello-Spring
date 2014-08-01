DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
    id int(32) NOT NULL auto_increment,
    email varchar(50) NOT NULL,
    name varchar(50) default NULL,
    password varchar(50) NOT NULL,
    lastLoginTime date ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table  t_dept;
create table t_dept(
  deptno int primary key,
  dname varchar(20),
  loc varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into t_dept values (10,'testing','beijing');
insert into t_dept values (20,'saling','shanghai');

DROP TABLE T_EMP;
CREATE TABLE T_EMP(
  ID INT PRIMARY KEY  AUTO_INCREMENT  ,
  NAME VARCHAR(20),
  JOB VARCHAR (20),
  HIREDATE DATE ,
  DEPTNO INT
);

INSERT  INTO  T_EMP (NAME ,JOB , HIREDATE , DEPTNO) VALUES ('zhangsanfeng' , 'manager' , null , 10);
INSERT  INTO  T_EMP (NAME ,JOB , HIREDATE , DEPTNO) VALUES ('lisi' , 'manager' , null , 20);
INSERT  INTO  T_EMP (NAME ,JOB , HIREDATE , DEPTNO) VALUES ('wangwu' , 'manager' , null , 30);
INSERT  INTO  T_EMP (NAME ,JOB , HIREDATE , DEPTNO) VALUES ('hello' , 'manager' , null , 10);
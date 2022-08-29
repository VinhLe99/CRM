CREATE DATABASE IF NOT EXISTS crm;

USE crm;

create table role(
	id int auto_increment,
    role_name varchar(55),    
    primary key(id)
);

CREATE TABLE IF NOT EXISTS user (
	id int auto_increment,
    fullname varchar(100) not null,
    email varchar(100) not null,
    password varchar(30) not null,
    phone varchar(20),
    address varchar(255),
    avatar varchar(255),
    role_id int,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS project (
	id int auto_increment,
    name varchar(255) not null,
    description varchar(255),
    start_date	date,
    end_date date,
    owner int,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS project_user (
	project_id		int,
    user_id			int,
    join_date		date,
    role_description varchar(255),
    primary key(project_id, user_id)
);

CREATE TABLE IF NOT EXISTS status(
	id int auto_increment,
	name varchar(40) not null,
    description varchar(255),
    primary key(id)    
);

CREATE TABLE IF NOT EXISTS task (
	id int auto_increment,
    task_name varchar(100) not null,
    description varchar(255),
	start_date date,
    end_date date,
    project_id int,
    user_id	int,
    status enum("1","2"),
    primary key(id)
);

ALTER TABLE user
	ADD CONSTRAINT FK_USER_ROLE
		FOREIGN KEY (role_id) REFERENCES role(id); 
        
ALTER TABLE project
	ADD CONSTRAINT FK_PROJECT_USER_OWNER
		FOREIGN KEY (owner) REFERENCES user(id); 
	
ALTER TABLE project_user
	ADD CONSTRAINT FK_PROJECT_USER_PROJECT_USER_LIST
		FOREIGN KEY (project_id) REFERENCES project(id),
	ADD CONSTRAINT FK_PROJECT_USER_USER_JOIN_LIST
		FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE task
	ADD CONSTRAINT FK_TASK_USER
		FOREIGN KEY (user_id) REFERENCES user(id),
	ADD CONSTRAINT FK_TASK_PROJECT
		FOREIGN KEY (project_id) REFERENCES project(id);
        
INSERT INTO role (role_name)
VALUES ('ROLE_ADMIN');
INSERT INTO role (role_name)
VALUES ('ROLE_LEADER');
INSERT INTO role (role_name)
VALUES ('ROLE_MEMBER');

INSERT INTO user (fullname,email,password,phone,address,avatar,role_id)
VALUES ('Admin','admin@gmail.com','admin123','+84 123456789','Can Giuoc - Long An','','1');

INSERT INTO user (fullname,email,password,phone,address,avatar,role_id)
VALUES ('Nguyen Van A','nguyenvana@gmail.com','admin456','+84 123456789','Ba Ria - Vung Tau','','2');

INSERT INTO user (fullname,email,password,phone,address,avatar,role_id)
VALUES ('Le Thanh B','lethanhb@gmail.com','admin789','+84 258664299','Quan 1 - HoChiMinh City','','3');

INSERT INTO status(name) 
VALUES ('Finish');
INSERT INTO status(name) 
VALUES ('Unfinish');

INSERT INTO project (name,description,start_date,end_date,owner)
VALUES ('Nhóm việc 1','Dự án CRM Quản lý công việc','2019-5-12','2019/11/3',1);
INSERT INTO project (name,description,start_date,end_date,owner)
VALUES ('Nhóm việc 2','Dự án CRM Quản lý công việc','2019-5-12','2019/11/3',1);
INSERT INTO project (name,description,start_date,end_date,owner)
VALUES ('Nhóm việc 3','Dự án CRM Quản lý công việc','2019-5-12','2019/11/3',1);

INSERT INTO task (task_name,description,start_date,end_date,project_id,user_id,status)
VALUES ('Kết nối Database','Kết nối Project với Database thông qua docker và mysql workbench','2019-5-12','2019-11-3',1,1,'2');

INSERT INTO task (task_name,description,start_date,end_date,project_id,user_id,status)
VALUES ('Tạo các models','Tạo các model ánh xạ database','2019-5-12','2019-11-3',2,1,'2');

INSERT INTO task (task_name,description,start_date,project_id,user_id,status)
VALUES ('Tạo các models 2','Tạo các model ánh xạ database','2019-5-12',2,1,'2');

INSERT INTO task (task_name,description,start_date,end_date,project_id,user_id,status)
VALUES ('Kết nối Database 2','Kết nối Project với Database thông qua docker và mysql workbench','2019-5-12','2019-11-3',1,1,'2');

INSERT INTO task (task_name,description,start_date,end_date,project_id,user_id,status)
VALUES ('Tạo các models 3','Tạo các model ánh xạ database','2019-5-12','2019-11-3',2,1,'2');

INSERT INTO task (task_name,description,start_date,project_id,user_id,status)
VALUES ('Tạo các models 4','Tạo các model ánh xạ database','2019-5-12',2,3,'2');

select task_name, description, status, u.fullname
from task t
left join user u
on u.id=t.user_id
where project_id=1



















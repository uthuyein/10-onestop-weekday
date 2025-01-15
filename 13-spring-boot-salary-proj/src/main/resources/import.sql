insert into department_tbl(name,active)values('IT',true)
insert into department_tbl(name,active)values('Sales',true)
insert into department_tbl(name,active)values('Accountant',true)

insert into employee_tbl(name,dob,department_id,active)values('Andrew','2001-02-11',1,1);
insert into employee_tbl(name,dob,department_id,active)values('William','1998-05-03',1,1);
insert into employee_tbl(name,dob,department_id,active)values('John','2000-11-13',1,1);
insert into employee_tbl(name,dob,department_id,active)values('Snowei','2001-09-21',2,1);
insert into employee_tbl(name,dob,department_id,active)values('Susan','1999-09-22',3,1);
insert into employee_tbl(name,dob,department_id,active)values('Samlew','1990-10-23',3,1);

insert into salary_tbl(amount,bonus,position,employee_id)values (250000,20000,'Casual',1);
insert into salary_tbl(amount,bonus,position,employee_id)values (400000,50000,'Senior',3);
insert into salary_tbl(amount,bonus,position,employee_id)values (300000,20000,'Permanent',6);
insert into salary_tbl(amount,bonus,position,employee_id)values (500000,50000,'Manager',6);
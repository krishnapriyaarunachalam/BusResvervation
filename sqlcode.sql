CREATE DATABASE jdbcproj;
USE jdbcproj;

CREATE TABLE details (
    emp_id INT PRIMARY KEY,
    ename VARCHAR(30),
    salary INT
);

INSERT INTO details VALUES (1, "ram", 10000);
INSERT INTO details VALUES (2, "sri", 20000);
INSERT INTO details VALUES (3, "arun", 3000);
SELECT * FROM details;
-- drop database jdbcproj;
delimiter $$
create procedure GetEmp()
begin
select * from details;
end$$
delimiter ;


delimiter $$
create procedure GetEmpByID(IN id int)
begin
select * from details where emp_id=id;
end$$
delimiter ;

delimiter $$
create procedure GetNameById(IN id int,out empname varchar(40))
begin
select ename from details where emp_id=id into empname ;
end$$
delimiter ;


use mydb;

-- To create Student table
CREATE TABLE student (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         lname VARCHAR(20),
                         fname VARCHAR(20),
                         score INT
)


-- To insert data into Student table

insert into student(fname,lname,score)values ('Elon','Musk',100);
insert into student(fname,lname,score)values ('Bill','Gates',80);
insert into student(fname,lname,score)values ('Warren','Buffet',90);
insert into student(fname,lname,score)values ('Tony','Robins',70);
insert into student(fname,lname,score)values ('Jay','Shetty',60);
insert into student(fname,lname,score)values ('Robin','Sharma',50);

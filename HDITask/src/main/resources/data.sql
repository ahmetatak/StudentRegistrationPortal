

/* Department data */
INSERT INTO DEPARTMENT (department_name) 
VALUES ( 'Computer Engineering');
INSERT INTO DEPARTMENT (department_name) 
VALUES ( 'Software Engineering');
INSERT INTO DEPARTMENT ( department_name) 
VALUES ( 'Mechanical Engineering');
 
/* Student data */
INSERT INTO STUDENT (student_name,student_surname,student_email,student_password,department_id) 
VALUES ( 'Ahmet','Atak','ahmet@ahmet.com','123456',1);
INSERT INTO STUDENT ( student_name,student_surname,student_email,student_password,department_id) 
VALUES ( 'Aynur','Duran','aynur@duran.com','123456',1);
INSERT INTO STUDENT ( student_name,student_surname,student_email,student_password,department_id) 
VALUES ( 'Ayşey','çelik','Ayşe@celik.com','123456',3);
INSERT INTO STUDENT ( student_name,student_surname,student_email,student_password,department_id) 
VALUES ( 'Ali','Veli','ali@veli.com','123456',2);
/* Department data */

INSERT INTO COURSE  (course_code,course_name,course_quota)
VALUES ('MATH101','Calculus |',2);

INSERT INTO COURSE  (course_code,course_name,course_quota)
VALUES ( 'MATH112','Calculus ||',1);

INSERT INTO COURSE (course_code,course_name,course_quota) 
VALUES ( 'MATH113','Differential Equations',3);

INSERT INTO COURSE (course_code,course_name,course_quota) 
VALUES ( 'COME101','Introduction to Computer Engineering',2);

INSERT INTO COURSE (course_code,course_name,course_quota) 
VALUES ( 'COME107','Java Programming',4);

/* COURSE_AVAILABLE data */
INSERT INTO COURSE_AVAILABLE (COURSE_ID) 
VALUES ( 1);

INSERT INTO COURSE_AVAILABLE (COURSE_ID) 
VALUES (3);

INSERT INTO COURSE_AVAILABLE (COURSE_ID) 
VALUES ( 3);

INSERT INTO COURSE_AVAILABLE (COURSE_ID) 
VALUES ( 2);

/* COURSE_SAVED data */

INSERT INTO COURSE_SELECTED (COURSE_ID,STUDENT_ID) 
VALUES ( 1,1);
INSERT INTO COURSE_SELECTED (COURSE_ID,STUDENT_ID) 
VALUES ( 1,3);
 

# StudentRegistrationPortal
Studetin registration rest api build in this application

##  Project Based on
Backend          | Database
------------- | -------------
Springboot  | H2 Database Engine
JPA (Java Persistence API)  | http://localhost:8080/h2-console

##  Run in Docker
project need to be build firstly

 ```diff
 
- Please make sure there is no an application run on 8080 port!
 
```

1. ```git clone https://github.com/ahmetatak/StudentRegistrationPortal.git``` 
2. ```ls``` 
3. ```cd StudentRegistrationPortal``` 
4. ```ls```  please make sure that HDITask folder is exist
5. ```cd HDITask``` 
6. ```mvn clean package``` 
7. ```cd ../``` back to up folder to build in docker.
8. ```ls```  please make sure that  Dockerfile is exist 
9. ```docker build --tag=hdi-task:latest .```  build the container in docker
10. ```docker run -p8080:8080 hdi-task:latest```  run in docker
11. after successfult run the container the project will be running on 8080 port number
12. http://localhost:8080

##  H2 Database monitorring
it runs on
```http://localhost:8080/h2-console``` 
Jdb Url
```jdbc:h2:mem:testdb``` 

##  Testing On Postman
Open postman File>import and select ```HDITask.postman_collection.json``` 

<img width="1658" alt="postnl" src="https://user-images.githubusercontent.com/3717312/184002176-d309a6ca-77ea-466c-afa5-457471f686ec.png">

##  Explanation Of APı URls

###  Explanation Of APı URls
main url http://localhost:8080;

####  A. Student Section
1. ```GET /v1/student``` 
it brings all student records in database. 

2. ```GET /v1/student/{student_id}``` 
get spesific student information via student id  

3. ```POST /v1/student``` 
create a new student requaired json body

4. ```PUT /v1/student``` 
update student requaired studentId in body
 
        "studentId": 2,
        "studentName": "Ahmet2",
        "studentSurname": "ATAK2",
        "studentEmail": "ahmet@ahmet.com",
        "studentPassword": "123456",
        "departmentId": 19999       

    
    
5. ```DELETE /v1/student/{student_id}```
delete the student via student id

####  B. Course Section
```courseQuota``` represent how many student can take this course.
 

1. ```GET  /v1/course``` 
it brings all course records in database. 

2. ```GET /v1/course/{course_id}``` 
get spesific course information via student id  

3. ```POST /v1/course``` 
create a new course requaired json body

4. ```PUT /v1/course/{courseId}``` 
update course requaired courseId in body

   
5. ```DELETE /v1/course/{courseId}```
delete the course via courseId

####  C. Available Courses Section

in this section, there is a table on database called COURSE_AVAILABLE it is spesified which course can be selected by students.

1. ```GET  /v1/course/available/``` 
it brings all course available records in database. 

 

2. ```POST /v1/course/available/``` 
create a new  course available requaired json body requaired courseId
{
courseId:4
}


 

   
3. ```DELETE /v1/course/available/{courseAvailableId}```
delete the  course available via courseId


####  D Selected Course Section

each selected course records saved on COURSE_SELECTED table in database. Only courses can be selected listed in Coursa Available section.


1. ```GET  /v1/course/selected/``` 
it brings all course selected by ALL Students in database. 

2. ```GET /v1/course/selected/{studentId}``` 
get  course  selected by spesific student  via studentId

3. ```POST /v1/course/selected/{studentId}``` 
create and select a new course is available in COURSES_AVAILABLE table
 
4. ```DELETE /v1/course/selected/{studentId}```
delete selected course in COURSE_SELECTED table courseId requaired in body section

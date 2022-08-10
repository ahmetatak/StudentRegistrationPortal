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
8. ```ls```  please make sure that HDITask Dockerfile is exist 
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

<img width="1658" alt="postnl" src="https://user-images.githubusercontent.com/3717312/183995663-dadac617-de7b-45f7-9372-1270380e8f8d.png">


##  Explanation Of APı URls

#  Explanation Of APı URls



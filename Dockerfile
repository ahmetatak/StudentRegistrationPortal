FROM amazoncorretto:11-alpine-jdk
MAINTAINER baeldung.com
COPY HDITask/target/HDI-0.0.1-SNAPSHOT.jar hdi-task-1.0.0.jar
ENTRYPOINT ["java","-jar","/hdi-task-1.0.0.jar"]
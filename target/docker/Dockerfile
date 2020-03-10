FROM openjdk:8-jdk-alpine 
VOLUME /tmp 
ENV DBIP=127.0.0.2
ENV DBNAME=TestDB
ADD springdemo-0.0.1-SNAPSHOT.jar app.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
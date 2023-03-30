FROM openjdk:11.0.9.1

MAINTAINER shreyanshjain

COPY target/jpa-intro-0.0.1-SNAPSHOT.jar jpa-intro-0.0.1.jar

ENTRYPOINT ["java","-jar","/jpa-intro-0.0.1.jar"]
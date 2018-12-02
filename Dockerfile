FROM openjdk:10-jre as builder
WORKDIR /usr/app
ARG JAR_FILE=build/libs/docker-app.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","application.jar"]



FROM openjdk:10-jre
ARG JAR_FILE
WORKDIR /usr/app
COPY ${JAR_FILE} docker-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app/docker-app.jar"]
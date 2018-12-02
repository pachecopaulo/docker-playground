# docker-playground

This is a PoC project intended to work with Docker and Kubernets.

### Stack
   * Kotlin
   * Spring Boot
   * Redis DB
   * NGINX
   * Docker
   * Gradle

### Gradle Tasks

Please note the ```./gradlew``` is a wrapper for the ```gradle``` command. If you're running on Windows you can use the ```gradlew.bat``` as a wrapper or the ```gradle``` command instead.


As part of the project configuration some Gradle tasks have been created

| Task                 |      Command            |
|--------------------  |-------------------------|
| Build docker images  | ./gradlew build docker  |
| Show linter errors   | ./gradlew lintKotlin    |
| Fix linter errors    | ./gradlew formatKotlin  |

## Docker Compose

The docker-compose has been defined to configure the multi docker images available in this project which are the **Redis** database and the application itself making possible the communication between containers.

## Running the application in the docker

**1)** ```./gradlew build``` - It's responsible to create the jar file that will be picked up by the docker build

**2)** ```docker-compose up --build``` - It's responsible to build the docker images and create a network for the containers

**3)** Once the app is up and running the application can be acessible via: http://localhost:8081/api/visits/counter where the port 8081 is configured to forward incoming traffic to port 8080 in the docker container which is the default Tomcat port used by Spring Boot

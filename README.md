# docker-playground

This is a PoC project intended to work with Docker and Kubernets.

### Stack
   * Kotlin
   * Spring Boot
   * Redis DB
   * NGINX
   * Docker
   * Gradle
   * Travis CI

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

**2)** ```docker-compose up --build``` - The docker-compose will be responsible to create 3 containers to be able to run this application
   
  * Redis database to be able to store the number of visits
   
  * The NGINX for reverse proxy
   
  * The application itself

**3)** Once the app is up and running the application can be acessible via: http://localhost/count where the NGINX will forward the incoming requests to the service name under the Rest endpoint to store the number visits.

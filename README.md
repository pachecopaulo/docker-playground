# docker-playground

This is a PoC project intended to work with Docker and Kubernets.

### Stack
   * Kotlin
   * Spring Boot
   * Redis
   * Docker
   * Gradle

### Gradle Tasks

As part of the project configuration some Gradle tasks have been created

| Task                 |      Command            |
|--------------------  |-------------------------|
| Build docker images  | ./gradlew build docker  |
| Show linter errors   | ./gradlew lintKotlin    |
| Fix linter errors    | ./gradlew formatKotlin  |

## Docker

The application requires an instance of Redis up and running on port **6379** so you can start a redis docker container using ```docker run -p 6379:6379 redis```

Next step is to build the docker image for the application using the gradle task ```./gradlew build docker```.

Once the gradle task is done you can launch the application thru Docker using: ```docker run -p 8080:8080 -t study/docker-app``` 

For now the application's image will be tagged as **latest**, so you can ommit the tag when running the docker image.

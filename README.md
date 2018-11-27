# docker-playground

This is a PoC project intended to work with Docker and Kubernets.

### Gradle Tasks

As part of the project configuration some Gradle tasks have been created

| Task                 |      Command            |
|--------------------  |-------------------------|
| Build docker images  | ./gradlew build docker  |
| Show linter errors   | ./gradlew lintKotlin    |
| Fix linter errors    | ./gradlew formatKotlin  |

## Running the Docker image
After building the docker image using the gradle task you can run the container using ```docker run -p 8080:8080 -t study/docker-app```. 

For now the image will be tagged as **latest**, so you can ommit the tag when running the docker image.

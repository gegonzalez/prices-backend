# Prices Backend

## Requirements

* [Java 11](https://www.oracle.com/java/technologies/downloads/#java11)
* [Gradle](https://gradle.org/)

## Recommended

* [SdkMan](https://sdkman.io/)

## Commands

- `./gradlew bootRun`: Run the Application
- `./gradlew test`: Run unit tests
- `./gradlew integrationTest`: Run integration tests

## How to use

- Run the command `./gradlew bootRun`
- Execute `curl localhost:8080/prices/1/35455/2020-12-31T23:59:59` in another console

There is an [Open API Specification](https://github.com/gegonzalez/prices-backend/blob/main/docs/openapi.yaml)

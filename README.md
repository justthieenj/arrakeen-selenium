# Arrakeen Selenium

## Introduction

This is a Selenium core library for my personal project using latest JDK LTS version.

## Requirements

- JDK 25
- Maven 3.9 or higher
- Gradle 9.4 or higher

## Dependencies

- selenium-java
- jackson-databind

## Build

### Gradle

- Windows: `gradlew.bat build`
- macOS/Linux: `./gradlew build`

### Maven

- Windows/macOS/Linux: `mvn clean package`

## Publish to local Maven repository

### Gradle

- Windows: `gradlew.bat publishToMavenLocal`
- macOS/Linux: `./gradlew publishToMavenLocal`

### Maven

- Windows/macOS/Linux: `mvn clean install`

## Projects using this library

- [dotafetchmatch](https://github.com/justthieenj/dotafetchmatch)
- [sample-arrakeen-selenium](https://github.com/justthieenj/sample-arrakeen-selenium)

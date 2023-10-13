FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ./target/rei-do-gado-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "/app/spring-app.jar"]

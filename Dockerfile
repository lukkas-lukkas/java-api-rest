# Start with a base image containing Java runtime and Maven
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

VOLUME /tmp

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

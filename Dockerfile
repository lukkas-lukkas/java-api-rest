# Start with a base image containing Java runtime and Maven
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn package -DskipTests

EXPOSE 8080

FROM maven:3.8.5-openjdk-17-slim AS release

COPY --from=build /app/target/*.jar /app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

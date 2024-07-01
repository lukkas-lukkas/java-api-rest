# Start with a base image containing Java runtime and Maven
FROM maven:3.8.5-openjdk-17-slim AS base

WORKDIR /app

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./src ./src

EXPOSE 8080

FROM base as dev

CMD mvn spring-boot:run

FROM base as prod

VOLUME /tmp

RUN mvn clean package -DskipTests

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

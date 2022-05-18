FROM maven:3.8-openjdk-11-slim AS maven-b

WORKDIR /app

COPY pom.xml .

COPY src /app/src

RUN mvn clean package

#pull base image runtime
FROM openjdk:11-jdk-slim-bullsey as jdk-runtime

#expose port
EXPOSE 8080

COPY --from=maven-b /app/target/hello-world-0.1.0.jar /usr/local/hello-world-0.1.0.jar

ENTRYPOINT [ "java" , "-jar", "/usr/local/hello-world-0.1.0.jar" ]
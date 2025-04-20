FROM maven:3.8-openjdk-11 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn clean package

COPY . .

FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=build . .

# Expose Dropwizard application and admin ports
EXPOSE 8080
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "app/target/gameauth-0.0.1-SNAPSHOT.jar", "server", "app/config.yml"]
FROM maven:3.8-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package
FROM openjdk:17-slim
COPY --from=build /app/target/ECF3-cda-BackEnd-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "app.jar"]


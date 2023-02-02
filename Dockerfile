FROM gradle:7.6.0-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN gradle clean build

FROM openjdk:17-slim
COPY --from=build /app/./build/libs/ECF3-cda-BackEnd-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "app.jar"]


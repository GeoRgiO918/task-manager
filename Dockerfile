FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

COPY build/libs/taskManager-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
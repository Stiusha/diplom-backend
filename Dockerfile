FROM gradle:8.7.0-jdk17 as builder
COPY . /app
RUN  cd /app && gradle build

FROM openjdk:17
COPY --from=builder /app/build/libs/diplom-backend-0.0.1-SNAPSHOT.jar ./project.jar
EXPOSE 2004
ENTRYPOINT ["java", "-jar", "/project.jar"]

FROM gradle:8.7.0-jdk17 as builder
COPY src /app/src
COPY build.gradle /app/
COPY settings.gradle /app/
RUN  cd /app && (gradle bootJar --no-daemon --console=plain || return 0)

FROM openjdk:17
COPY --from=builder /app/build/libs/*.jar ./project.jar
EXPOSE 2004
ENTRYPOINT ["java", "-jar", "/project.jar"]
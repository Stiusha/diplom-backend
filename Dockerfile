#FROM openjdk:17
#WORKDIR /app
#COPY . .
#RUN #./gradlew wrapper
#RUN #./gradlew build
#CMD ["tail", "-f", "/dev/null"]
FROM openjdk:17
MAINTAINER Leonid
COPY build/libs/diplom-backend-0.0.1-SNAPSHOT.jar project.jar
EXPOSE 2004
ENTRYPOINT ["java", "-jar", "/project.jar"]

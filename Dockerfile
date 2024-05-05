FROM ubuntu:latest

# Установка необходимых пакетов
RUN apt-get update && \
    apt-get install -y wget && \
    apt-get clean

# Скачивание и установка JDK 17
RUN mkdir -p /usr/lib/jvm && \
    wget -qO- https://download.java.net/java/GA/jdk17/0d483333a00540d886896bac774ff48b/35/GPL/openjdk-17_linux-x64_bin.tar.gz | tar xvz -C /usr/lib/jvm && \
    ln -s /usr/lib/jvm/jdk-17 /usr/lib/jvm/java-17-openjdk-amd64

# Установка переменных среды для JDK 17
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$PATH:$JAVA_HOME/bin

#FROM openjdk:17
MAINTAINER Leonid
COPY . /app
RUN  /app/gradlew jar || return 0
RUN  cp /app/build/libs/diplom-backend-0.0.1-SNAPSHOT.jar project.jar
#COPY build/libs/diplom-backend-0.0.1-SNAPSHOT.jar project.jar
EXPOSE 2004
ENTRYPOINT ["java", "-jar", "/project.jar"]

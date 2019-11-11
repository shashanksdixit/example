FROM openjdk:8-jdk-alpine
LABEL maintainer="sd"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/properties-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} properties.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/properties.jar"]
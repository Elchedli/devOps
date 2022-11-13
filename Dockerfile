FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/tpAchatProject-1.0.5-RELEASE.jar tpAchatProject-1.0.5-RELEASE.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.5-RELEASE.jar"]

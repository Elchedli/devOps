FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tpAchatProject-1.0.5-RELEASE.jar tpAchatProject-1.0.5-RELEASE.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.5-RELEASE.jar"]

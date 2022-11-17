FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tpAchatProject-1.0.6-RELEASE.jar tpAchatProject-1.0.6-RELEASE.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.6-RELEASE.jar"]

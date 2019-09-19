FROM openjdk:11
EXPOSE 5000
ADD target/greeting-docker.jar greeting-docker.jar
ENTRYPOINT ["java","-jar","/greeting-docker.jar"]

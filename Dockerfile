FROM adoptopenjdk/openjdk11

WORKDIR /opt/app

COPY target/devops-assignment-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

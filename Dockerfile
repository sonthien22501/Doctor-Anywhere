FROM openjdk:8

COPY target/doctor-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
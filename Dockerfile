FROM openjdk:20-oracle

EXPOSE 8080

COPY target/sping-auth-service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

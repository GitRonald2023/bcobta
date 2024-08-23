FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/bcobta-0.0.1-SNAPSHOT.jar /app/bcobta-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/app/bcobta-0.0.1-SNAPSHOT.jar"]
EXPOSE 5000
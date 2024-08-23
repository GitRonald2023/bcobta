From openjdk:8
copy /home/runner/work/bcobta/bcobta/target/bcobta-0.0.1-SNAPSHOT.jar bcobta-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","bcobta-0.0.1-SNAPSHOT.jar"]
EXPOSE 5000
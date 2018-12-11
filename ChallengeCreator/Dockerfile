FROM openjdk:8-jre
ADD ./target/challenge-creator-0.0.1-SNAPSHOT.jar /usr/app1/challenge-creator-0.0.1-SNAPSHOT.jar
WORKDIR usr/app1
ENTRYPOINT ["java","-jar", "challenge-creator-0.0.1-SNAPSHOT.jar"]

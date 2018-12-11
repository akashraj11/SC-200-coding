FROM openjdk:8-jre
ADD ./target/upvote-0.0.1-SNAPSHOT.jar /usr/app1/upvote-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8185/actuator/health || exit 1
WORKDIR usr/app1
ENTRYPOINT ["java","-jar", "upvote-0.0.1-SNAPSHOT.jar"]

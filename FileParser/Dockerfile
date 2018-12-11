FROM openjdk:8-jre
ADD ./target/Fileparser-0.0.1-SNAPSHOT.jar /usr/app1/Fileparser-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8182/actuator/health || exit 1
WORKDIR usr/app1
ENTRYPOINT ["java","-jar", "Fileparser-0.0.1-SNAPSHOT.jar"]

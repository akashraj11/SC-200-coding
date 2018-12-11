FROM openjdk:8
EXPOSE 8085
ADD target/neo4jservice-0.0.1-SNAPSHOT.jar /usr/src/neo4jservice-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8187/actuator/health || exit 1
WORKDIR usr/src
ENTRYPOINT ["java","-jar","neo4jservice-0.0.1-SNAPSHOT.jar"]

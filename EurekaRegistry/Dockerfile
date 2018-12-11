FROM openjdk:8-jre
ADD ./target/eureka-registry-0.0.1-SNAPSHOT.jar /usr/src/eureka-registry-0.0.1-SNAPSHOT.jar
EXPOSE 8091
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8091/actuator/health || exit 1
WORKDIR usr/src
ENTRYPOINT ["java","-jar","eureka-registry-0.0.1-SNAPSHOT.jar"]

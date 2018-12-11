FROM openjdk:8-jre

ADD ./target/user-authentication-service-0.0.1-SNAPSHOT.jar /usr/app/user-authentication-service-0.0.1-SNAPSHOT.jar

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8184/actuator/health || exit 1

WORKDIR /usr/app

ENTRYPOINT ["java","-jar", "user-authentication-service-0.0.1-SNAPSHOT.jar"]	

FROM openjdk:8-jdk
ADD ./target/Compilation-0.0.1-SNAPSHOT.jar /usr/app1/Compilation-0.0.1-SNAPSHOT.jar
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8183/actuator/health || exit 1
WORKDIR usr/app1
CMD apt-get install curl
CMD curl -sSL https://get.docker.com/
ENTRYPOINT ["java","-jar", "Compilation-0.0.1-SNAPSHOT.jar"]

FROM openjdk:8-jre
ADD ./target/moviesNew-0.0.1-SNAPSHOT.jar /usr/app1/moviesNew-0.0.1-SNAPSHOT.jar
WORKDIR usr/app1
ENTRYPOINT ["java","-jar", "moviesNew-0.0.1-SNAPSHOT.jar"]

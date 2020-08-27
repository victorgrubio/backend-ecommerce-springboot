FROM 3.6.3-jdk-11
RUN mvn clean install
FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar", $JAVA_OPTS, "-Dserver.port=80", "/app.jar"]
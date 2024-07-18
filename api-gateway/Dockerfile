# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} api-gateway.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/api-gateway.jar"]

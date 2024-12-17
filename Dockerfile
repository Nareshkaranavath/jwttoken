# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/Spring-security-Jwt-Token-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application runs
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

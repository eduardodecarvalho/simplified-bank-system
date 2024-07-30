# Use an official OpenJDK 21 runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/simplified-bank-ssytem-0.0.1-SNAPSHOT.jar /app

# Expose the port the application runs on
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-Dspring.profiles.active=dev", "-jar", "simplified-bank-ssytem-0.0.1-SNAPSHOT.jar"]

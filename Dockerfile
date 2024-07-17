# Use the Amazon Corretto 22 as the base image
FROM amazoncorretto:22

# Set the working directory
WORKDIR /usr/recruiting

# Copy the Spring Boot JAR file to the container
COPY build/libs/recruiting-0.0.1-SNAPSHOT.jar /usr/recruiting/recruiting-0.0.1-SNAPSHOT.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/usr/recruiting/recruiting-0.0.1-SNAPSHOT.jar"]
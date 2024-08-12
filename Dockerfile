# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable jar file from your local machine to the container
COPY target/servertemplate-0.0.1-SNAPSHOT.jar servertemplate.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "servertemplate.jar"]
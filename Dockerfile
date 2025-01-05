# Use a Maven image to build the project
FROM maven:3.8.7-openjdk-17-slim AS build
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Use a lightweight JDK image to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]

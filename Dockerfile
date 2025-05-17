# -------- Stage 1: Build the application --------
FROM eclipse-temurin:21-jdk AS builder

# Set working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and build scripts
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle .
COPY settings.gradle .

# Copy source code
COPY src ./src

# Build the application and skip tests
RUN ./gradlew clean build

# -------- Stage 2: Create the runtime image --------
FROM eclipse-temurin:21-jdk

# Create a non-root user
RUN groupadd spring && useradd -g spring spring

# Use the non-root user
USER spring

# Copy the jar from the builder stage
COPY --from=builder /app/build/libs/demo-gradle-0.0.1-SNAPSHOT.jar /app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app.jar"]

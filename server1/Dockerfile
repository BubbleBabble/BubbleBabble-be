#FROM openjdk:17
#
#ARG JAR_FILE_PATH=./build/libs/*.jar
#
#COPY $JAR_FILE_PATH app.jar
#
#EXPOSE 8081
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Step 1: Build the Spring Boot application
FROM gradle:7.2.0-jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src/ /app/src/
RUN gradle bootJar

# Step 2: Create the Docker image for the application
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/server1-0.0.1-SNAPSHOT.jar /app/server1.jar

# Step 3: Set environment variables for MongoDB connection
ENV MONGO_DB_URI=mongodb+srv://soolo:soolo@cluster0.nnm1vfo.mongodb.net/chat?retryWrites=true&w=majority
ENV SERVER_PORT=8081

# Step 4: Expose the port for the Spring Boot application
EXPOSE $SERVER_PORT

# Step 5: Run the Spring Boot application
CMD ["java", "-jar", "server1.jar"]
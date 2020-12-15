FROM openjdk:11.0.9.1-jdk-buster AS BUILD_STAGE
WORKDIR /workspace/app/
COPY . .
RUN ./gradlew clean build

FROM openjdk:11.0.9.1-jre-buster
WORKDIR /app/bin/
COPY --from=BUILD_STAGE /workspace/app/build/libs/*.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bookstore-0.0.1-SNAPSHOT.jar"]
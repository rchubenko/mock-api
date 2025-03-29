FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /opt
COPY . .
RUN mvn package

FROM eclipse-temurin:17-jdk
WORKDIR /opt
COPY --from=builder /opt/target/mock-api.jar .
EXPOSE 8080
CMD ["java", "-jar", "mock-api.jar"]

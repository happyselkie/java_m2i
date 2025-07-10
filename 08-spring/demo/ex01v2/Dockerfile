# Etape 1 : build avec maven
FROM maven AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etape 2 : image d'execution
FROM eclipse-temurin
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","app.jar" ]

# docker build -t todopaper .
# docker run -p 8085:8080 todopaper
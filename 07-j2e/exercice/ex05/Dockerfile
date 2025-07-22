# Etape 1 : build avec maven
FROM maven AS mvn_builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etape 2 : image d'execution
FROM tomcat:9.0.107-jre21-temurin-noble
WORKDIR /usr/local/tomcat/
COPY --from=mvn_builder /app app.war
EXPOSE 8080
ENTRYPOINT [ "catalina.sh", "run" ]

# docker build -t goodboy .
# docker run -p 8888:8080 goodboy
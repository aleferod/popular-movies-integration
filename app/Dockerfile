FROM openjdk:17-jdk-slim
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY app/build/libs/popular-movies-integration-*-all.jar /app/popular-movies-integration.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app/popular-movies-integration.jar
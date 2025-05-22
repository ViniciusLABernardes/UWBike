FROM node:18-alpine
# Instalando OpenJDK 21
RUN apk update && \
    apk add --no-cache openjdk21-jdk bash curl
RUN mkdir /app
WORKDIR /app
COPY /target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
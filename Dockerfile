# Utilisez une image de base pour Java
FROM openjdk:17-jdk-slim

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar de l'application dans le conteneur
COPY target/crud-0.0.1-SNAPSHOT.war /app/app.war

# Expose le port sur lequel l'application Spring Boot tourne
EXPOSE 8080

# Démarre l'application
ENTRYPOINT ["java", "-jar", "/app/app.war"]

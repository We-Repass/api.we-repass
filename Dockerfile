# Usa una imagen base de OpenJDK
FROM openjdk:22-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación en el contenedor
COPY target/api_we_repass-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto en el que tu aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

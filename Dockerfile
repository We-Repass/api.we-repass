# 🔨 Etapa 1: Build con Maven y Java 22
FROM eclipse-temurin:22-jdk as builder

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Crea el directorio de trabajo
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Compila el proyecto y genera el .jar
RUN mvn clean package -DskipTests

# 🏃 Etapa 2: Imagen final, solo con el JAR
FROM eclipse-temurin:22-jdk

# Crea carpeta para el JAR
WORKDIR /app

# Copia el JAR desde el contenedor builder
COPY --from=builder /app/target/api_we_repass-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto
EXPOSE 8080

# Ejecuta la app
ENTRYPOINT ["java", "-jar", "app.jar"]

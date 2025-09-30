# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todos os arquivos do projeto para dentro da imagem
COPY . .

# Usa o wrapper que já está no seu projeto (mvnw.cmd/mvnw)
RUN ./mvnw clean package -DskipTests

# Etapa 2: imagem final só com o JAR
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar
ENTRYPOINT ["java", "-jar", "app.jar"]

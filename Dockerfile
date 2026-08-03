# --- Этап 1: Сборка приложения ---
  FROM maven:3.9.6-eclipse-temurin-17 AS builder
  WORKDIR /app
  
  # Копируем pom.xml и скачиваем зависимости (кэшируется Docker-ом)
  COPY pom.xml .
  RUN mbn dependency:go-offline -B
  
  # Копируем исходный код и собираем production jar (пропуская тесты для скорости)
  COPY src ./src
  RUN mvn clean package -DskipTests
  
  # --- Этап 2: Финальный легковесный образ ---
  FROM eclipse-temurin:17-jre-alpine
  WORKDIR /app
  
  # Копируем собранный jar-ник из предыдущего этапа
  COPY --from=builder /app/target/*.jar app.jar
  
  # Настройка портов и запуск
  EXPOSE 8080
  ENTRYPOINT ["java", "-jar", "app.jar"]
  

#Primeira Etapa - construcao do jar

#Dockerfile esta dividido em 2 

FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app


COPY pom.xml ./

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

RUN ls -la /app/target

FROM eclipse-temurin:17-jdk-alpine


WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

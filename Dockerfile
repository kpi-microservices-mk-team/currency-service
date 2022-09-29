FROM openjdk:17-alpine
ADD build/libs/currency-service-1.0.5-SNAPSHOT.jar currency-service.jar
EXPOSE 8080
CMD ["java", "-jar", "currency-service.jar"]
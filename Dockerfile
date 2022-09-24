FROM openjdk:17-alpine
ADD build/libs/currency-service-1.0.0.jar currency-service.jar
EXPOSE 8028
CMD ["java", "-jar", "currency-service.jar"]
#sesuiakan dengan jdl yg terinstal
FROM openjdk:17
#gradle clean kemudian gradle build
COPY build/libs/senjaapi-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]
FROM openjdk:17

VOLUME /tmp

EXPOSE 8081  

COPY build/libs/*.jar application.jar

CMD ["java", "-jar", "application.jar"]

FROM hypriot/rpi-java

ADD build/libs/*SNAPSHOT.jar /opt/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/app.jar"]

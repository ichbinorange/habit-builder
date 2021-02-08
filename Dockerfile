# openjdk:11
FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.security.oauth2.client.registration.google.client-id='${GOOGLE_OAUTH_CLIENT_ID}'", "-Dspring.security.oauth2.client.registration.google.client-secret='${GOOGLE_OAUTH_CLIENT_SECRET}'","-jar","/app.jar"]
CMD ["gradle", "bootRun"]
EXPOSE 3000
# openjdk:11
FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.security.oauth2.client.registration.google.client-id='${GOOGLE_OAUTH_CLIENT_ID}'", "-Dspring.security.oauth2.client.registration.google.client-secret='${GOOGLE_OAUTH_CLIENT_SECRET}'","-Dspring.datasource.url=jdbc:postgresql://ec2-54-225-190-241.compute-1.amazonaws.com:5432/d5cfl02tlmjad?user=fydstdjbhenvak&password=f1f657929a4002d5a59e78043d9ca6e77c5f112a18047b0db6ffb92742c1a225","-Dserver.port=$PORT","-jar","/app.jar"]

EXPOSE $PORT
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/bot/src
COPY pom.xml /home/bot
RUN mvn -f /home/bot/pom.xml clean package

FROM openjdk

ENV PORT 8080
COPY --from=build /home/bot/target/Bot-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/bin

WORKDIR /usr/local/bin

RUN chmod +x Bot-1.0-SNAPSHOT-jar-with-dependencies.jar

EXPOSE $PORT

CMD ["/usr/bin/java","-cp", "Bot-1.0-SNAPSHOT-jar-with-dependencies.jar", "Main"]

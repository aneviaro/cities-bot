FROM openjdk

ENV PORT 8080
COPY target/Bot-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/bin

WORKDIR /usr/local/bin

RUN chmod +x Bot-1.0-SNAPSHOT-jar-with-dependencies.jar

EXPOSE $PORT

CMD ["/usr/bin/java","-cp", "Bot-1.0-SNAPSHOT-jar-with-dependencies.jar", "Main"]

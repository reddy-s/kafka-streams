FROM java:8-jre-alpine

LABEL maintainer="Sangram Reddy <reddy.horcrux@gmail.com>"
LABEL maintainer="Aivars Silins <aivars.silins@hotmail.com>"
LABEL application="kafka-streams"

COPY ./build/libs/kafka-streams-*.jar /home/app/app.jar

COPY ./utils/scripts/button.sh /home/app/

RUN apk --no-cache add curl && chmod +x /home/app/button.sh

WORKDIR /home/app/

EXPOSE 8080

CMD [ "sh", "/home/app/button.sh" ]
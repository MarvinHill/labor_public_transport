FROM alpine:latest
COPY ./SpringWebApplication/buga23publictransport/build/libs/get2buga.jar .
CMD [ "java", "-jar filename.jar" ]
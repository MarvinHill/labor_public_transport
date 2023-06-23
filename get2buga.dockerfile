FROM sapmachine:lts
COPY /home/get2buga .
WORKDIR /get2buga
RUN ./gradlew clean build
RUN ./gradlew bootWar
WORKDIR /get2buga/SpringWebApplication/buga23publictransport/build/libs
CMD [ "java", "-jar get2buga.jar" ]
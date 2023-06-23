FROM sapmachine:lts
RUN sudo apt update
RUN sudo apt-get install git
ADD /home/get2buga /get2buga
WORKDIR /get2buga
RUN git checkout docker-install
RUN ./gradlew clean build
RUN ./gradlew bootWar
WORKDIR /get2buga/SpringWebApplication/buga23publictransport/build/libs
CMD [ "java", "-jar get2buga.jar" ]
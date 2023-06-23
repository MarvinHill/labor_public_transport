FROM sapmachine:lts
RUN sudo apt update
RUN sudo apt-get install git
RUN git clone "https://github.com/MarvinHill/labor_public_transport.git" /get2buga
WORKDIR /get2buga
RUN git checkout docker-install
RUN ./gradlew clean build
RUN ./gradlew bootWar
WORKDIR /get2buga/SpringWebApplication/buga23publictransport/build/libs
CMD [ "java", "-jar get2buga.jar" ]
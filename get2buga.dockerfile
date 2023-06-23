FROM ubuntu:latest
RUN apt update
RUN apt install openjdk-17-jdk openjdk-17-jre -y
RUN apt-get install git -y
RUN git clone "https://github.com/MarvinHill/labor_public_transport.git" /get2buga

WORKDIR /get2buga
RUN git checkout docker-install

WORKDIR /get2buga/FrontEnd
RUN apt install -y curl
RUN curl -fsSL https://deb.nodesource.com/setup_16.x | bash
RUN apt install -y nodejs
RUN npm install
RUN npm install -g @angular/cli@latest
RUN ng build

WORKDIR /get2buga/SpringWebApplication/buga23publictransport
RUN chmod +x ./gradlew
RUN ./gradlew bootWar
WORKDIR /get2buga/SpringWebApplication/buga23publictransport/build/libs
CMD [ "java", "-jar get2buga.jar" ]
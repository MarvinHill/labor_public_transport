#!/bin/bash 
PROGRESS=0
REPO_URL="https://github.com/MarvinHill/labor_public_transport.git"

print_progress() {
    str=""
    for ((i=0;i < PROGRESS;i=i+1))
    do
    str="$str="
    done
    echo "Install Progress: [$str] $PROGRESS%"
}

update_system(){
    sudo apt update
    echo "Systempakete wurden geupdated"
}

install_git(){
    sudo apt-get install git
    echo "Git wurde installiert"
}

install_docker(){
    sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable" -y
    sudo apt update
    sudo apt install docker-ce -y
    echo "Docker wurde installiert"
}

install_docker_compose(){
    sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose
}

configure_ports(){
    sudo ufw default allow outgoing
    sudo ufw default deny incoming
    sudo ufw allow ssh
    sudo ufw allow "OpenSSH"
    echo "Ports wurden konfiguriert"
}

activate_ufw(){
    sudo ufw enable
    echo "ufw wurde aktiviert"
}

clone_get2buga(){
    git clone $REPO_URL /home/get2buga
    echo "Das Git Repo wurde geklont"
}

build_dockerfile(){
    cd /home/get2buga
    docker build -t get2buga
    echo "Das Dockerfile wurde gebuildet"
}

start_dockercompose(){
    cd /home/get2buga
    docker compose up
    echo "get2buga, nginx und mariadb wurden gestartet"
}

echo ""
echo ""
cat << EOF 
Der Installations-Prozess startet jetzt
--------------------------------------------

HINWEIS : Stellen Sie sicher, dass Sie mit dem Hochschul VPN verbunden sind und sowohl auf das Bitbucket git repository wie auch auf das Internet zugreifen können.

Folgendes wird installiert:

1. Systempakete werden geupdated
2. Git wird auf dem System installiert
3. Docker wird auf dem System installiert
4. Docker Compose wird auf dem System installiert 
5. Ports werden konfiguriert
6. ufw wird als Firewall aktiviert
7. get2buga wird über git geklont
8. Das Dockerfile wird gebuilded
9. Docker Compose startet das get2buga, nginx und mariadb container

Bitte haben Sie kurz gedult, dass kann etwas dauern...

--------------------------------------------

EOF

update_system
print_progress

install_git
print_progress

install_docker
print_progress

install_docker_compose
print_progress

configure_ports
print_progress

activate_ufw
print_progress

clone_get2buga
print_progress

build_dockerfile
print_progress

start_dockercompose
print_progress

echo "Der Server ist jetzt bereit genutzt zu werden. Vielen Dank fürs warten."

#sudo apt update
#sudo apt install nginx -y
#sudo ufw allow 'Nginx HTTP'
#cp /home/get2buga/get2buga.d /etc/nginx/conf.d
#echo "Der Nginx Webserver wurde installiert"
#sudo systemctl restart nginx
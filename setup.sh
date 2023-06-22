#!/bin/bash 
PROGRESS=0
REPO_URL="https://bitbucket-student.it.hs-heilbronn.de/scm/swp23pubt/get2buga.git"

print_progress() {
    str=""
    for ((i=0;i < PROGRESS;i=i+1))
    do
    str="$str="
    done
    echo "Install Progress: [$str] $PROGRESS%"
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
3. Docker wird auf dem Stystem installiert
4. Ports werden konfiguriert
5. ufw wird als Firewall aktiviert
6. get2buga wird über git geklont
7. Das Dockerfile wird gebuilded
8. Das gebuildete Image wird auf Docker ausgeführt
9. Nginx Server installieren

Bitte haben Sie kurz gedult, dass kann etwas dauern...

--------------------------------------------

EOF

sudo apt update
echo "Systempakete wurden geupdated"

sudo apt-get install git
echo "Git wurde installiert"
print_progress

sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable" -y
sudo apt update
sudo apt install docker-ce -y
echo "Docker wurde installiert"
print_progress

sudo ufw default allow outgoing
sudo ufw default deny incoming
sudo ufw allow ssh
sudo ufw allow "OpenSSH"
echo "Ports wurden konfiguriert"
print_progress

sudo ufw enable
echo "ufw wurde aktiviert"
print_progress

git clone $REPO_URL /home/get2buga
echo "Das Git Repo wurde geklont"
print_progress

cd /home/get2buga
docker build -t get2buga
echo "Das Dockerfile wurde gebuildet"
print_progress


docker run --name get2buga -p 8080:80 get2buga
echo "Das Docker Image wurde ausgeführt"
print_progress

sudo apt update
sudo apt install nginx -y
sudo ufw allow 'Nginx HTTP'
cp /home/get2buga/get2buga.d /etc/nginx/conf.d
echo "Der Nginx Webserver wurde installiert"
sudo systemctl restart nginx
print_progress

echo "Der Server ist jetzt bereit genutzt zu werden. Vielen Dank fürs warten."

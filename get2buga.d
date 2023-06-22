server {

  server_name get2buga.de www.get2buga.de;
  access_log /var/log/nginx/tomcat-access.log;
  error_log /var/log/nginx/tomcat-error.log;

  location / {
        proxy_set_header X-Forwarded-Host $host;
        proxy_set_header X-Forwarded-Server $host;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass http://127.0.0.1:8080/buga23publictransport-2.0/;
  }
}
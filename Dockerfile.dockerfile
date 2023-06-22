FROM alpine:latest
RUN apk update
RUN apk add nginx
COPY nginx.conf /etc/nginx/
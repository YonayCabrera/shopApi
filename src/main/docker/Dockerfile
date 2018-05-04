FROM postgres

MAINTAINER Yonay Cabrera <yonaycl@gmail.com>

ENV POSTGRES_DB shoptheam
ENV POSTGRES_USER batman
ENV POSTGRES_PASSWORD alfred

COPY init.sql /docker-entrypoint-initdb.d/init.sql

WORKDIR /shoptheam

EXPOSE 5432
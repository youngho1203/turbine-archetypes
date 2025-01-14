#using multi-stage

# mariadb use docker-entrypoint 
FROM mysql:8.0.26 as builder

# That file does the DB initialization but also runs mysql daemon, by removing the last line it will only init
RUN ["/bin/sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]

#
# check where and what configurations are read with e.g.
# docker-compose run db /usr/sbin/mysqld --verbose --help | grep -A 1 "Default options"
# docker run <image> /usr/sbin/mysqld --verbose --help | grep -A 1 "Default options"

ARG DB_CONTEXT
ARG MYSQL_ROOT
ARG MYSQL_ROOT_PASSWORD
ARG MYSQL_DATABASE
ARG MYSQL_USER
ARG MYSQL_PASSWORD

# required, to create
ENV DB_CONTEXT ${DB_CONTEXT}
ENV MYSQL_ROOT=${MYSQL_ROOT}
ENV MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}

ENV MYSQL_DATABASE=${MYSQL_DATABASE}
ENV MYSQL_USER=${MYSQL_USER}
ENV MYSQL_PASSWORD=${MYSQL_PASSWORD}
ENV MYSQL_HOST=

# mount in docker-compose
#ADD #var("DB_CONTEXT:-.")/mysql/conf/my.cnf /etc/

# for logs
#RUN mkdir -p /mysql/log
#RUN chmod -R a+r /mysql/log

RUN chmod -R a-w /etc/mysql/conf.d                          

COPY generated-sql/torque/mysql /generated-sql-init
# dependent sql should be name sorted after init.sql
# add what you need, avoid duplicate keys
RUN cat /generated-sql-init/*.sql > /docker-entrypoint-initdb.d/init.sql

COPY data/sample-mysql-data /generated-sql-post-init
RUN cat /generated-sql-post-init/*.sql > /docker-entrypoint-initdb.d/post_init.sql

# Need to change the datadir to something else that /var/lib/mysql because the parent docker file defines it as a volume.
# https://docs.docker.com/engine/reference/builder/#volume :
#       Changing the volume from within the Dockerfile: If any build steps change the data within the volume after
#       it has been declared, those changes will be discarded.

RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]

FROM mysql:latest

# my.cnf setting data-dir 
COPY --from=builder /initialized-db /var/lib/mysql



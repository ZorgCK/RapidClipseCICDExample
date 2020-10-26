FROM tomcat:8

RUN rm -rf /usr/local/tomcat/webapps/*
COPY JCON_Docker_JDNI.war /usr/local/tomcat/webapps
COPY context.xml /usr/local/tomcat/conf

CMD ["catalina.sh", "run"]
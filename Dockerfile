FROM tomcat:8

RUN rm -rf /usr/local/tomcat/webapps/*
COPY CICD_JNDI_Docker_Example.war /usr/local/tomcat/webapps
COPY context.xml /usr/local/tomcat/conf

CMD ["catalina.sh", "run"]
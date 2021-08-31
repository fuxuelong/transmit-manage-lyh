FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD transmit-manage-1.2.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
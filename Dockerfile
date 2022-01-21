#
# Gradle build sample dockerfile from: https://codestijl.dev/2020/09/14/a-gradle-build-in-docker/
#
FROM gradle:latest as build-image
WORKDIR /home/gradle/project

#
# Copy the Gradle config, source code, and static analysis config
# into the build container.
#
COPY --chown=gradle:gradle build.gradle settings.gradle /home/gradle/project/
COPY --chown=gradle:gradle src /home/gradle/project/src
#COPY --chown=gradle:gradle config /home/gradle/config

#
# Build the application.
#
RUN gradle --no-daemon build

#
# Java image for the application to run in.
#
#FROM tomcat:alpine
FROM tomcat:9-jdk17-openjdk-slim

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY --from=build-image /home/gradle/project/build/libs/docker-tomcat-java-example.war /usr/local/tomcat/webapps/ROOT.war

#
# Copy a modified server.xml into tomcat to define jvmRoute
#


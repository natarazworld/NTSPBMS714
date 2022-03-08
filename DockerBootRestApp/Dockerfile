#From <image>
FROM openjdk:11

# Temp folder to run the app
VOLUME /tmp

# Provide port number to run the application
EXPOSE 4545

# add jar file location to mappig name /alias name
ADD target/DockerBootRestApp-1.0.jar  DockerBootRestApp-1.0.jar

# Jar Execution Command
ENTRYPOINT ["java","-jar","/DockerBootRestApp-1.0.jar"]



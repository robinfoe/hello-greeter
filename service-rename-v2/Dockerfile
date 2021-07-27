
## use this for external build 
FROM openjdk:13-ea-27-jdk-alpine3.10
#VOLUME /tmp
RUN mkdir /app && \
    apk add tcpdump
    
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/rename.jar

WORKDIR /app 

CMD ["java", "-jar", "rename.jar"]


# # our base build image
# FROM maven:3.3-jdk-8 as builder

# # copy the project files
# COPY ./pom.xml ./pom.xml

# # build all dependencies
# RUN mvn dependency:go-offline -B

# # copy your other files
# COPY ./src ./src

# # build for release
# RUN mvn package


# FROM ibmjava:8-sfj as runner

# # Install Extra Packages
# RUN apt-get update \
#     && apt-get install -y jq bash bc ca-certificates curl \
#     && update-ca-certificates


# # Copy jar file over from builder stage
# ENV JAR_NAME=solution-serviceb-0.0.1-SNAPSHOT.jar
# COPY --from=builder target/$JAR_NAME ./app.jar

# ENV JAVA_OPTS=""
# ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar ./app.jar" ]
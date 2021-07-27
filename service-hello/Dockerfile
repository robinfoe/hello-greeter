
## use this for external build 
FROM openjdk:13-ea-27-jdk-alpine3.10
#VOLUME /tmp
RUN mkdir /app && \
    apk add tcpdump
    
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/hello.jar

WORKDIR /app 

CMD ["java", "-jar", "hello.jar"]




## below is meant for internal build 
# FROM maven:3.6.3-jdk-13 as builder
# COPY ./pom.xml ./pom.xml
# RUN mvn dependency:go-offline -B
# COPY ./src ./src
# RUN mvn package


# FROM openjdk:13-ea-27-jdk-alpine3.10 as runner
# RUN mkdir /app && \
#     apk add tcpdump
# ARG JAR_FILE=target/*.jar
# COPY --from=builder ${JAR_FILE} /app/hello.jar
# WORKDIR /app 
# CMD ["java", "-jar", "hello.jar"]


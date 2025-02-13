FROM gradle:8.4.0-jdk21-alpine

RUN apk add --no-cache make

ENV GRADLE_USER_HOME=/gradle-cache
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

RUN mkdir -p /code/kata

COPY gradlew /code
RUN mkdir -p /code/gradle/wrapper
COPY gradle/wrapper/* /code/gradle/wrapper

WORKDIR /code/kata

VOLUME ["/code", "/code/gradle", "/code/kata/build"]
FROM maven:3.8-openjdk-17-slim

RUN apt update && apt install -y make && apt-get clean && rm -rf /var/lib/apt/lists/*
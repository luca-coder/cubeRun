FROM openjdk:8
RUN apt update
RUN apt install curl
RUN apt-get install -y libxrender1 libxtst6 libxi6
RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token " https://api.github.com/repos/luca-coder/cubeRun/actions/artifacts/40910337/zip --output cubeRun.zip
RUN unzip cubeRun.zip
CMD ["java", "-jar", "CubeRun-1.0.jar"]
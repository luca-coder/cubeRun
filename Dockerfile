FROM openjdk:8
RUN apt update
RUN apt install curl
RUN apt-get install -y libxrender1 libxtst6 libxi6
RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization:token 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" https://api.github.com/repos/luca-coder/cubeRun/actions/artifacts/72230260/zip --output cubeRun.zip
RUN unzip cubeRun.zip
CMD ["java", "-jar", "CubeRun-1.0.jar"]
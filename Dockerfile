# Open A11y Guard - Architecture Blueprint
FROM node:20-bullseye-slim

LABEL org.opencontainers.image.source="[https://github.com/MichalZajkowski/a11y-compliance-blueprint](https://github.com/MichalZajkowski/a11y-compliance-blueprint)"
LABEL org.opencontainers.image.description="Containerized Accessibility Auditor for Sovereign OS"
LABEL maintainer="Michał Zajkowski"

ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
ENV ANDROID_HOME="/root/android-sdk"
ENV PATH="${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools"

# 1. Install System Dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk-headless \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# 2. Install Appium & Drivers
RUN npm install -g appium \
    && appium driver install uiautomator2

WORKDIR /app

# 3. Entrypoint
CMD ["echo", "Open A11y Guard Container Ready. Run with specific scan arguments."]
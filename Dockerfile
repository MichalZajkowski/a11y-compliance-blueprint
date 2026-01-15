# Open A11y Guard - Architecture Blueprint
FROM node:20-bullseye-slim

LABEL org.opencontainers.image.source="[https://github.com/MichalZajkowski/a11y-compliance-blueprint](https://github.com/MichalZajkowski/a11y-compliance-blueprint)"
LABEL org.opencontainers.image.description="Containerized Accessibility Auditor for Sovereign OS"
LABEL maintainer="Michał Zajkowski"

ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
ENV ANDROID_HOME="/root/android-sdk"
ENV PATH="${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:/app/node_modules/.bin"

# 1. Install System Dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk-headless \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# 2. Install Appium & Drivers (globally, for system-wide access)
RUN npm install -g appium \
    && appium driver install uiautomator2

WORKDIR /app

# 3. Copy Application Files & Install Dependencies
COPY package.json ./
COPY src/ ./src/
RUN npm install
RUN npm link

# 4. Entrypoint
# This default command runs the mock scan. In a real CI scenario,
# this would be overridden by specific arguments like in docker-compose.yml.
CMD ["npm", "run", "scan:system-ui"]

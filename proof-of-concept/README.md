# Proof of Concept

This directory contains a minimal, compilable, and runnable Proof of Concept (PoC) for The A11y-Compliance Blueprint project.

## Purpose

The purpose of this PoC is to demonstrate the core technical methodology of the project: using a standardized Android application (`test-app`) and an Appium-based test suite (`appium-tests`) to programmatically query and validate the behavior of an Android OS's foundational accessibility APIs.

## Components

1.  **/test-app**: A minimal Android application built in Android Studio. It contains a single button with a hardcoded `contentDescription`. This app acts as the controlled "measuring stick" for our tests.
2.  **/appium-tests**: A minimal JVM/Kotlin project using Gradle. It contains a single JUnit test that uses the Appium client to verify the `contentDescription` of the button in the `test-app`.

## How to Run This PoC Locally

### Prerequisites

* **Android Studio:** To build and install the `test-app`.
* **Node.js & npm:** To install and run the Appium server.
* **Appium Server:** Install globally via npm: `npm install -g appium`.
* **IntelliJ IDEA** (or Android Studio): To run the test suite.

### Step 1: Build and Install the `test-app`

1.  Open the `proof-of-concept/test-app` directory as a project in Android Studio.
2.  Allow Gradle to sync and build the project.
3.  Create an Android Virtual Device (AVD) using the **Device Manager** in Android Studio (e.g., Pixel 6, API 33).
4.  Run the application by selecting your AVD and clicking the "Run 'app'" button.
5.  **Goal:** You should see the `A11y Test App` running on your emulator, showing a single "Test Button".

### Step 2: Start the Appium Server

1.  Open a new terminal window.
2.  Run the following command and leave it running:
    ```bash
    appium
    ```
3.  **Goal:** You should see logs indicating that the Appium server is running and listening on port 4723.

### Step 3: Run the `appium-tests`

1.  Open the `proof-of-concept/appium-tests` directory as a project in IntelliJ IDEA.
2.  Allow Gradle to sync and download the required dependencies (JUnit, Appium client).
3.  Open the `AccessibilityApiTest.kt` file.
4.  **Crucially**, update the `deviceName` variable inside the `setUp()` method to match the exact name of your AVD.
5.  Run the test by clicking the green "play" arrow next to the `AccessibilityApiTest` class definition.

## Expected Outcome

If everything is configured correctly, the test will execute:
1.  The `A11yBlueprintApp` will launch on your emulator.
2.  The test script will query the OS for the button's `contentDescription`.
3.  The test will pass.
4.  You will see a **"✅ Test PASSED!"** message printed in the console within your IDE.
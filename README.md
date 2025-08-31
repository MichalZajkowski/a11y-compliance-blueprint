# The A11y-Compliance Blueprint 🏗️

An open-source testing framework and compliance dashboard for validating foundational accessibility APIs in alternative mobile operating systems. This project is proposed for funding by the NGI Mobifree fund.

---

## The Problem: An Accessibility Blind Spot in the Open Mobile Ecosystem

The movement towards an open, sovereign mobile ecosystem is vital for a human-centric internet. However, emerging platforms like GrapheneOS, /e/OS, and others often lack the resources for dedicated accessibility quality assurance. This creates a critical risk: without a reliable way to validate their foundational Accessibility APIs, these platforms may inadvertently exclude users with disabilities, undermining the goal of creating a truly inclusive alternative.

## The Solution: A Public Benchmark for Accessibility

**The A11y-Compliance Blueprint** is an automated testing system that acts as a public "quality lab" for mobile OS accessibility. It provides two key public goods:

1.  **A Public Compliance Dashboard:** A simple, clear website that tracks and displays the accessibility compliance of major open-source mobile OSes, creating transparency and a healthy incentive for improvement.
2.  **A "Blueprint-in-a-Box":** The entire testing system is provided as an open-source, replicable template that any OS developer can use to test their own builds and fix issues before they are released.

## How It Works

The system uses a simple, powerful methodology:
- **A Standardized Test App:** A simple, consistent Android application is used as a "measuring stick."
- **Automated OS-Level Testing:** An Appium-based test suite runs against the test app, but it queries the **Operating System's Accessibility API** to check if the OS correctly interprets the app's accessibility features.
- **Continuous Reporting:** Tests are run automatically via GitHub Actions, and the results are published to the public dashboard, providing a continuous, up-to-date benchmark.

## 🚦 Project Status

This project is currently in the **proposal stage** for the NGI Mobifree fund. The technical architecture and roadmap have been defined.

## 🗺️ Roadmap

- **Phase 1: Core Testing Framework.** Develop the core Appium/Kotlin test suite and the standardized Android test application.
- **Phase 2: CI Automation & Dashboard.** Implement the GitHub Actions workflow for automated testing and create the public-facing dashboard.
- **Phase 3: Blueprint & Dissemination.** Create comprehensive documentation ("the Blueprint") and engage with open-source communities to promote adoption.

## 🙌 How to Contribute

This project is intended to be an open-source public good. At this early stage, the best way to contribute is by providing feedback or expressing interest. Please open an issue to start a discussion.

For more details, see our **[CONTRIBUTING.md](CONTRIBUTING.md)** file.

## 📄 License

This project is licensed under the **MIT License**.

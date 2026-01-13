# Open A11y Guard
### (formerly "The A11y-Compliance Blueprint")

> **Current Status:** 🚧 **Phase 1: Proof of Concept** (Proposal for NGI Mobifree Fund)
> **Focus:** CI-Native Accessibility Automation for Sovereign OS

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![NGI Zero](https://img.shields.io/badge/Grant-NGI_Mobifree_Candidate-blue)](https://nlnet.nl/)

## 🚀 The Mission
**Open A11y Guard** is an open-source initiative to eliminate the "accessibility blind spot" in the alternative mobile ecosystem.

While proprietary platforms have massive QA resources, sovereign Operating Systems (GrapheneOS, /e/OS, LineageOS, Plasma Mobile) often lack the automated tooling to verify **WCAG** & **European Accessibility Act (EAA)** compliance at the System UI level.

**This project aims to solve that by providing a "Drop-in" CI Container that acts as a headless accessibility auditor.**

---

## 🏗️ Architecture & Vision (Roadmap)

We are moving away from local, manual Appium scripts towards a fully containerized, CI-agnostic solution.

### The Problem
Traditional mobile testing requires complex setups (Android Studio, Emulators, Appium Servers) that are hard to maintain in lightweight CI environments like GitLab CI or Woodpecker.

### The Solution: "Container-First" Approach
The goal of the NGI-funded phase (Phase 2) is to deliver a **Portable Accessibility Compliance Container (PACC)**.

* **🐳 Dockerized Runner:** No external dependencies. Just `docker run open-a11y-guard`.
* **🔗 CI-Agnostic:** Designed to run on **GitLab CI** (/e/OS), **Woodpecker** (Codeberg), **Jenkins**, and **GitHub Actions**.
* **🤖 Zero-Touch:** Automatically boots a headless Android environment, runs the audit against the Accessibility API, and shuts down.
* **📊 Standardized Reporting:** Outputs JUnit XML and HTML reports ready for compliance dashboards.

```mermaid
graph LR
    A[OS Build Pipeline] -->|Triggers| B(Open A11y Guard Container)
    B -->|Spins up| C[Headless Android / Emulator]
    B -->|Injects| D[A11y Inspector Engine]
    D -->|Queries| E[OS Accessibility API]
    E -->|Returns| D
    D -->|Generates| F[Compliance Report]
    F -->|Pass/Fail| A
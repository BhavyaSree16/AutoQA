# 🚀 AutomationExercise – Selenium Test Automation Suite

---

## 📌 Project Overview

AutomationExercise is a comprehensive **end-to-end Selenium automation framework** built using **Selenium WebDriver and TestNG**.  
This project demonstrates real-world automation scenarios including authentication, product testing, cart operations, checkout flow, and form validations.

The framework follows **industry best practices** such as Page Object Model (POM), config-driven testing, and reusable utilities.

**Project Type:** Selenium 4 + TestNG + Config-Driven Testing  
**Version:** 1.0  
**Language:** Java  
**Build Tool:** Maven  

---

## 🎯 Project Goals

- Automate complete user workflow (Register → Checkout)
- Implement **Page Object Model (POM)**
- Perform **config-driven testing (no hardcoding)**
- Handle dynamic UI elements and popups
- Capture screenshots (failure + execution)
- Validate forms and negative scenarios
- Maintain reusable and scalable framework

---

## 🏗 Architecture & Design Patterns

### 🔹 Design Patterns Used:

Page Object Model (POM) - Encapsulates web elements and interactions
Base Page Pattern - Common functionality for all page objects
Base Test Pattern - Setup and teardown for all test classes
Factory Pattern - WebDriver initialization and management
Data-Driven Testing - Excel-based test data
Listener Pattern (Screenshot Handling) - Custom TestNG listeners for reporting
Config Reader Pattren

---

### 🔹 Architecture Layers:
```
├── Base Layer (BasePage, BaseTest)
├── Page Layer (Page Objects)
├── Test Layer (Test Classes)
├── Utilities Layer (Helper classes)
└── Configuration Layer (Properties files)
```

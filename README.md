# 🚀 AutomationExercise – E2E Selenium Test Automation Suite

---

## 📌 Project Overview

AutomationExercise is a complete **end-to-end Selenium automation framework** built using **Selenium WebDriver, TestNG, and Java**.  
This project automates real-world user flows such as:

- User Registration & Login  
- Product Browsing  
- Cart Operations  
- Checkout & Payment  
- Form Validations  

**Project Type:** Selenium 4 + TestNG + POM + Config-Driven Testing  
**Language:** Java  
**Build Tool:** Maven  

---

## 🎯 Project Goals

- Automate full user journey (Register → Checkout)
- Implement **Page Object Model (POM)**
- Use **config-driven testing (no hardcoding)**
- Handle dynamic elements and popups
- Capture screenshots (failure + execution)
- Validate negative scenarios

---

## Architecture & Design Patterns

### 🔹 Design Patterns Used

- Page Object Model (POM)
- Base Test Pattern
- Base Page Pattern
- Config Reader Pattern
- Listener Pattern (Screenshot on failure)

---

### 🔹 Architecture Layers
Base Layer → BaseTest, BasePage
Page Layer → Pages
Test Layer → Test Classes
Utility Layer → ConfigReader, ScreenshotUtil
Config Layer → config.properties

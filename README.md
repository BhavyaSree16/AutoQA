# 🚀 AutomationExercise – Selenium Test Automation Suite

---

## 📌 Project Overview

AutomationExercise is a comprehensive **end-to-end Selenium automation framework** built using **Selenium WebDriver and TestNG**.  
This project demonstrates real-world automation scenarios including authentication, product testing, cart operations, checkout flow, and form validations.

The framework follows **industry best practices** such as Page Object Model (POM), config-driven testing, and reusable utilities.

**Project Type:** Selenium 4 + TestNG + Config-Driven Testing  
**Version:** 0.0.1-SNAPSHOT 
**Language:** Java  
**Build Tool:** Maven  

---

## Project Goals

- Automate complete user workflow (Register → Checkout)
- Implement **Page Object Model (POM)**
- Perform **config-driven testing (no hardcoding)**
- Handle dynamic UI elements and popups
- Capture screenshots dynamically
- Generate professional HTML reports (Extent Reports)
- Validate negative scenarios (form validation, login failure)

---

##  Architecture & Design Patterns

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


---

##  Project Structure
```
AutomationExercise/
│
├── pom.xml                  # Maven configuration (dependencies, plugins)
├── testng.xml               # TestNG suite configuration (tests execution)
├── README.md                # Project documentation
│
├── src/
│ ├── main/java/
│ │ ├── base/
│ │ │ ├── BasePage.java     # Common reusable methods (waits, actions)
│ │ │ └── BaseTest.java     # Test setup & teardown (driver init, quit)
│ │ │
│ │ ├── pages/
│ │ │ ├── SignupPage.java   # Registration page actions (enter details, signup)
│ │ │ ├── LoginPage.java    # Login page actions (valid/invalid login)
│ │ │ ├── ProductsPage.java # Product page (search, category, view product)
│ │ │ ├── CartPage.java     # Cart operations (add/remove products, popup handling)
│ │ │ └── CheckoutPage.java # Checkout & payment flow (place order, payment details)
│ │ │
│ │ ├── utils/
│ │ │ ├── ConfigReader.java # Reads values from config.properties
│ │ │ ├── ScreenshotUtil.java # Captures screenshots (manual + failure)
│ │ │ └── TestListener.java  # TestNG listener (screenshot on failure)
│
│ ├── test/java/
│ │ ├── tests/
│ │ │ ├── EndToEndTest.java     # Complete flow (Register → Login → Checkout)
│ │ │ ├── ProductsTest.java     # Product module tests (search, category, details)
│ │ │ ├── CartTest.java         # Cart module tests (add products, navigation)
│ │ │ ├── CheckoutTest.java     # Checkout module tests (payment, order)
│ │ │ └── FormValidationTest.java # Form validation tests (empty, invalid inputs)
│
├── screenshots  # Stores screenshots (failure + execution)
│    ├──Payment_Page_20260415015548.png
├── test-output/                     # TestNG default report output
│   ├── index.html
│   ├── emailable-report.html
│   ├── testng-results.xml
│   └── junitreports/                # JUnit format reports
│
│── reports/ # Extent Reports (HTML)
├── test-output/ # TestNG reports
└── .git/                            # Git version control
```

⚙️ Technologies Used
Java
Selenium WebDriver
TestNG
Maven
Apache POI (Excel handling)
WebDriverManager
Extent Reports 
ITestListener

---

## 📦 Dependencies

| Dependency | Purpose |
|-----------|--------|
| Selenium WebDriver | Browser automation |
| TestNG | Test execution |
| WebDriverManager | Driver setup |
| Apache POI | Excel handling |
| ExtentReports | HTML reporting |

---

## ⚙️ Configuration

### 📄 `config.properties`
```
browser=chrome
baseUrl=https://automationexercise.com

timeout=10

productIds=1,2,3

nameOnCard=Bhavya
cardNumber=534712345678
cvc=550
expiryMonth=03
expiryYear=2034
```

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

---

## 🧪 Test Modules Overview

### 1️⃣ Authentication Module
- User registration  
- Login validation  
- Logout verification  

---

### 2️⃣ Product Module
- Product search  
- Category navigation  
- View product details  
- Validate product name & price  

---

### 3️⃣ Cart Module
- Add multiple products (config-driven)  
- Handle popup (Continue Shopping / View Cart)  
- Navigate to cart  

---

### 4️⃣ Checkout Module
- Proceed to checkout  
- Place order  
- Enter payment details  
- Dynamic validation for empty fields  

---

### 5️⃣ Form Validation Module
- Submit empty form  
- Invalid email validation  

---

## 🔄 End-to-End Flow
```
Register → Login
→ Products → Add to Cart
→ Cart → Checkout
→ Payment → Order Confirmation
```

---

## 📊 Test Reports

### 🔹 Extent Report
```
 Generated at: C:\Users\Bhavya Sree\git\repository4\AutoQA\reports\ExtentReport.html
```


### Features:

- Test execution summary  
- Pass / Fail status  
- Error logs  
- Screenshot attachment  
- Clean UI dashboard  

---

### 🔹 Screenshots
```
Location: C:\Users\Bhavya Sree\git\repository4\AutoQA\reports\screenshots\
Captured:
- On test failure  
- On dynamic validation  
```
---

### 🔹 TestNG Report
```
##  Running Tests

### Run all tests : mvn test

### Run specific test : mvn test -Dtest=EndToEndTest

```


---

## ⚙️ TestNG Configuration

```xml
<suite name="AutomationSuite">

    <listeners>
        <listener class-name="utils.TestListener"/>
    </listeners>

    <test name="All Tests">
        <classes>
            <class name="tests.EndToEndTest"/>
        </classes>
    </test>

</suite>

💡 Best Practices Implemented
```
Page Object Model (POM)
Explicit waits (no Thread.sleep)
Config-driven testing
Dynamic validation
Screenshot handling
Extent Report integration
Clean layered architecture
```

🛠 Troubleshooting
```
Issue	Solution
Report not generated	Check extent.flush()
Screenshots missing	Verify folder path
Driver issues	Use WebDriverManager
Element not found	Increase wait
```
🧰 Technology Stack
```
Component	Technology
Language	Java
Automation	Selenium
Framework	TestNG
Build Tool	Maven
Reporting	ExtentReports
Browser	Chrome
```

📌 Conclusion

This project demonstrates a complete real-world automation framework with:
Authentication
Product testing
Cart operations
Checkout & payment
Form validations
Advanced reporting

Contact & Contribution
For questions, issues, or contributions, please:
Create an issue in the repository
Submit a pull request with improvements
Follow the existing code style and patterns

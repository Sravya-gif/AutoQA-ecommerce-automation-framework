\# E-Commerce Automation Framework - Design Document


##  Introduction

This project is an automation testing framework built using Selenium and Java for an eCommerce web application.
The framework automates key functionalities like user login, product search, add to cart, checkout process, account management, and order validation.


## Tools & Technologies

Java
Selenium WebDriver
TestNG
Maven
WebDriverManager
Extent Reports and screenshots
Apache POI (for Excel data)

## Key Features

Page Object Model (POM)
Data-driven testing using Excel
Screenshot capture on failure
Extent report generation
Config file usage
FluentWait for dynamic elements
TestNG for test execution

## Project Structure
```
ecommerce
│
├── src/main/java
│   ├── com.srm.base
│   │   └── BaseTest.java
│   │
│   ├── com.srm.driver
│   │   └── DriverFactory.java
│   │
│   ├── com.srm.pages
│   │   ├── BasePage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   ├── ContactUsPage.java
│   │   ├── LoginPage.java
│   │   ├── ProductsPage.java
│   │   └── SignupPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExcelUtils.java
│   │   ├── ExtentManager.java
│   │   └── ScreenshotUtil.java
│
├── src/main/resources
│   ├── config.properties
│   └── testdata4.xlsx
│
├── src/test/java
│   ├── com.srm.tests
│   │   ├── CheckoutFlowTest.java
│   │   ├── ContactUsTest.java
│   │   ├── DataProviders.java
│   │   ├── FormValidationTest.java
│   │   ├── LoginTest.java
│   │   ├── ProductsTest.java
│   │   └── SignupTest.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│
├── screenshots
│   └── (failure screenshots stored here)
│
├── reports
│   └── (Extent Reports generated here)
│
├── testng.xml
├── pom.xml
```

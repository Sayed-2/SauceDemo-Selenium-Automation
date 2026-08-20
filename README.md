# SauceDemo Selenium Automation

Automated UI testing framework for the [SauceDemo](https://www.saucedemo.com/) web application using Java, Selenium WebDriver, TestNG, Cucumber, Maven, and the Page Object Model (POM).

## Technologies

- Java
- Selenium WebDriver
- TestNG
- Cucumber
- Maven
- Page Object Model (POM)
- Git / GitHub

## Automated Test Scenarios

1. Successful login
2. Negative login validation
3. Products page verification
4. Add product to cart
5. Checkout with valid information
6. Checkout validation with missing information
7. Complete order

## Project Structure

```text
src
└── test
    ├── java
    │   └── com.saucedemo
    │       ├── pages
    │       ├── tests
    │       ├── step_definitions
    │       ├── runners
    │       └── utilities
    │
    └── resources
        ├── features
        └── configuration.properties
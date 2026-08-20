# SauceDemo Selenium Automation

Automated UI testing project for the SauceDemo web application using Java, Selenium WebDriver, TestNG, Cucumber, and Maven.

## Technologies
- Java
- Selenium WebDriver
- TestNG
- Cucumber
- Maven
- Page Object Model (POM)
- Git / GitHub


- ## Automated Test Scenarios
- Successful login
- Negative login validation
- Products page verification
- Add product to cart
- Checkout with valid information
- Checkout validation with missing information
- Complete order


## Project Structure

src/test/java/com/saucedemo
├── pages
├── tests
├── step_definitions
├── runners
└── utilities

src/test/resources
├── features
└── configuration.properties

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java and Maven are configured.
4. Run the TestNG tests from the `tests` package.

Or run the tests with Maven:

```bash
mvn clean test
# UI Automation Framework for DemoQA

## Overview
This framework is designed to automate the testing of the DemoQA application. It is built using Java, Selenium WebDriver, and TestNG.

## Project Structure
```
ui_automation_demoqa/
├── src/main/java/
│   ├── base/
│   │   └── BaseTest.java
│   ├── config/
│   │   └── ConfigReader.java
│   ├── pages/
│   │   ├── HomePage.java
│   │   ├── TextBoxPage.java
│   │   ├── AlertsPage.java
│   │   ├── ButtonsPage.java
│   │   ├── CheckBoxPage.java
│   │   ├── RadioButtonPage.java
│   │   ├── WebTablePage.java
│   │   ├── DynamicPropertiesPage.java
│   │   └── (other pages as applicable)
│   └── models/
│       └── TestDataModel.java
├── src/test/java/
│   ├── utils/
│   │   ├── DataProviderUtil.java
│   │   └── WebDriverFactory.java
│   ├── tests/
│   │   └── DemoQATests.java
├── test-output/
├── config.properties
├── pom.xml
└── README.md
```

## Configuration
- **config.properties**: Contains configuration settings like browser type and base URL.

## Setup
1. Ensure you have JDK and Maven installed.
2. Clone the repository.
3. Navigate to the project directory.
4. Run `mvn clean install` to set up the project dependencies.

## Running Tests
1. Navigate to the project directory.
2. Run `mvn test` to execute the test suite.

## Framework Components
- **BaseTest.java**: Sets up and tears down WebDriver instances for tests.
- **ConfigReader.java**: Reads configuration properties from the `config.properties` file.
- **Page Classes**: Represent various pages of the DemoQA application.
- **DataProviderUtil.java**: Provides test data using TestNG's `@DataProvider` annotation.
- **DemoQATests.java**: Contains TestNG test methods for various scenarios.

## Logging
- **Log4j**: Used for internal logging during tests.

## Reporting
- **Extent Reports**: Generates visually rich test execution reports.

## Cross-Browser Testing
- **WebDriverManager**: Manages driver binaries for different browsers.

## Notes
- Ensure modular code to allow the addition of more UI test cases seamlessly.

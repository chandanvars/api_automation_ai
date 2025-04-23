# UI Automation Framework for DemoQA

## Overview
This framework is designed to automate the testing of the DemoQA application using Java, Selenium WebDriver, and TestNG. It follows the Page Object Model (POM) design pattern for scalability and maintainability.

## Features
- Automates all pages and functionalities of the DemoQA application.
- Covers both positive and negative test scenarios.
- Generates detailed HTML reports using Extent Reports.
- Supports cross-browser testing (Chrome and Firefox).

## Prerequisites
- JDK 11 or higher
- Maven 3.6 or higher
- ChromeDriver and GeckoDriver (managed automatically by WebDriverManager)

## Setup Instructions
1. Clone the repository.
2. Navigate to the project directory.
3. Update the `config.properties` file with the desired browser and application URL.
4. Run `mvn clean install` to install dependencies.

## Execution
- To execute tests, run `mvn test`.
- Test results will be available in the `test-output` directory.

## Adding New Tests
1. Create a new page class in the `pages` package.
2. Add corresponding test methods in the `tests` package.
3. Use `DataProviderUtil` for test data management.

## Maintenance
- Update dependencies in `pom.xml` as needed.
- Ensure compatibility with the latest browser versions.

## Reporting Issues
For any issues, please create a ticket in the project management tool.
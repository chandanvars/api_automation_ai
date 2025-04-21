# UI Automation Framework for DemoQA

## Overview
This framework is designed to automate the UI testing of the DemoQA application using Selenium WebDriver and TestNG.

## Prerequisites
- JDK 1.8 or higher
- Maven 3.x

## Configuration
- Update `config.properties` with the desired browser and base URL.

## Running Tests
- Use the command `mvn test` to execute the test suite.

## Structure
- `src/main/java`: Contains the main Java classes for page objects and utilities.
- `src/test/java`: Contains the test classes and utilities.
- `pom.xml`: Maven configuration file.

## Reporting
- Test results are generated using Extent Reports.

## Logging
- Log4j is used for logging test execution details.

## Maintenance
- Ensure dependencies in `pom.xml` are up-to-date.
- Add new test cases in `DemoQATests.java` as needed.

## Contribution
- Follow the branch naming convention `feature/ui_automation_framework` for new features.
- Ensure all tests pass before merging to `master`.
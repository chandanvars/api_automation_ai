# UI Automation Framework for DemoQA

## Overview
This framework is designed to automate the testing of the DemoQA application using Selenium WebDriver 4 and TestNG. It covers various UI functionalities such as text boxes, buttons, alerts, checkboxes, radio buttons, and more.

## Prerequisites
- JDK 1.8 or higher
- Maven

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd ui_automation_demoqa
   ```
3. Install the dependencies:
   ```
   mvn clean install
   ```

## Running Tests
To run the tests, use the following command:
```
   mvn test
```

## Framework Structure
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
│   │   ├── SwitchWindowsPage.java
│   │   ├── WidgetsPage.java
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

## Logging and Reporting
- **Log4j** is used for logging during test execution.
- **Extent Reports** is used for generating visually rich test execution reports, including screenshots of failures.

## Adding More Test Cases
To add more test cases, follow these steps:
1. Create a new page class in the `pages/` directory if it doesn't already exist.
2. Add methods to interact with the UI elements in the new page class.
3. Create a new test method in the `DemoQATests.java` file and use the page class methods to implement the test logic.
4. Use assertions to validate the expected behavior.

## Exception Handling
Proper exception handling is implemented to ensure that any errors during test execution are logged and reported.

## Test Coverage
Ensure 100% test coverage for all automated test cases before pushing the code.

## Validation
Ensure no validation errors for files created in the following paths:
- `src/test/java/tests/DemoQATests.java`
- `src/test/java/utils/DataProviderUtil.java`
- `pom.xml`

All files should seamlessly pass validations during commits, with proper exception handling and error resolution.

## Git Workflow
1. Create a feature branch named `feature/ui_automation_framework`.
2. Push all generated framework code to this branch.
3. Ensure the base branch for the pull request is `master`.

## Contact
For any queries or issues, please contact the repository owner.

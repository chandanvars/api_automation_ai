# api_automation_ai
git init
git branch -M master
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework

# UI Automation Framework for DemoQA

## Overview
This project contains a UI automation framework for testing the DemoQA application using Selenium WebDriver 4 and TestNG.

## Prerequisites
- JDK 8 or higher
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
To execute the tests, run the following command:
```bash
mvn test
```

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

## Test Cases
The test cases are implemented in the `DemoQATests.java` file and cover the following functionalities:
- TextBox functionality
- Alerts functionality
- Switch Windows functionality
- Widgets functionality

## Logging and Reporting
- Log4j is used for logging.
- Extent Reports is used for generating test execution reports.

## Contributing
Feel free to contribute to this project by submitting a pull request.

## License
This project is licensed under the MIT License.
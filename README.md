# api_automation_ai
git init
git branch -M master
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework

# API Automation Framework

## Overview
This framework is designed to automate API testing for the Petstore application using Java, Rest Assured, and TestNG.

## Project Structure
```
api_automation_ai/
├── src/main/java/
│   ├── base/
│   │   └── BaseTest.java
│   ├── config/
│   │   └── ConfigReader.java
│   ├── helpers/
│   │   └── EndpointHelper.java
│   └── models/
│       ├── Pet.java
│       ├── ResponseModel.java
│       └── UploadResponse.java
├── src/test/java/
│   ├── tests/
│   │   └── PetTests.java
│   ├── utils/
│   │   ├── TestDataGenerator.java
│   │   └── ApiUtils.java
├── config.properties
├── pom.xml
└── README.md
```

## Configuration
1. Clone the repository.
2. Navigate to the project directory.
3. Update the `config.properties` file with the base URL if needed.

## Running Tests
1. Ensure you have Maven installed.
2. Execute the following command to run the tests:
```
mvn test
```

## Maintaining the Framework
- Add new test cases in the `src/test/java/tests` directory.
- Update the `EndpointHelper.java` for new endpoints.
- Use `TestDataGenerator.java` to generate test data.

## Logging
- Logs are captured using Log4j.
- Update the log configuration in `log4j2.xml` if needed.

## Notes
- Ensure all dependencies are defined in `pom.xml`.
- Follow the project structure for consistency.
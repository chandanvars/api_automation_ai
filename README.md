# api_automation_ai
git init
git branch -M master
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework

# README.md

# API Automation Framework

## Overview
This framework is designed to automate the testing of the Petstore API endpoints using Java, Rest Assured, and TestNG.

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

## Setup Instructions
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to install the required dependencies.

## Running Tests
- To run all tests, use the command: `mvn test`

## Test Cases
The test cases are designed to cover the following endpoints:
- Add a new pet (POST /pet)
- Update an existing pet (PUT /pet)
- Find a pet by ID (GET /pet/{petId})
- Find pets by status (GET /pet/findByStatus)
- Delete a pet (DELETE /pet/{petId})

## Notes
- Ensure that the base URL in `config.properties` is correct.
- The framework uses Java Faker to generate test data.
- Log4j is used for logging test execution details.

## Future Enhancements
- Add more test cases for other endpoints.
- Improve test data management.
- Integrate with CI/CD pipelines.
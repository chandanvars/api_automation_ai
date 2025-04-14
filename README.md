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
This framework is designed to automate API endpoints for the PetStore application using Java, Rest Assured, and TestNG.

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

## Setup
1. Clone the repository.
2. Configure the `config.properties` file with the base URL.
3. Run the tests using Maven.

## Running Tests
```sh
mvn test
```

## Future Enhancements
- Add more test cases.
- Enhance logging and reporting.
- Integrate with CI/CD pipeline.
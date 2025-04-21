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
This framework is designed to automate the testing of API endpoints in the PetStore application using Java, Rest Assured, and TestNG.

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
1. **Base URL**: Update the `config.properties` file with the base URL of the PetStore API.

## Running Tests
1. **Using Maven**:
   ```
   mvn test
   ```

## Dependencies
- Java 8 or higher
- Maven
- Rest Assured
- TestNG
- Jackson
- Log4j

## Adding New Tests
1. Create a new test class in the `src/test/java/tests/` directory.
2. Use the `ApiUtils` class for making API requests.
3. Use the `TestDataGenerator` class for generating test data.
4. Use assertions to validate the responses.

## Maintaining the Framework
1. Keep dependencies up to date in the `pom.xml` file.
2. Follow the existing project structure for consistency.
3. Add meaningful commit messages for any changes made.

## Contributing
1. Create a feature branch for your changes.
2. Push your changes to the feature branch.
3. Create a pull request to merge your changes into the master branch.
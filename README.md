# api_automation_ai
git init
git branch -M master
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework

# API Automation Framework

This framework is designed for automating API tests for the Petstore application using Java, Rest Assured, and TestNG.

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

## Prerequisites

- Java 8 or higher
- Maven

## Setup

1. Clone the repository:

```sh
$ git clone <repository-url>
$ cd api_automation_ai
```

2. Install dependencies:

```sh
$ mvn install
```

3. Run the tests:

```sh
$ mvn test
```

## Framework Components

- **BaseTest.java**: Sets up the base URI for Rest Assured.
- **ConfigReader.java**: Loads configuration settings from `config.properties`.
- **EndpointHelper.java**: Manages endpoint paths centrally.
- **Pet.java, ResponseModel.java, UploadResponse.java**: POJO classes for serializing and deserializing JSON objects.
- **PetTests.java**: Contains test cases for Petstore API endpoints.
- **TestDataGenerator.java**: Generates test data using Java Faker.
- **ApiUtils.java**: Utility class for API-related helper methods.

## Adding New Tests

1. Create a new test method in `PetTests.java`.
2. Use Rest Assured to make API calls and assertions.
3. Run the tests to ensure they pass.

## Contributing

1. Create a new branch for your feature:

```sh
$ git checkout -b feature/<branch-name>
```

2. Make your changes and commit them:

```sh
$ git commit -m "Description of changes"
```

3. Push your changes to the remote repository:

```sh
$ git push origin feature/<branch-name>
```

4. Create a pull request to merge your changes into the master branch.

## License

This project is licensed under the MIT License.
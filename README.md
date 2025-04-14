# API Automation Framework for Swagger Petstore

## Overview

This framework is designed to automate the testing of the Pet Section endpoints in the Swagger Petstore using Java, Rest Assured, and TestNG.

## Technologies Used

- Java
- Rest Assured
- TestNG
- Jackson
- Log4j

## Framework Structure

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

The configuration settings are specified in the `config.properties` file. This includes the base URL for the API.

## Getting Started

### Prerequisites

- Java 8 or above
- Maven

### Installation

1. Clone the repository:

```sh
$ git clone <repository_url>
```

2. Navigate to the project directory:

```sh
$ cd api_automation_ai
```

3. Install the dependencies:

```sh
$ mvn install
```

## Running Tests

To run the tests, use the following command:

```sh
$ mvn test
```

## Test Cases

The test cases are automated for the following endpoints:
1. Add a new pet (POST /pet)
2. Update an existing pet (PUT /pet)
3. Find a pet by ID (GET /pet/{petId})
4. Find pets by status (GET /pet/findByStatus)
5. Update pet information via form data (POST /pet/{petId})
6. Delete a pet (DELETE /pet/{petId})

## Extending the Framework

To add new endpoints or test cases, create new classes in the appropriate directories and follow the existing coding standards and structure.
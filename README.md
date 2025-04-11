# API Automation Framework

This framework is designed to automate API testing for the Petstore API, focusing on the Pet section endpoints.

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

### Running Tests

To run the tests, use the following command:

```sh
$ mvn test
```

## Project Structure

- **src/main/java/**: Contains the main Java files.
  - **base/**: Contains the base test class.
  - **config/**: Contains configuration utilities.
  - **helpers/**: Contains helper utilities for endpoints.
  - **models/**: Contains POJO classes for API requests and responses.
- **src/test/java/**: Contains the test classes and utilities.
  - **tests/**: Contains the test cases.
  - **utils/**: Contains utility classes for tests.
- **config.properties**: Configuration file for the framework.
- **pom.xml**: Maven configuration file.

## Extending the Framework

To add new endpoints or test cases, create new classes in the appropriate directories and follow the existing coding standards and structure.

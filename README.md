# api_automation_ai

## Project Structure

```
api_automation_ai/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── api/
│   │   │               └── framework/
│   │   │                   ├── ApiClient.java
│   │   │                   ├── ApiService.java
│   │   │                   └── utils/
│   │   │                       ├── ConfigLoader.java
│   │   │                       └── JsonUtil.java
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── api/
│   │   │               └── tests/
│   │   │                   ├── ApiTestBase.java
│   │   │                   └── UserApiTests.java
│   └── resources/
│       └── config/
│           └── application.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6 or higher
- Git

### Clone the Repository
```bash
git clone https://github.com/chandanvars/api_automation_ai.git
cd api_automation_ai
```

### Install Dependencies
```bash
mvn clean install
```

### Configuration
Update the `application.properties` file located in `src/main/resources/config/` with the necessary configurations.

### Run Tests
To execute the test cases, run the following command:
```bash
mvn test
```

## Test Case Details

### ApiTestBase.java
This class contains the setup and teardown methods for the API tests. It initializes the API client and loads the configuration properties.

### UserApiTests.java
This class contains the test cases related to User API. Below are the details of the test cases:

- `testCreateUser`: Validates the creation of a new user.
- `testGetUser`: Validates retrieving user details.
- `testUpdateUser`: Validates updating user information.
- `testDeleteUser`: Validates deleting a user.

Each test method follows the Arrange-Act-Assert pattern and makes use of utility methods provided in the framework for JSON handling and configuration loading.

## Contributing
To contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
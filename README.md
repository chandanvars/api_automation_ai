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
This project is an API Automation Framework designed to streamline the process of testing APIs. It provides a robust structure for writing and executing automated tests for various API endpoints.

## Features
- **Modular Design**: Easily add new tests and endpoints.
- **Comprehensive Reporting**: Detailed test reports with logs.
- **Configurable**: Customizable configurations for different environments.
- **Integration**: Compatible with CI/CD pipelines.

## Getting Started

### Prerequisites
- Git
- Java (version 8 or higher)
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/chandanvars/api_automation_ai.git
    ```
2. Navigate to the project directory:
    ```sh
    cd api_automation_ai
    ```

### Running Tests
1. To run all tests, use the following Maven command:
    ```sh
    mvn test
    ```
2. To generate a test report, use:
    ```sh
    mvn surefire-report:report
    ```

### Project Structure
- `src/main/java`: Contains the main Java source files.
- `src/test/java`: Contains the test cases.
- `src/test/resources`: Contains test resources such as configuration files.
- `pom.xml`: Maven configuration file.

### Writing Tests
1. Create a new test class in `src/test/java`.
2. Write test methods using JUnit/TestNG.
3. Use the provided utility classes for making API requests and assertions.

### Configuration
- **Config File**: `src/test/resources/config.properties`
    - Update the configuration file with the necessary environment settings.

## Contributing
1. Fork the repository.
2. Create a new branch for your feature/bugfix.
3. Submit a pull request with a detailed description of your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact
For any questions or support, please contact [chandanvars](https://github.com/chandanvars).

---

Happy Testing!
# api_automation_ai

# API Automation Framework

This repository contains a framework for API automation using Java, Rest Assured, and TestNG. This document provides instructions on configuring, running, and maintaining the framework.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Maintaining the Framework](#maintaining-the-framework)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or higher installed
- Maven (for dependency management)
- An IDE (like IntelliJ IDEA or Eclipse)
- Git installed on your machine

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/chandanvars/api_automation_ai.git
   cd api_automation_ai
   ```

2. **Build the project:**

   Ensure you have Maven installed and run the following command to build the project:

   ```bash
   mvn clean install
   ```

   This command will download all necessary dependencies specified in the `pom.xml` file.

## Configuration

1. **Update Configuration Properties:**

   Navigate to `src/test/resources` and update the `config.properties` file with your API base URL and any required authentication details:

   ```properties
   base.url=https://api.example.com
   api.key=your_api_key_here
   ```

2. **Set Up Test Environment:**

   Ensure that your test environment is set up correctly. You may need to mock certain endpoints or set up a testing database.

## Running Tests

To run the API tests, you can use Maven commands. Here are the commands for different scenarios:

- **Run all tests:**

   ```bash
   mvn test
   ```

- **Run a specific test class:**

   ```bash
   mvn -Dtest=YourTestClassName test
   ```

- **Run tests with TestNG XML file:**

   Create a TestNG XML file (e.g., `testng.xml`) in the root directory and include your test classes. Run the tests with:

   ```bash
   mvn test -DsuiteXmlFile=testng.xml
   ```

## Maintaining the Framework

1. **Updating Dependencies:**

   To keep the framework up to date, regularly check for new versions of dependencies in the `pom.xml`. You can use the following command to update them:

   ```bash
   mvn versions:use-latest-versions
   ```

2. **Adding New Tests:**

   Create new test classes in the `src/test/java` directory. Follow the naming convention `FeatureNameTest.java` to maintain consistency.

3. **Logging and Reporting:**

   Review test logs and reports generated in the `target/surefire-reports` directory after running tests. Ensure any failures are addressed promptly.

4. **Continuous Integration:**

   Integrate with CI/CD tools like Jenkins or GitHub Actions for automated testing on every commit. Configure the CI tool to run `mvn test` on each push to the repository.

## Contributing

If you would like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Make your changes and commit them:
   ```bash
   git commit -m "Description of your changes"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature
   ```
5. Create a Pull Request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
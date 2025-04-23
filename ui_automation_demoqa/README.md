# UI Automation Framework for DemoQA

## Prerequisites
- JDK 8 or above
- Maven
- ChromeDriver/GeckoDriver

## Setup
1. Clone the repository.
2. Navigate to the project directory.
3. Update `config.properties` with the required configurations.

## Running Tests
To run the tests, execute the following command:
```
mvn test
```

## Adding New Tests
1. Create a new page class in `src/main/java/pages/`.
2. Implement the test methods in `src/test/java/tests/DemoQATests.java`.
3. Add the necessary locators and methods in the page class.

## Project Structure
- `src/main/java/`: Contains the main Java source files.
- `src/test/java/`: Contains the test Java source files.
- `config.properties`: Configuration file for global settings.
- `pom.xml`: Maven configuration file.

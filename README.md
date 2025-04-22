# api_automation_ai

# API Automation Framework for Petstore

This repository contains an API automation framework for testing the Petstore API. The framework is built using Java and RestAssured, providing a robust environment for automated API testing.

## Project Structure

```
api_automation_ai/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── petstore/
│   │               ├── api/
│   │               │   └── PetstoreApi.java
│   │               └── utils/
│   │                   └── ApiUtils.java
│   └── test/
│       └── java/
│           └── com/
│               └── petstore/
│                   └── tests/
│                       ├── PetstoreApiTest.java
│                       └── TestBase.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/chandanvars/api_automation_ai.git
   cd api_automation_ai
   ```

2. **Install Dependencies**
   Make sure you have Maven installed, then run:
   ```bash
   mvn install
   ```

3. **Configuration**
   Update any necessary configurations in `src/main/java/com/petstore/utils/ApiUtils.java` as required for your environment.

## Running Tests

To run the API tests, execute the following command:
```bash
mvn test
```

This command will compile the code and execute all the test cases located in the `src/test/java/com/petstore/tests` directory.

## Contributing

1. Fork the repository.
2. Create your feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your message"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a Pull Request. 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. 

For any questions or issues, feel free to reach out via the repository's issue tracker.
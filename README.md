# api_automation_ai
git init
git branch -M master
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework

## Configuration, Running, and Maintenance Instructions

### Pre-requisites

1. **Java Development Kit (JDK)**
   - Ensure you have JDK 8 or higher installed on your machine.
   - Verify installation by running `java -version` in the command prompt or terminal.

2. **Apache Maven**
   - Install Maven from the official website.
   - Add Maven to your system's PATH.
   - Verify the installation by running `mvn -version` in the command prompt or terminal.

3. **Git**
   - Ensure Git is installed to clone the repository and manage version control.
   - Verify installation by running `git --version`.

### Configuration

1. **Clone the Repository**
   - Run the following command to clone the project:
     ```
     git clone https://github.com/chandanvars/api_automation_ai.git
     cd api_automation_ai
     ```

2. **Set Up Environment Variables**
   - If the project requires any environment-specific variables, set them up in your system or use a `.env` file if supported.

3. **Configure Test Data and Endpoints**
   - Update the configuration files located in `src/test/resources` to point to the correct test data and API endpoints.

### Running the Automation Suite

1. **Build the Project**
   - Navigate to the project directory and run:
     ```
     mvn clean install
     ```
   - This will compile the code and run unit tests.

2. **Execute Tests**
   - To run all tests, execute:
     ```
     mvn test
     ```
   - For running specific test cases, use:
     ```
     mvn -Dtest=TestClassName test
     ```

3. **Generate Test Reports**
   - After test execution, reports will be generated in the `target/surefire-reports` directory.
   - Use tools like Allure for better visualization if needed.

### Maintenance

1. **Update Dependencies**
   - Regularly check the `pom.xml` for outdated dependencies and update them.
   - Use `mvn versions:display-dependency-updates` to check for available updates.

2. **Continuous Integration**
   - Integrate with CI tools like Jenkins or GitHub Actions to automate builds and tests on every commit.

3. **Code Review and Refactoring**
   - Regularly review code quality and refactor as necessary.
   - Use tools like SonarQube for static code analysis.

4. **Documentation**
   - Keep documentation up-to-date with changes in the framework or test cases.

By following these instructions, you can effectively configure, run, and maintain the API automation framework.
# API Automation AI Framework

## Overview

This project provides an automation framework for testing APIs. It is designed to be easily extendable and includes comprehensive logging for all test activities.

## Setup

To set up the API automation framework, follow these steps:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/chandanvars/api_automation_ai.git
   cd api_automation_ai
   ```

2. **Install Dependencies:**

   Ensure you have [Node.js](https://nodejs.org/) installed. Then, install the required dependencies:

   ```bash
   npm install
   ```

## Running Tests

To execute the test suite, use the following command:

```bash
npm test
```

This command will run all the test cases defined in the `tests` directory and output the results to the console.

## Extending the Framework

To add new test cases or extend the framework:

1. **Create a New Test File:**

   Add your test file in the `tests` directory. Ensure your test file follows the existing naming conventions and structure.

2. **Write Your Test Cases:**

   Use the existing test cases as a guide. Make use of the provided utilities and helpers to streamline your test development.

3. **Add Any Required Utilities:**

   If you need new utilities, add them in the `utils` directory. Ensure they are well-documented and tested.

## Logging

The framework includes extensive logging for all test executions. Logs are generated for both test success and failures, and can be found in the `logs` directory.

- **Log Levels:** The framework logs at various levels including `info`, `debug`, and `error`.
- **Viewing Logs:** Use any log viewer or text editor to view the log files in the `logs` directory.

## Contribution

Contributions are welcome! Please fork the repository and submit a pull request. Ensure your code adheres to the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

By following the above instructions, you can set up, run, and extend the API automation framework efficiently. For any further questions or issues, please refer to the issues section on GitHub or contact the project maintainers.
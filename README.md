# API Automation Framework

## Overview
This repository contains an API automation framework designed to streamline testing of RESTful APIs. It is built with best practices for maintainability, scalability, and ease of use.

---

## Project Structure

```
api_automation_ai/
├── config/               # Configuration files and environment settings
├── tests/                # Test cases and test suites
├── utils/                # Utility functions and helpers
├── reports/              # Test reports and logs
├── node_modules/         # Project dependencies
├── .env.example          # Sample environment variables file
├── .gitignore            # Git ignore rules
├── package.json          # npm package manifest
├── README.md             # Project documentation
```

---

## Getting Started

### Prerequisites
- Install [Git](https://git-scm.com/)
- Install [Node.js](https://nodejs.org/) (version 14 or higher)
- Install [npm](https://www.npmjs.com/) or [yarn](https://yarnpkg.com/) package manager

### Installation
1. Clone the repository:
   ```
   git clone https://github.com/chandanvars/api_automation_ai.git
   ```
2. Navigate to the project directory:
   ```
   cd api_automation_ai
   ```
3. Install dependencies:
   ```
   npm install
   ```
   or
   ```
   yarn install
   ```

---

## Configuration

1. Copy `.env.example` to `.env`:
   ```
   cp .env.example .env
   ```
2. Edit the `.env` file to set your environment variables:
   ```
   API_BASE_URL=https://api.example.com
   AUTH_TOKEN=your_auth_token_here
   ```
3. Modify any additional settings in the `config/` directory to match your environment needs.

---

## Running Tests

- To run all tests:
  ```
  npm test
  ```
- To run tests with detailed logging for debugging:
  ```
  npm run test:debug
  ```
- Test reports, including logs and summaries, are generated automatically in the `reports/` directory after each test run.

---

## Framework Maintenance

- Keep dependencies up to date:
  ```
  npm update
  ```
- Ensure code quality and consistency by running lint checks:
  ```
  npm run lint
  ```
- Write clear and maintainable test cases with descriptive names.
- Use meaningful commit messages when pushing changes to the repository.
- Regularly review and refactor tests and utilities to maintain framework health.

---

## Branching Model and Pull Requests

- **Branching**
  - `master` branch contains stable, production-ready code.
  - Create feature branches from `master` using the naming convention:
    ```
    feature/your_feature_name
    ```
  - Create bugfix branches as needed:
    ```
    bugfix/your_bugfix_description
    ```
- **Pull Requests (PRs)**
  - Create PRs from feature or bugfix branches to `master`.
  - Use clear, descriptive PR titles.
  - Include detailed descriptions of changes and link related issues if applicable.
  - Ensure all tests pass before requesting reviews.
  - Reviews must approve PRs before merging.
  - Squash commits to maintain a clean git history.

---

## Contribution Guidelines

- Fork the repository and create your feature branch.
- Write tests for any new functionality or bug fixes.
- Follow existing code style and conventions.
- Submit pull requests with clear, comprehensive descriptions of your changes.

---

## Notes and Best Practices

- Always keep sensitive information such as tokens out of the repository by using environment variables.
- Maintain modular and reusable test code to facilitate scalability.
- Regularly update documentation to reflect changes in the framework.
- Utilize the `reports/` directory to monitor test outcomes and troubleshoot failures.
- Engage with the team through issues and PR reviews to improve code quality.

---

## Contact

For any questions or assistance, please open an issue or contact the repository maintainer.

---

Thank you for using and contributing to the API Automation Framework!
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
This repository contains an API automation framework designed to streamline testing of RESTful APIs. It is built with best practices for maintainability, scalability, and ease of use.

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

- Configure environment variables in `.env` file (copy from `.env.example`):
  ```
  API_BASE_URL=https://api.example.com
  AUTH_TOKEN=your_auth_token_here
  ```
- Modify configuration files in the `config/` directory to suit your environment.

---

## Running Tests

- To run all tests:
  ```
  npm test
  ```
- To run tests with detailed logging:
  ```
  npm run test:debug
  ```
- Test reports are generated in the `reports/` directory after each run.

---

## Framework Maintenance

- Keep dependencies up to date by running:
  ```
  npm update
  ```
- Follow coding standards and linting rules:
  ```
  npm run lint
  ```
- Write clear, maintainable test cases with proper descriptions.
- Use meaningful commit messages when pushing changes.

---

## Branching Model and Pull Requests

- **Branching**
  - `master` branch contains stable, production-ready code.
  - Feature branches should be created from `master` using the naming convention:
    ```
    feature/your_feature_name
    ```
  - Bugfix branches:
    ```
    bugfix/your_bugfix_description
    ```
- **Pull Requests (PRs)**
  - Always create PRs from feature or bugfix branches into `master`.
  - PR titles should be clear and descriptive.
  - Include detailed descriptions of changes, and link related issues if applicable.
  - Ensure all tests pass before requesting a review.
  - Reviewers must approve PRs before merging.
  - Squash commits for a clean history.

---

## Contribution Guidelines

- Fork the repository and create your feature branch.
- Write tests for any new functionality.
- Follow the existing code style and conventions.
- Submit a pull request with a clear description of your changes.

---

## Contact

For any questions or assistance, please open an issue or contact the repository maintainer.

---

Thank you for using and contributing to the API Automation Framework!
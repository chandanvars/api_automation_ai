# api_automation_ai

## Framework Overview
This repository contains the Automation Framework designed to facilitate automated testing of RESTful APIs and UI components. The framework supports test case creation, execution, logging, and reporting, enabling efficient validation of API endpoints, workflows, and UI interactions, with a focus on DemoQA.

## Setup Instructions
1. Clone the repository:
   ```
   git clone https://github.com/chandanvars/api_automation_ai.git
   ```
2. Navigate to the project directory:
   ```
   cd api_automation_ai
   ```
3. Install required dependencies:
   ```
   # Assuming a Python-based framework, adjust accordingly if different
   pip install -r requirements.txt
   ```
4. Configure environment variables or config files as needed (e.g., API base URLs, authentication tokens, browser drivers for UI testing).

## Usage Instructions

### API Automation
- To run all API tests:
  ```
  pytest tests/api/
  ```
- To run a specific API test file:
  ```
  pytest tests/api/test_sample_api.py
  ```
- To generate API reports (if using pytest-html):
  ```
  pytest --html=reports/api_report.html
  ```
- To view detailed logs for API tests, check the `logs/api/` directory or configure logging level in `config.yaml`.

### UI Automation
- To run all UI tests:
  ```
  pytest tests/ui/
  ```
- To run a specific UI test file:
  ```
  pytest tests/ui/test_demoqa_ui.py
  ```
- To generate UI reports (if using pytest-html):
  ```
  pytest --html=reports/ui_report.html
  ```
- To view detailed logs for UI tests, check the `logs/ui/` directory or configure logging level in `config.yaml`.

## Framework Features

### API Automation
- Supports testing RESTful APIs with request validation, response validation, and workflow testing.
- Centralized logging and reporting mechanisms.

### UI Automation
- Provides automated testing of DemoQA's user interface components.
- Capable of validating UI workflows, element interactions, and visual verifications.
- Utilizes Selenium WebDriver for browser automation.

## Logging
- The framework uses a centralized logging mechanism to capture test execution details.
- Logs are stored in the `logs/` directory with subdirectories for `api` and `ui` logs.
- Logging levels can be adjusted in the configuration file (`config.yaml` or equivalent).

## Reporting
- Test execution results are compiled into HTML reports stored in the `reports/` directory.
- Reports provide pass/fail status, error messages, and stack traces for failed tests.
- Separate reports are generated for API and UI tests.
- Integrate with CI/CD pipelines by exporting report artifacts for review.

## Branching Guidelines
- The main branch (`master`) contains stable, production-ready code.
- Feature development should be done on branches named as `feature/<feature_name>`.
- Bug fixes should be done on branches named as `bugfix/<issue_name>`.
- Always create a pull request from your feature/bugfix branch to `master` after completing development.
- Ensure all tests pass and code reviews are completed before merging.

---

## Initial Commit Commands
```
git init
git branch -M master
git checkout -b feature/automation_framework
git add .
git commit -m "Added API and UI automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/automation_framework
```
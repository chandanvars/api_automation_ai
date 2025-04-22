# api_automation_ai

## Framework Overview
This repository contains the API Automation Framework designed to facilitate automated testing of RESTful APIs. The framework supports test case creation, execution, logging, and reporting, enabling efficient validation of API endpoints and workflows.

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
4. Configure environment variables or config files as needed (e.g., API base URLs, authentication tokens).

## Usage Instructions
- To run all tests:
  ```
  pytest tests/
  ```
- To run a specific test file:
  ```
  pytest tests/test_sample_api.py
  ```
- To generate reports (if using pytest-html):
  ```
  pytest --html=reports/report.html
  ```
- To view detailed logs, check the logs directory or configure logging level in `config.yaml`.

## Logging
- The framework uses a centralized logging mechanism to capture test execution details.
- Logs are stored in the `logs/` directory with timestamps.
- Logging levels can be adjusted in the configuration file (`config.yaml` or equivalent).

## Reporting
- Test execution results are compiled into HTML reports stored in the `reports/` directory.
- Reports provide pass/fail status, error messages, and stack traces for failed tests.
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
git checkout -b feature/api_automation_framework
git add .
git commit -m "Added API automation framework and initial test cases"
git remote add origin https://github.com/chandanvars/api_automation_ai
git push -u origin feature/api_automation_framework
```
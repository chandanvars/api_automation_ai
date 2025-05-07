# DemoQA UI Automation Framework

This repository contains a robust and extensible UI automation framework for testing the [DemoQA](https://demoqa.com/) web application. The framework is designed for maintainability, scalability, and traceability, making it suitable for both small and large-scale UI test automation projects.

---

## Table of Contents

- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Project Structure](#project-structure)
- [Usage Guide](#usage-guide)
- [Extensibility](#extensibility)
- [Traceability](#traceability)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **Page Object Model (POM):** Clean separation of page structure and test logic.
- **Cross-browser Support:** Easily configurable for Chrome, Firefox, and Edge.
- **Test Reporting:** Integrated with Allure for rich test reports.
- **Parallel Execution:** Supports running tests in parallel for faster feedback.
- **Data-driven Testing:** Parameterize tests using external data sources (CSV, JSON, Excel).
- **CI/CD Ready:** Easily integrable with Jenkins, GitHub Actions, or other CI/CD tools.
- **Traceability:** Each test case is mapped to requirements and user stories.

---

## Setup Instructions

### Prerequisites

- Python 3.8+
- pip (Python package manager)
- Chrome/Firefox/Edge browser installed
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) / [GeckoDriver](https://github.com/mozilla/geckodriver/releases) / [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/) (ensure the driver is in your PATH)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/chandanvars/api_automation_ai.git
   cd api_automation_ai
   ```

2. **Create and activate a virtual environment (recommended):**
   ```bash
   python -m venv venv
   source venv/bin/activate  # On Windows: venv\Scripts\activate
   ```

3. **Install dependencies:**
   ```bash
   pip install -r requirements.txt
   ```

4. **(Optional) Install Allure for reporting:**
   - [Allure installation guide](https://docs.qameta.io/allure/#_installing_a_commandline)

---

## Project Structure

```
api_automation_ai/
│
├── tests/                  # Test cases organized by feature
│   ├── test_login.py
│   ├── test_registration.py
│   └── ...
│
├── pages/                  # Page Object Model classes
│   ├── base_page.py
│   ├── login_page.py
│   ├── registration_page.py
│   └── ...
│
├── data/                   # Test data files (CSV, JSON, Excel)
│
├── utils/                  # Utility modules (helpers, config, logger)
│   ├── config.py
│   ├── logger.py
│   └── ...
│
├── requirements.txt        # Python dependencies
├── conftest.py             # Pytest fixtures and hooks
├── pytest.ini              # Pytest configuration
└── README.md               # Project documentation
```

---

## Usage Guide

### Running Tests

- **Run all tests:**
  ```bash
  pytest
  ```

- **Run tests for a specific feature:**
  ```bash
  pytest tests/test_login.py
  ```

- **Generate Allure report:**
  ```bash
  pytest --alluredir=allure-results
  allure serve allure-results
  ```

- **Run tests in parallel:**
  ```bash
  pytest -n 4
  ```

### Configuration

- Update `utils/config.py` to set browser, base URL, timeouts, etc.
- Use environment variables or command-line options for dynamic configuration.

---

## Extensibility

- **Adding New Pages:**  
  Create a new class in `pages/` inheriting from `BasePage`. Define locators and actions as methods.

- **Adding New Tests:**  
  Add a new test module in `tests/`. Use Pytest for test functions and fixtures.

- **Custom Utilities:**  
  Place reusable helpers in `utils/` (e.g., custom wait conditions, data generators).

- **Data-driven Tests:**  
  Use Pytest parameterization and load data from files in `data/`.

- **Browser Support:**  
  Extend `config.py` and fixtures in `conftest.py` to add or configure browsers.

---

## Traceability

- **Requirement Mapping:**  
  Each test function includes a docstring referencing the requirement/user story ID.

  ```python
  def test_login_valid_user():
      """
      Requirement: AUTH-001
      User Story: US-101
      """
      ...
  ```

- **Test Reports:**  
  Allure reports provide traceability links and test documentation.

- **Test Case Documentation:**  
  Maintain a mapping document (`docs/traceability_matrix.xlsx`) linking requirements to test cases.

---

## Contributing

1. Fork the repository and create your branch (`git checkout -b feature/your-feature`).
2. Commit your changes (`git commit -am 'Add new feature'`).
3. Push to the branch (`git push origin feature/your-feature`).
4. Create a new Pull Request.

---

## License

This project is licensed under the MIT License.

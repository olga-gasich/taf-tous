# taf-tous

Website selling jewelry in Spanish, its url https://www.tous.com/.

# Overview

The test framework is designed to facilitate automated testing of the tous site. 
It provides a set of tools and utilities to create and run tests, generate test reports, and manage test data.
The framework is based on Page object model and uses DriverSingleton design pattern which ensures its scalability and further support.

# Features

- Easy setup and configuration
- Support for ui and api tests
- Test data management and generation
- Integration with Maven build system
- Test results and coverage information (using Allure tool)


# Getting Started

To use the test framework, follow these steps:

1. Clone the repository: https://github.com/olga-gasich/taf-tous that has public access
2. Run the ui tests locally
3. Run the api tests locally

# Usage

The test framework provides a variety of ui and api tests. 
UI tests include login, items search, add an item to the basket and view it here.
API tests include login and items search.

# Test Reports

As the test framework is integrated locally with Jenkins and Allure tools, the project can be built automatically and tests cases can be running on schedule using crone expression. 
The generated test reports will be displayed in Allure, including test results and coverage information.
These reports can help you identify areas that need more testing and track the progress of your testing efforts.
The test report will be generated in the target/allure-results directory of the project.

# Contact

For any questions or inquiries, please contact the project maintainer at olagasich@gmail.com.
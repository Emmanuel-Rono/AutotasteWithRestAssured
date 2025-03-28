# API Testing Framework

## Overview
This project is a **RestAssured-based API testing framework** designed to automate the testing of RESTful web services. The framework integrates several industry-standard tools to provide a robust testing solution, including:

- **RestAssured** – API testing library for RESTful services
- **TestNG** – Test framework for running tests efficiently
- **Extent Reports** – Library for generating interactive and detailed test reports

This framework is highly flexible and can be used to create API tests for any RESTful application.

---

## Features
✅ **Automated API Testing** – Supports GET, POST, PUT, DELETE requests.  
✅ **Data-Driven Testing** – Uses external data sources (Excel) for dynamic test execution.  
✅ **TestNG Integration** – Provides structured test execution and assertions.  
✅ **Reporting with Extent Reports** – Generates interactive HTML reports with test results.  
✅ **Modular and Scalable** – Designed with reusable components for maintainability.  

---

## Project Structure
```
API-Testing-Framework/
│-- src/
│   ├── api/
│   │   ├── payload/          # POJO classes for request/response handling
│   │   ├── utilities/        # Utility classes (Excel handling, Config, etc.)
│   │   ├── tests/            # API test cases
│-- testData/                 # External test data (Excel)
│-- reports/                  # Extent Report files
│-- pom.xml                    # Maven dependencies
│-- README.md                  # Project documentation
```

---

## Setup Instructions
### Prerequisites
Ensure you have the following installed:
- **Java 8+**
- **Maven**
- **TestNG** (installed via `pom.xml`)

### Installation
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/API-Testing-Framework.git
   cd API-Testing-Framework
   ```
2. **Install dependencies:**
   ```sh
   mvn clean install
   ```
3. **Run API tests:**
   ```sh
   mvn test
   ```
4. **View Test Reports:**
   - Navigate to the `reports/` directory.
   - Open the `ExtentReport.html` file in a browser.

---

## How to Write a New Test
1. **Create a new test class in `api.tests` package**
2. **Use TestNG annotations (`@Test`, `@DataProvider`)**
3. **Use RestAssured for API calls**
4. **Use assertions for validation**

Example:
```java
@Test(dataProvider = "Data", dataProviderClass = api.utilities.DataProviders.class)
public void testPostUser(String userID, String userName, String firstName, String lastName, String userEmail, String passWord, String phone) {
    User userPayLoad = new User();
    userPayLoad.setId(Integer.parseInt(userID));
    userPayLoad.setUsername(userName);
    userPayLoad.setFirstName(firstName);
    userPayLoad.setLastName(lastName);
    userPayLoad.setEmail(userEmail);
    userPayLoad.setPassword(passWord);
    userPayLoad.setPhone(phone);

    Response response = UseEndPointsImpl.CreateUser(userPayLoad);
    Assert.assertEquals(response.getStatusCode(), 200);
}
```

---

## Test Execution
Run tests using:
```sh
mvn test
```
To execute a specific test class:
```sh
mvn -Dtest=TestClassName test
```

---

## Reporting
- After test execution, reports will be generated in the `reports/` folder.
- Open `ExtentReport.html` in a browser to view results.

---

## Contributing
1. **Fork the repository**
2. **Create a feature branch:**
   ```sh
   git checkout -b feature-new-test
   ```
3. **Commit changes:**
   ```sh
   git commit -m "Added new API test"
   ```
4. **Push and create a pull request**

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For any issues or contributions, feel free to reach out via GitHub Issues.

---
Happy Testing! 🚀


# REST Assured API Automation Framework

This repository contains a robust and modular API automation testing framework built using **Java**, **REST Assured**, and **TestNG**. The project is structured to follow clean coding practices and simulate real-world testing scenarios commonly encountered in product-based organisations and FinTech domains.

---

## 📌 Tech Stack

- Java 11
- REST Assured
- TestNG
- Maven
- GitHub Actions (CI-ready)
- JSON / POJO-based payloads
- RequestSpecification for scalable test writing

---

## 🧪 Features

- Structured test suite for CRUD (Create, Read, Update, Delete) operations.
- Professional-style framework separation (Base classes, Utils, Payloads, Endpoints).
- Reusable `RequestSpecification` setup to reduce code duplication.
- Data-driven testing using `@DataProvider`.
- Assertion handling using `Assert` for clean validations.
- Follows best practices of `Given-When-Then` REST Assured syntax.

---

## 🔖 Folder Structure
RestAssuredFramework/

├── src/

└── test/

├── java/

├── com.api.base/

├── com.api.endpoints/

├── com.api.payloads/

├── com.api.tests/

└── com.api.utils/

└── resources/

├── pom.xml

├── testng.xml

└── README.md

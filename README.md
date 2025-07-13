# Dmoney Portal Automation 

This repository consists of **API Automation** using **Rest Assured**, **Selenium**, **TestNG**, and **Java**.  
The automation framework follows the **Page Object Model (POM)** design pattern for better maintainability and scalability.

Website: https://dmoneyportal.roadtocareer.net

I have automated the **user creation** process for **Customer**, **Agent** and **Merchant** roles. Additionally, several **transaction-related operations** have been automated, such as:
- Send Money  
- Agent to Customer Deposit  
- Money Withdrawal  
- Customer Payment  

Comprehensive **assertions** and **negative test cases** have been implemented for each scenario to ensure robust validation.

Manual and automated API testing has also been performed using **Postman**, and all test results are visualized using **Allure Reports**.


## 🛠 Technology Used

* **Language**: Java
* **Automation Tool**: Selenium WebDriver
* **Test Framework**: TestNG
* **Build Tool**: Gradle
* **Design Pattern**: Page Object Model (POM)
* **Data Files**: `users.json`, `user.csv`
* **End-to-end API test scenarios using** Rest Assured
* **Manual & automated API testing using** Postman

## How to run this project
1. Clone the repository.
   
2. Run the test suite:

   ```bash
   gradle clean test
   
3. Generate Allure report:

   ```bash
   allure generate allure-results --clean -output 
   allure serve allure-results
   ```
## Postman Documentation: 
https://documenter.getpostman.com/view/24475549/2sB2qi9yKq


---
## Allure Report(Overview and Behaviour)
![15](https://github.com/user-attachments/assets/0649d0cd-9221-4d6b-9db1-2370ebcda97c)
![16](https://github.com/user-attachments/assets/ee81740f-c1c3-4e54-afef-9d0656dd889c)


## Automation Video

![Watch the Test Automation](https://github.com/user-attachments/assets/3d8609c3-04aa-4169-bc5e-1d3bf44403df)


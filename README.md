# User Tests Automation

## Description
This project contains automated tests for user login and registration functionalities. The tests are written using Selenium WebDriver and TestNG in Java. The purpose of these tests is to ensure the login and registration features work as expected under various conditions.

## Technologies Used
- Selenium WebDriver
- TestNG
- Java
- Maven (for dependency management)

## Test Scenarios
- **Successful Login**: Verifies that a user can successfully log in with valid credentials.
- **Invalid Login Credentials**: Verifies that the system shows an error message when invalid credentials are entered.
- **Empty Email Field**: Verifies that the system displays an error message when the email field is left empty.
- **Empty Password Field**: Verifies that the system displays an error message when the password field is left empty.
- **Successful Registration**: Verifies that a user can successfully register with valid details.
- **Username Already In Use**: Verifies that the system shows an error when a user tries to register with an already taken username.
- **Empty Username Field**: Verifies that the system displays an error message when the username field is left empty.
- **Email Already In Use**: Verifies that the system shows an error when a user tries to register with an already taken email.
- **Invalid Email Format**: Verifies that the system displays an error when the email entered is in an invalid format.
- **Weak Password**: Verifies that the system displays an error when a weak password is entered (less than 6 characters).
- **Adding a Product to the Cart**: Verifies that a user can successfully add a product to the shopping cart and that the cart is updated accordingly.

## How Page Object Model (POM) is Used
In this project, the **Page Object Model (POM)** design pattern is used to separate the test scripts from the web page's structure and functionality. This pattern helps in maintaining and managing the tests efficiently.

### Structure
- **Page Classes**: Each web page (like `LoginPage`, `RegistrationPage`, `HomePage`, etc.) has its own corresponding page class where all the elements and actions for that page are defined. The page classes contain methods to interact with web elements (such as entering text, clicking buttons, or getting error messages).
- **Base Class**: A base class (`BaseClass`) is used for initializing the WebDriver and for handling common actions such as clicking elements, sending keys, and waiting for elements.
- **Test Class**: The test classes contain the test scenarios where the corresponding page objects are instantiated and used to perform actions.

By using POM, the tests are made more readable and maintainable, and any changes to the page layout or elements will only require modifications in the respective page class, rather than updating the entire test script.




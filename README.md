# ATM Interface

## About the Project

The ATM Interface is a console-based Java application developed as part of the OASIS INFOBYTE Java Development Internship. It simulates basic ATM operations such as checking account balance, depositing money, withdrawing money, transferring funds, and viewing transaction history.

The application uses PIN authentication to control access and allows a maximum of three PIN attempts.

## Features

- PIN authentication with a maximum of three attempts
- Check account balance
- Deposit money
- Withdraw money
- Transfer funds to a specified recipient
- View transaction history with date and time
- Input validation for menu options and transaction amounts
- Simple menu-driven console interface

## Technologies Used

- Java
- Object-oriented programming
- Scanner class for user input
- ArrayList for transaction history
- LocalDateTime for transaction timestamps
- Eclipse IDE

## Project Structure

```text
ATMInterface/
├── src/
│   ├── ATMInterface.java
│   ├── ATM.java
│   ├── BankAccount.java
│   ├── Transaction.java
│   └── PinAuthenticator.java
└── README.md
```

## How to Run

1. Install JDK 21 or another compatible Java version.
2. Clone or download this repository.
3. Import the project into Eclipse IDE or another Java IDE.
4. Create the five Java classes listed in the project structure.
5. Copy the corresponding source code into each class.
6. Run `ATMInterface.java` as a Java application.
7. Enter the demo PIN to access the ATM menu.

## Demo Credentials

- PIN: `1234`
- Initial balance: Rs. 5,000.00

These credentials are for demonstration purposes only.

## Learning Outcomes

This project provides practical experience with Java classes and objects, encapsulation, conditional statements, loops, collections, input validation, and basic transaction processing.

## Limitations

This is an educational simulation. Account information and transaction history are stored in memory and are reset when the application is restarted. Transfers are simulated and do not involve real bank accounts or payments.

## Author

Ajay Kumar

Java Development Internship  
OASIS INFOBYTE

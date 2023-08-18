# EldarApp Challenge - Credit Card Transaction Processor

EldarApp is a Java-based application designed to process credit card transactions, calculate transaction rates based on card brands, and expose RESTful APIs for querying the transaction rates.

## Features

- Process credit card transactions.
- Validate transaction amounts and card expiration dates.
- Calculate transaction rates based on card brands: VISA, NARA, and AMEX.
- RESTful API to query transaction rates by providing card brand and amount.

## System Requirements

- Java JDK 17 (BellSoft Liberica JDK is recommended).
- Maven for dependency management.
- Spring Boot 3.1.2 for application framework.


## Getting Started

1 - Clone the Repository:
```
 git clone https://github.com/YourGitHubUsername/EldarApp.git 
```

2 - Navigate to the directory:
```
cd EldarApp
```

3 - Build the project:
```
 mvn clean install
```

4 - Run the Application:
```
mvn spring-boot:run
```
5 - Once the application starts, the RESTful API will be available at: 
 http://localhost:8080/

## API Usage

#### Get Transaction Rate
Fetches the transaction rate based on the provided card brand and transaction amount. 

- Endpoint: /transaction/rate
- Method: GET
- Parameters:
   * brand (required): The brand of the credit card (e.g., VISA, NARA, AMEX).
   * amount (required): The transaction amount.


 Examples:
 #### 1 - Fetching rate for VISA card with a transaction amount of 100:
```
curl -X GET 'http://localhost:8080/transaction/rate?brand=VISA&amount=100'
```
#### 2 - Fetching rate for NARA card with a transaction amount of 250:
```
curl -X GET 'http://localhost:8080/transaction/rate?brand=NARA&amount=250'
```
#### 3 - Fetching rate for AMEX card with a transaction amount of 500:
```
curl -X GET 'http://localhost:8080/transaction/rate?brand=AMEX&amount=500'
```

#### 4 - Trying to fetch rate for an unsupported card brand:
```
curl -X GET 'http://localhost:8080/transaction/rate?brand=UNSUPPORTED&amount=100'
```
#### 5 - Fetching rate for VISA card with a large transaction amount (should return an error since the amount is too high):
```
curl -X GET 'http://localhost:8080/transaction/rate?brand=VISA&amount=1500'

```

## Running Tests

Execute the following command to run the unit tests:
```
mvn test
```


## Demonstrative Main Method

The Main class in the com.demo.eldarApp package provides a hands-on demonstration of the application's core functionalities. This class is designed to fulfill the requirements of Exercise 1 and acts as a driver program to showcase the application logic without the overhead of a web framework.

### What does the Main class do?
- Card Objects Creation: Three sample card objects are created with different brands and details.
Display Card Information: The details of each card are printed to the console.
- Transaction Validity: Two transactions are created, and their validity is checked based on the amount.
- Card Validity: The expiration date of the cards is checked to determine if they are valid for transactions.
- Card Uniqueness: The program checks if two cards are the same or different.
- Rate Calculation: The transaction rate is calculated based on the brand of the card and the transaction amount. Any errors during this operation, such as an invalid brand, are caught and displayed.

### How to Run the Main Method:
You can execute the Main class directly from your IDE to see the application logic in action. This will provide a console-based demonstration of the functionalities mentioned above.

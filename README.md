# Java Credit Card Processing Application

### Student ID: 017463602 
### Subject: CMPE 202

This application is developed using Java implementing various Design Patterns. This Application lets the user provide the Credit Card records, and it determines the type of the credit card.
The application accepts the records in various files including CSV, JSON, XML. The application reads a record from the file, verifies that the credit card number is a possible account number, and creates an instance of the appropriate credit card class. The input files should contain credit card information such as credit card number, expiration date, and the name of the cardholder.
The design patterns implemented are:
1.	Strategy Pattern
2.	Factory Pattern

## How to Run This?
-	Clone the Repository.
-	Open the project in any IDE (Ex: IntelliJ)
-	This is a maven project, so all the dependencies which are defined in the pom.xml file will be automatically downloaded.
-	Run the class CreditCardClient as given below
    -	Open the class CreditCardClient in IDE.
    - The input files are present in the folder src/main/resources/input/ folder.
    - The output files will be created in the folder src/main/resources/output/ folder.
    -	The input files and input files can be modified by using the appropriate variables present in the main() function.
    -	Run the main() function to see the application in action.

## Describe what is the primary problem you try to solve?
The primary problem that I have tried to solve here is to read the file, that contains records of the credit cards,and for each record based on credit card number, expiration date, and the name of the card holder verify if the credit card number is a possible account number and create an instance of the appropriate credit card class among the given credit card types. - Master, Discover, Visa and American Express.

## Describe what are the secondary problems you try to solve (if there are any).
The secondary problems that l've come across are as below -
1.	how to parse the files
2.	how to choose and efficiently implement appropriate design patterns.


## Describe what design pattern(s) you use and how (use plain text and diagrams).
The design patterns that I've implemented are:
### 1. Strategy Pattern
-	Strategy Design pattern allows changing the behaviour of an application based on the selected strategy.
-	Since there are different file types, objects for each file type are created and appropriate strategies are used based on the input file.
-	I used a strategy design pattern to support different file formats.
-	I have created 3 different interfaces CsvFileHandler, JsonHandler and XmlHandler. All these are extended to a file parser. Based on the input, the behaviour changes.
  
### 2. Factory Pattern
-	Factory pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
-	Since there are various types of cards, With an interface called cardFactory, implements it to return a created object of the card type.

## Describe the consequences of using this/these pattern(S).
Ans: Strategy pattern: With usage of strategy pattern, the context becomes independent of concrete strategies, so you can add new implementations or modify existing ones without changing the code of the context or other strategies. Hence, now the code supports sv, xml and json file formats and could be extended further for any file types by just writing another class and adding it to strategy pattern. Factory pattern: The Factory Method separates construction code from the code that actually uses. Therefore, it's easier to extend the construction code independently from the rest of the code. Currently code supports VisaCC, MasterCC, American express ,Discover, to add a new card type to the app, you'll only need to create a new creator subclass and override the factory method in it.

## Part 2:
Here the given question is to extend the code to read input from (ison, xml, csv) different types, hence we use Strategy pattern to scan the file extension, based on the file extension type, that particular file parser class is executed.

## Class Diagrams
(Kindly click on the images and zoom for clarity - Thank you)

•    UML Class Diagram for Factory Pattern Implementation

 ![image](https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/d2c730d6-eec2-49d4-96ff-397da6a4f767)

•	UML Class Diagram for Strategy Pattern Implementation!

 ![image](https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/afb8cc9b-49cc-4406-bcbf-468a8c2bdafd)


## Sample testcases
- CSV Input
<img width="468" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/0ed7e905-9640-43f2-81e2-1da28b0b8dc8">

- CSV Output
<img width="468" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/a505ac7c-6764-4e0c-a581-7105ef6032be">

- XML Input
<img width="440" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/a0bdb39d-2941-477e-8d9b-e5faa703f287">

- XML Output
<img width="440" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/fcef8c0b-3c0b-462a-b3c1-c6f29e63df96">

- JSON Input
<img width="440" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/ba46105a-7898-409b-863d-d830f615364e">

- JSON Output
<img width="440" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/9f948be3-5a3e-43fe-b296-d90fdfef2aae">

- JUnit Test cases
<img width="468" alt="image" src="https://github.com/gopinathsjsu/individual-project-cxx5208/assets/76988460/282a9ebf-d397-42ab-9587-d4aea82e8091">









 

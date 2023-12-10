# Java Credit Card Processing Application

### Student ID: 017463602 
### Subject: CMPE 202

This application, developed in Java, employs various design patterns to determine credit card types based on user-provided records. It supports multiple file formats, including CSV, JSON, and XML, and reads credit card details like card number, expiration date, and cardholder's name.

The application leverages these design patterns:

##### 1.Strategy Pattern
- Flexibility in Processing: Enables runtime selection of the right algorithm for handling various file formats like CSV, JSON, and XML.
- Easy to Extend: New file formats can be added without altering the existing code.
- Decouples Algorithm: Separates the file processing algorithms from the client code, leading to cleaner, more maintainable code.

##### 2.Factory Pattern
- Simplifies Object Creation: Encapsulates the logic of creating credit card instances based on the provided information.
- Centralized Creation Logic: Makes it easier to manage and modify the creation process of credit card objects in the future.
- Provides Flexibility: New credit card types can be added without changing the client code, adhering to the open/closed principle.

## Steps to Run the Application:
- First, download the code by cloning the repository.
- Open the project in an Integrated Development Environment (IDE), such as IntelliJ IDEA.
- As this is a Maven project, any dependencies listed in the **'pom.xml'** file will automatically be downloaded.
- To start the application, execute the **CreditCardClient** class:
    * Find and open the **CreditCardClient** class within your IDE.
    * Input files are located in the **'src/main/resources/input/'** directory.
    * Output files will be generated in the **'src/main/resources/output/'** directory.
    * You can adjust the input and output files using the corresponding variables in the main() function.
    * Run the main() function to initiate the application and observe its functionality.

# Read Me First

# Create 2 REST services: 
    - one that allows to register a user 
    - and the other one that displays the details of an registered user.
    - You don’t need to spend too much time on this exercise – few hours, 
    - the goal is to be able to quickly check your code!

Requirements:
* define a user (what are the fields needed). We should have mandatory and optional fields!
  - User 
  - UserRQ

* validate the input and return proper error messages/http status
  - UserRQ
  - UserController

* log the input and output of each call and the processing time.
  - LoggingAdvice

* have a request parameter which is not mandatory and which provides a default value in case is not set
  - UserController

* have a path variable
  - UserController
* clear code and javadoc
  + Clear code
    - Folder structure 
    - Format
  + Javadoc
    - UserSV
    - LoggingAdvice
* unit tests
  - UserControllerTest

* only adults ( age > 18 years) and that live in France can create an account!
  Bonuses:
* user a non*relational DB in order to save the users!
* use AOP
* documentation/UML/schemas to explain the architecture

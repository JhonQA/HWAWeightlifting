Coverage Main: 67%
# HWA Weightlifting

A full stack application done as the second project as a part of the QA Academy. Consists of an CRUD record system in Java/Spring which also uses Front end technologies like HTML/CSS/JavaScript. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
* Eclipse IDE (or a suitable Java IDE equivalent)
* MySql
* Maven
* Visual Studio Code
* Bash (or an equivalent. To run the Jar file)
* Web Explorer

```

### Installing

A step by step series of examples that tell you how to get a development env running

* Start off by cloning the master branch of this repository.

* Once cloned, open the project in the IDE of your choice or access the application directly via the Jar file in git Bash.

* Import the maven project into the IDE. Once done, modify the application-prod.properties so that the database credentials correspond with your own. Run either the test or production. Found inside:
```
src/main/resources/application-prod.properties
```
```
src/main/resources/application.properties
```

* Once setup, open the WeightliftingApplication.java class and run the application as a Spring Boot App. This will start the application and connect to the database. Ready to go. Once running the console will tell you what port you are running on. From there connect to the front end via:

```
Localhost:”specified port here”
```

To access the application using the Jar file. Access Target sub-folder via git bash and run the application using the following command:

```
java -jar Weightlifting-0.0.1-SNAPSHOT.jar

```

## Running the tests

All tests are found under
```
src/test/java
```


### Unit/Integration & Selenium Tests 

Unit testing is an approach to testing which targets fundamental building blocks in an application with the idea of proving that each ‘unit’ of the application is functioning as expected. 

Unit testing is an automated process (reusable and provides reliable results) aswell as a white-box testing approach which means that the code being tested is known to the user.

Integration testing is an approach to testing which software modules are integrated logically and tested as a group. The purpose of this type of testing is to expose defects in the interactions between these modules when they are integrated

Mockito is used in the unit test which is used to simulate user input when objects are created.

Run the tests in your selected IDE by running the application in Junit test.

An option to run the project in ‘Coverage As’ is available in Eclipse.

For Selenium Testing: Have the application properties found in src/main/resources set to “test”.
Must have one record added in database at the start of testing. This can be done by adding a record in the front end after you start the server.

Each Update and delete is tied to the id of that row which is unique. so the test will work once and not after for Update and Delete. To test these multiple times, you must increment the id of the “Change the PR!” button, the modal window and the update/delete button in the Modal. Further comments found in the WeightliftingIndexTest.java class.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Elipse](https://www.eclipse.org/) – Java IDE
* [MySql](https://www.mysql.com/) – MySql
* [Visual Studio Code] (https://code.visualstudio.com/) – Visual Studio
* [Spring] (https://spring.io/) – Spring
* [Bootstrap] (https://getbootstrap.com/) - Bootstrap
* [Jira Board]( https://jhon-urrego.atlassian.net/jira/software/projects/HOB/boards/4/backlog) – Jira Board




## Versioning

We use [SemVer](http://semver.org/) for versioning.

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thank you to all the trainers Savannah,Aswene,Vinesh.



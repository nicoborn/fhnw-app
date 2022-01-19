# ExpenseTracker

This is an expense tracker, enabling the functionalities of managing expenses as well as crypto investments.
The web application is currently being developed and a initial version has been deployed to Heroku.

It can be accessed under the following URL: https://fhnw-project.herokuapp.com/

An account with existing expenses and investments:

Username: born.nico@gmail.com

Password: <empty>

#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic Design](#business-logic-design)
  - [Endpoint Design](#endpoint-design)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Deployment](#deployment)
- [User Guide](#user-guide)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)

## Analysis

### Scenario

The expense tracker allows companies, organizations and individuals to keep an overview of their finances. Since receipts are easy to lose and a transaction history can easily get lost, this tracker app provides an overview and the ability to add, edit, delete expenses and crypto investments. Users are also able to receive analytical data on their expenses and investments.

### User Stories
1.	As a user, I want to have a Web app so that I can use it on different mobile devices and on desktop computers.
2.	As a user, I want to navigate through the WebApp and find all the functions in a easy way.
3.	As a user I can log-in after authorizing myself with a username and password.
4.	As a non-user, I want to register an account by entering my name and desired username + password.
5.	As a user, I want to have a dashboard after i login.
6.	As a user, I want to use list views so that I can explore and read my expenses.
7.	As a user, I want to be able to add, edit and delete my expenses.
8.  As a user, I want to use list views so that I can explore and read my crypto investments.
9.  As a user, I want to be able to add, edit and delete my crypto investments.
10. As a user, I want to be able to see the current price of my crypto investments.
11. As a user, I want to be able to see analytics on my expenses and crypto investments.
12. As a user, I want to be able to change my name, email and password.

### Use Case
<img width="248" alt="image" src="https://user-images.githubusercontent.com/82437415/150107124-37feba59-f9a8-408d-908e-7b7de3dac7b4.png">

- UC-1 [Login]: Users can log-in after authorizing themselves with a valid username and password.
- UC-2 [Register account]: New users can register themselves with their name, username and password.
- UC-3 [Dashboard]: Users will see a dashboard after they successfully logged in.
- UC-4 [View expenses]: Users can view their existing and already added expenses.
- UC-5 [Edit expenses]: Users can create, read, update and delete expenses. 
- UC-6 [View investments]: Users can view their existing and already added crypto investments. 
- UC-7 [Edit expenses]: Users can create, read, update and delete crypto investments. 
- UC-8 [Investment prices]: Users can view the current prices of their crypto investments.
- UC-9 [Analytics]: Users can view analytical data of their expenses and crypto investments.
- UC-10 [Profile]: Users can update their profile data (name, username, password).

## Design

### Prototype Design

A bootstrap based static prototype has been created by using a prototyping application. 

In this case, the prototype application Bootstrap Studio has been used to create a basic user interface design based on an HTML grid, Bootstrap CSS and JavaScript, including the selection of web fonts and font-based icons.

The assets (HTML, CSS, JavaScript, image and font files) has been exported and will be extended in the later during implementation with jQuery, to build a dynamic website.

### Domain Design

The `ch.fhnw.acrm.data.domain` package contains the following domain objects / entities including getters and setters:

![](images/domain-model.png)

### Business Logic Design

The package 'https://fhnw-project.herokuapp.com/' contains the data of created persons. With this data, users are created who can store information about their spending.

![](images/business-service.png)

### Endpoint Design
**Path**: [`/api/expense`](/api/expense) 

**Method:** `POST`

**Sample Request**  • *Header:* `Content-Type: application/json` • *Body:*

```JSON
{
  "name":"Abendessen",
  "description":"Restaurant Classico Arlesheim",
  "amount":80.0,
  "expenseDate":"2022-01-15",
  "category":{
      "id":1,
      "name":"Nahrung"
  }
}
```
  
**Success Response**  • *Code:* `200 OK` • *Sample Body:*

```JSON
{
  "name":"Abendessen",
  "description":"Restaurant Classico Arlesheim",
  "amount":80.0,
  "expenseDate":"2022-01-15",
  "category":{
      "id":1,
      "name":"Nahrung"
  }
}
```

**Error Response** • *Code:* `404 NOT FOUND`

## Implementation

### Backend Technology
This Web application is relying on [Spring Boot](https://projects.spring.io/spring-boot) and the following dependencies:

- [Spring Boot](https://projects.spring.io/spring-boot)
- [Spring Web](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
- [Spring Data](https://projects.spring.io/spring-data)
- [Java Persistence API (JPA)](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)
- [H2 Database Engine](https://www.h2database.com)
- [PostgreSQL](https://www.postgresql.org)

To bootstrap the application, the [Spring Initializr](https://start.spring.io/) has been used.

Then the following further dependencies has been added to the project `pom.xml`:

- Swagger and Swagger UI:
```XML
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

- Java HTML Parser and JWT:
```XML
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-gson</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
```

### Frontend Technology
This Web application is relying on the following frontend technology/libraries:

- jQuery
- Bootstrap

## Deployment
This spring boot has been deployed to Heroku by using a pre-configuration scripts `app.json` and `Procfile`.

## User Guide
The Web application can be accessed over the browser by using the following address: `https://***.herokuapp.com/`. And the Swagger-UI can be access using the specific page: `https://***.herokuapp.com/swagger-ui/`.

## Project Management

### Roles
- Head of the Project: Nico Born
- All-rounder: Marino Bottacin
- All-rounder: Laurent Zeugin
- All-rounder: Kenan Ahmetasevic

### Milestones
![](images/project-phases.png)

1.	Planning and strategy: definition of goals
2.	Requirements: Specifications, use case analysis
3.	Design: conception
4.	Layout: create website
5.	Implementation: technical implementation, implementation of business logic and API
6.	Test: testing: final acceptance
7.	Launch: Launch of Web application on Heroku


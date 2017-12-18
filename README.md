# SpringBootREST
A REST Api based on Spring Boot, JPA, MYSQL and a Client web based GUI built on Spring Boot, Thymleaf and AngularJS

SpringBootRESTApi

A REST Api to store and retrieve user information.

Technology
	•	Spring Boot
	•	Spring Security (BCryptPasswordEncoder)
	•	Java Persistence API
	•	MYSQL Database

Usage
	•	Run the application and go on http://localhost:8080/
	•	Use the following urls to invoke controllers methods and see the interactions with the database:
	
GET requests:
	◦	/users/: create a new user with an auto-generated id and email and name as passed values.
	◦	/users/email/{email}: retrieve user(s) by email, (replace dot (“.”) with underscore (“_”) in email.
	◦	/users/{id}: retrieve user by id.

POST request:
	◦	/users/: create a new user by passing id, name, email, key and password.
PUT request:
	◦	/users/: update users sending same key-values as above (post request).
DELETE request:
	◦	/users/{id}: delete users by sending id as a delete request).


Build and run
Prerequisites
	•	Java 7
	•	Maven 3
	•	MYSQL Database

Configurations
Open the application.properties file and set your own configurations for the database connection.
Create your database and enter the name in “your_database_name”. 
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?autoReconnect=true&useSSL=false

Set “your_username” and “your_password” also.
spring.datasource.username=your_username
spring.datasource.password=your_password

From terminal
Go on the project's root folder, then type:
$ mvn spring-boot:run

From IntelliJ
Open project and run it as Spring Boot App.


SpringBootRESTClient

Web based client GUI to access retrieve and post data from the REST Api.

Technology
	•	Spring Boot
	•	AngularJS (1.5.3)
	•	Thymeleaf
	•	Apache HttpComponents

Usage
	•	Run the application and go on http://localhost:8090/
	•	Use the GUI to show, create, update and delete users.


Build and run
Prerequisites
	•	Java 7
	•	Maven 3

Configurations
Open the application.properties file and set your own configurations server port.
Change server port to “your_port”. (default port=8090)
server.port=your_port

From terminal
Go on the project's root folder, then type:
$ mvn spring-boot:run

From IntelliJ
Before running from IDE open pom.xml and change (uncomment) from:
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
	<version>1.5.3.RELEASE</version>
</dependency>
to:
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring4</artifactId>
	<version>3.0.0.RELEASE</version>
</dependency>
Open project and run it as Spring Boot App.

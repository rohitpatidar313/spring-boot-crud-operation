Spring Boot CRUD REST API
========

+ [Introduction](#introduction)
+ [Technology Stack](#technology-stack)
+ [Infrastructure](#infrastructure)
+ [API Details](#api-details)
+ [Local setup](#local-setup)
+ [Try Demo](#try-demo)


## Introduction
REST APIs to demonstrate CRUD operations using Person object.


## Technology Stack
Below technology stack is used in this application
1)  Java : 1.8
2)	Spring Boot: 2.2.3.RELEASE
3)	H2 : 1.4.193
4)	Swagger2 : 2.9.3
5)	Spring Actuator : 2.2.3
6)  Spring Security : 2.2.3
7)  Maven : 3.x.x
8)  GIT


## Infrastructure
AWS


## API Details

	* REST APIs explained in detail: http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/swagger-ui.html

1) **Add Person**

    This resource is used to add person.

    * Dev URL : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/api/v1/person
    * Method : POST
    * Response HTTP code : 200 for Success


2) **Modify Person Detail**

    This resource is used to initiate modify person details.

    * Dev URL : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/api/v1/person/{firstName}
    * Method : PUT
    * Response HTTP code : 200 for Success


3) **Retrieve Person Detail**

    This resource is used to retrieve person details.

    * Dev URL : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/api/v1/getPersonDetails/{firstName}
    * Method : GET
    * Response HTTP code : 200 for Success


4) **Remove Person**

    This resource is used to remove person details from the system.

    * Dev URL : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/api/v1/person/{firstName}
    * Method : DELETE
    * Response HTTP code : 200 for Success

4) **Remove All Person**

    This resource is used to remove all person details from the system.

    * Dev URL : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/api/v1/persons/removeAll
    * Method : DELETE
    * Response HTTP code : 200 for Success

## Local setup

1) Clone repository from : 
2) Run maven clean install in Intellij/Eclipse.
3) Run application.

## Try Demo
1) Go to link : http://springcrud-env.mjpt9zqb4h.us-east-2.elasticbeanstalk.com/swagger-ui.html
2) Expnad person-rest
3) Open any API and click "Try it out".
4) Fill the required fields and "Execute".
5) Enjoy the reponse.
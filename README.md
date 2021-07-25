# cgi-code-challenge
===================================================================================

I have choosen SpringBoot REST Services for the following reasons:
  portablity, reusability, performance, manageable and scalablity


===================================================================================
Order Service Api - Silver Bars Marketplace
===================================================================================
Tech-Stack :
    spring-boot - 2.5.3
    Java - 1.8
    Swagger - 2.9.2
    Lombok
    DB - H2

How to run :
    mvn spring-boot:run

How to test (API Documentation) :
    Swagger link : http://localhost:8090/swagger-ui.html?urls.primaryName=CORE#/

Integration Tests :
    JUnit integration tests have been provided using in-memory database H2

How to access H2 database :
    http://localhost:8090/h2-ui

====================================================================================
Know Issues:
  since the application uses Lombok third party dependency, it may not work on Eclipse IDE.
  The lombok jar file as to be configured for Eclipse
  Below link to configure lombok jar to eclipse ide.
  https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/


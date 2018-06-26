**DMV registration**
-
Simple application used for registering cars.


DMV Service is the entry point into the application. It exposes different endpoints.(Eg. GET /registrations/{id}), contains business related logic.
Behind the scenes DMV Service is making calls to registration repository to retrieve data related to registrations, to car repository service to retrieve car information data 
and to owner repository service to retrieve owner related data.


**Components**
-

- Config Service - Service configuration provider
- Eureka service - Discovery service
- Registration repository - Service for accessing Registration Table
- Owner repository - Service for accessing Owner Table
- Car repository - Service for accessing Car Table 
- DMV service - Provides a REST service for access from the outside. 
                Also in this service all the business related logic of the application is present.


***Build project***
 
 ```mvn clean install```
 
 ***Start services***
 
 ```java -jar <<jar name>>```
 
 ***Components Starting order***
 
 ```config-service```,
 ```eureka-service```,
 ```registration-repository```,
 ```owner-repository```, 
 ```car-repository```, 
 ```dmv-service```

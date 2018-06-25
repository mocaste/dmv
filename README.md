**DMV registration**
-
Simple application used for registering cars.

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
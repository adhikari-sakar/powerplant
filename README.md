## Power Plant

### Introduction

This is an application for a virtual power plant system for aggregating distributed power sources into a single cloud based energy provider.

### Implementation
- Spring boot 2.7.10 
- H2 as InMemory DB. 

### Requirements
- Java 11
- Maven
- Lombok Support
- Enable Annotation Processor

### Properties:

| property                     |      sample value      | description      |
|------------------------------|:----------------------:|------------------|
| `server.port`                |          8080          | server http port |
| `spring.datasource.url`      | jdbc:h2:mem:powerplant | db url           |
| `spring.datasource.username` |           sa           | db user name     |
| `spring.datasource.password` |                      | db password      |



### Run Instruction
- mvn clean install
- `./mvnw spring-boot:run` or `mvn spring-boot:run` or `java -jar target/powerplant-0.0.1-SNAPSHOT.jar`
- Database is automatically loaded with the samples batteries on application start up.
- Data can be viewed/queried through h2 console http://localhost:8080/h2-console/

### Power Plant Battery API:
- A collection of batteries can be registered through **/api/v1/batteries/register** API.
- BatteryRequest consists of **name**, **postcode** and **capacity**.
- Battery information can be collected by supplying the Postcode range through **/api/v1/batteries/info** API.
- Postcode range consists of **from** and **to** request parameters.
- Battery information will contain the names of registered batteries in alphabetical order along with total and average battery capacity.
- Request data must not be invalid like null or empty.
- Invalid API requests are handled with proper exception message.


### Postman
The documentation for all sever endpoints can be found in `/src/main/resources/BatteryAPICollection.json` file.
- Import the json collection file in Postman client.
- Invoke Register request for registering new batteries.
- Invoke Battery Info request for querying batteries within supplied postcode range.

### Sample Data
```json
[
  {
    "name": "Cannington",
    "postcode": "6107",
    "capacity": 13500
  },
  {
    "name": "Midland",
    "postcode": "6057",
    "capacity": 50500
  },
  {
    "name": "Hay Street",
    "postcode": "6000",
    "capacity": 23500
  },
  {
    "name": "Mount Adams",
    "postcode": "6525",
    "capacity": 12000
  },
  {
    "name": "Koolan Island",
    "postcode": "6733",
    "capacity": 10000
  },
  {
    "name": "Armadale",
    "postcode": "6992",
    "capacity": 25000
  },
  {
    "name": "Lesmurdie",
    "postcode": "6076",
    "capacity": 13500
  },
  {
    "name": "Kalamunda",
    "postcode": "6076",
    "capacity": 13500
  },
  {
    "name": "Carmel",
    "postcode": "6076",
    "capacity": 36000
  },
  {
    "name": "Bentley",
    "postcode": "6102",
    "capacity": 85000
  },
  {
    "name": "Akunda Bay",
    "postcode": "2084",
    "capacity": 13500
  },
  {
    "name": "Werrington County",
    "postcode": "2747",
    "capacity": 13500
  },
  {
    "name": "Bagot",
    "postcode": "0820",
    "capacity": 27000
  },
  {
    "name": "Yirrkala",
    "postcode": "0880",
    "capacity": 13500
  },
  {
    "name": "University of Melbourne",
    "postcode": "3010",
    "capacity": 85000
  },
  {
    "name": "Norfolk Island",
    "postcode": "2899",
    "capacity": 13500
  },
  {
    "name": "Ootha",
    "postcode": "2875",
    "capacity": 13500
  },
  {
    "name": "Kent Town",
    "postcode": "5067",
    "capacity": 13500
  },
  {
    "name": "Northgate Mc",
    "postcode": "9464",
    "capacity": 13500
  },
  {
    "name": "Gold Coast Mc",
    "postcode": "9729",
    "capacity": 50000
  }
]
```


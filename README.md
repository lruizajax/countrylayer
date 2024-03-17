## Getting Started

The "Country Layer" API can be tested in three different Tools:

### Prerequisites

* [Java](https://www.oracle.com/java/technologies/downloads)
* [Maven](https://maven.apache.org/install.html)
* [IntelliJ](https://www.jetbrains.com/idea/download)
* [Postman](https://www.postman.com/downloads/)
* [SoapUI](https://www.soapui.org/tools/soapui/)
  
### Installation REST Assured

Clone the repo
   ```sh
   git clone git@github.com:lruizajax/countrylayer.git
   ```

### Execution 

#### (Rate limit: 1 per second limit of API{429})

Postman, import the collection "Country Layer API.postman_collection.json" located in the resources/postman folder, and test all requests

SoapUI, Import the project "REST_CountryLayer.xml" located in the resources/soapUI folder, active "REST MockService Country" and launch TestRunner.

Run tests in Maven 
   ```sh
   # Run all the test classes.
   mvn test
   ```

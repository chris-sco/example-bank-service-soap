# example-bank-service-soap
This is an example application built as part of the process of learning
the Spring Boot Web Service module, as well as more general investigation of
developing SOAP web services in Kotlin.

This app does nothing that achieves anything and is for learning purposes only.

### Project Startup
Nothing fancy. Clone this repository locally and run gradle build; requires
JDK8.

If gradle build fails in the first instance, run `.\gradlew xjcGenerate` and then rerun 
gradle build.

### Running application
WSDL for account service can be found on `localhost:8080/ws/account_service.wsdl`.

# TrafikLabs APP

Simple command line app fetching the top 10 bus lines in Stockholm with the most bus stops on their routes.
It will print the top 10 list of buses as well as all the bus stop names of the bus line with the most stops.

It utilises the TrafikLab APIs (https://www.trafiklab.se/). You can sign up for an API key there which 
is needed to run this application.

## Building the project
Prerequisites:
- Java 17
- Maven
- Api key from trafiklab.se

It is a basic Spring Boot application built with Maven and Java 17. If you have these installed
you can run the app in IntelliJ or the terminal using maven. You will need to add your api key in the
'application.properties' file as `app.key` before running the project with:
- `./mvnw spring-boot:run`

To package the project as a JAR run the following:
- `./mvnw clean package`

And then run the application with:
- `java -jar target/trafiklabs-0.0.1-SNAPSHOT.jar`

If you do not like to add your key to the application.properties file you can pass it as an argument when 
running the JAR file: 
- `--app.key="insert you api key here"`

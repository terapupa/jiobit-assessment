# Jiobit Platform Engineering Assignment

Thank you for your interest in Jiobit. We appreciate you taking the time to go through our programming assignment.

## Background

- This projects implements a RESTful API which stores and retrieves location data related to a mobile app
- Each mobile app instance has a GUID associated with it
- The app reports it's current location (latitude, longitude, accuracy) every five minutes
- The app sends the location payload it generates to the RESTful API as a JSON payload, along with it's identifying GUID
- The app is to retrieve a history of previous locations from the RESTful API for its user
- The purpose of this assignment is to create the RESTful API for the mobile app
- An example of the JSON location payload is below:

```JSON
{
    "latitude": 37.427440,,
    "longitude": -122.169118,
    "accuracy": 18
}
```

## Instructions

- This project can be completed  in either Java, Python, or Node.js
- The goal is to create a RESTful API backend which accepts an app GUID and subsequent location data from the mobile app and stores it into persistent storage
- A docker-compose file is provided to you with a MYSQL empty database for persistent storage, but you are able to use any sort of persistent storage you like
- Saving new location data is to be done via HTTP POST requests which receive the location information sent by the app and the associated app GUID and stores the associated locaiton data along with the associated app GUID in the DB
- Retrieving locations is to be done via an HTTP GET request with the app GUID sent to with either via path parameters or query parameters

## Expectations
We have a few expectations for your submission:

- The code should be well strucutered and documented
- Instructions should be provided in a README describing how to build and run the solution
- The solution should be fully dockerized

Please feel free to use any IDE - IntelliJ/Eclipse/Visual Studio etc. When you are ready, submit your code back to the repository before the in person review.  In case you have any questions, please reach out to your recruiting coordinator. Thank you and good luck!

# Implementation
The project implements RESTful API backend server according to the requirements provided above.
The project is implemented by Java and Springboot framework and uses MySQL as a persistent layer. The access to the persistent layer is provided by JPA and Hibernate ORM. The Springboot application is dockerized by Docker file and docker-compose yaml.

## The project building
The project is built by Gradle. Please use next command to build and execute project from a Docker container.
1. Clone the project to local folder.
2. Install gradle (if neccessary).
3. Go to the project root folder.
4. Build the project's executable jar. Run next command `gradle clean build`
5. Build the Docker image. Run next command `docker build -t jiobit-assessment.jar .`
6. Start the RESTful API backend server by using next command: `docker-compose up -d`
7. Use next command to shutdown the RESTful API backend server: `docker-compose down`

## The RESTful API backend server access
The RESTful API backend server endpoint mapped to the port 8081. Please use the entry endpoint 'http://localhost:8081' 

## RESTful API
The RESTful API backend server provides next APIs:
- Add geolocation by mobile client GUID
- Retrieve geolocations by mobile client GUID

### Add geolocation by mobile client GUID
#### HTTP Request:
- request type : POST
- URI : `<entry endpoint>/jiobit/add?guid=<mobile client GUID>`
- Request header: `Content-Type: application/json`
- Request body: 
```JSON
{
    "latitude": <value>,
    "longitude": <value>,
    "accuracy": <value>
}
```

#### HTTP Response:

```JSON
{
"id": <internal id>,
"guid": <mobile client GUID>,
"timestamp": <value>,
"latitude": <value>,
"longitude": <value>,
"accuracy": <value>
}
```

#### Request example:

```
curl -X POST 'http://localhost:8081/jiobit/add?guid=123' \
-H "Content-Type: application/json" \
-d '{"latitude": 37.427440,"longitude": -122.169118,"accuracy": 18}'
```
#### Response example:
`{"id":11,"guid":"123","timestamp":1651097991074,"latitude":37.42744,"longitude":-122.169118,"accuracy":18}`

### Retrieve geolocations by mobile client GUID
#### HTTP Request:
- request type : GET
- URI : `<entry endpoint>/jiobit/<mobile client GUID>`

#### HTTP Response:

```JSON
  [
    {
      "id":<internal id>,
      "guid":<mobile client GUID>,
      "timestamp":<value>,
      "latitude":<value>,
      "longitude":<value>,
      "accuracy":<value>
    },
    ...
    {
      "id":<internal id>,
      "guid":<mobile client GUID>,
      "timestamp":<value>,
      "latitude":<value>,
      "longitude":<value>,
      "accuracy":<value>
    }
  ]
```
#### Request example:

```
curl -X GET 'http://localhost:8081/jiobit/12gg'
```
#### Response example:
```
[{"id":7,"guid":"12gg","timestamp":1651089681111,"latitude":0.0,"longitude":0.0,"accuracy":0},{"id":8,"guid":"12gg","timestamp":1651089682424,"latitude":0.0,"longitude":0.0,"accuracy":0},{"id":9,"guid":"12gg","timestamp":1651097100362,"latitude":0.0,"longitude":0.0,"accuracy":0}]
```

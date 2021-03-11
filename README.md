# test_task
This is a simple program, which provides basic functions for air companies management system.

You can easily install and use it, following this step by step program execution guide.


## Installation
1. Make sure you have Java 11 JDK, any Java Environment, Postman and MySQL Workbencch 8.0 installed.
2. Clone this project.
3. Find "test_db.sql" file in "/data" folder, open it as SQL script and run it to create database and set initial values.
4. Now you can run Java project. The main class is located in "test_app\src\main\java\com\shymoniak\testapp\TestAppApplication.java".
5. Import json requests collection "Test app requests.postman_collection.json" from "/data" folder to test application.

## Functions
1. Simple CRUD operations for Air company entity.
2. Endpoint to move airplanes between companies (simple endpoint to reassign airplane to another company).
3. Endpoint to find all Air Company Flights by status (use company name for identification of Air Company).
4. Endpoint to find all Flights in ACTIVE status and started more than 24 hours ago.
5. Endpoint to add new Airplane (Could be assign to a company immediately or moved later).
6. Endpoint to add new Flight (set status to PENDING)
7. Endpoint to change Flight status:
- if status to change is DELAYED – set delay started at
- if status to change is ACTIVE – set started at
- if status to change is COMPLETED set ended at
8. (Optional) Endpoint to find all Flights in COMPLETED status and difference between started and ended time is bigger than estimated flight time.

## Testing
There are Postman requests prepared to test each function of application, so you can use and modify them.
The results of those requests you can see either in postman response window or making select queries in MySQL Workbencch(mentioned below). 
(SELECT * FROM airplane_test.air_company;   ---   Select querry for Air Company entity
SELECT * FROM airplane_test.airplane;   ---   Select querry for Airplane entity
SELECT * FROM airplane_test.flight;   ---   Select querry for Flight entity)
In case user enters invalid data, program can handle requests without crashing.

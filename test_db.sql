DROP DATABASE IF EXISTS airplane_test;
CREATE DATABASE airplane_test CHAR SET UTF8;
USE airplane_test;

# Add NOT NULL
CREATE TABLE airplane (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	airplane_name VARCHAR(30),
	factory VARCHAR(30),
	serial_number VARCHAR(10),
	air_company_id INT,
	number_of_flights INT,
	flight_distance INT,
	fuel_capacity INT,
    airplane_type VARCHAR(100),
    created_at DATE
);

CREATE TABLE air_company (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	air_company_name VARCHAR(30),
	company_type VARCHAR(30),
	founded_at DATE
);

CREATE TABLE flight (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	flight_status ENUM('ACTIVE', 'COMPLETED', 'DELAYED', 'PENDING'),
	air_company_id INT,
	airplane_id INT,
	departure_country VARCHAR(30),
	destination_country VARCHAR(30),
	distance INT,
	ended_at DATE,
    delay_started_at DATE,
    created_at DATE
);


INSERT INTO 
airplane(airplane_name, factory, serial_number , air_company_id, number_of_flights, flight_distance, fuel_capacity, airplane_type, created_at)
VALUES
('Airbus A320neo', 'Airbus', 'MW248' , 1, 9, 6850, 23760, 'Mid-Size Passenger Jet', "2020-02-14"),
('Airbus A330neo', 'Airbus', 'R2492' , 2, 31, 13300, 139090, 'Jumbo Passenger Jets', "2018-10-01"),
('Boeing 777-8', 'Boeing', 'S1589' , 3, 27, 16000, 198000, 'Jumbo Passenger Jets', "2018-11-17"),
('Boeing 777-9', 'Boeing', 'ZD576' , 1, 11, 14000, 198000, 'Jumbo Passenger Jets', "2020-04-19"),
('Boeing 737 MAX 10', 'Boeing', 'SW344' , 2, 33, 5950, 25800, 'Mid-Size Passenger Jet', "2018-06-03"),
('Comac C919', 'COMAC', 'R2496' , 3, 19, 2400, 4000, 'Mid-Size Passenger Jet', "2019-02-12");

INSERT INTO 
air_company(air_company_name, company_type, founded_at)
VALUES
('Ukraine International Airlines', 'International Airlines', "1992-10-01"),
('Pegasus Airlines', 'International Airlines', "1990-01-12"),
('Sky Up Airlines', 'National Airlines', "2018-06-04");

INSERT INTO 
flight(flight_status, air_company_id, airplane_id, departure_country ,destination_country, distance, ended_at, delay_started_at, created_at)
VALUES
(1, 1, 1, 'Ukraine' ,'Turkey', 1500, null, "2021-03-09  14:45:00", "2021-03-01  16:00:35"),
(1, 2, 2, 'Poland' ,'Ukraine', 800, null, null, "2021-03-01  18:30:35"),
(2, 3, 3, 'Germany' ,'Italy', 1500, "2020-05-12  09:34:21", null, "2020-05-12  09:34:21"),
(2, 1, 4, 'Italy' ,'Romania', 1600, "2021-01-01  17:12:10", "2021-01-01  14:27:03", "2020-11-27  17:40:21"),
(3, 2, 5, 'Austria' ,'Ukraine', 1400, null, "2021-03-10  03:20:20", "2021-02-18  13:20:50"),
(3, 3, 6, 'Austria' ,'Germany', 700, null, "2021-03-09  23:06:15", "2021-02-15  12:00:20"),
(4, 1, 1, 'Urkaine' ,'Italy', 2300, null, "2021-01-01  14:27:03", "2021-03-01  18:21:03"),
(4, 2, 2, 'Poland' ,'Turkey', 2000, null, null, "2021-02-07  15:25:20");

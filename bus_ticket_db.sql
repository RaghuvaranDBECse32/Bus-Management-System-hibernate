CREATE DATABASE bus_ticket_db;
-- Use existing database
USE bus_ticket_db;

-- Create Bus table
CREATE TABLE IF NOT EXISTS bus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    busName VARCHAR(100) NOT NULL,
    route VARCHAR(100) NOT NULL,
    totalSeats INT NOT NULL
);

-- Create Passenger table
CREATE TABLE IF NOT EXISTS passenger (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

-- Create Ticket table
CREATE TABLE IF NOT EXISTS ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bus_id INT NOT NULL,
    passenger_id INT NOT NULL,
    date DATE NOT NULL,
    seatNo INT NOT NULL,
    FOREIGN KEY (bus_id) REFERENCES bus(id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id)
);

-- View all buses
SELECT * FROM bus;

-- View all passengers
SELECT * FROM passenger;

-- View all tickets
SELECT t.id, b.busName, b.route, p.name AS passengerName, t.date, t.seatNo
FROM ticket t
JOIN bus b ON t.bus_id = b.id
JOIN passenger p ON t.passenger_id = p.id;
CREATE DATABASE MySimpleDatabase;


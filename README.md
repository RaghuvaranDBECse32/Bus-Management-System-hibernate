# Local Bus Ticket System

**Author:** Raghuvaran D
**Technology Stack:** Java, Hibernate ORM, MySQL, Maven
**Project Type:** Console-based Application
**Purpose:** Demonstrate a simple bus ticket booking system using Java and Hibernate ORM.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Project Structure](#project-structure)
5. [Setup Instructions](#setup-instructions)
6. [Usage](#usage)
7. [Sample Data](#sample-data)
8. [License](#license)

---

## Project Overview

The **Local Bus Ticket System** is a console-based application built with Java and Hibernate ORM that allows users to:

* Add buses and passengers.
* Book tickets for passengers on specific buses.
* View all buses, passengers, and ticket bookings.

The system uses **MySQL** as the database backend, and **Hibernate** handles ORM mapping.

---

## Features

* Add and manage buses with details like route and total seats.
* Add and manage passengers with personal details.
* Book tickets linking a passenger to a bus on a specific date and seat.
* Display all buses, passengers, and booked tickets.
* Preloaded sample data for easy testing.

---

## Technologies Used

* **Java 1.8+**
* **Hibernate ORM**
* **MySQL 8+**
* **Maven** for dependency management
* **Eclipse IDE**

---

## Project Structure

```
LocalBusTicketSystem/
│
├─ src/main/java/com/bus/main/
│   └─ BusApp.java           # Main class with console menu
│
├─ src/main/java/com/bus/entity/
│   ├─ Bus.java
│   ├─ Passenger.java
│   └─ Ticket.java
│
├─ src/main/java/com/bus/dao/
│   ├─ BusDAO.java
│   ├─ PassengerDAO.java
│   └─ TicketDAO.java
│
├─ src/main/java/com/bus/util/
│   └─ HibernateUtil.java   # Handles SessionFactory
│
├─ src/main/resources/
│   └─ hibernate.cfg.xml
│
├─ pom.xml                  # Maven project file
└─ README.md
```

---

## Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/your-username/LocalBusTicketSystem.git
cd LocalBusTicketSystem
```

2. **Set up MySQL database**

```sql
CREATE DATABASE bus_ticket_db;
USE bus_ticket_db;
```

Tables are automatically created by Hibernate (`hbm2ddl.auto=update`).

3. **Configure database credentials** in `hibernate.cfg.xml`:

```xml
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>
```

4. **Import project in Eclipse** as Maven Project.

5. **Build and run** the project from Eclipse or command line.

---

## Usage

1. Run `BusApp.java`
2. Select options from the menu:

```
1. Add Bus
2. Add Passenger
3. Book Ticket
4. Exit
5. View All Data
```

3. Input data as prompted.
4. Option 5 shows **all buses, passengers, and booked tickets**.

---

## Sample Data (Preloaded)

**Buses**

| ID | Name     | Route       | Seats |
| -- | -------- | ----------- | ----- |
| 1  | Raanji   | Tirunelveli | 50    |
| 2  | ExpressX | Chennai     | 40    |
| 3  | RapidGo  | Madurai     | 45    |

**Passengers**

| ID | Name       | Age |
| -- | ---------- | --- |
| 1  | Raghuvaran | 23  |
| 2  | Anitha     | 30  |
| 3  | Karthik    | 27  |

Tickets are created dynamically using option 3.

---

## License

This project is **MIT Licensed**. Feel free to use, modify, or distribute.

---

package com.bus.main;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import com.bus.dao.*;
import com.bus.entity.*;
import com.bus.util.HibernateUtil;

public class BusApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BusDAO busDao = new BusDAO();
        PassengerDAO passengerDao = new PassengerDAO();
        TicketDAO ticketDao = new TicketDAO();
        

        // ==== Insert 3 sample data at startup ====
        if (busDao.getAllBuses().isEmpty()) {
            busDao.saveBus(new Bus("Raanji", "Tirunelveli", 50));
            busDao.saveBus(new Bus("ExpressX", "Chennai", 40));
            busDao.saveBus(new Bus("RapidGo", "Madurai", 45));
        }

        if (passengerDao.getAllPassengers().isEmpty()) {
            passengerDao.savePassenger(new Passenger("Raghuvaran", 23));
            passengerDao.savePassenger(new Passenger("Anitha", 30));
            passengerDao.savePassenger(new Passenger("Karthik", 27));
        }
        
        boolean exit = false;
        

        while (!exit) {
            System.out.println("\n==== Local Bus Ticket System ====");
            System.out.println("1. Add Bus");
            System.out.println("2. Add Passenger");
            System.out.println("3. Book Ticket");
            System.out.println("4. View All Data");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Bus Name: ");
                    String busName = sc.nextLine();
                    System.out.print("Enter Route: ");
                    String route = sc.nextLine();
                    System.out.print("Enter Total Seats: ");
                    int seats = readInt();
                    busDao.saveBus(new Bus(busName, route, seats));
                    System.out.println("Bus added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Passenger Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = readInt();
                    passengerDao.savePassenger(new Passenger(pname, age));
                    System.out.println("Passenger added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Bus ID: ");
                    int busId = readInt();
                    System.out.print("Enter Passenger ID: ");
                    int passengerId = readInt();
                    System.out.print("Enter Travel Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    int seatNo = readInt();

                    // Fetch Bus and Passenger from DB
                    Bus bus;
                    Passenger passenger;
                    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                        bus = session.get(Bus.class, busId);
                        passenger = session.get(Passenger.class, passengerId);
                        if (bus == null || passenger == null) {
                            System.out.println("Bus or Passenger not found!");
                            break;
                        }
                    }

                    ticketDao.bookTicket(new Ticket(bus, passenger, date, seatNo));
                    System.out.println("Ticket booked successfully!");
                    break;

                case 4:
                    System.out.println("\n---- Buses ----");
                    List<Bus> buses = busDao.getAllBuses();
                    for (Bus b : buses) {
                        System.out.println(b.getId() + " | " + b.getBusName() + " | " + b.getRoute() + " | Seats: " + b.getTotalSeats());
                    }

                    System.out.println("\n---- Passengers ----");
                    List<Passenger> passengers = passengerDao.getAllPassengers();
                    for (Passenger p : passengers) {
                        System.out.println(p.getId() + " | " + p.getName() + " | Age: " + p.getAge());
                    }

                    System.out.println("\n---- Tickets ----");
                    List<Ticket> tickets = ticketDao.getAllTickets();
                    for (Ticket t : tickets) {
                        System.out.println("Ticket ID: " + t.getId() + 
                                           " | Bus: " + t.getBus().getBusName() + 
                                           " | Passenger: " + t.getPassenger().getName() + 
                                           " | Date: " + t.getDate() + 
                                           " | Seat No: " + t.getSeatNo());
                    }
                    break;  
                
                
                
                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
        HibernateUtil.shutdown();
        System.out.println("Exiting System...");
    }

    private static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // Consume newline
        return val;
    }
}

package com.bus.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bus.model.Bus;
import com.bus.util.HibernateUtil;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== BUS MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Search Bus by Route");
            System.out.println("4. Update Bus Capacity");
            System.out.println("5. Delete Bus");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBus();
                case 2 -> viewAllBuses();
                case 3 -> searchBusByRoute();
                case 4 -> updateBusCapacity();
                case 5 -> deleteBus();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addBus() {
        sc.nextLine();
        System.out.print("Enter Bus Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Route: ");
        String route = sc.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Bus bus = new Bus(name, route, capacity);
        session.save(bus);
        tx.commit();
        session.close();
        System.out.println("✅ Bus added successfully!");
    }

    private static void viewAllBuses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Bus> buses = session.createQuery("from Bus", Bus.class).list();
        buses.forEach(System.out::println);
        session.close();
    }

    private static void searchBusByRoute() {
        sc.nextLine();
        System.out.print("Enter route to search: ");
        String route = sc.nextLine();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Bus> buses = session.createQuery("from Bus where route = :r", Bus.class)
                .setParameter("r", route).list();
        if (buses.isEmpty()) System.out.println("No buses found for that route.");
        else buses.forEach(System.out::println);
        session.close();
    }

    private static void updateBusCapacity() {
        System.out.print("Enter Bus ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new capacity: ");
        int newCap = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Bus bus = session.get(Bus.class, id);
        if (bus != null) {
            bus.setCapacity(newCap);
            session.update(bus);
            tx.commit();
            System.out.println("✅ Capacity updated successfully!");
        } else {
            System.out.println("❌ Bus not found!");
        }
        session.close();
    }

    private static void deleteBus() {
        System.out.print("Enter Bus ID to delete: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Bus bus = session.get(Bus.class, id);
        if (bus != null) {
            session.delete(bus);
            tx.commit();
            System.out.println("🗑️ Bus deleted successfully!");
        } else {
            System.out.println("❌ Bus not found!");
        }
        session.close();
    }
}

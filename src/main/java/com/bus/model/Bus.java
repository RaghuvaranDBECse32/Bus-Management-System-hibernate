package com.bus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String route;
    private int capacity;

    public Bus() {}
    public Bus(String name, String route, int capacity) {
        this.name = name;
        this.route = route;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return "Bus [id=" + id + ", name=" + name + ", route=" + route + ", capacity=" + capacity + "]";
    }
}

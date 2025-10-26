package com.bus.entity;
import javax.persistence.*;
@Entity
@Table(name="bus")
public class Bus {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    private String busName; private String route; private int totalSeats;
    public Bus() {}
    public Bus(String busName,String route,int totalSeats){this.busName=busName;this.route=route;this.totalSeats=totalSeats;}
    public int getId(){return id;} public String getBusName(){return busName;} public void setBusName(String busName){this.busName=busName;}
    public String getRoute(){return route;} public void setRoute(String route){this.route=route;} public int getTotalSeats(){return totalSeats;}
    public void setTotalSeats(int totalSeats){this.totalSeats=totalSeats;}
}
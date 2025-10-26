package com.bus.entity;
import javax.persistence.*;
@Entity
@Table(name="passenger")
public class Passenger {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    private String name; private int age;
    public Passenger() {} public Passenger(String name,int age){this.name=name;this.age=age;}
    public int getId(){return id;} public String getName(){return name;} public void setName(String name){this.name=name;}
    public int getAge(){return age;} public void setAge(int age){this.age=age;}
}
package com.bus.entity;
import javax.persistence.*;
@Entity
@Table(name="ticket")
public class Ticket {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    @ManyToOne private Bus bus; @ManyToOne private Passenger passenger;
    private String date; private int seatNo;
    public Ticket() {}
    public Ticket(Bus bus,Passenger passenger,String date,int seatNo){this.bus=bus;this.passenger=passenger;this.date=date;this.seatNo=seatNo;}
    public int getId(){return id;} public Bus getBus(){return bus;} public void setBus(Bus bus){this.bus=bus;}
    public Passenger getPassenger(){return passenger;} public void setPassenger(Passenger passenger){this.passenger=passenger;}
    public String getDate(){return date;} public void setDate(String date){this.date=date;}
    public int getSeatNo(){return seatNo;} public void setSeatNo(int seatNo){this.seatNo=seatNo;}
}
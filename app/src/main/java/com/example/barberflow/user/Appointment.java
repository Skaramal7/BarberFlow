package com.example.barberflow.user;

import java.util.Date;

public class Appointment{
    public Date date;
    public Barber barber;
    public Customer customer;
    public Appointment(Date date, Barber barber, Customer customer){
        this.date = date;
        this.barber = barber;
        this.customer = customer;
    }

    public boolean changeBarber(Barber newBarber){
        this.barber = newBarber;
        return true;
    }

    public boolean changeDate(Date newDate){
        this.date = newDate;
        return true;
    }
}

package com.example.barberflow.user;

public class Customer extends User{
    public Appointment appointment;

    public Customer(Long uid, String name, String phoneNumber, String email){
        this.uid = uid;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
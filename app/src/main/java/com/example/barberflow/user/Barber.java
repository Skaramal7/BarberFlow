package com.example.barberflow.user;

import java.util.List;

public class Barber extends User{
    public List<Appointment> appointments;
    public int starTime;
    public int endTime;

    public Barber(Long uid, String name, String email, List<Appointment> appointments, int starTime, int endTime) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.appointments = appointments;
        this.starTime = starTime;
        this.endTime = endTime;

    }
}
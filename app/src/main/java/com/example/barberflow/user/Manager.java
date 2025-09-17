package com.example.barberflow.user;

import java.util.List;

public class Manager extends User{
    public List<Barber> barbersToManage;

    public Manager(Long uid, String name, String email, List<Barber> barbers){
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.barbersToManage = barbers;
    }
}

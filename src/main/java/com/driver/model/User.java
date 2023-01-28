package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    private String phoneNumber;
    private String password;


    public User() {
    }

    

    public User(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }



    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Reservation> reservationList;


    



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public List<Reservation> getReservationList() {
        return reservationList;
    }



    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }



    public int getUserId() {
        return userId;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }

    


    
}

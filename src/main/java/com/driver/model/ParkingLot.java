package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
    private List<Spot> spotList;
}

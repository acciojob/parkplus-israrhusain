package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private SpotType spotType;
    private int pricePerHour;
    private Boolean Occupied;
    private int numberOfWheels;

    
    

     public Spot() {
    }




    public Spot(int pricePerHour,Boolean Occupied,int numberOfWheels) {
        this.pricePerHour=0;
        this.Occupied=Occupied;
        this.numberOfWheels=numberOfWheels;
    }




    @ManyToOne
    @JoinColumn
     private ParkingLot parkingLot;

     @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
     private List<Reservation> ReservationList=new ArrayList<>();



  public SpotType getSpotType() {
        return spotType;
    }




    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }




   

   public int getPricePerHour() {
        return pricePerHour;
    }




    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }




    public Boolean getOccupied() {
        return Occupied;
    }




    public void setOccupied(Boolean occupied) {
        Occupied = occupied;
    }




    public ParkingLot getParkingLot() {
        return parkingLot;
    }




    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }




    public List<Reservation> getReservationList() {
        return ReservationList;
    }




    public void setReservationList(List<Reservation> reservationList) {
        ReservationList = reservationList;
    }




   public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }




    public int getNumberOfWheels() {
        return numberOfWheels;
    }




    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }




   



}

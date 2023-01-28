package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spotId;
    private SpotType spotType;
    private int priceperhour;
    private boolean occupied;
    private int numberOfWheels;

    
    

     public Spot() {
    }




    public Spot(SpotType spotType, int priceperhour,boolean occupied,int numberOfWheels) {
        this.spotType = spotType;
        this.priceperhour = priceperhour;
        this.occupied=true;
        this.numberOfWheels=numberOfWheels;
    }




    @ManyToOne
     private ParkingLot parkingLot;

     @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
     private List<Reservation> ReservationList;




   




    public SpotType getSpotType() {
        return spotType;
    }




    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }




    public int getPriceperhour() {
        return priceperhour;
    }




    public void setPriceperhour(int priceperhour) {
        this.priceperhour = priceperhour;
    }




    public boolean isOccupied() {
        return occupied;
    }




    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
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




    public int getNumberOfWheels() {
        return numberOfWheels;
    }




    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }




    public int getSpotId() {
        return spotId;
    }




    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }



}

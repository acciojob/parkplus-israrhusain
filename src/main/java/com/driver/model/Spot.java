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
    private int id;
    private SpotType spotType;
    private int PricePerHour;
    private Boolean Occupied;
    private int numberOfWheels;

    
    

     public Spot() {
    }




    public Spot(SpotType spotType, int PricePerHour,Boolean Occupied,int numberOfWheels) {
        this.spotType = spotType;
        this.PricePerHour= PricePerHour;
        this.Occupied=false;
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




   

   public int getPricePerHour() {
        return PricePerHour;
    }




    public void setPricePerHour(int pricePerHour) {
        PricePerHour = pricePerHour;
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




    public int getNumberOfWheels() {
        return numberOfWheels;
    }




    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }




    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }




   



}

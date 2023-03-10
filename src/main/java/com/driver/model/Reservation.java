package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;
    private int numberOfHours;

    

    public Reservation() {
    }

    public Reservation(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @ManyToOne
    @JoinColumn
    private Spot spot;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToOne(mappedBy="reservation")
    private Payment Payment;

   



   

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Payment getPayment() {
        return Payment;
    }

    public void setPayment(Payment payment) {
        Payment = payment;
    }

    

    


}

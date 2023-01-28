package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean Paymentcompleted;
    private PaymentMode paymentMode;

    

    public Payment() {
    }



    public Payment(boolean paymentcompleted, PaymentMode paymentMode) {
        this.Paymentcompleted = false;
        this.paymentMode = paymentMode;
    
    }

    
    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public boolean isPaymentcompleted() {
        return Paymentcompleted;
    }



    public void setPaymentcompleted(boolean paymentcompleted) {
        Paymentcompleted = paymentcompleted;
    }



    public PaymentMode getPaymentMode() {
        return paymentMode;
    }



    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }



    public Reservation getReservation() {
        return reservation;
    }



    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }



    @OneToOne
    private Reservation reservation;
 
    
}

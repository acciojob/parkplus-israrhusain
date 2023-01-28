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
    private boolean PaymentCompleted;
    private PaymentMode paymentMode;

    

    public Payment() {
    }



    public Payment(boolean PaymentCompleted, PaymentMode paymentMode) {
        this.PaymentCompleted = false;
        this.paymentMode = paymentMode;
    
    }

    
    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
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



    public boolean isPaymentCompleted() {
        return PaymentCompleted;
    }



    public void setPaymentCompleted(boolean paymentCompleted) {
        PaymentCompleted = paymentCompleted;
    }
 
    
}

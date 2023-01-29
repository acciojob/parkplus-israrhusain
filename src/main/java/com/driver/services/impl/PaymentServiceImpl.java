package com.driver.services.impl;

import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
            Payment payment=new Payment();
            Reservation reservation=reservationRepository2.findById(reservationId).get();
            int hours=reservation.getNumberOfHours();
            int pricePerHour=reservation.getSpot().getPricePerHour();
            int bill=hours*pricePerHour;

            if(bill>amountSent){
                //paymentRepository2.save(payment);
               throw new Exception("Insufficient Amount");
           }
             String paymentmode=mode.toUpperCase();
            if(paymentmode.equals("CASH")){
                payment.setPaymentMode(PaymentMode.CASH);
                
            }
            else if(paymentmode.equals("CARD")){
                payment.setPaymentMode(PaymentMode.CARD);
            }
            else if(paymentmode.equals("UPI")){
                payment.setPaymentMode(PaymentMode.UPI);
            }
            else{
               // payment.setPaymentMode(null);
                //paymentRepository2.save(payment);
                throw new Exception("Payment mode not detected");
            }
           
            payment.setReservation(reservation);
            payment.setPaymentCompleted(true);

          //  paymentRepository2.save(payment);

            return payment;
    }
}

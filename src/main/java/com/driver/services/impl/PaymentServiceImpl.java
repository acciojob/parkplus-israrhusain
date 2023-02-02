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

          
           if(mode.equalsIgnoreCase("CASH") || mode.equalsIgnoreCase("CARD") || mode.equalsIgnoreCase("UPI")){

            if(bill!=amountSent){
                //paymentRepository2.save(payment);
               throw new Exception("Insufficient Amount");
           }
               
              if(mode.equalsIgnoreCase("CASH")){
                payment.setPaymentMode(PaymentMode.CASH);
                
             }
               if(mode.equalsIgnoreCase("CARD")){
                payment.setPaymentMode(PaymentMode.CARD);
            }
               if(mode.equalsIgnoreCase("UPI")){
                payment.setPaymentMode(PaymentMode.UPI);
                }
           }
            else{
               // payment.setPaymentMode(null);
                //paymentRepository2.save(payment);
                throw new Exception("Payment mode not detected");
            }

            
            payment.setReservation(reservation);
            payment.setPaymentCompleted(true);

           reservationRepository2.save(reservation);

            return payment;
        }
           
    }


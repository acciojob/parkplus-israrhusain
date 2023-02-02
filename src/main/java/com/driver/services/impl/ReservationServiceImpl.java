package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
         
        try{
            User user=userRepository3.findById(userId).get();

            ParkingLot parkingLot=parkingLotRepository3.findById(parkingLotId).get();

         if(user==null || parkingLot==null){
                throw new Exception("Cannot make reservation");
             }
            //SET USER
         List<Spot> list=parkingLot.getSpotList();
         Spot spot=null;

         for(Spot spot1:list){
            if(spot1.getOccupied()==Boolean.FALSE){
                if(spot==null || spot.getPricePerHour()>spot1.getPricePerHour()){
                     spot=spot1;
                }
            }
            }
            if(spot==null ){
                 throw new Exception("Cannot make reservation");
             }
             
            spot.setNumberOfWheels(numberOfWheels);
            spot.setOccupied(true);
            spot.setParkingLot(parkingLot);
        
            parkingLot.setSpotList(list);
            spotRepository3.save(spot);
             
            Reservation reservation=new Reservation();
            List<Reservation>list1=user.getReservationList();
            list1.add(reservation);
            user.setReservationList(list1);
            reservation.setUser(user);
            reservation.setNumberOfHours(timeInHours);
            reservation.setSpot(spot);
            userRepository3.save(user);

            //reservationRepository3.save(reservation);

       return reservation;
    }
    catch(Exception e){
        return null;
    }
    }
   
}

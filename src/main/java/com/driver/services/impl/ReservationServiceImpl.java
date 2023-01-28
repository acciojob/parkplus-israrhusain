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
            Reservation reservation=new Reservation();
            reservation.setNumberOfHours(timeInHours);
            User user=userRepository3.findById(userId).get();
            List<Spot> list=spotRepository3.findAll();

               
            if( user==null ){
                      throw new Exception("Cannot make reservation");
               }
            //SET USER
            Spot spot=null;

         for(Spot spot1:list){
            if(spot1.isOccupied()==Boolean.FALSE){
                if(spot==null || spot.getPriceperhour()>spot1.getPriceperhour()){
                     spot=spot1;
                }
            }
            }
            if(spot==null){
                throw new Exception("spot not found");
            }
            
            ParkingLot parkingLot=parkingLotRepository3.findById(parkingLotId).get();
            if(parkingLotId==null){
                throw new Exception("Cannot make reservation");
            }
            spot.setNumberOfWheels(numberOfWheels);
            spot.setOccupied(true);
            spot.setParkingLot(null);
           
            List<Spot> lists=parkingLot.getSpotList();
            lists.add(spot);
            parkingLot.setSpotList(lists);
            
             

            List<Reservation>list1=user.getReservationList();
            list1.add(reservation);
            user.setReservationList(list1);
            reservation.setUser(user);
           
            reservation.setSpot(spot);

            reservationRepository3.save(reservation);

       return reservation;

    }
}

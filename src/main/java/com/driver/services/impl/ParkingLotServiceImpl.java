package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
           ParkingLot parkingLot=new ParkingLot(name,address);
           return parkingLotRepository1.save(parkingLot);
           
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
          
          Spot spot=new Spot();
          spot.setNumberOfWheels(numberOfWheels);
          spot.setPricePerHour(pricePerHour);
    
          if(numberOfWheels==2){
            spot.setSpotType(SpotType.TWO_WHEELER);
          }
          else if(numberOfWheels==4){
            spot.setSpotType(SpotType.FOUR_WHEELER);
          }
          else if(numberOfWheels>4) {
            spot.setSpotType(SpotType.OTHERS);
          }
          
          ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
          List<Spot> list=parkingLot.getSpotList();
          list.add(spot);
          parkingLot.setSpotList(list);
          spot.setParkingLot(parkingLot);
          
         // parkingLotRepository1.save(parkingLot);
          
          

         return spotRepository1.save(spot);
          
    }

    @Override
    public void deleteSpot(int spotId) {
            spotRepository1.deleteSpotById(spotId);

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
             Spot spot=spotRepository1.findById(spotId).get();
             spot.setPricePerHour(pricePerHour);
             ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
             List<Spot> list=parkingLot.getSpotList();
             list.add(spot);
             parkingLot.setSpotList(list);
             spot.setParkingLot(parkingLot);
             return spotRepository1.save(spot);
            // parkingLotRepository1.save(parkingLot);
            
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
         
          //ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
          
         parkingLotRepository1.deleteById(parkingLotId);
    }
}

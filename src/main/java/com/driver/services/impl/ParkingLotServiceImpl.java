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
             ParkingLot parkingLot=new ParkingLot();
             parkingLot.setAddress(address);
             parkingLot.setName(name);
             
            parkingLotRepository1.save(parkingLot);
            return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
          Spot spot=new Spot();
          spot.setOccupied(false);
          spot.setNumberOfWheels(numberOfWheels);
          spot.setPriceperhour(pricePerHour);
          if(spot.getNumberOfWheels()==2){
            spot.setSpotType(SpotType.TWO_WHEELER);
          }
          else if(spot.getNumberOfWheels()==4){
            spot.setSpotType(SpotType.FOUR_WHEELER);
          }
          else{
            spot.setSpotType(SpotType.OTHERS);
          }
          
          ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
          List<Spot> list=parkingLot.getSpotList();
          list.add(spot);
          parkingLot.setSpotList(list);
          spot.setParkingLot(parkingLot);

          spotRepository1.save(spot);

          return spot;

    }

    @Override
    public void deleteSpot(int spotId) {
            spotRepository1.deleteById(spotId);
            Spot spot=spotRepository1.findById(spotId).get();
            
            spot.setOccupied(true);

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
             Spot spot=spotRepository1.findById(spotId).get();
             spot.setPriceperhour(pricePerHour);
             ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
             List<Spot> list=parkingLot.getSpotList();
             list.add(spot);
             parkingLot.setSpotList(list);
             spot.setParkingLot(parkingLot);
             spotRepository1.save(spot);

             return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
         
          ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
          List<Spot>list=parkingLot.getSpotList();
          List<Spot> spots=spotRepository1.findAll();
          for(Spot spot1:list){
             if(spots.contains(spot1)){
                spots.remove(spot1);
             }
          }
          parkingLotRepository1.deleteById(parkingLotId);
    }
}

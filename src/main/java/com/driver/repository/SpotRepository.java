package com.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.Spot;
@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{
    
    void deleteSpotById(Integer spotId);

    //@Query("select b from spot b where b.numberOfWheels in (select a from Spot where a.number=:numberOfWeels)")
    //List<Spot> findBynumberSpots(Integer numberOfWheels);
     List<Spot> findAll();
    //List<Spot> findBSpots(Integer numberOfWheels);
    
}

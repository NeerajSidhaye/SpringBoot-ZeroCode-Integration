package com.xp.springboot.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xp.springboot.entity.ParkRunner;

@Repository
public interface ParkRunnerRepository extends CrudRepository<ParkRunner, Long >{

}

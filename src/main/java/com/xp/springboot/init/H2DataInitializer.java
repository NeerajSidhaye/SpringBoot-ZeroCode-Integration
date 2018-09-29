package com.xp.springboot.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.respository.ParkRunnerRepository;

@Component
public class H2DataInitializer implements ApplicationRunner {

	private ParkRunnerRepository parkRunnerRepository;
	
	@Autowired
	public H2DataInitializer(ParkRunnerRepository parkRunnerRepository) {
		this.parkRunnerRepository = parkRunnerRepository;
	}
	
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		
		ParkRunner parkRunner = new ParkRunner();
		parkRunner.setName("NEERAJ SIDHAYE");
		parkRunner.setTotalRuns("10");
		parkRunner.setClub("Nanwitch");
		parkRunner.setGender("M");
		
		parkRunnerRepository.save(parkRunner);
	}
	
	
}

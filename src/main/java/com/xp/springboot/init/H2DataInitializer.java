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
		parkRunner.setFirstName("NEERAJ");
		parkRunner.setLastName("SIDHAYE");
		parkRunner.setEmail("RestAPI_integrationTest@code.com");
		parkRunner.setTotalRuns("28");
		parkRunner.setGender("M");
		parkRunner.setHomeRun("INDORE");
		parkRunner.setRunningClub("NA");
		parkRunner.setPostCode("CW2ZZZ");
		
		parkRunnerRepository.save(parkRunner);
	}
	
	
}

package com.xp.springboot.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.respository.DBSqlExecutor;
import com.xp.springboot.respository.ParkRunnerRepository;

@Component
public class H2DataInitializer implements ApplicationRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(H2DataInitializer.class);

	private ParkRunnerRepository parkRunnerRepository;
	private DBSqlExecutor dbSqlExecutor;
	
	
	@Autowired
	public H2DataInitializer(ParkRunnerRepository parkRunnerRepository, DBSqlExecutor dbSqlExecutor) {
		this.parkRunnerRepository = parkRunnerRepository;
		this.dbSqlExecutor = dbSqlExecutor;
	}
	
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		
		LOGGER.info("H2DataInitializer:run");
		
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

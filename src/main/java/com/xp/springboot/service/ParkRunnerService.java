package com.xp.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.respository.ParkRunnerRepository;


@Service
public class ParkRunnerService implements ParkRunServices{

	@Autowired
	private ParkRunnerRepository parkRunnerRepository;
	
	@Override
	public ParkRunResponse registerRunner(ParkRunner toBeparkRunner) {
		
		ParkRunner parkRunner =  parkRunnerRepository.save(toBeparkRunner);
		Long parkRunId = parkRunner.getParkRunId();
		return new ParkRunResponse(parkRunId.toString(), "Registration Sucessfull.", "http://localhost:8080/parkrun/api/v1/runners/"+parkRunId);
	}

	@Override
	public ParkRunner getParkRunnerById(Long parkRunnerId) throws ParkRunException {

		Optional<ParkRunner> parkRunnerOptional = parkRunnerRepository.findById(parkRunnerId);
		return parkRunnerOptional.orElseThrow(() -> new ParkRunException(parkRunnerId.toString(), "404", "Runner Not Found"));
		
	}

	@Override
	public List<ParkRunner> getAllParkRunnersByClub(String clubName) {

		return null; //TODO
		
	}

	@Override
	public List<ParkRunner> getAllParkRunners() {
		List<ParkRunner> parkRunnerList = new ArrayList<ParkRunner>();
		
		parkRunnerRepository.findAll().forEach(parkRunner -> parkRunnerList.add(parkRunner));
		return parkRunnerList;

	}

	@Override
	public void updateRunnerProfile(Long parkRunId, ParkRunner runnerProfileToUpdate) throws ParkRunException {
		Optional<ParkRunner> parkRunner = parkRunnerRepository.findById(parkRunId);
		if(parkRunner.isPresent()){
			parkRunner.get().setTotalRuns(runnerProfileToUpdate.getTotalRuns());
			parkRunnerRepository.save(parkRunner.get());
		} else
		{
			throw new ParkRunException(parkRunId.toString(), "404", "ParkRunner profile not found for update");
			
		}
		
		
	}	
}

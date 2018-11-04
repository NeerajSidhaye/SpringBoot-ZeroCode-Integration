package com.xp.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.respository.ParkRunnerRepository;


@Service
public class ParkRunnerService implements ParkRunServices{

	@Autowired
	private ParkRunnerRepository parkRunnerRepository;
	
	@Override
	public ParkRunResponse registerRunner(ParkRunner toBeparkRunner) {
		
		ParkRunner parkRunner =  parkRunnerRepository.save(toBeparkRunner);
		return new ParkRunResponse("Registration Success.", String.valueOf(parkRunner.getParkRunId()));
	}

	@Override
	public ParkRunner getParkRunnerById(Long parkRunnerId) throws ParkRunException {

		Optional<ParkRunner> parkRunnerOptional = parkRunnerRepository.findById(parkRunnerId);
		return parkRunnerOptional.orElseThrow(() -> new ParkRunException(parkRunnerId.toString(), "404", "Runner Not Found"));
		
	}

	@Override
	public List<ParkRunner> getAllParkRunners() {
		List<ParkRunner> parkRunnerList = new ArrayList<>();

		parkRunnerRepository.findAll().forEach(parkRunner -> parkRunnerList.add(parkRunner));
		return parkRunnerList;

	}

	@Override
	public ParkRunResponse updateRunnerProfile(Long parkRunId, ParkRunner runnerProfileToUpdate) throws ParkRunException {
		Optional<ParkRunner> parkRunner = parkRunnerRepository.findById(parkRunId);
		if(parkRunner.isPresent()){
			ParkRunner parkRunneEntity = parkRunner.get();
			parkRunneEntity.setTotalRuns(runnerProfileToUpdate.getTotalRuns());
			parkRunnerRepository.save(parkRunneEntity);
			return new ParkRunResponse("Update Success.", String.valueOf(parkRunneEntity.getParkRunId()));
		} else
		{
			throw new ParkRunException(parkRunId.toString(), "404", "ParkRunner profile not found for update");
			
		}
		
		
	}	
}

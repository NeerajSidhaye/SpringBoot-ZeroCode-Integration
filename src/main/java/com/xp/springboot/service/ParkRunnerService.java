package com.xp.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.respository.ParkRunnerRepository;

@Service
public class ParkRunnerService implements ParkRunServices {

	@Autowired
	private ParkRunnerRepository parkRunnerRepository;
	
	
	@Override
	public ParkRunner registerRunner(ParkRunner toBeparkRunner) {
		return parkRunnerRepository.save(toBeparkRunner);
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
	public void updateRunnerProfile(ParkRunner runnerProfileToUpdate) {
		
		parkRunnerRepository.save(runnerProfileToUpdate);
		
	
	}	
}

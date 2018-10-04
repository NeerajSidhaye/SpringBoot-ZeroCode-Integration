package com.xp.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ParkRunner getParkRunnerById(Long parkRunnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkRunner> getAllParkRunnersByClub(String clubName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkRunner> getAllParkRunners() {
		List<ParkRunner> parkRunnerList = new ArrayList<ParkRunner>();
		
		parkRunnerRepository.findAll().forEach(parkRunner -> parkRunnerList.add(parkRunner));
		return parkRunnerList;

	}

	
	
}

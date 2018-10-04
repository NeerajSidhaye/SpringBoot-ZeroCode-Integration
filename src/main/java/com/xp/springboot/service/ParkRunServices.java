package com.xp.springboot.service;

import java.util.List;

import com.xp.springboot.model.ParkRunner;

public interface ParkRunServices {

	public ParkRunner registerRunner(ParkRunner toBeparkRunner);
	
	public ParkRunner getParkRunnerById(Long parkRunnerId);
	
	public List<ParkRunner>  getAllParkRunnersByClub(String clubName);
	
	public List<ParkRunner> getAllParkRunners();
	
}

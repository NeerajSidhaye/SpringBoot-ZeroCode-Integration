package com.xp.springboot.service;

import java.util.List;

import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.ParkRunner;

public interface ParkRunServices {

	public ParkRunResponse registerRunner(ParkRunner toBeparkRunner);
	
	public ParkRunner getParkRunnerById(Long parkRunnerId) throws ParkRunException;
	
	public List<ParkRunner>  getAllParkRunnersByClub(String clubName);
	
	public List<ParkRunner> getAllParkRunners();
	
	public void updateRunnerProfile(Long parkRunId, ParkRunner runnerProfile) throws ParkRunException;
	
}

package com.xp.springboot.service;

import java.util.List;

import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;

public interface ParkRunServices {

	public ParkRunResponse registerRunner(ParkRunner toBeparkRunner);
	
	public ParkRunner getParkRunnerById(Long parkRunnerId) throws ParkRunException;
	
	public List<ParkRunner> getAllParkRunners();
	
	public ParkRunResponse updateRunnerProfile(Long parkRunId, ParkRunner runnerProfile) throws ParkRunException;
	
}

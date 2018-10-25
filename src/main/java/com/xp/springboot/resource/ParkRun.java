package com.xp.springboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.service.ParkRunServices;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */

@RestController
@RequestMapping("/api/v1/runners")
public class ParkRun {

	ParkRunServices parkRunService;
	
	@Autowired
	public ParkRun(ParkRunServices parkRunServices) {
		
		this.parkRunService = parkRunServices;
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {
		
		return new ResponseEntity<List<ParkRunner>>(parkRunService.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{parkRunId}")
	public ResponseEntity<ParkRunner> getParkRunner(@PathVariable Long parkRunId) throws ParkRunException {
		
		return new ResponseEntity<ParkRunner>(parkRunService.getParkRunnerById(parkRunId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ParkRunResponse> registerRunner(@RequestBody ParkRunner toBeParkRunner) {
		
		return new ResponseEntity<>(parkRunService.registerRunner(toBeParkRunner), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{parkRunId}")
	public ResponseEntity<ParkRunResponse> partialProfileUpdate(@PathVariable Long parkRunId, @RequestBody ParkRunner updateRunnerProfile) throws ParkRunException {
		
		return new ResponseEntity<>(parkRunService.updateRunnerProfile(parkRunId, updateRunnerProfile), HttpStatus.OK);
		
	}
	
}

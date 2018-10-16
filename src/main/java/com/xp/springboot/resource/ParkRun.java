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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.service.ParkRunnerService;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */

@RestController
@RequestMapping("/api/v1/runners")
public class ParkRun {

	ParkRunnerService parkRunnerService;
	
	@Autowired
	public ParkRun(ParkRunnerService parkRunnerService) {
		
		this.parkRunnerService = parkRunnerService;
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {
		
		return new ResponseEntity<List<ParkRunner>>(parkRunnerService.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{parkRunId}")
	public ResponseEntity<ParkRunner> getParkRunner(@PathVariable Long parkRunId) throws ParkRunException {
		
		return new ResponseEntity<ParkRunner>(parkRunnerService.getParkRunnerById(parkRunId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ParkRunResponse> registerRunner(@RequestBody ParkRunner toBeParkRunner) {
		
		return new ResponseEntity<>(parkRunnerService.registerRunner(toBeParkRunner), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{parkRunId}")
	public void partialProfileUpdate(@PathVariable Long parkRunId, @RequestBody ParkRunner updateRunnerProfile) throws ParkRunException {
		
		parkRunnerService.updateRunnerProfile(parkRunId, updateRunnerProfile);
		
	}
	
}

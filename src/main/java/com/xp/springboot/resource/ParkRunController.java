package com.xp.springboot.resource;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.service.ParkRunnerService;

@RestController
public class ParkRunController {

	ParkRunnerService parkRunnerService;
	
	@Autowired
	public ParkRunController(ParkRunnerService parkRunnerService) {
		
		this.parkRunnerService = parkRunnerService;
		
	}
	
	
	@GetMapping("/runners")
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {
		
		return new ResponseEntity<List<ParkRunner>>(parkRunnerService.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@GetMapping("/runner/{parkRunId}")
	public ResponseEntity<ParkRunner> getParkRunner(@PathVariable Long parkRunId) throws ParkRunException {
		
		return new ResponseEntity<ParkRunner>(parkRunnerService.getParkRunnerById(parkRunId), HttpStatus.OK);
		
	}
	
	@PostMapping("/runner")
	public Long registerRunner(@RequestBody ParkRunner toBeParkRunner) {
		
		return parkRunnerService.registerRunner(toBeParkRunner).getParkRunId();
	}
	
	@PatchMapping("/runner/{parkRunId}")
	public void partialProfileUpdate(@RequestBody ParkRunner updateRunnerProfile) {
		
		parkRunnerService.updateRunnerProfile(updateRunnerProfile);
		
	}
	
}

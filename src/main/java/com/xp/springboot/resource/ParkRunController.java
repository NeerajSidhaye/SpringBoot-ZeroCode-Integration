package com.xp.springboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.service.ParkRunnerService;

@RestController
public class ParkRunController {

	@Autowired
	ParkRunnerService parkRunnerServivce;
	
	@GetMapping("/parkrunners")
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {
		
		return new ResponseEntity<List<ParkRunner>>(parkRunnerServivce.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@PostMapping("/registerRunner")
	public Long registerRunner(@RequestBody ParkRunner toBeParkRunner) {
		
		return parkRunnerServivce.registerRunner(toBeParkRunner).getParkRunId();
	}
	
}

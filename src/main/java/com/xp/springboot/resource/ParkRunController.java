package com.xp.springboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.model.ParkRunner;
import com.xp.springboot.respository.ParkRunnerRepository;

@RestController
public class ParkRunController {

	@Autowired
	private ParkRunnerRepository parkRunnerRepository;
	
	@GetMapping("/parkrunners/")
	public ResponseEntity<String> geAllParkRunners() {
		System.out.println("ParkRunController.geAllParkRunners()");
		Iterable<ParkRunner> parkRunners =parkRunnerRepository.findAll();
		StringBuilder sb = new StringBuilder();
		
		parkRunners.forEach(runner -> sb.append(runner.getName()+ "<br>"));
		
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
		
	}
	
}

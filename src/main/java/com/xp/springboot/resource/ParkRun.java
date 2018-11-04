package com.xp.springboot.resource;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.dto.PartialUpdateDTO;
import com.xp.springboot.model.dto.RegisterRunnerDTO;
import com.xp.springboot.service.ParkRunServices;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */

@RestController
@RequestMapping("/api/v1/runners")
public class ParkRun {

	private ParkRunServices parkRunService;
	private ModelMapper modelMapper;
	
	@Autowired
	public ParkRun(ParkRunServices parkRunServices, ModelMapper modelMapper) {
		
		this.parkRunService = parkRunServices;
		this.modelMapper = modelMapper;
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {

		return new ResponseEntity<>(parkRunService.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{parkRunId}")
	public ResponseEntity<ParkRunner> getParkRunner(@PathVariable Long parkRunId) throws ParkRunException {
		
		return new ResponseEntity<>(parkRunService.getParkRunnerById(parkRunId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ParkRunResponse> registerRunner(@RequestBody RegisterRunnerDTO toBeParkRunner) {
		
		return new ResponseEntity<>(parkRunService.registerRunner(convertRegisterRunnerDtoToEntity(toBeParkRunner)), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{parkRunId}")
	public ResponseEntity<ParkRunResponse> partialProfileUpdate(@PathVariable Long parkRunId, @RequestBody PartialUpdateDTO updateRunnerProfile) throws ParkRunException {
		
		
		return new ResponseEntity<>(parkRunService.updateRunnerProfile(parkRunId, convertPartialUpdateDtoToEntity(updateRunnerProfile)), HttpStatus.OK);
		
	}
	
	private ParkRunner  convertPartialUpdateDtoToEntity(PartialUpdateDTO partialUpdateDTO) {

		return modelMapper.map(partialUpdateDTO, ParkRunner.class);
	}
	
	private ParkRunner convertRegisterRunnerDtoToEntity(RegisterRunnerDTO registerRunner) {
		return modelMapper.map(registerRunner, ParkRunner.class);
	}
	
}

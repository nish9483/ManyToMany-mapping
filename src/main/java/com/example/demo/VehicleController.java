package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
	@Autowired
	private VehicleRepo vehicleRepo;
	
	
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicle>saveVehicle(@RequestBody Vehicle vehicle)
	{
	Vehicle o=vehicleRepo.save(vehicle);
		return new ResponseEntity<Vehicle>(o,HttpStatus.CREATED);
	}
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>>getAllVehicle()
	{
	List<Vehicle> o=vehicleRepo.findAll();
		return new ResponseEntity<List<Vehicle>>(o,HttpStatus.OK);
	}
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle>getVehicleById(@PathVariable int id)
	{
	Optional<Vehicle> o=vehicleRepo.findById(id);
	if(o.isPresent())
	{
		Vehicle v=o.get();
		return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
	}
	
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle>updateVehicle(@RequestBody Vehicle vehicle,@PathVariable int id)
	{
		Optional<Vehicle> l=vehicleRepo.findById(id);
		if(l.isPresent())
		{
			Vehicle e=l.get();
			e.setName(vehicle.getName());
			Vehicle n=vehicleRepo.save(e);
			return new ResponseEntity<Vehicle>(n,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Vehicle>(HttpStatus.OK);
		}
		}
	
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Void>deleteVehicle(@PathVariable int id)
	{
		Optional<Vehicle> l=vehicleRepo.findById(id);
		if(l.isPresent())
		{
			vehicleRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
			
		}
	
		
	}
	
	



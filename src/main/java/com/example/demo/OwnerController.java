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
public class OwnerController {
	@Autowired
	private OwnerRepo ownerRepo;
	
	
	@PostMapping("/owner")
	public ResponseEntity<Owner>saveOwner(@RequestBody Owner owner)
	{
		Owner o=ownerRepo.save(owner);
		return new ResponseEntity<Owner>(o,HttpStatus.CREATED);
	}
	
	@GetMapping("/owner")
	public ResponseEntity<List<Owner>>getAllVehicle()
	{
	List<Owner> o=ownerRepo.findAll();
		return new ResponseEntity<List<Owner>>(o,HttpStatus.OK);
	}
	
	@GetMapping("/owner/{id}")
	public ResponseEntity<Owner>getOwnerById(@PathVariable int id)
	{
	Optional<Owner> o=ownerRepo.findById(id);
	if(o.isPresent())
	{
		Owner v=o.get();
		return new ResponseEntity<Owner>(v,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Owner>(HttpStatus.OK);
	}
	}
	
	@PutMapping("/owner/{id}")
	public ResponseEntity<Owner>updateOwner(@RequestBody Owner owner,@PathVariable int id)
	{
		Optional<Owner> l=ownerRepo.findById(id);
		if(l.isPresent())
		{
			Owner e=l.get();
			e.setName(owner.getName());
			e.setGender(owner.getGender());
			Owner n=ownerRepo.save(e);
			return new ResponseEntity<Owner>(n,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Owner>(HttpStatus.OK);
		}
		}
	
	@DeleteMapping("/owner/{id}")
	public ResponseEntity<Void>deleteOwner(@PathVariable int id)
	{
		Optional<Owner> l=ownerRepo.findById(id);
		if(l.isPresent())
		{
			ownerRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
			
		}
	
		
	}
	
	





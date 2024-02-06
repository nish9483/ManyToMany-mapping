package com.example.demo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	

	@ManyToMany(mappedBy="vehicle")
	private Set<Owner>owner;
	


	public Vehicle(int id, String name, Set<Owner> owner) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
	}

	 Vehicle()
	{
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Owner> getOwner() {
		return owner;
	}


	public void setOwner(Set<Owner> owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + "]";
	}
	
	
}

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
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String gender;
	
	
	@ManyToMany
	
	@JoinTable(name="vehicle_owner",
	joinColumns=@JoinColumn(name="owner_id"),
	inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Set<Vehicle>vehicle;
	
	public Owner()
	{
		
	}

	public Owner(int id, String name, String gender, Set<Vehicle> vehicle) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.vehicle = vehicle;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
	

}

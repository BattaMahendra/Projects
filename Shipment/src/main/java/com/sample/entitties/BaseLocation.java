package com.sample.entitties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseLocation {
	
	public BaseLocation() {
		super();
	}
	public BaseLocation(long id, String towerAddress, String city) {
		super();
		this.id = id;
		this.towerAddress = towerAddress;
		this.city = city;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String towerAddress;
	String city;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTowerAddress() {
		return towerAddress;
	}
	public void setTowerAddress(String towerAddress) {
		this.towerAddress = towerAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}

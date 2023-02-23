package com.sample.controllers;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entitties.BaseLocation;
import com.sample.services.BaseLocationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/BL")
public class BaseLocationController {
	@Autowired
	private BaseLocationService locationService;
	
	@GetMapping("/all")
	public List<BaseLocation> getAll() {
		
		 
		System.out.println("we are in BL controller");
		
		return locationService.getAllBaseLocations();
	}
	
	@GetMapping("/id/{id}")
	public BaseLocation getById(@PathVariable("id") long id){
		return locationService.getAllBaseLocationsById(id).get();
	}
	
	@PutMapping("/update")
	public BaseLocation  updateABaseLocation(@RequestBody BaseLocation baseLocation) {
		return locationService.updateABaseLocation(baseLocation);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addAShipper(@RequestBody BaseLocation baseLocation){
		
		if(baseLocation.getTowerAddress()!=null&&baseLocation.getCity()!=null) 
			return new ResponseEntity<BaseLocation> (locationService.addBaseLocation(baseLocation),HttpStatus.CREATED);
		
	
		return new ResponseEntity<String>("please give proper location details" ,HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBaseLocation(@PathVariable("id") long id) {
	
		if(locationService.deleteAllBaseLocationsById(id)) {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Give proper base location id!.", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/allCities")
	public TreeSet<String> getAllCities(){
		return locationService.getAllCitiesOfBL();
	}
	
	@GetMapping("/city/{city}")
	public  BaseLocation getByCity(@PathVariable("city") String city){
		return locationService.findByCity(city).get(0);
	}

}

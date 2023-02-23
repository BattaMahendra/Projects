package com.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entitties.BaseLocation;
import com.sample.entitties.Employee;
import com.sample.repositories.BaseLocationRepository;

@Service
public class BaseLocationService {
	
	@Autowired
	private BaseLocationRepository baseLocationRepo;
	
	public List<BaseLocation> getAllBaseLocations(){
		return baseLocationRepo.findAll();
	}
	
	public Optional<BaseLocation> getAllBaseLocationsById(long id){
		return baseLocationRepo.findById(id);
	}
	
	public BaseLocation addBaseLocation(BaseLocation b){
		return baseLocationRepo.save(b);
	}
	
	public BaseLocation updateABaseLocation(BaseLocation b) {
		BaseLocation updatedBL=new BaseLocation();
		if(baseLocationRepo.existsById(b.getId())) {
			updatedBL=baseLocationRepo.getById(b.getId());
			updatedBL.setTowerAddress(b.getTowerAddress());
			updatedBL.setCity(b.getCity());
			return baseLocationRepo.save(updatedBL);
		}
		
		return null;
		
	}
	
	public boolean deleteAllBaseLocationsById(long id){
		if(baseLocationRepo.existsById(id)) {
		 baseLocationRepo.deleteById(id);
		 return true;
		}
		
		return false;
	}
	
	public TreeSet<String> getAllCitiesOfBL(){
		List<String> cityList=new ArrayList<>();
		cityList=baseLocationRepo.getAllCities();
		TreeSet<String> citySet=new TreeSet<>(cityList);
		return citySet;
	}
	
	public List<BaseLocation> findByCity(String city){
		return baseLocationRepo.findByCity(city);
	}

}

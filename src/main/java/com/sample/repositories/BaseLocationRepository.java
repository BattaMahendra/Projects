package com.sample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sample.entitties.BaseLocation;


@Repository
public interface BaseLocationRepository extends JpaRepository<BaseLocation, Long> {
	
	@Query(
			value = "select city from base_location",
			nativeQuery = true
			
			)
	List<String> getAllCities();
	
	public List<BaseLocation> findByCity(String city);

}

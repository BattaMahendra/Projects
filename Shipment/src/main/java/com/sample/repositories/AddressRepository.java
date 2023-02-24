package com.sample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.entitties.EmployeeAddress;

@Repository
public interface AddressRepository extends JpaRepository<EmployeeAddress, Long>{
	
	@Query(
			value = "select * from address where pincode= ?1",
			nativeQuery = true
			
			)
	List<EmployeeAddress> getAllAddressByPincode(long pincode);
	
	@Query(
			value = "select * from address where state= ?1",
			nativeQuery = true
			
			)
	List<EmployeeAddress> getAllAddressByState(String state);
	
	
	@Query(
			value = "select * from address where city= ?1",
			nativeQuery = true
			
			)
	List<EmployeeAddress> getAllAddressBycity(String city);
	
	@Query(
			value = "select * from address where address_id= ?1",
			nativeQuery = true
			
			)
	EmployeeAddress getShipmentStatusByAddressId(long id);
	
	@Query(
			value = "select * from address where shipper_id= ?1",
			nativeQuery = true
			
			)
	List<EmployeeAddress> getAddressByShipperId(long id);
	
	@Query(
			value = "select city from address",
			nativeQuery = true
			
			)
	List<String> getAllCities();
	
	@Query(
			value = "select state from address",
			nativeQuery = true
			
			)
	List<String> getAllStates();



}

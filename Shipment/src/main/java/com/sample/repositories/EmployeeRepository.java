package com.sample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sample.entitties.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
//	@Query(
//			value = "select * from employee where base_location= ?1",
//			nativeQuery = true
//			
//			)
//	List<Employee> getEmployeeDetailsByBAseLocation(String base_Location);
	
	@Query(
			value = "select * from employee where base_location_id= ?1",
			nativeQuery = true
			
			)
	List<Employee> getEmployeeDetailsByBAseLocationId(long base_Location_id);
	
	

}

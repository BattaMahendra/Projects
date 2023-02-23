package com.sample.controllers;

import java.util.ArrayList;
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

import com.sample.entitties.Employee;
import com.sample.entitties.EmployeeAddress;
import com.sample.services.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/allEmp")
	public List<Employee> getAll(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("/getEmpStatus/{id}")
	public Employee getStatus(@PathVariable long id) {
		List<Employee> empList=new ArrayList<>();
		empList=getAll();
		
		for(Employee e:empList) {
			if(e.getEMPLOYEE_ID()==id) {
				return e;
			}
		}
//		
		return null;
		
//		return empList.stream().filter(x-> x.getEMPLOYEE_ID()==id).map(x->{
//			return x;
//		});
	}
	
	@GetMapping("/status/{id}")
	public String getShipmentStatus(@PathVariable("id") long id){
		return empService.getShipmentStausByEmpId(id);
	}
	

	
	@GetMapping("/all/ByBLId/{id}")
	public List<Employee> getByBaseLocationId(@PathVariable long id){
		return empService.getByBaseLocationId(id);
	}
	
	@PutMapping("/update")
	public Employee updateAEmployee(@RequestBody Employee emp) {
		return empService.updateAEmp(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
	
		if(empService.deleteAEmp(id)) {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Give proper employee id!.", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/allAddress")
	public List<EmployeeAddress> getAllAdrress(){
		return empService.getAllEmployeesAddress();
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addAEmployees(@RequestBody Employee emp){
		
		if(emp.getEMPLOYEE_NAME()!=null&&emp.getEMPLOYEE_ROLE()!=null) 
			return new ResponseEntity<Employee> (empService.addAEmployees(emp),HttpStatus.CREATED);
		
	
		return new ResponseEntity<String>("please give proper employee details" ,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addAddress")
	public ResponseEntity<?> addAddress(@RequestBody EmployeeAddress empAdsress){
		
		if(empAdsress.getSTATE()!=null&&empAdsress.getCITY()!=null) 
			return new ResponseEntity<EmployeeAddress> (empService.addAddress(empAdsress),HttpStatus.CREATED);
		
	
		return new ResponseEntity<String>("please give proper address details" ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/addr/city/{city}")
	public List<EmployeeAddress> getAddressByCity(@PathVariable String city){
		return empService.getByCity(city);
	}

	@GetMapping("/addr/state/{state}")
	public List<EmployeeAddress> getAddressByState(@PathVariable String state){
		return empService.getByState(state);
	}
	
	@GetMapping("/addr/{pincode}")
	public List<EmployeeAddress> getAddressByPIncode(@PathVariable long pincode){
		return empService.getByPincode(pincode);
	}
	
	@GetMapping("/allCities")
	public TreeSet<String> getAllCities(){
		return empService.getAllCitiesOfEmp();
	}
	
	@GetMapping("/allStates")
	public TreeSet<String> getAllStates(){
		return empService.getAllStatesOfEmp();
	}
}

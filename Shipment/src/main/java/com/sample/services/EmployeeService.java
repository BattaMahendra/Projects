package com.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entitties.Employee;
import com.sample.entitties.EmployeeAddress;
import com.sample.repositories.AddressRepository;
import com.sample.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee addAEmployees(Employee emp){
		return empRepo.save(emp);
	}
	
	public List<EmployeeAddress> getAllEmployeesAddress(){
		return addressRepo.findAll();
	}
	
	public EmployeeAddress addAddress(EmployeeAddress empAddress){
		return addressRepo.save(empAddress);
	}
	
	
	
	public List<Employee> getByBaseLocationId(long id) {
		return empRepo.getEmployeeDetailsByBAseLocationId(id);
	}
	
	public Employee updateAEmp(Employee emp) {
		Employee upEmp=new Employee();
		if(empRepo.existsById(emp.getEMPLOYEE_ID())) {
			upEmp=empRepo.getById(emp.getEMPLOYEE_ID());
			upEmp.setEMPLOYEE_NAME(emp.getEMPLOYEE_NAME());
			upEmp.setMobileNumber(emp.getMobileNumber());
			upEmp.setEMPLOYEE_ROLE(emp.getEMPLOYEE_ROLE());
			if(emp.getAddress()!=null) {
			upEmp.setAddress(emp.getAddress());
			}
			return empRepo.save(upEmp);
		}
		
		return null;
		
	}
	
	public boolean deleteAEmp(long id) {
		if(empRepo.existsById(id)) {
		addressRepo.delete(empRepo.getById(id).getAddress());
		empRepo.deleteById(id);
		return true;
		}
		return false;
	}
	
	public List<EmployeeAddress> getByPincode(long pincode){
		return addressRepo.getAllAddressByPincode(pincode);
	}
	
	public List<EmployeeAddress> getByState(String state){
		return addressRepo.getAllAddressByState(state);
	}

	public List<EmployeeAddress> getByCity(String city){
		return addressRepo.getAllAddressBycity(city);
	}
	
	public String getShipmentStausByEmpId(long id) {
		return 
			addressRepo
				.getShipmentStatusByAddressId(empRepo
											.findById(id)
											.get()
											.getAddress()
											.getADDRESS_ID())
			                                .getShipmentStatus();
													
	}
	
	public TreeSet<String> getAllCitiesOfEmp(){
		List<String> cityList=new ArrayList<>();
		cityList=addressRepo.getAllCities();
		TreeSet<String> citySet=new TreeSet<>(cityList);
		return citySet;
	}
	
	public TreeSet<String> getAllStatesOfEmp(){
		List<String> stateList=new ArrayList<>();
		stateList=addressRepo.getAllStates();
		TreeSet<String> stateSet=new TreeSet<>(stateList);
		return stateSet;
	}
}

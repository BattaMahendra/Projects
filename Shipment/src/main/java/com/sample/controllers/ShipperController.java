package com.sample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entitties.Employee;
import com.sample.entitties.EmployeeAddress;
import com.sample.entitties.Shipper;
import com.sample.services.EmployeeService;
import com.sample.services.ShipperService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/shipper")
public class ShipperController {
	
	@Autowired
	private ShipperService shipperServ;
	
	@GetMapping("/all")
	public List<Shipper> getAll(){
		return shipperServ.getAllSHIPPER();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addAShipper(@RequestBody Shipper shipper){
		
		List<Shipper> shipperList=new ArrayList<>();
		shipperList=shipperServ.getAllSHIPPER();
		boolean nameExists = shipperList
							.stream()
							.anyMatch(m -> m.getShipperEmail().equalsIgnoreCase(shipper.getShipperEmail())
										   &&m.getShipperName().equalsIgnoreCase(shipper.getShipperName())
									);
							
	
			
		
		
		if(shipper.getShipperName()!=null&&shipper.getShipperEmail()!=null&&shipper.getShipperPassword()!=null&&!nameExists) 
			return new ResponseEntity<Shipper> (shipperServ.addASHIPPER(shipper),HttpStatus.CREATED);
		
	
		return new ResponseEntity<Boolean>(false ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/validate/{emailAddress}/{password}")
	public boolean validate(@PathVariable String emailAddress , @PathVariable String password){
		return shipperServ.validateAShipper(emailAddress, password);
	}

	@GetMapping("/addrByShipperId/{id}")
	public List<EmployeeAddress> getAllAddressOfAShipper(@PathVariable long id){
		return shipperServ.getAllAddressOfAShipper(id);
	}
	
	
	@GetMapping("/updateUserStatus/{status}/{addressId}/{shipperId}")
	public String updateUserStatus(@PathVariable String status, @PathVariable long addressId,@PathVariable long shipperId) {
		return shipperServ.updatestatusOfUser(status, addressId, shipperId);
		
	}
	
	@PutMapping("/addAddressToShipper/{addressId}/{shipperId}")
	public EmployeeAddress addAddressToShipper(@PathVariable long addressId,@PathVariable long shipperId) {
		return shipperServ.addAAddressToShipper(addressId, shipperId);
	}
			
}

package com.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entitties.Employee;
import com.sample.entitties.EmployeeAddress;
import com.sample.entitties.Shipper;
import com.sample.repositories.AddressRepository;
import com.sample.repositories.ShipperRepository;

@Service
public class ShipperService {
	
	@Autowired
	private ShipperRepository shipperRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public boolean validateAShipper(String emailId, String passWord) {
		if(shipperRepo.findByShipperEmailAddressAndPassword(emailId, passWord)!=null) {
			return true;
		}
		
		return false;
		
	}

	public Shipper addASHIPPER(Shipper shipper){
		return shipperRepo.save(shipper);
	}
	
	public List<Shipper> getAllSHIPPER(){
		return shipperRepo.findAll();
	}
	
	public List<EmployeeAddress> getAllAddressOfAShipper(long id) {
		if(shipperRepo.existsById(id)) {
			return addressRepo.getAddressByShipperId(id);
		}
		
		return null;
	}
	
	public String updatestatusOfUser(String status, long addressId, long shipperId) {
		if(!getAllAddressOfAShipper(shipperId).isEmpty()) {
		List<EmployeeAddress> shipperAddressList=new ArrayList<>();
		shipperAddressList=getAllAddressOfAShipper(shipperId);
		return shipperAddressList
			.stream()
			.filter(x-> x.getADDRESS_ID()==addressId)
			.map(address->{
				address.setShipmentStatus(status);
				if(addressRepo.save(address)!=null) {
					return address.getShipmentStatus();
				}
				return null;
			}).toString();
	}
		return null;
	}
	
	public EmployeeAddress addAAddressToShipper(long addressId , long shipperId) {
		if(shipperRepo.existsById(shipperId)
			&&addressRepo.existsById(addressId)
			&&addressRepo.getById(addressId).getShipper()==null
			) {
			EmployeeAddress address=new EmployeeAddress();
			address=addressRepo.getById(addressId);
			address.setShipper(shipperRepo.getById(shipperId));
			return addressRepo.save(address);			
		}
		return null;
	}
}

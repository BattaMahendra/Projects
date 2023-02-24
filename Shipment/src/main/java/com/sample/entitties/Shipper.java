package com.sample.entitties;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shipper")
public class Shipper {
	
	
	public Shipper() {
		super();
	}
	public Shipper(long shipperId, String shipperName, String shipperEmail, String shipperPassword) {
		super();
		this.shipperId = shipperId;
		this.shipperName = shipperName;
		this.shipperEmail = shipperEmail;
		this.shipperPassword = shipperPassword;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	long shipperId;
	String shipperName;
	String shipperEmail;
	String shipperPassword;
//	@OneToMany(
//	        mappedBy = "shipper",
//	        cascade = CascadeType.ALL,
//	        orphanRemoval = true
//	    )
//	    private List<EmployeeAddress> address = new ArrayList();
	
	
	public long getShipperId() {
		return shipperId;
	}
	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getShipperEmail() {
		return shipperEmail;
	}
	public void setShipperEmail(String shipperEmail) {
		this.shipperEmail = shipperEmail;
	}
	public String getShipperPassword() {
		return shipperPassword;
	}
	public void setShipperPassword(String shipperPassword) {
		this.shipperPassword = shipperPassword;
	}
	
}

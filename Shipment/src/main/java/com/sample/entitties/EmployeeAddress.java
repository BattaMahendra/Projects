package com.sample.entitties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="ADDRESS")
public class EmployeeAddress {
	
	
	
	
	public EmployeeAddress(long aDDRESS_ID, String sTRRET_NAME, String cITY, long pINCODE, String sTATE,
			String shipmentStatus, Shipper shipper) {
		super();
		ADDRESS_ID = aDDRESS_ID;
		STRRET_NAME = sTRRET_NAME;
		CITY = cITY;
		PINCODE = pINCODE;
		STATE = sTATE;
		this.shipmentStatus = shipmentStatus;
		this.shipper = shipper;
	}
	public EmployeeAddress(long aDDRESS_ID, String sTRRET_NAME, String cITY, long pINCODE, String sTATE,
			String shipmentStatus) {
		super();
		ADDRESS_ID = aDDRESS_ID;
		STRRET_NAME = sTRRET_NAME;
		CITY = cITY;
		PINCODE = pINCODE;
		STATE = sTATE;
		this.shipmentStatus = shipmentStatus;
	}
	public EmployeeAddress() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	long ADDRESS_ID;
	String STRRET_NAME;
	String CITY;
	long PINCODE;
	String STATE;
	String shipmentStatus;
	
//	@OneToOne(mappedBy="Address")  //defines a bidirectional relationship.
//	    private Employee employee;
	
	
	@ManyToOne(
			cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY
			)
	@JoinColumn(
			name="shipper_id",
			referencedColumnName = "shipperId"
	
			)
	private Shipper shipper;
	public long getADDRESS_ID() {
		return ADDRESS_ID;
	}
	public void setADDRESS_ID(long aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}
	public String getSTRRET_NAME() {
		return STRRET_NAME;
	}
	public void setSTRRET_NAME(String sTRRET_NAME) {
		STRRET_NAME = sTRRET_NAME;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public long getPINCODE() {
		return PINCODE;
	}
	public void setPINCODE(long pINCODE) {
		PINCODE = pINCODE;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
}
	
	
	
	
	
	
	
	


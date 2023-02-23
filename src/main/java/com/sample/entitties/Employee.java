package com.sample.entitties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="Employee")
public class Employee {
	
	
	public Employee() {
		super();
	}

	public Employee(long eMPLOYEE_ID, String eMPLOYEE_NAME, String eMPLOYEE_ROLE, long mobileNumber,
			EmployeeAddress address, BaseLocation baseLocation) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		EMPLOYEE_NAME = eMPLOYEE_NAME;
		EMPLOYEE_ROLE = eMPLOYEE_ROLE;
		this.mobileNumber = mobileNumber;
		Address = address;
		this.baseLocation = baseLocation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long EMPLOYEE_ID;
	String EMPLOYEE_NAME;
	String EMPLOYEE_ROLE;
	long mobileNumber;
	@OneToOne(
			cascade = CascadeType.ALL	,
			fetch = FetchType.LAZY
			)
	@JoinColumn(
					name="ADDRESS_ID",
					referencedColumnName = "ADDRESS_ID"		
			)
//	@LazyToOne(value = LazyToOneOption.NO_PROXY)
	private EmployeeAddress Address;
	
	@ManyToOne(cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY
			)
	@JoinColumn(
			name="baseLocationId",
			referencedColumnName = "id"
	
			)
	private BaseLocation baseLocation;

	public long getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}

	public void setEMPLOYEE_ID(long eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}

	public String getEMPLOYEE_NAME() {
		return EMPLOYEE_NAME;
	}

	public void setEMPLOYEE_NAME(String eMPLOYEE_NAME) {
		EMPLOYEE_NAME = eMPLOYEE_NAME;
	}

	public String getEMPLOYEE_ROLE() {
		return EMPLOYEE_ROLE;
	}

	public void setEMPLOYEE_ROLE(String eMPLOYEE_ROLE) {
		EMPLOYEE_ROLE = eMPLOYEE_ROLE;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public EmployeeAddress getAddress() {
		return Address;
	}

	public void setAddress(EmployeeAddress address) {
		Address = address;
	}

	public BaseLocation getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(BaseLocation baseLocation) {
		this.baseLocation = baseLocation;
	}
	
	
	
	

}

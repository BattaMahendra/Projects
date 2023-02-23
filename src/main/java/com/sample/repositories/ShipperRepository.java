package com.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.entitties.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
	
	@Query(
			value = "select * from shipper where shipper_email= ?1 and shipper_password=?2",
			nativeQuery = true
			
			)
	Shipper findByShipperEmailAddressAndPassword(String emailAddress,String Password);

}

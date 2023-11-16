package com.qsp.hospital_Management.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_Management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	List<Address> findAddressByPincode(int pincode);
  
}

package com.qsp.hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.AddressRepo;
import com.qsp.hospital_Management.dto.Address;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address deleteAddressById(int id) {
		Optional<Address>optional=repo.findById(id);
		if(optional.isPresent()) {
			Address address=optional.get();
			repo.deleteById(id);
			return address;
		}
		return null;
	}

	public Address findAddressById(int id) {
		Optional<Address>optional=repo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Address address=optional.get();
		repo.findById(id);
		return address;
	}

	public Address updateAddress(Address address) {
			return repo.save(address);
	}

	public List<Address> findAddressByPincode(int pincode) {
		// TODO Auto-generated method stub
		return repo.findAddressByPincode(pincode);
	}
	
	

}

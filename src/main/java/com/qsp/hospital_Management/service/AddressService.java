package com.qsp.hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_Management.dao.AddressDao;
import com.qsp.hospital_Management.dto.Address;
import com.qsp.hospital_Management.dto.Hospital;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.exception.PincodeNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;
	
	ResponseStructure<Address> structure=new ResponseStructure<Address>();
	ResponseStructure<List<Address>>structure2=new ResponseStructure<List<Address>>();

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		structure.setMessage("Address Inserted Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData( dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id) {
		Address address=dao.findAddressById(id);
		
		if(address!=null) {
			structure.setMessage("Address Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( dao.deleteAddressById(id));
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Address with Given Id Not Found");
		
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {
		
		Address address= dao.findAddressById(id);
		if(address!=null) {
			structure.setMessage("Address Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}

		throw new IdNotFound("Address with Given Id Not Found");
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address address2=dao.findAddressById(id);
		if(address2!=null) {
			structure.setMessage("Address Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			address.setId(id);
			structure.setData(dao.updateAddress(address));
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Address with Given Id Not Found");
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressByPincode(int pincode) {
		
		List<Address> address= dao.findAddressByPincode(pincode);
		if(address.isEmpty()) {
			structure2.setMessage("Address Not Found");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
			structure2.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.NOT_FOUND);
		}
		throw new PincodeNotFound("Address With Given Pincode Not Found");
	}
	

}

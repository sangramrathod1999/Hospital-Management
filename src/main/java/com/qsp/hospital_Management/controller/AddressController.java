package com.qsp.hospital_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_Management.dto.Address;
import com.qsp.hospital_Management.service.AddressService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.val;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	
	@Autowired
	private AddressService service;
	
	@ApiOperation(notes = "This API is use to save Address ",value = "Save Address API")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Address saved successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}
	@ApiOperation(notes = "This API is use to delete Address",value = "Delete address API")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Addresss deleted successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int id) {
		return service.deleteAddressById(id);
	}
	
	@ApiOperation(notes = "This API is use to find the address ",value = "Find address API")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Address found successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@RequestParam int id) {
		return service.findAddressById(id);
	}
	
	@ApiOperation(notes = "This API is use to update Address ",value = "Update address API")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Address updated successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id,@RequestBody Address address) {
		return service.updateAddress(id,address);
	}
	@ApiOperation(notes = "This API is use to find address by Pincode ",value = "find address  by pincode API")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Address updated successfully")})
	@GetMapping("/{pincode}")
	public ResponseEntity<ResponseStructure<Address>> findAddressByPincode(@PathVariable int pincode){
		return service.findAddressByPincode(pincode);
	}

}

package com.qsp.hospital_Management.controller;

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

import com.qsp.hospital_Management.dto.Hospital;
import com.qsp.hospital_Management.service.HospitalService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService service;

	@ApiOperation(notes = "This API is use to save the hospital details into the database", value = "Save hospital API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "data save successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Hospital hospital) {
		return service.save(hospital);
	}

	@ApiOperation(notes = "This API is use to get the details of Hospital ", value = "Find Hospital API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Hospital found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}

	@ApiOperation(notes = "This API is use to delete hospital", value = "Delete Hospital API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Hospital deleted successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int id) {
		return service.deleteHospitalById(id);
	}

	@ApiOperation(notes = "This API is use to update hospital", value = "Update hospital API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Hospitla updated Successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}

	@ApiOperation(notes = "This API is use to find hospital by Email", value = "Find hospital By Email API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Hospital found Successfully") })
	@GetMapping("/{email}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(@PathVariable String email) {
		return service.findHospitalByEmail(email);
	}

}

package com.qsp.hospital_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_Management.dto.Branch;
import com.qsp.hospital_Management.dto.Hospital;
import com.qsp.hospital_Management.service.BranchService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService service;

	@ApiOperation(notes = "This API is use to save branch ", value = "Save branch API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "branch save successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,
			@RequestParam int hospitalID, @RequestParam int addressID) {
		return service.saveBranch(branch, hospitalID, addressID);
	}

	@ApiOperation(notes = "This API is use to find brach by hospital ", value = "Find branch API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Branch found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getBranchByHospital(@RequestParam int id) {
		return service.getBranchByHospital(id);
	}

	@ApiOperation(notes = "This API is use to delete branch by id ", value = "Delete branch API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Branch deleted successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchId(@RequestParam int id) {
		return service.deleteBranchById(id);
	}

	@ApiOperation(notes = "This API is use to find brach by id ", value = "Find branch API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Branch found successfully") })
	@GetMapping("/id")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id) {
		return service.getBranchById(id);
	}

	@ApiOperation(notes = "This API is use to update branch ", value = "Update branch API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Branch updated successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int id, @RequestBody Branch branch,
			@RequestParam int hospitalID, @RequestParam int addressID) {
		return service.updateBranchById(id, branch, hospitalID, addressID);
	}

}

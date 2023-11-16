package com.qsp.hospital_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_Management.dao.EncounterDao;
import com.qsp.hospital_Management.dto.Encounter;
import com.qsp.hospital_Management.service.EncounterService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	@Autowired
	private EncounterService service;

	@ApiOperation(notes = "This API is use to save Encounter ", value = "Save Encounter API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Encounter saved successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int personID, @RequestParam int branchID) {
		return service.saveEncounter(encounter, personID, branchID);
	}

	@ApiOperation(notes = "This API is use to find Encounter ", value = "Save Encounter API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Encounter found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id) {
		return service.getEncounterById(id);
	}

	@ApiOperation(notes = "This API is use to update Encounter ", value = "Update Encounter API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Encounter updated successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, @RequestBody Encounter encounter,
			@RequestParam int personID, @RequestParam int branchID) {
		return service.updateEncounter(id, encounter, personID, branchID);
	}

	@ApiOperation(notes = "This API is use to delete Encounter ", value = "delete Encounter API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Encounter deleted successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) {
		return service.deleteEncounterById(id);
	}

}

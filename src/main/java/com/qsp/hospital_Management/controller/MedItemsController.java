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

import com.qsp.hospital_Management.dto.MedItems;
import com.qsp.hospital_Management.service.MedItemsService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medItems")
public class MedItemsController {

	@Autowired
	private MedItemsService service;

	@ApiOperation(notes = "This API is use to save MedItem ", value = "Save MedItem API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "MedItem saved successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestParam int medOrderId,
			@RequestBody MedItems medItems) {
		return service.saveMedItems(medOrderId, medItems);
	}

	@ApiOperation(notes = "This API is use to delete MedItem ", value = "Delete MedItem API")
	@ApiResponses(value = { @ApiResponse(code = 202, message = "MedItem deleted successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemById(@RequestParam int id) {
		return service.deleteMedItemById(id);
	}

	@ApiOperation(notes = "This API is use to find MedItem ", value = "Find MedItem API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "MedItem found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int id) {
		return service.getMedItemById(id);
	}

	@ApiOperation(notes = "This API is use to update MedItem ", value = "Update MedItem API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "MedItem updated successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItemById(@RequestParam int id,
			@RequestBody MedItems items) {
		return service.updateMedItemById(id, items);
	}

}

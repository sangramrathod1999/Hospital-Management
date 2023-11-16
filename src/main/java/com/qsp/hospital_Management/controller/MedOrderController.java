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

import com.qsp.hospital_Management.dto.MedOrder;
import com.qsp.hospital_Management.service.MedOrderService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medOrder")
public class MedOrderController {

	@Autowired
	private MedOrderService service;

	@ApiOperation(notes = "This API is use to save medorder ", value = "Save medorder API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Medorder saved successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int encounterId) {
		return service.saveMedOrder(medOrder, encounterId);

	}

	@ApiOperation(notes = "This API is use to find medorder ", value = "Find medorder API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Medorder found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return service.getMedOrderById(id);
	}

	@ApiOperation(notes = "This API is use to update medorder ", value = "Update medorder API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Medorder updated successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id,
			@RequestBody MedOrder medOrder) {
		return service.updateMedOrder(id, medOrder);
	}

	@ApiOperation(notes = "This API is use to delete medorder ", value = "Delete medorder API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Medorder deleted successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(@RequestParam int id) {
		return service.deleteMedOrderById(id);
	}

}

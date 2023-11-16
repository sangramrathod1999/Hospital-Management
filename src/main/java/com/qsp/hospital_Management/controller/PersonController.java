package com.qsp.hospital_Management.controller;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;

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

import com.qsp.hospital_Management.dto.Person;
import com.qsp.hospital_Management.service.PersonService;
import com.qsp.hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService service;

	@ApiOperation(notes = "This API is use to save person ", value = "Save person API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Person saved successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(notes = "This API is use to find person ", value = "Find person API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Person found successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}

	@ApiOperation(notes = "This API is use to delete person by id ", value = "Delete person API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Person  removed successfully") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePersonById(@RequestParam int id) {
		return service.deletePersonById(id);
	}

	@ApiOperation(notes = "This API is use to update person ", value = "Update person API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Person updated successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@ApiOperation(notes = "This API is use to find person by phone number ", value = "Find person API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Person saved successfully") })
	@GetMapping("/{phone}")
	public ResponseEntity<ResponseStructure<Person>> getPersonByPhone(@PathVariable long phone) {
		return service.getPersonByPhone(phone);
	}

	@ApiOperation(notes = "This API is use to find person by email ", value = "Find person API")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Person saved successfully") })
	@GetMapping("/email")
	public ResponseEntity<ResponseStructure<Person>> getPersonByEmail(@PathVariable String email) {
		return service.getPersonByEmail(email);
	}

}

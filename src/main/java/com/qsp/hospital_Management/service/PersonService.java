package com.qsp.hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_Management.dao.PersonDao;
import com.qsp.hospital_Management.dto.MedOrder;
import com.qsp.hospital_Management.dto.Person;
import com.qsp.hospital_Management.exception.EmailNotFound;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.exception.PhoneNumberNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	ResponseStructure<Person> structure = new ResponseStructure<Person>();

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		structure.setMessage("Person Inserted Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		Person person = dao.getPersonById(id);
		if (person != null) {
			structure.setMessage("Person Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("Person with given id not found");
	}

	public ResponseEntity<ResponseStructure<Person>> deletePersonById(int id) {
		
		Person person = dao.getPersonById(id);
		if (person != null) {
			structure.setMessage("Person Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletePersonById(id));
			 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("Person with given id not found");
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		Person person2 = dao.getPersonById(id);
		if (person2 != null) {
			structure.setMessage("Person Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			person.setId(id);

			structure.setData(dao.updatePerson(person));
			 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Person with given id not found");

	}

	public ResponseEntity<ResponseStructure<Person>> getPersonByPhone(long phone) {
		Person person= dao.findPersonByPhone(phone);
		if(person!=null) {
			structure.setMessage("Person Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		throw new PhoneNumberNotFound("Person with given phone number not found");
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonByEmail(String email) {
	 Person	person= dao.getPersonByEmail(email);
		if(person!=null) {
			structure.setMessage("Person Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			 return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		throw new EmailNotFound("Person with given id not found");
		
	}

}

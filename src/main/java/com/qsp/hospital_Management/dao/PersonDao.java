package com.qsp.hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.PersonRepo;
import com.qsp.hospital_Management.dto.Person;

@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {
		return repo.save(person);
	}
	
	public Person getPersonById(int id) {
		Optional<Person>optional=repo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public Person deletePersonById(int id) {
		Optional<Person>optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);;
			return optional.get();
		}return null;
	}

	public Person updatePerson(Person person) {
		return repo.save(person);
	}
	public Person findPersonByPhone(long phone) {
		Person person=repo.findPersonByPhone(phone);
		if(person !=null) {
			return person;
		}
		return null;
	}
	
	public Person getPersonByEmail(String email) {
		Person person=repo.getPersonByEmail(email);
		if(person !=null) {
			return person;
		}
		
		return null;
	}
	

}

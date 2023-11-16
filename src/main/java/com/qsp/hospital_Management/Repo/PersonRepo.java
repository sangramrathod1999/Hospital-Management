package com.qsp.hospital_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.hospital_Management.dto.Person;

public interface PersonRepo  extends JpaRepository<Person, Integer>{
	
	Person findPersonByPhone(long phone);
	
	
	@Query("SELECT p FROM Person p WHERE p.email=?1")
	Person getPersonByEmail(String email) ;
	
	

}

package com.qsp.hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.HospitalRepo;
import com.qsp.hospital_Management.dto.Hospital;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;

	public Hospital save(Hospital hospital) {
		return repo.save(hospital);
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital deleteHospitalById(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			Hospital hospital = optional.get();
			repo.delete(hospital);
			return hospital;
		}
		return null;
	}

	public Hospital updateHospital( Hospital hospital) {
			return repo.save(hospital);	
	}

	public Hospital findHospitalByEmail(String email) {
		
		return repo.findHospitalByEmail(email);
	}

}

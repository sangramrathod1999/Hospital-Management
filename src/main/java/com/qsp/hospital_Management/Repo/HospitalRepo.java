package com.qsp.hospital_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_Management.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	
	Hospital findHospitalByEmail(String email);

}

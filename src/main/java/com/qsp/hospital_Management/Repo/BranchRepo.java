package com.qsp.hospital_Management.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.hospital_Management.dto.Branch;
import com.qsp.hospital_Management.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer>{
	@Query("SELECT b FROM Branch b WHERE b.hospital.hospitalID=?1")
	List<Branch> getBranchByHospitalId(int id);

}

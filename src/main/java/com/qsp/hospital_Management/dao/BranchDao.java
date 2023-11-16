package com.qsp.hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.BranchRepo;
import com.qsp.hospital_Management.dto.Branch;
import com.qsp.hospital_Management.dto.Hospital;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo repo;
	
	public Branch saveBranch(Branch branch) {
		return repo.save(branch);
	}

	public List<Branch> getBranchByHospital(int id) {
		List<Branch>list= repo.getBranchByHospitalId(id);
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}

	public Branch deleteBranchById(int id) {
		Optional<Branch>optional=repo.findById(id);
		if(optional.isPresent()) {
			Branch branch=optional.get();
			repo.delete(branch);
			return branch;
		}
		return null;
	}

	public Branch getBranchById(int id) {
		Optional<Branch>optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}

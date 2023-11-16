package com.qsp.hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.hospital_Management.dao.AddressDao;
import com.qsp.hospital_Management.dao.BranchDao;
import com.qsp.hospital_Management.dao.HospitalDao;
import com.qsp.hospital_Management.dto.Address;
import com.qsp.hospital_Management.dto.Branch;
import com.qsp.hospital_Management.dto.Hospital;
import com.qsp.hospital_Management.exception.DataNotFound;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao ;
	@Autowired
	private AddressDao addressDao;
	
	ResponseStructure<Branch>structure=new ResponseStructure<Branch>();
	ResponseStructure<List<Branch>>structure2=new ResponseStructure<List<Branch>>();
		
	

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hospitalID, int addressID) {
		Hospital hospital=hospitalDao.getHospitalById(hospitalID);
		Address address=addressDao.findAddressById(addressID);
		if(address!=null && hospital!=null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			structure.setMessage("Branch Added Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveBranch(branch));
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}else if(address==null) {
			throw new IdNotFound("Address With Given Id Not found");
		}
		throw new IdNotFound("Hospital With Given ID Not Found");
		
	}



	public ResponseEntity<ResponseStructure<Branch>> getBranchByHospital(int id) {
		List<Branch> branchs=dao.getBranchByHospital(id);
		if(branchs==null) {
			throw new DataNotFound("Hospital With Given ID Not Found");
		}
		structure2.setMessage("Branchs Found Successfully");
		structure2.setStatus(HttpStatus.FOUND.value());
		structure2.setData(branchs);
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		
	}



	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int id) {
		
		Branch branch= dao.deleteBranchById(id);
		if(branch != null) {
			structure.setMessage("Branch Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		throw new DataNotFound("Branchs with given Hospital ID Not Found");
	}



	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		
		Branch branch= dao.getBranchById(id);
		if(branch != null) {
			structure.setMessage("Branch Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("Branch With given id not found");
	}



	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int id, Branch branch, int hospitalID, int addressID) {
		Branch branch2=dao.getBranchById(id);
		Hospital hospital=hospitalDao.getHospitalById(hospitalID);
		Address address=addressDao.findAddressById(addressID);
		if(branch2!=null && hospital!=null && address!=null) {
			branch.setBranchId(id);
			branch.setAddress(address);
			branch.setHospital(hospital);
			structure.setMessage("Branch Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( dao.saveBranch(branch));
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Branch With Given Id Not Found");
		
	}

}

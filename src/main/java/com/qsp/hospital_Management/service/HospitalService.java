package com.qsp.hospital_Management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qsp.hospital_Management.dao.HospitalDao;
import com.qsp.hospital_Management.dto.Hospital;
import com.qsp.hospital_Management.exception.EmailNotFound;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

	public ResponseEntity<ResponseStructure<Hospital>> save(Hospital hospital) {

		structure.setMessage("Data has been Successfully added");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.save(hospital));
		return new ResponseEntity<>(structure,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully"); 
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
		} else {
			
			throw new IdNotFound("Hospital With Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int id) {
		Hospital hospital = dao.deleteHospitalById(id);
		if (hospital != null) {
			structure.setMessage("Hospital Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);

		} else {
			throw new IdNotFound("Hospital with Given Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital hospital2 = dao.getHospitalById(id);
		if (hospital2 != null) {
			structure.setMessage("Hospital Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			hospital.setHospitalID(id);
			structure.setData(dao.updateHospital(hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Hospital with Given Id Not Found");
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByEmail(String email) {
		Hospital hospital = dao.findHospitalByEmail(email);
		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
			
		}
		
		 throw new EmailNotFound("Hospital with Given Email Not Found");
	}

}

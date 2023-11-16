package com.qsp.hospital_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_Management.dao.BranchDao;
import com.qsp.hospital_Management.dao.EncounterDao;
import com.qsp.hospital_Management.dao.PersonDao;
import com.qsp.hospital_Management.dto.Branch;
import com.qsp.hospital_Management.dto.Encounter;
import com.qsp.hospital_Management.dto.Person;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int personID, int branchID) {
		Person person = personDao.getPersonById(branchID);
		Branch branch = branchDao.getBranchById(branchID);
		List<Branch> list = new ArrayList<Branch>();
		list.add(branch);
		if (person != null && branch != null) {
			encounter.setBranchList(list);
			encounter.setPerson(person);
			structure.setMessage("Encounter Inserted Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveEncouter(encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);
		}else if(person==null) {
			throw new IdNotFound("Person With Given Id Not Found");
		}
		throw new IdNotFound("Branch With Given Id Not Found");
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		Encounter encounter = dao.getEncounterById(id);
		if (encounter != null) {
			structure.setMessage("Encounter Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
		}
		throw new IdNotFound("Encounter With Given Id Not Found"); 

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter, int personID,
			int branchID) {
		Encounter encounter2 = dao.getEncounterById(id);
		Branch branch = branchDao.getBranchById(branchID);
		Person person = personDao.getPersonById(personID);

		if (encounter2 != null && branch != null && person != null) {
			encounter.setId(id);
			List<Branch> branchList = encounter2.getBranchList();
			branchList.add(branch);
			encounter.setBranchList(branchList);
			encounter.setPerson(person);
			structure.setMessage("Encounter Update Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEncounterById(encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Encounter With Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(int id) {
		Encounter encounter = dao.getEncounterById(id);
		if (encounter != null) {
			structure.setMessage("Encounter Deletded Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			dao.deleteEncounterById(id);
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
		}
		throw new IdNotFound("Encounter With Given Id not Found");

	}

}

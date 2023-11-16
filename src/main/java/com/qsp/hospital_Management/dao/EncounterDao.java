package com.qsp.hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.EncounterRepo;
import com.qsp.hospital_Management.dto.Encounter;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo repo;

	public Encounter saveEncouter(Encounter encounter) {
		return repo.save(encounter);
	}
	
	public Encounter getEncounterById(int id) {
		Optional<Encounter>optional= repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void deleteEncounterById(int id) {
		repo.deleteById(id);
	}
	
	public Encounter updateEncounterById(Encounter encounter) {
		return repo.save(encounter);
	}
	

}

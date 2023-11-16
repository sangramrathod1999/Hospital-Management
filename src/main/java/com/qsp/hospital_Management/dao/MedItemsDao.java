package com.qsp.hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.MedItemsRepo;
import com.qsp.hospital_Management.dto.MedItems;

@Repository
public class MedItemsDao {
	
	@Autowired
	private MedItemsRepo repo;

	public MedItems saveMedItem(MedItems medItems) {
		
		return repo.save(medItems);
	}
	
	public void deleteMedItemById(int id) {
		repo.deleteById(id);
	}
	
	public MedItems getMedItemById(int id) {
		Optional<MedItems>optional=repo.findById(id);
		if(optional.isPresent()) {
			return  optional.get();
		}
		return null;
	}
	
	
	

}

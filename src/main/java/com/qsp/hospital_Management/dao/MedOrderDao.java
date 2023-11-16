package com.qsp.hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_Management.Repo.MedOrderRepo;
import com.qsp.hospital_Management.dto.MedOrder;

@Repository
public class MedOrderDao {
	
	@Autowired
	private MedOrderRepo repo;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repo.save(medOrder);
	}
	
	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder>optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public MedOrder deleteMedOrderById(int id) {
		Optional<MedOrder>optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

}

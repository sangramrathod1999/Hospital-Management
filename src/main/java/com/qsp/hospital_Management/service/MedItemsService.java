package com.qsp.hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_Management.dao.MedItemsDao;
import com.qsp.hospital_Management.dao.MedOrderDao;
import com.qsp.hospital_Management.dto.Encounter;
import com.qsp.hospital_Management.dto.MedItems;
import com.qsp.hospital_Management.dto.MedOrder;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedItemsDao dao;
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
	

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(int medOrderId, MedItems medItems) {
		MedOrder medOrder=medOrderDao.getMedOrderById(medOrderId);
		if(medOrder !=null) {
			medItems.setMedOrder(medOrder);
			structure.setMessage("MedItem Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveMedItem(medItems));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
		}else {
			throw new IdNotFound("MedOrder With Given id not found");
			
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemById(int id) {
		MedItems medItems=dao.getMedItemById(id);
		if(medItems!=null) {
			structure.setMessage("MedItem Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			dao.deleteMedItemById(id);
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("MedItem Not Found With Given ID");
		
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemById(int id){
		MedItems medItems=dao.getMedItemById(id);
		if(medItems!=null) {
			structure.setMessage("MedItem Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("MedItem with given id not found");
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItemById(int id,MedItems medItems){
		MedItems medItems2=dao.getMedItemById(id);
		if(medItems2!=null) {
			structure.setMessage("MedItem Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			medItems.setMeditemId(id);
			medItems.setMedOrder(medItems2.getMedOrder());
			structure.setData(dao.saveMedItem(medItems));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("MedItem With given ID not found");
	}
	
	
	
	

}

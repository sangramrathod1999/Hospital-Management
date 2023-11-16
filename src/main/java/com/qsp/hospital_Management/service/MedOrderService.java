package com.qsp.hospital_Management.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.qsp.hospital_Management.dao.EncounterDao;
import com.qsp.hospital_Management.dao.MedOrderDao;
import com.qsp.hospital_Management.dto.Encounter;
import com.qsp.hospital_Management.dto.MedItems;
import com.qsp.hospital_Management.dto.MedOrder;
import com.qsp.hospital_Management.exception.IdNotFound;
import com.qsp.hospital_Management.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao dao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	java.util.Date date=new java.util.Date(); 
	
	
	ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int encounterId) {
		
		Encounter encounter=encounterDao.getEncounterById(encounterId);
		if(encounter !=null) {
			structure.setMessage("MedOrder Data Inserted Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			medOrder.setDate(date);
			 medOrder.setEncounter(encounter);
			 structure.setData(dao.saveMedOrder(medOrder));
			 return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFound("Encounter With given id not found");
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id){
		MedOrder medOrder=dao.getMedOrderById(id);
		if(medOrder!=null) {
			structure.setMessage("MedOrder Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("MedOrder With given id not found");
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		MedOrder medOrder2 =dao.getMedOrderById(id);
		if(medOrder2 !=null) {
			medOrder.setMedId(id);
			medOrder.setEncounter(medOrder2.getEncounter());
			medOrder.setDate(date);
			structure.setMessage("MedOrder Updated Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.saveMedOrder(medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("MedOrder with given id not found");
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(int id){
		MedOrder medOrder =dao.getMedOrderById(id);
		if(medOrder!=null) {
			structure.setMessage("MedOrder Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.deleteMedOrderById(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFound("MedOrde With given Id not found");
	}

}

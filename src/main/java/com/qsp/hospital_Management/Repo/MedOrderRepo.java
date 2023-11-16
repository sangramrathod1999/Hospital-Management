package com.qsp.hospital_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_Management.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{

}

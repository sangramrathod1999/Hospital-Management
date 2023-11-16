package com.qsp.hospital_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_Management.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}

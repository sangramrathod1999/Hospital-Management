package com.qsp.hospital_Management.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int medId;
	private Date date;
	@NotBlank(message = "Doctor name can't be blank")
	@NotNull(message = "Doctor name cannnot be null")
	private String doctor;
	@ManyToOne
	private Encounter encounter;
	

}

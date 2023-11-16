package com.qsp.hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedItems {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int meditemId;
	@NotBlank(message = "MedItem name can't be blank")
	@NotNull(message = "MedItem name cannot be null")
	private String name;
	@Min(value=0000)
	@Max(value = 9999)
	private double price;
	@ManyToOne
	private MedOrder medOrder;
	
}

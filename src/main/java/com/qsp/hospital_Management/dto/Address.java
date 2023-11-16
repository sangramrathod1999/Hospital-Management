package com.qsp.hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "City can't be blank")
	@NotNull(message = "City can't be null")
	private String city;
	@NotBlank(message = "State can't be blank")
	@NotNull(message = "State can't be null")
	private String state;
	@Min(value = 000000)
	@Max(value = 999999)
	private int pincode;
	
	
	

}

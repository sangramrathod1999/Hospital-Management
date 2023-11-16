package com.qsp.hospital_Management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name can't be blank")
	@NotNull(message = "Name can't be null")
	private String name;
	
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long phone;
	
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email Can't be null")
	@Email(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Invalid Email")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Address can't be blank")
	@NotNull(message = "Address Can't be null")
	private String address;
	
	

}

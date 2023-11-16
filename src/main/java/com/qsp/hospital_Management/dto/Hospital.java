	package com.qsp.hospital_Management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int hospitalID;
	@NotBlank(message = "Hospital name can't be blank")
	@NotNull(message = "Hospital name can't be null")
	private String hospitalName;
	@Column(unique = true)
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email can't be null")
	@Email(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Invalid Email")
	private String email;
	@NotBlank(message = "CEO can't be blank")
	@NotNull(message = "CEO can't be null")
	private String CEO;
	

}

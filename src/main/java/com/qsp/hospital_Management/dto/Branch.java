package com.qsp.hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	@NotBlank(message = "Branch name can't blank")
	@NotNull(message = "Branch name can't be null")
	private String branchName;
	@NotBlank(message = "Branch manager can't be blank")
	@NotNull(message = "Branch Manager can't be null")
	private String branchManager;
	@ManyToOne
	private Hospital hospital;
	@OneToOne
	
	private Address address;
 
}

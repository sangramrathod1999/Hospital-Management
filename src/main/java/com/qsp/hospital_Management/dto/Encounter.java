package com.qsp.hospital_Management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Cause can't be blank")
	@NotNull(message = "Cause can't be null")
	private String cause;
	@Min(value = 0000000)
	@Max(value = 9999999)
	private double cost;
	@ManyToOne
	private Person person;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchList;

}

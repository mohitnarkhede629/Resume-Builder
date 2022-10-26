package com.technoelevate.resumebuilder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Education implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	
	private String highestEducation;
	
	private String specialization;
	
	private String institution;
	
	private Integer yearOfPassout;
	
	@DecimalMin(value = "35.00")
	@DecimalMax(value = "100")
	@Digits(fraction = 2, integer = 3)
	private double percentage;

}

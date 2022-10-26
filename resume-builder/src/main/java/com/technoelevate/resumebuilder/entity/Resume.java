package com.technoelevate.resumebuilder.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.technoelevate.resumebuilder.utils.StringListConverter;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Resume implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resumeNumber;
	
	private String resumeId;
	
	private String email;
	
	private String phoneNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime dateOfBirth;
	
	private String employeeId;
	
	private String firstName;

	private String lastName;

	private String totalExperience;

	private String relevantExperience;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> technologies;
																		
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> summary;

	@OneToOne(cascade = CascadeType.ALL)
	private Skills skills;

	@OneToOne(cascade = CascadeType.ALL)
	private Education educationDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	private List<ProjectDetails> projectDetails;

}

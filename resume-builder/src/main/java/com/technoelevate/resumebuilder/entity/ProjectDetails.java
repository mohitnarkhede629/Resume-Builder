package com.technoelevate.resumebuilder.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.technoelevate.resumebuilder.utils.StringListConverter;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class ProjectDetails implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	@Past(message = PROJECT_START_DATE_MUST_N_OT_BE_A_FUTURE_DATE)
	private LocalDateTime projectStartDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	@Future(message =  PROJECT_END_DATE_MUST_N_OT_BE_A_PAST_DATE)
	private LocalDateTime projectEndDate;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> frontEndTechnology;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> backEndTechnology;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> designPatternUsed;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> dataBase;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> developmentTools;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> duration;

	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> teamSize;

	@Column(length = 2000)
	@Convert(converter = StringListConverter.class)
	private List<String> projectDescription;

	@Column(length = 2000)
	@Convert(converter = StringListConverter.class)
	private List<String> rolesAndResponsibilities;
}

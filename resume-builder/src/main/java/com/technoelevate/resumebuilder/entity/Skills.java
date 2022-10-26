package com.technoelevate.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.technoelevate.resumebuilder.utils.StringListConverter;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Skills implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String> languages;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	j2eeTechnologies;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	frontEndFrameworks;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	backEndFrameworks;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	designPatterns;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	dataBase;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	webServers;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	aws;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	codeQualityTools;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	versionControlSystems;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	buildAutomationTools;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	ciCdTools;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	otherTools;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private List<String>	sdlc;
	
	
	
}
